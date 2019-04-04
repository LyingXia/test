/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Apr 04 03:09:05 GMT 2019
 */

package com.test.sometest;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class testSelenium_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.test.sometest.testSelenium"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "GBK"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.country", "CN"); 
    java.lang.System.setProperty("user.language", "zh"); 
    java.lang.System.setProperty("user.timezone", "Asia/Shanghai"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(testSelenium_ESTest_scaffolding.class.getClassLoader() ,
      "org.openqa.selenium.Platform$10",
      "org.openqa.selenium.Platform$11",
      "com.google.common.collect.Hashing",
      "org.openqa.selenium.remote.service.DriverService$Builder",
      "org.openqa.selenium.net.EphemeralPortRangeDetector",
      "org.openqa.selenium.Platform$14",
      "com.google.common.collect.ImmutableList$SubList",
      "org.openqa.selenium.Platform$15",
      "org.openqa.selenium.html5.LocationContext",
      "org.openqa.selenium.Platform$12",
      "org.openqa.selenium.Platform$13",
      "org.openqa.selenium.remote.Augmentable",
      "com.google.common.collect.PeekingIterator",
      "com.google.common.collect.ImmutableSet$Indexed",
      "org.openqa.selenium.os.OsProcess",
      "com.google.common.collect.RegularImmutableList",
      "org.openqa.selenium.internal.FindsById",
      "com.google.common.base.Optional",
      "org.openqa.selenium.net.FixedIANAPortRange",
      "org.openqa.selenium.Platform$16",
      "org.openqa.selenium.net.UrlChecker$TimeoutException",
      "com.google.common.collect.ImmutableCollection$ArrayBasedBuilder",
      "com.google.common.collect.Platform",
      "com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl",
      "com.google.common.collect.ImmutableMapKeySet",
      "com.google.common.collect.RegularImmutableMap",
      "com.google.common.collect.RegularImmutableBiMap",
      "com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1",
      "com.google.common.collect.RegularImmutableSet",
      "com.google.common.collect.AbstractMapEntry",
      "com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap",
      "com.google.common.collect.Iterators$12",
      "com.google.common.collect.Iterators$11",
      "com.google.common.collect.ImmutableBiMap$Builder",
      "com.google.common.base.Predicate",
      "org.openqa.selenium.NoSuchSessionException",
      "org.openqa.selenium.chrome.ChromeDriverService$Builder",
      "org.openqa.selenium.internal.FindsByCssSelector",
      "org.openqa.selenium.internal.FindsByTagName",
      "org.openqa.selenium.logging.Logs",
      "com.google.common.collect.ImmutableSet$Indexed$1",
      "org.openqa.selenium.SearchContext",
      "org.openqa.selenium.chrome.ChromeDriverService",
      "com.google.common.collect.ImmutableAsList",
      "com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet",
      "org.openqa.selenium.WebDriver",
      "org.openqa.selenium.WebDriverException",
      "com.google.common.collect.ImmutableSet$Builder",
      "com.google.common.collect.RegularImmutableAsList",
      "com.google.common.collect.SingletonImmutableSet",
      "com.google.common.collect.Iterators$13",
      "com.google.common.collect.ImmutableMapEntrySet",
      "org.openqa.selenium.Platform$5",
      "org.openqa.selenium.Platform$6",
      "org.openqa.selenium.Platform$3",
      "org.openqa.selenium.TakesScreenshot",
      "org.openqa.selenium.Platform$4",
      "org.openqa.selenium.Platform$9",
      "org.openqa.selenium.Platform$7",
      "org.openqa.selenium.Platform$8",
      "com.google.common.collect.UnmodifiableListIterator",
      "org.openqa.selenium.os.ExecutableFinder",
      "org.openqa.selenium.Platform$1",
      "com.google.common.collect.ImmutableMultimap",
      "org.openqa.selenium.remote.FileDetector",
      "org.openqa.selenium.Platform$2",
      "org.openqa.selenium.net.PortProber",
      "org.openqa.selenium.WebDriver$Navigation",
      "com.google.common.collect.ObjectArrays",
      "com.google.common.collect.AbstractIterator",
      "org.openqa.selenium.Platform",
      "org.openqa.selenium.remote.RemoteWebDriver",
      "com.google.common.collect.ImmutableList$1",
      "com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets",
      "org.openqa.selenium.remote.SessionNotFoundException",
      "com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry",
      "org.openqa.selenium.remote.CommandExecutor",
      "com.google.common.base.Preconditions",
      "com.google.common.collect.UnmodifiableIterator",
      "com.google.common.collect.ImmutableMapValues",
      "com.google.common.collect.ImmutableEntry",
      "org.openqa.selenium.chrome.ChromeDriver",
      "org.openqa.selenium.remote.service.DriverService",
      "com.google.common.collect.ImmutableCollection",
      "org.openqa.selenium.logging.LoggingHandler",
      "org.openqa.selenium.interactions.Keyboard",
      "org.openqa.selenium.JavascriptExecutor",
      "com.google.common.collect.ImmutableList$ReverseImmutableList",
      "org.openqa.selenium.remote.ExecuteMethod",
      "com.google.common.collect.SingletonImmutableList",
      "org.openqa.selenium.interactions.HasInputDevices",
      "com.google.common.collect.ImmutableCollection$Builder",
      "com.google.common.collect.ImmutableSetMultimap",
      "com.google.common.collect.Iterators$6",
      "com.google.common.collect.BiMap",
      "com.google.common.collect.Iterators$7",
      "com.google.common.base.Function",
      "com.google.common.collect.ImmutableSet",
      "com.google.common.collect.ImmutableMap",
      "com.google.common.collect.ImmutableMapEntry",
      "com.google.common.collect.AbstractIndexedListIterator",
      "org.openqa.selenium.Capabilities",
      "com.google.common.collect.CollectPreconditions",
      "org.openqa.selenium.interactions.Mouse",
      "com.google.common.collect.Iterators$1",
      "com.google.common.collect.Iterators$2",
      "com.google.common.collect.ImmutableMapValues$1",
      "com.google.common.collect.Iterators$3",
      "com.google.common.collect.ImmutableMapValues$2",
      "org.openqa.selenium.internal.FindsByLinkText",
      "com.google.common.collect.RegularImmutableBiMap$Inverse",
      "com.google.common.collect.ImmutableMap$1",
      "org.openqa.selenium.remote.UnreachableBrowserException",
      "org.openqa.selenium.internal.FindsByClassName",
      "com.google.common.collect.AbstractMultimap",
      "com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableBiMapEntry",
      "com.google.common.collect.Multimap",
      "com.google.common.collect.Iterators",
      "com.google.common.collect.ImmutableBiMap",
      "com.google.common.collect.ImmutableList",
      "org.openqa.selenium.internal.FindsByName",
      "com.google.common.collect.SingletonImmutableBiMap",
      "org.openqa.selenium.NotFoundException",
      "org.openqa.selenium.HasCapabilities",
      "com.test.sometest.testSelenium",
      "org.openqa.selenium.html5.WebStorage",
      "org.openqa.selenium.WebDriver$Options",
      "org.openqa.selenium.os.CommandLine",
      "org.openqa.selenium.internal.FindsByXPath",
      "org.openqa.selenium.Beta",
      "com.google.common.collect.ImmutableMap$Builder",
      "com.google.common.collect.SetMultimap",
      "org.openqa.selenium.WebDriver$TargetLocator",
      "com.google.common.collect.Iterators$MergingIterator"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(testSelenium_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.openqa.selenium.remote.RemoteWebDriver",
      "org.openqa.selenium.chrome.ChromeDriverService",
      "com.google.common.collect.ImmutableMap",
      "com.google.common.collect.ImmutableBiMap",
      "com.google.common.collect.RegularImmutableBiMap",
      "org.openqa.selenium.Platform$1",
      "org.openqa.selenium.Platform$2",
      "org.openqa.selenium.Platform$3",
      "org.openqa.selenium.Platform$4",
      "org.openqa.selenium.Platform$5",
      "org.openqa.selenium.Platform$6",
      "org.openqa.selenium.Platform$7",
      "org.openqa.selenium.Platform$8",
      "org.openqa.selenium.Platform$9",
      "org.openqa.selenium.Platform$10",
      "org.openqa.selenium.Platform$11",
      "org.openqa.selenium.Platform$12",
      "org.openqa.selenium.Platform$13",
      "org.openqa.selenium.Platform$14",
      "org.openqa.selenium.Platform$15",
      "org.openqa.selenium.Platform$16",
      "org.openqa.selenium.Platform",
      "org.openqa.selenium.net.PortProber",
      "com.google.common.collect.ImmutableCollection",
      "com.google.common.collect.ImmutableSet",
      "com.google.common.collect.ObjectArrays",
      "com.google.common.collect.Hashing",
      "com.google.common.collect.RegularImmutableSet",
      "org.openqa.selenium.os.ExecutableFinder",
      "com.google.common.collect.ImmutableCollection$Builder",
      "com.google.common.collect.Iterators"
    );
  }
}