/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:03:23 GMT 2019
 */

package com.test.sometest;

import org.junit.Test;
import static org.junit.Assert.*;
import com.test.sometest.Demo;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Demo_ESTest extends Demo_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String[] stringArray0 = new String[1];
      Demo.main(stringArray0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Demo demo0 = new Demo();
  }
}
