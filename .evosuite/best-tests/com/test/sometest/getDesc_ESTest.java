/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 02:59:30 GMT 2019
 */

package com.test.sometest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.test.sometest.getDesc;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class getDesc_ESTest extends getDesc_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      getDesc getDesc0 = new getDesc();
      int int0 = getDesc0.revInt(0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      getDesc getDesc0 = new getDesc();
      // Undeclared exception!
      try { 
        getDesc0.revInt((-648));
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"846-\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      getDesc getDesc0 = new getDesc();
      int int0 = getDesc0.revInt(731);
      assertEquals(137, int0);
  }
}
