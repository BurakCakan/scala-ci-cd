package com.test.burak

import org.scalatest.wordspec.AnyWordSpec
import com.test.burak.SampleCode.{countChange}

class UnitTests extends AnyWordSpec{



  "Function: count change" should {
    "test1" in {
      assert(countChange(4,List(1,2)) == 3)
    }
    "test2" in {
      assert(countChange(300,List(500,5,50,100,20,200,10)) == 1022)
    }
  }

}
