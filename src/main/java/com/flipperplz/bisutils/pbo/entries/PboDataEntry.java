package com.flipperplz.bisutils.pbo.entries;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;

import java.util.Objects;

public class PboDataEntry extends PboEntry {
    public long entryDataStartOffset; //Relative to pbo data block
    public long entryDataStopOffset; //Relative to pbo data block

    public PboDataEntry(BisBinaryReader reader, PboFile entryParent) throws Exception {
        super(reader, entryParent);
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws Exception {
        super.readBinary(reader);
        if(entryMagic != PboEntryMagic.Compressed &&
           entryMagic != PboEntryMagic.Decompressed /*&&
           entryMagic != PboEntryMagic.Encrypted*/)
            throw new Exception("This entry is not a data entry (or it is encrypted).");
    }

    public void reinitializeOffsets() {
        entryDataStartOffset = 0;

        for (var ent : this.entryParent.getEntries()) {
            if(!(ent instanceof PboDataEntry)) {
                if(Objects.equals(ent, this)) break;
                entryDataStartOffset += ((PboDataEntry) ent).getPackedSize();
            }
        }
        entryDataStopOffset = entryDataStartOffset + getPackedSize();
    }

    public long getOriginalSize() {
        return reserved1;
    }

    public void setOriginalSize(long size) {
        reserved1 = size;
    }

    @Deprecated
    public long getBinaryOffset() {
        return reserved2;
    }

    @Deprecated
    public void setBinaryOffset(long offset) {
        reserved2 = offset;
        entryParent.desynchronize();
    }

    public long getTimestamp() {
        return reserved3;
    }

    public void setTimestamp(long size) {
        reserved3 = size;
        entryParent.desynchronize();

    }

    public long getPackedSize() {
        return reserved4;
    }

    public void setPackedSize(long size) {
        reserved4 = size;
        entryParent.desynchronize();

    }

}
