/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 02:43:12 GMT 2019
 */

package com.test.worldCup;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.test.worldCup.getData;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class getData_ESTest extends getData_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      getData getData0 = new getData();
      // Undeclared exception!
      try { 
        getData0.getData("Tf");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.test.worldCup.getData", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      getData getData0 = new getData();
      String string0 = getData0.get("Tf");
      assertNull(string0);
  }
}