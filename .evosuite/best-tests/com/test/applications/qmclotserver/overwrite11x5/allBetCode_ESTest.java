/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:07:40 GMT 2019
 */

package com.test.applications.qmclotserver.overwrite11x5;

import org.junit.Test;
import static org.junit.Assert.*;
import com.test.applications.qmclotserver.overwrite11x5.allBetCode;
import net.sf.json.JSONObject;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class allBetCode_ESTest extends allBetCode_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      allBetCode allBetCode0 = new allBetCode();
      String[] stringArray0 = allBetCode0.setCode();
      assertNotNull(stringArray0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      allBetCode allBetCode0 = new allBetCode();
      JSONObject jSONObject0 = allBetCode0.betpost();
      assertFalse(jSONObject0.isArray());
  }
}