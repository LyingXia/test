/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 02:53:04 GMT 2019
 */

package com.test.sometest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.test.sometest.arrayDesc;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class arrayDesc_ESTest extends arrayDesc_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      arrayDesc arrayDesc0 = new arrayDesc();
      int[] intArray0 = new int[2];
      intArray0[1] = 100;
      arrayDesc0.desc(intArray0);
      assertArrayEquals(new int[] {0, 100}, intArray0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      arrayDesc arrayDesc0 = new arrayDesc();
      // Undeclared exception!
      try { 
        arrayDesc0.desc((int[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Arrays", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      arrayDesc arrayDesc0 = new arrayDesc();
      int[] intArray0 = new int[9];
      intArray0[0] = (-1);
      arrayDesc0.desc(intArray0);
      assertArrayEquals(new int[] {(-1), 0, 0, 0, 0, 0, 0, 0, 0}, intArray0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      arrayDesc arrayDesc0 = new arrayDesc();
      int[] intArray0 = new int[9];
      intArray0[6] = 766;
      arrayDesc0.desc(intArray0);
      assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 766}, intArray0);
  }
}
