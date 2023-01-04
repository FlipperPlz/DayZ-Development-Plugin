package com.flipperplz.bisutils.core.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BisBinaryReader extends FilterInputStream {
    private long position;

    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in}
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    public BisBinaryReader(InputStream in) {
        super(in);
        setPosition(0);
    }

    /**
     * Read an arbitrary number of bytes.
     */
    public byte[] readBytes(int length) throws IOException {
        byte[] bytes = new byte[length];
        this.read(bytes);
        incrementPosition(length);
        return bytes;
    }

    /**
     * Read a single byte.
     */
    public byte readByte(ByteOrder order) throws IOException {
        incrementPosition(1);
        return ByteBuffer.wrap(this.readBytes(1)).order(order).get();
    }

    public String readAsciiZ() throws IOException  {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = read();
            incrementPosition(1);
            if (b == 0) {
                break;
            }
            sb.append((char)b);
        }
        return sb.toString();
    }

    /**
     * Reads a 4-byte signed integer from the current stream and advances the current position of the stream by four bytes.
     * @return
     * @throws IOException
     */
    public int readInt32(ByteOrder order) throws IOException {
        incrementPosition(4);
        return ByteBuffer.wrap(this.readBytes(4)).order(order).getInt();
    }

    /**
     * Reads a 4-byte unsigned integer from the current stream and advances the position of the stream by four bytes. Returns a long as java does not have the means to have unsigned values.
     * @return
     * @throws IOException
     */
    public long readUInt32(ByteOrder order) throws IOException {
        incrementPosition(4);
        return this.readInt32(order) & 0xFFFFFFFFL;
    }

    /**
     * Reads a 2-byte signed integer from the current stream and advances the current position of the stream by two
     *  bytes. Returns a 32-bit int as there are not 16-bit ints in java.
     * @return
     * @throws IOException
     */
    public int readInt16(ByteOrder order) throws IOException {
        incrementPosition(2);
        return ByteBuffer.wrap(this.readBytes(2)).order(order).getShort();
    }

    /**
     * Reads a 2-byte unsigned integer from the current stream using little-endian encoding and advances the position of
     *  the stream by two bytes. Returns a 32-bit int as there are not 16-bit ints in java.
     * @return
     * @throws IOException
     */
    public int readUInt16(ByteOrder order) throws IOException {
        incrementPosition(2);
        return this.readInt16(order) & 0xFFFF;
    }

    /**
     * Reads a 2-byte signed integer from the current stream and advances the current position of the stream by two
     *  bytes. Returns a 32-bit int as there are not 16-bit ints in java.
     * @return
     * @throws IOException
     */
    public short readShort(ByteOrder order) throws IOException {
        incrementPosition(2);
        return ByteBuffer.wrap(this.readBytes(2)).order(order).getShort();
    }

    /**
     * Reads a string from the current stream. The string is prefixed with the length, encoded as an integer seven bits
     *  at a time.
     * @return
     * @throws IOException
     */
    public String readString() throws IOException {
        incrementPosition(this.getStringLength());
        return new String(this.readBytes(this.getStringLength()));
    }

    /**
     * Reads a Boolean value from the current stream and advances the current position of the stream by one byte.
     * @return
     * @throws IOException
     */
    public boolean readBoolean() throws IOException {
        incrementPosition(1);
        return this.readBytes(1)[0] != 0;
    }

    /**
     * Reads a 4-byte floating point value from the current stream and advances the current position of the stream by
     *  four bytes.
     * @return
     * @throws IOException
     */
    public float readSingle(ByteOrder order) throws IOException {
        incrementPosition(4);
        return ByteBuffer.wrap(this.readBytes(4)).order(order).getFloat();
    }

    /**
     * Source: https://github.com/vrecan/Thaw-Giant/blob/master/src/main/java/com/vreco/thawgiant/BinaryUtil.java
     * Binary files are encoded with a variable length prefix that tells you
     * the size of the string. The prefix is encoded in a 7bit format where the
     * 8th bit tells you if you should continue. If the 8th bit is set it means
     * you need to read the next byte.
     * @return
     * @throws IOException
     */
    private int getStringLength() throws IOException {
        int count = 0;
        int shift = 0;
        boolean more = true;
        while (more) {
            byte b = (byte) this.read();
            count |= (b & 0x7F) << shift;
            shift += 7;
            if((b & 0x80) == 0) {
                more = false;
            }
        }
        return count;
    }

    private void incrementPosition(long increment) {
        setPosition(getPosition() + increment);
    }

    public long getPosition(){
        return this.position;
    }

    private void setPosition(long position){
        this.position = position;
    }
}
