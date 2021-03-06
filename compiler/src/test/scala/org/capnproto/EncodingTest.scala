package org.capnproto;

import org.capnproto.test.Test._;

import org.scalatest.FunSuite


class EncodingSuite extends FunSuite {

  test("AllTypes") {
    val message = new MessageBuilder();
    val allTypes = message.initRoot(TestAllTypes.factory);
    TestUtil.initTestMessage(allTypes);
    TestUtil.checkTestMessage(allTypes);
    TestUtil.checkTestMessage(allTypes.asReader());
  }

  test("AllTypesMultiSegment") {
    val message = new MessageBuilder(5, BuilderArena.AllocationStrategy.FIXED_SIZE);
    val allTypes = message.initRoot(TestAllTypes.factory);
    TestUtil.initTestMessage(allTypes);

    TestUtil.checkTestMessage(allTypes);
    TestUtil.checkTestMessage(allTypes.asReader());
  }

  test("Groups") {
    val builder = new MessageBuilder();
    val root = builder.initRoot(TestGroups.factory);

    //val foo = root.getGroups().initFoo();

  }


  // to debug, do this:
  //Serialize.writeMessage((new java.io.FileOutputStream("/Users/dwrensha/Desktop/test.dat")).getChannel(),
  //                       message);


}
