package org.capnproto;

import java.nio.ByteBuffer;

final class FarPointer {
    public static int getSegmentId(long ref) {
        return WirePointer.upper32Bits(ref);
    }

    public static int positionInSegment(long ref) {
        return WirePointer.offsetAndKind(ref) >>> 3;
    }

    public static boolean isDoubleFar(long ref) {
        return ((WirePointer.offsetAndKind(ref) >>> 2) & 1) != 0;
    }

    public static void setSegmentId(ByteBuffer buffer, int offset, int segmentId) {
        buffer.putInt(8 * offset + 4, segmentId);
    }

    public static void set(ByteBuffer buffer, int offset, boolean isDoubleFar, int pos) {
        int idf = isDoubleFar ? 1 : 0;
        WirePointer.setOffsetAndKind(buffer, offset, (pos << 3) | (idf << 2) | WirePointer.FAR);
    }
}
