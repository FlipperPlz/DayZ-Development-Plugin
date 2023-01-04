package com.flipperplz.bisutils.pbo.entries;


import com.flipperplz.bisutils.core.BisBinarizable;
import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;

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

    public PboEntry(BisBinaryReader reader, PboFile entryParent, PboEntryMagic magic) throws Exception {
        super(reader);
        this.entryMagic = magic;
        this.entryParent = entryParent;
    }

    public PboEntry(BisBinaryReader reader, PboFile entryParent) throws Exception {
        super(reader);
        this.entryMagic = PboEntryMagic.Undefined;
        this.entryParent = entryParent;
    }


    @Override
    public void readBinary(BisBinaryReader reader) throws Exception {
        this.entryName = reader.readAsciiZ();
        if(this.entryMagic != PboEntryMagic.values()[reader.readInt32(ByteOrder.LITTLE_ENDIAN)]) throw new Exception("Incorrect magic value for pbo entry.");
        reserved1 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved2 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved3 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
        reserved4 = reader.readUInt32(ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws Exception {
        if (entryMagic == PboEntryMagic.Undefined) throw new Exception("Cannot write undefined entry. " + entryName);
        writer.writeAsciiZ(entryName);
        writer.writeLittleEndian(entryMagic.magic);
        writer.writeUInt32(reserved1, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved2, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved3, ByteOrder.LITTLE_ENDIAN);
        writer.writeUInt32(reserved4, ByteOrder.LITTLE_ENDIAN);
    }

    public int CalculateMetaLength() {
        return this.entryName.getBytes(StandardCharsets.UTF_8).length + 21;
    }
}
