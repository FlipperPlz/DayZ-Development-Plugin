package com.flipperplz.bisutils.pbo.entries;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;

import java.io.IOException;

public class PboDummyEntry extends PboEntry {
    public PboDummyEntry(BisBinaryReader reader, PboFile entryParent) throws IOException {
        super(reader, entryParent);
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws IOException {
        super.readBinary(reader);
        if(this.entryMagic != PboEntryMagic.Decompressed ||
           !this.entryName.equals("") ||
           this.reserved1 != 0 ||
           this.reserved2 != 0 ||
           this.reserved3 != 0 ||
           this.reserved4 != 0) throw new IOException("This entry is not a dummy entry.");
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws IOException {
        writer.write(new byte[21]);
    }
}
