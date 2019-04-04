/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Apr 04 02:58:34 GMT 2019
 */

package com.test.applications;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class test_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.test.applications.test"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(test_ESTest_scaffolding.class.getClassLoader() ,
      "org.openqa.selenium.io.FileHandler$Filter",
      "org.openqa.selenium.remote.CommandInfo",
      "org.openqa.selenium.net.EphemeralPortRangeDetector",
      "com.google.common.collect.ImmutableMultimap$Itr",
      "com.google.common.collect.Lists$RandomAccessPartition",
      "org.openqa.selenium.remote.Augmentable",
      "com.google.common.collect.Collections2",
      "com.google.common.collect.PeekingIterator",
      "com.google.common.collect.ImmutableSet$Indexed",
      "org.openqa.selenium.logging.LogEntry$1",
      "org.openqa.selenium.os.OsProcess",
      "org.openqa.selenium.chrome.ChromeOptions",
      "org.openqa.selenium.remote.internal.ApacheHttpClient",
      "org.openqa.selenium.internal.FindsById",
      "org.openqa.selenium.net.FixedIANAPortRange",
      "org.openqa.selenium.net.UrlChecker$TimeoutException",
      "com.google.common.collect.ImmutableCollection$ArrayBasedBuilder",
      "com.google.common.collect.Platform",
      "com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl",
      "com.google.common.collect.RegularImmutableMap",
      "com.google.common.collect.RegularImmutableBiMap",
      "com.google.common.base.Converter$IdentityConverter",
      "com.google.common.collect.ImmutableMultimap$Values",
      "org.apache.http.conn.HttpClientConnectionManager",
      "com.google.common.collect.AbstractMapEntry",
      "com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap",
      "com.google.common.collect.Iterators$12",
      "com.google.common.collect.Iterators$11",
      "com.google.common.collect.ImmutableBiMap$Builder",
      "com.google.common.base.Predicate",
      "com.google.common.collect.ImmutableSet$Indexed$1",
      "org.apache.http.client.CredentialsProvider",
      "com.google.common.base.Joiner",
      "org.openqa.selenium.logging.profiler.ProfilerLogEntry",
      "org.apache.http.client.ClientProtocolException",
      "org.openqa.selenium.SearchContext",
      "org.openqa.selenium.chrome.ChromeDriverService",
      "org.openqa.selenium.WebDriverException",
      "org.openqa.selenium.WebDriver",
      "com.google.common.collect.Iterators$13",
      "org.openqa.selenium.remote.RemoteWebDriver$When",
      "com.google.common.collect.Lists$Partition",
      "com.google.common.collect.Lists",
      "org.apache.http.auth.Credentials",
      "com.google.common.collect.UnmodifiableListIterator",
      "com.google.common.collect.ImmutableMultimap",
      "org.openqa.selenium.remote.FileDetector",
      "org.openqa.selenium.remote.Response",
      "com.google.common.collect.Maps$BiMapConverter",
      "com.google.common.base.Joiner$MapJoiner",
      "com.google.common.base.Equivalence$Equals",
      "org.apache.http.client.RedirectStrategy",
      "com.test.applications.test",
      "org.openqa.selenium.remote.SessionNotFoundException",
      "org.apache.http.protocol.HttpContext",
      "com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry",
      "org.openqa.selenium.remote.CommandExecutor",
      "org.apache.http.HttpResponse",
      "com.google.common.base.Preconditions",
      "org.openqa.selenium.UnsupportedCommandException",
      "org.openqa.selenium.remote.SessionId",
      "com.google.common.collect.ImmutableMapValues",
      "com.google.common.collect.ImmutableEntry",
      "com.google.common.base.Joiner$1",
      "com.google.common.base.Joiner$2",
      "com.google.common.base.Converter$ConverterComposition",
      "com.google.common.collect.AbstractNavigableMap",
      "com.google.common.collect.ImmutableCollection",
      "com.google.common.collect.ImmutableEnumMap",
      "org.openqa.selenium.logging.LoggingHandler",
      "org.openqa.selenium.JavascriptExecutor",
      "org.openqa.selenium.interactions.HasInputDevices",
      "com.google.common.collect.ImmutableCollection$Builder",
      "com.google.common.collect.ImmutableSetMultimap",
      "com.google.common.collect.Iterators$6",
      "com.google.common.collect.BiMap",
      "com.google.common.collect.Iterators$7",
      "com.google.common.collect.ImmutableSet",
      "com.google.common.collect.Lists$AbstractListWrapper",
      "com.google.common.collect.ImmutableMapEntry",
      "org.openqa.selenium.remote.HttpCommandExecutor",
      "org.apache.http.HttpEntity",
      "org.openqa.selenium.interactions.Mouse",
      "com.google.common.collect.Iterators$1",
      "com.google.common.collect.Iterators$2",
      "com.google.common.collect.ImmutableMapValues$1",
      "com.google.common.collect.Iterators$3",
      "com.google.common.collect.ImmutableMapValues$2",
      "org.openqa.selenium.internal.FindsByLinkText",
      "org.openqa.selenium.remote.http.HttpClient",
      "com.google.common.base.Converter$ReverseConverter",
      "com.google.common.collect.ImmutableMultimap$EntryCollection",
      "com.google.common.collect.Lists$StringAsImmutableList",
      "com.google.common.collect.Lists$2",
      "org.openqa.selenium.logging.NeedsLocalLogs",
      "com.google.common.collect.Maps$IteratorBasedAbstractMap",
      "com.google.common.collect.Maps$FilteredEntryBiMap",
      "com.google.common.collect.RegularImmutableBiMap$Inverse",
      "com.google.common.collect.Lists$1",
      "org.apache.http.conn.SchemePortResolver",
      "org.openqa.selenium.logging.LogEntry",
      "com.google.common.base.Equivalence$Identity",
      "org.openqa.selenium.remote.UnreachableBrowserException",
      "com.google.common.collect.Multiset",
      "org.openqa.selenium.internal.FindsByClassName",
      "com.google.common.collect.AbstractMultimap",
      "com.google.common.collect.EmptyImmutableListMultimap",
      "com.google.common.collect.ImmutableList",
      "org.openqa.selenium.internal.FindsByName",
      "org.openqa.selenium.NotFoundException",
      "org.openqa.selenium.HasCapabilities",
      "org.openqa.selenium.By$ByPartialLinkText",
      "org.openqa.selenium.NoAlertPresentException",
      "org.openqa.selenium.By$ById",
      "org.openqa.selenium.html5.WebStorage",
      "com.google.common.collect.Maps$FilteredEntrySortedMap",
      "org.openqa.selenium.io.FileHandler",
      "org.openqa.selenium.By",
      "com.google.common.collect.ImmutableMap$Builder",
      "com.google.common.base.Converter$FunctionBasedConverter",
      "org.openqa.selenium.WebDriver$TargetLocator",
      "com.google.common.collect.Maps$EntryTransformer",
      "org.openqa.selenium.remote.http.HttpMethod",
      "org.openqa.selenium.logging.LocalLogs",
      "org.openqa.selenium.Platform$10",
      "org.openqa.selenium.Platform$11",
      "com.google.common.collect.Hashing",
      "org.openqa.selenium.remote.service.DriverService$Builder",
      "org.openqa.selenium.Platform$14",
      "com.google.common.collect.ImmutableList$SubList",
      "org.openqa.selenium.Platform$15",
      "com.google.common.collect.ListMultimap",
      "com.google.common.base.FunctionalEquivalence",
      "org.openqa.selenium.html5.LocationContext",
      "org.openqa.selenium.Platform$12",
      "org.openqa.selenium.Platform$13",
      "com.google.common.collect.RegularImmutableList",
      "com.google.common.base.Optional",
      "com.google.common.collect.Lists$TransformingRandomAccessList",
      "org.apache.http.HttpMessage",
      "org.openqa.selenium.Platform$16",
      "org.openqa.selenium.remote.http.HttpClient$Factory",
      "com.google.common.collect.ImmutableMapKeySet",
      "com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1",
      "org.openqa.selenium.remote.DesiredCapabilities",
      "org.apache.http.HttpRequest",
      "com.google.common.collect.SortedMapDifference",
      "com.google.common.collect.RegularImmutableSet",
      "org.openqa.selenium.NoSuchSessionException",
      "org.openqa.selenium.chrome.ChromeDriverService$Builder",
      "com.google.common.collect.ImmutableListMultimap",
      "com.google.common.collect.ImmutableMultimap$1",
      "org.openqa.selenium.internal.FindsByCssSelector",
      "com.google.common.collect.Maps$AbstractFilteredMap",
      "org.openqa.selenium.internal.FindsByTagName",
      "org.openqa.selenium.logging.Logs",
      "com.google.common.base.Present",
      "org.openqa.selenium.By$ByName",
      "com.google.common.collect.ImmutableMultimap$2",
      "com.google.common.collect.ImmutableAsList",
      "com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet",
      "com.google.common.collect.ImmutableSet$Builder",
      "com.google.common.collect.RegularImmutableAsList",
      "com.google.common.collect.Maps$FilteredEntryMap",
      "com.google.common.collect.SingletonImmutableSet",
      "org.apache.http.client.methods.HttpUriRequest",
      "com.google.common.collect.ImmutableMapEntrySet",
      "org.openqa.selenium.Platform$5",
      "org.openqa.selenium.Platform$6",
      "org.openqa.selenium.Platform$3",
      "org.openqa.selenium.TakesScreenshot",
      "org.openqa.selenium.Platform$4",
      "org.openqa.selenium.Platform$9",
      "org.apache.http.client.HttpClient",
      "org.openqa.selenium.Platform$7",
      "com.google.common.collect.ImmutableMultiset",
      "org.openqa.selenium.Platform$8",
      "com.google.common.collect.ImmutableMultimap$Keys",
      "org.openqa.selenium.os.ExecutableFinder",
      "org.openqa.selenium.Platform$1",
      "org.openqa.selenium.Platform$2",
      "com.google.common.collect.Lists$TransformingSequentialList",
      "org.openqa.selenium.net.PortProber",
      "org.openqa.selenium.WebDriver$Navigation",
      "com.google.common.collect.ObjectArrays",
      "com.google.common.collect.AbstractIterator",
      "org.openqa.selenium.Platform",
      "org.openqa.selenium.remote.RemoteWebDriver",
      "com.google.common.collect.ImmutableList$1",
      "org.openqa.selenium.NoSuchElementException",
      "com.google.common.collect.MapDifference",
      "com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets",
      "org.openqa.selenium.By$ByXPath",
      "com.google.common.collect.UnmodifiableIterator",
      "org.openqa.selenium.By$ByClassName",
      "org.openqa.selenium.remote.Command",
      "com.google.common.collect.Maps$FilteredEntryNavigableMap",
      "org.openqa.selenium.chrome.ChromeDriver",
      "org.openqa.selenium.remote.service.DriverService",
      "org.apache.http.NoHttpResponseException",
      "com.google.common.collect.Lists$RandomAccessListWrapper",
      "org.openqa.selenium.interactions.Keyboard",
      "com.google.common.collect.ImmutableList$ReverseImmutableList",
      "org.apache.http.conn.routing.HttpRoutePlanner",
      "org.openqa.selenium.remote.ExecuteMethod",
      "com.google.common.collect.SingletonImmutableList",
      "org.openqa.selenium.logging.LocalLogs$1",
      "com.google.common.base.Converter",
      "com.google.common.collect.Maps$6",
      "com.google.common.base.Function",
      "com.google.common.collect.ImmutableMap",
      "com.google.common.collect.AbstractIndexedListIterator",
      "org.openqa.selenium.Capabilities",
      "com.google.common.collect.CollectPreconditions",
      "org.openqa.selenium.remote.internal.HttpClientFactory",
      "org.openqa.selenium.remote.internal.ApacheHttpClient$Factory",
      "com.google.common.collect.Maps$ViewCachingAbstractMap",
      "com.google.common.collect.ImmutableMap$1",
      "com.google.common.collect.ImmutableList$Builder",
      "org.openqa.selenium.chrome.ChromeDriverCommandExecutor",
      "org.openqa.selenium.By$ByLinkText",
      "com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableBiMapEntry",
      "com.google.common.collect.Multimap",
      "com.google.common.collect.Iterators",
      "com.google.common.collect.ImmutableBiMap",
      "com.google.gson.JsonElement",
      "com.google.common.collect.SingletonImmutableBiMap",
      "com.google.common.base.PairwiseEquivalence",
      "org.openqa.selenium.remote.service.DriverCommandExecutor",
      "org.openqa.selenium.WebDriver$Options",
      "org.apache.http.impl.client.CloseableHttpClient",
      "org.openqa.selenium.os.CommandLine",
      "org.openqa.selenium.By$ByTagName",
      "com.google.common.base.Equivalence",
      "org.openqa.selenium.internal.FindsByXPath",
      "org.openqa.selenium.By$ByCssSelector",
      "com.google.common.collect.Maps",
      "org.openqa.selenium.Beta",
      "com.google.common.collect.SetMultimap",
      "org.openqa.selenium.logging.profiler.HttpProfilerLogEntry",
      "com.google.common.collect.Iterators$MergingIterator"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(test_ESTest_scaffolding.class.getClassLoader()); 

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
      "com.google.common.collect.Iterators",
      "com.google.common.collect.ImmutableList",
      "com.google.common.collect.SingletonImmutableList",
      "org.openqa.selenium.chrome.ChromeOptions",
      "com.google.common.collect.Collections2",
      "com.google.common.collect.Maps",
      "org.openqa.selenium.remote.DesiredCapabilities",
      "org.openqa.selenium.remote.HttpCommandExecutor",
      "org.openqa.selenium.remote.http.HttpMethod",
      "com.google.common.collect.SingletonImmutableBiMap",
      "org.openqa.selenium.chrome.ChromeDriverCommandExecutor",
      "org.openqa.selenium.remote.internal.ApacheHttpClient$Factory",
      "org.openqa.selenium.remote.internal.HttpClientFactory"
    );
  }
}
