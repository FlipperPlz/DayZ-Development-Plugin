package com.flipperplz.bisutils.core;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class BisBinarizable {

    public BisBinarizable(BisBinaryReader reader) throws IOException {
        readBinary(reader);
    }

    public abstract void readBinary(BisBinaryReader reader) throws IOException;
    public abstract void writeBinary(BisBinaryWriter writer) throws IOException;
}
