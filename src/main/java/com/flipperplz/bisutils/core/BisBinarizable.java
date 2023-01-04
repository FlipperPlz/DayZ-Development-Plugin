package com.flipperplz.bisutils.core;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;

import java.io.DataOutputStream;

public abstract class BisBinarizable {

    public BisBinarizable(BisBinaryReader reader) throws Exception {
        readBinary(reader);
    }

    public abstract void readBinary(BisBinaryReader reader) throws Exception;
    public abstract void writeBinary(BisBinaryWriter writer) throws Exception;
}
