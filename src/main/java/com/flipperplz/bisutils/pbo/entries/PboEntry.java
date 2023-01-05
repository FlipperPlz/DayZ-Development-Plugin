package com.flipperplz.bisutils.pbo.entries;


import com.flipperplz.bisutils.core.BisBinarizable;
import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public abstract class PboEntry extends BisBinarizable {
    public final PboFile entryParent;
    protected PboEntryMagic entryMagic;

    public String entryName = "";
    protected long reserved1;
    protected long reserved2;
    protected long reserved3;
    protected long reserved4;

    public PboEntry(BisBinaryReader reader, PboFile entryParent, PboEntryMagic magic) throws IOException {
        super(reader);
        this.entryMagic = magic;
        this.entryParent = entryParent;
    }

    public PboEntry(BisBinaryReader reader, PboFile entryParent) throws IOException {
        super(reader);
        this.entryMagic = PboEntryMagic.Undefined;
        this.entryParent = entryParent;
    }

    public static PboEntry readPboEntry(BisBinaryReader reader, PboFile entryParent) throws IOException {
        reader.mark(129);
        var entryName = reader.readAsciiZ();
        var magic = PboEntryMagic.values()[reader.readInt32(ByteOrder.LITTLE_ENDIAN)];
        var reserved1 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        var reserved2 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        var reserved3 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        var reserved4 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reader.reset();

        if(entryName.equals("") && reserved1 == 0 && reserved2 == 0 && reserved3 == 0 && reserved4 == 0) {
            if(magic == PboEntryMagic.Version) return new PboVersionEntry(reader, entryParent);
            if(magic == PboEntryMagic.Decompressed) return new PboDummyEntry(reader, entryParent);
        }

        return new PboDataEntry(reader, entryParent);

    }


    @Override
    public void readBinary(BisBinaryReader reader) throws IOException {
        this.entryName = reader.readAsciiZ();
        if(this.entryMagic != PboEntryMagic.values()[reader.readInt32(ByteOrder.LITTLE_ENDIAN)]) throw new IOException("Incorrect magic value for pbo entry.");
        readBinaryReserves(reader);
    }

    private void readBinaryReserves(BisBinaryReader reader) throws IOException {
        reserved1 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved2 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved3 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved4 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
    }

    private void writeBinaryReserves(BisBinaryWriter writer) throws IOException {
        writer.writeUInt32(reserved1, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved2, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved3, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved4, ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws IOException {
        if (entryMagic == PboEntryMagic.Undefined) throw new IOException("Cannot write undefined entry. " + entryName);
        writer.writeAsciiZ(entryName);
        writer.writeLittleEndian(entryMagic.getMagic());
        writeBinaryReserves(writer);
    }

    public int CalculateMetaLength() {
        return this.entryName.getBytes(StandardCharsets.UTF_8).length + 21;
    }
}
