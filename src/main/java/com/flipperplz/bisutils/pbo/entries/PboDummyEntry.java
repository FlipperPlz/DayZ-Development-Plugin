package com.flipperplz.bisutils.pbo.entries;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;

public class PboDummyEntry extends PboEntry {
    public PboDummyEntry(BisBinaryReader reader, PboFile entryParent) throws Exception {
        super(reader, entryParent);
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws Exception {
        super.readBinary(reader);
        if(this.entryMagic != PboEntryMagic.Decompressed ||
           !this.entryName.equals("") ||
           this.reserved1 != 0 ||
           this.reserved2 != 0 ||
           this.reserved3 != 0 ||
           this.reserved4 != 0) throw new Exception("This entry is not a dummy entry.");
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws Exception {
        writer.write(new byte[21]);
    }
}
