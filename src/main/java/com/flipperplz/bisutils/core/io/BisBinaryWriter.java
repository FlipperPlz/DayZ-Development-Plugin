package com.flipperplz.bisutils.core.io;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BisBinaryWriter extends FilterOutputStream {
    private DataOutputStream dataOutputStream;
    private long position;

    public BisBinaryWriter(OutputStream outputStream) {
        super(outputStream);
        this.dataOutputStream = new DataOutputStream(outputStream);
        this.position = 0;
    }

    public void writeLittleEndian(byte[] data) throws IOException {
        for (int i = data.length - 1; i >= 0; i--) dataOutputStream.writeByte(data[i]);
        position += data.length;
    }

    public void writeLittleEndian(int data) throws IOException {
        writeLittleEndian(new byte[] {
                (byte)(data & 0xff),
                (byte)((data >> 8) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 24) & 0xff)
        });
    }

    public void writeLittleEndian(long data) throws IOException {
        writeLittleEndian(new byte[] {
                (byte)(data & 0xff),
                (byte)((data >> 8) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 32) & 0xff),
                (byte)((data >> 40) & 0xff),
                (byte)((data >> 48) & 0xff),
                (byte)((data >> 56) & 0xff)
        });
    }

    public void writeBigEndian(byte[] data) throws IOException {
        for (int i = 0; i < data.length; i++) dataOutputStream.writeByte(data[i]);
        position += data.length;
    }

    public void writeBigEndian(int data) throws IOException {
        writeBigEndian(new byte[] {
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 8) & 0xff),
                (byte)(data & 0xff)
        });
    }

    public void writeBigEndian(long data) throws IOException {
        writeBigEndian(new byte[] {
                (byte)((data >> 56) & 0xff),
                (byte)((data >> 48) & 0xff),
                (byte)((data >> 40) & 0xff),
                (byte)((data >> 32) & 0xff),
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 8) & 0xff),
                (byte)(data & 0xff)
        });
    }

    public void writeUInt32(long data, ByteOrder order) throws IOException {
        if (data < 0 || data > 0xffffffffL)
            throw new IllegalArgumentException("Value must be in the range 0 to 2^32-1");
        if (order == ByteOrder.LITTLE_ENDIAN) {
            writeLittleEndian(new byte[] {
                    (byte)(data & 0xff),
                    (byte)((data >> 8) & 0xff),
                    (byte)((data >> 16) & 0xff),
                    (byte)((data >> 24) & 0xff)
            });
        } else {
            writeBigEndian(new byte[] {
                    (byte)((data >> 24) & 0xff),
                    (byte)((data >> 16) & 0xff),
                    (byte)((data >> 8) & 0xff),
                    (byte)(data & 0xff)
            });
        }
    }

    public void writeAsciiZ(String s) throws IOException {
        byte[] bytes = s.getBytes("UTF-8");
        write(bytes);
        write((byte)0);
    }

    public void write(byte[] data) throws IOException {
        dataOutputStream.write(data);
        position += data.length;
    }

    public void write(int data) throws IOException {
        dataOutputStream.writeInt(data);
        position += 4;
    }

    public void write(long data) throws IOException {
        dataOutputStream.writeLong(data);
        position += 8;
    }

    public long getPosition() {
        return position;
    }

    @Override
    public void close() throws IOException {
        this.dataOutputStream.close();
        super.close();

    }
}
