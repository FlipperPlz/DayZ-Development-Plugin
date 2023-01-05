package com.flipperplz.bisutils.core.compression;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class BohemiaLZSS {

    public static void decompress(byte[] input, byte[] output, boolean alwaysDecompress) throws IOException {
        final int N = 4096,  F = 18, THRESHOLD = 2;
        DataInputStream inputReader = new DataInputStream(new ByteArrayInputStream(input));
        char[] text_buf = new char[N + F - 1];
        int i;
        int flags = 0;
        int cSum = 0, iDst = 0, bytesLeft = output.length;
        for (i = 0; i < N - F; i++) text_buf[i] = ' ';
        int r = N - F;
        while (bytesLeft > 0) {
            int c;
            if (((flags >>= 1) & 256) == 0) {
                c = inputReader.readByte();
                flags = c | 0xff00;
            }

            if ((flags & 1) != 0) {
                c = inputReader.readByte();
                cSum += (byte) c;

                // save byte
                output[iDst++] = (byte) c;
                bytesLeft--;
                // continue decompression
                text_buf[r] = (char) c;
                r++;
                r &= (N - 1);
            } else {
                i = inputReader.readByte();
                int j = inputReader.readByte();
                i |= (j & 0xf0) << 4;
                j &= 0x0f;
                j += THRESHOLD;

                int ii = r - i,
                        jj = j + ii;
                if (j + 1 > bytesLeft) {
                    throw new IOException("LZSS overflow");
                }

                for (; ii <= jj; ii++) {
                    c = (byte) text_buf[ii & (N - 1)];
                    cSum += (byte) c;

                    // save byte
                    output[iDst++] = (byte) c;
                    bytesLeft--;
                    // continue decompression
                    text_buf[r] = (char) c;
                    r++;
                    r &= (N - 1);
                }
            }
        }
    }
}
