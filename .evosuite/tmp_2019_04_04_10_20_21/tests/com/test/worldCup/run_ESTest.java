/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:12:53 GMT 2019
 */

package com.test.worldCup;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.test.worldCup.run;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class run_ESTest extends run_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      run run0 = new run();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[7];
      // Undeclared exception!
      try { 
        run.main(stringArray0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // org/apache/poi/ss/usermodel/Row
         //
         verifyException("com.test.worldCup.getHTML", e);
      }
  }
}
