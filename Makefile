CXX=clang++
CXX_FLAGS=-std=c++11 `pkg-config capnp --cflags --libs` -Wl,-rpath,/usr/local/lib

CAPNPC_JAVA_SOURCES=compiler/src/main/cpp/capnpc-java.c++

.PHONY: all clean

all : capnpc-java

clean :
	rm capnpc-java

capnpc-java : $(CAPNPC_JAVA_SOURCES)
	$(CXX) $(CAPNPC_JAVA_SOURCES) $(CXX_FLAGS) -g -o capnpc-java

addressbook : capnpc-java
	PWD=pwd
	mkdir -p examples/src/main/generated
	capnp compile -I$(PWD)/compiler/src/main/cpp --src-prefix=examples/src/main/schema -o./capnpc-java:examples/src/main/generated examples/src/main/schema/addressbook.capnp
