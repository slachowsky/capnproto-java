package org.capnproto;

import java.util.ArrayList;
import java.nio.ByteBuffer;

public final class ReaderArena implements Arena {

    public final ArrayList<SegmentReader> segments;

    public ReaderArena(ByteBuffer[] segmentSlices) {
        this.segments = new ArrayList<SegmentReader>();
        for(int ii = 0; ii < segmentSlices.length; ++ii) {
            this.segments.add(new SegmentReader(segmentSlices[ii], this));
        }
    }

    public SegmentReader tryGetSegment(int id) {
        return segments.get(id);
    }
}
