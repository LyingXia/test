/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:08:21 GMT 2019
 */

package com.test.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import com.test.exception.testExc;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class testExc_ESTest extends testExc_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      testExc.main((String[]) null);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      testExc testExc0 = new testExc();
      testExc0.testexc();
  }
}
