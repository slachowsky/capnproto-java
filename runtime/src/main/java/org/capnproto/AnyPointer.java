package org.capnproto;

public final class AnyPointer {

    public final static class Reader {
        public final PointerReader reader;

        public Reader(PointerReader reader) {
            this.reader = reader;
        }

        public final <T> T getAsStruct(FromStructReader<T> factory) {
            return factory.fromStructReader(this.reader.getStruct());
        }
    }

    public static final class Builder {
        public final PointerBuilder builder;

        public Builder(PointerBuilder builder) {
            this.builder = builder;
        }

        public final <T> T initAsStruct(FromStructBuilder<T> factory) {
            return factory.fromStructBuilder(this.builder.initStruct(factory.structSize()));
        }
    }

}
