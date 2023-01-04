package com.flipperplz.bisutils.pbo;

import com.flipperplz.bisutils.core.BisBinarizable;
import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.entries.PboDataEntry;
import com.flipperplz.bisutils.pbo.entries.PboDummyEntry;
import com.flipperplz.bisutils.pbo.entries.PboEntry;
import com.flipperplz.bisutils.pbo.entries.PboVersionEntry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PboFile extends BisBinarizable {
    private List<PboEntry> entries = new ArrayList<>();

    private long dataBlockStartOffset;
    private String pboFilePath;
    private boolean isSynchronized;

    public PboFile(String pboPath) throws Exception {
        super(new BisBinaryReader(new FileInputStream(pboPath)));
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws Exception {
        this.isSynchronized = true;
        this.dataBlockStartOffset = 0;

        PboEntry entry;
        do {
           this.entries.add(entry = PboEntry.readPboEntry(reader, this));
           this.dataBlockStartOffset += entry.CalculateMetaLength();
        } while (!(entry instanceof PboDummyEntry));

        reader.close();
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws Exception {
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

    public void AddEntry(PboEntry entry) {
        entries.add(entry);
        isSynchronized = false;
    }

    public PboVersionEntry getVersionEntry() {
        for (var entry : entries) {
            if (entry instanceof PboVersionEntry)
                return (PboVersionEntry) entry;
        }

        return null;
    }

    public void synchronize() throws Exception {
        if(isSynchronized) return;
        var outputWriter = new BisBinaryWriter(new FileOutputStream(pboFilePath));
        writeBinary(outputWriter);
        outputWriter.close();
        isSynchronized = true;
    }

    public void desynchronize() {
        isSynchronized = false;
    }
}
