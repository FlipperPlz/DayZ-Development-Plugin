package com.flipperplz.bisutils.pbo.enums;

public enum PboEntryMagic {
    Version(0x56657273),
    Compressed(0x43707273),
    Encrypted(0x456e6372),
    Decompressed(0x00000000),
    Undefined(-1);

    private int magic;

    PboEntryMagic(int i) {
        magic = i;
    }

    public int getMagic() {
        return magic;
    }
}
