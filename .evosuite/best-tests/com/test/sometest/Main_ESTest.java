/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:11:01 GMT 2019
 */

package com.test.sometest;

import org.junit.Test;
import static org.junit.Assert.*;
import com.test.sometest.Main;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Main_ESTest extends Main_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Main main0 = new Main();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[2];
      Main.main(stringArray0);
  }
}
