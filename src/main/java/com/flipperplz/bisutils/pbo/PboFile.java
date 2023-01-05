package com.flipperplz.bisutils.pbo;

import com.flipperplz.bisutils.core.BisBinarizable;
import com.flipperplz.bisutils.core.compression.BohemiaLZSS;
import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.entries.PboDataEntry;
import com.flipperplz.bisutils.pbo.entries.PboDummyEntry;
import com.flipperplz.bisutils.pbo.entries.PboEntry;
import com.flipperplz.bisutils.pbo.entries.PboVersionEntry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PboFile extends BisBinarizable {
    private List<PboEntry> entries = new ArrayList<>();

    private long dataBlockStartOffset;

    private Path pboFilePath;
    private FileLock pboFileLock;

    private boolean isSynchronized;

    public PboFile(Path pboPath) throws Exception {
        super(new BisBinaryReader(new FileInputStream(pboPath.toAbsolutePath().toString())));
        pboFilePath = pboPath;
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws IOException {
        this.unlockFile();
        this.isSynchronized = true;
        this.dataBlockStartOffset = 0;

        PboEntry entry;
        do {
           this.entries.add(entry = PboEntry.readPboEntry(reader, this));
           this.dataBlockStartOffset += entry.CalculateMetaLength();
        } while (!(entry instanceof PboDummyEntry));

        reader.close();

        lockFile();
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws IOException {
        this.unlockFile();
        for (var ent : entries) ent.writeBinary(writer);
        //TODO: Finish Writing
    }

    public List<PboDataEntry> getDataEntries() {
        var entries = new ArrayList<PboDataEntry>();
        for (var entry : entries) {
            if (entry instanceof PboDataEntry) entries.add(entry);
        }

        return entries;
    }

    public List<PboEntry> getEntries() {
        return entries;
    }

    private long calculateDataOffset(PboDataEntry dataEntry) {
        return dataBlockStartOffset + dataEntry.entryDataStartOffset;
    }

    public PboVersionEntry getVersionEntry() {
        for (var entry : entries) {
            if (entry instanceof PboVersionEntry)
                return (PboVersionEntry) entry;
        }

        return null;
    }


    public byte[] getEntryData(PboDataEntry dataEntry, boolean decompress) throws IOException {
        this.unlockFile();
        byte[] out;
        var reader = new BisBinaryReader(new FileInputStream(pboFilePath.toAbsolutePath().toString()));
        reader.skip(calculateDataOffset(dataEntry));

        if(!decompress) {
            out = reader.readBytes((int) dataEntry.getPackedSize());
        } else {
            out = new byte[(int) dataEntry.getOriginalSize()];
            BohemiaLZSS.decompress(reader.readBytes((int) dataEntry.getPackedSize()), out, false);
        }

        reader.close();
        lockFile();

        return out;
    }

    public void synchronize() throws Exception {
        if(isSynchronized) return;

        unlockFile();

        var outputWriter = new BisBinaryWriter(new FileOutputStream(pboFilePath.toAbsolutePath().toString()));
        writeBinary(outputWriter);

        outputWriter.close();
        isSynchronized = true;
    }

    private void lockFile() throws IOException {
        if(pboFileLock == null || !pboFileLock.isValid()) return;

        try (var channel = FileChannel.open(pboFilePath, StandardOpenOption.WRITE)) {
            pboFileLock = channel.lock();
        }
    }

    private void unlockFile() throws IOException {
        if(!pboFileLock.isValid() || pboFileLock == null) return;
        pboFileLock.release();
    }


    public void deSynchronize() {
        if(isSynchronized) isSynchronized = false;
    }
}
