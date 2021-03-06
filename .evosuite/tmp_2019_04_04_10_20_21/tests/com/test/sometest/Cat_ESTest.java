/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 04 03:11:56 GMT 2019
 */

package com.test.sometest;

import org.junit.Test;
import static org.junit.Assert.*;
import com.test.sometest.Cat;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Cat_ESTest extends Cat_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setScore((int[]) null);
      int[] intArray0 = cat0.getScore();
      assertNull(intArray0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Cat cat0 = new Cat();
      int[] intArray0 = new int[6];
      cat0.setScore(intArray0);
      int[] intArray1 = cat0.getScore();
      assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0}, intArray1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setName("\"!;+'");
      String string0 = cat0.getName();
      assertEquals("\"!;+'", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setColor("11|}dyZEny\"lzh(uAs]");
      String string0 = cat0.getColor();
      assertEquals("11|}dyZEny\"lzh(uAs]", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setColor("");
      String string0 = cat0.getColor();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setAge("/DA$,RuN\"?rYJpG");
      String string0 = cat0.getAge();
      assertEquals("/DA$,RuN\"?rYJpG", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setAge("");
      String string0 = cat0.getAge();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Cat cat0 = new Cat();
      String string0 = cat0.getAge();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Cat cat0 = new Cat();
      String string0 = cat0.getColor();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Cat cat0 = new Cat();
      int[] intArray0 = cat0.getScore();
      assertArrayEquals(new int[] {}, intArray0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Cat cat0 = new Cat();
      cat0.setName("");
      String string0 = cat0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Cat cat0 = new Cat();
      String string0 = cat0.getName();
      assertNull(string0);
  }
}
