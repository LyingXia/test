/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Apr 04 02:28:26 GMT 2019
 */

package com.test.applications.qmclotserver;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class easyFun_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.test.applications.qmclotserver.easyFun"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(easyFun_ESTest_scaffolding.class.getClassLoader() ,
      "org.apache.commons.beanutils.PropertyUtils",
      "org.apache.commons.beanutils.converters.SqlTimestampConverter",
      "net.sf.json.util.JavaIdentifierTransformer$CamelCaseJavaIdentifierTransformer",
      "net.sf.json.regexp.RegexpMatcher",
      "net.sf.ezmorph.MorphUtils",
      "net.sf.ezmorph.array.IntArrayMorpher",
      "org.apache.commons.beanutils.converters.ArrayConverter",
      "net.sf.ezmorph.object.AbstractObjectMorpher",
      "org.apache.commons.beanutils.ConvertUtilsBean",
      "net.sf.ezmorph.primitive.DoubleMorpher",
      "org.apache.commons.beanutils.converters.DateTimeConverter",
      "net.sf.ezmorph.array.CharArrayMorpher",
      "com.test.applications.qmclotserver.testPost",
      "org.apache.commons.collections.MapIterator",
      "net.sf.ezmorph.object.BooleanObjectMorpher",
      "net.sf.json.JSONString",
      "net.sf.ezmorph.bean.MorphDynaClass",
      "net.sf.ezmorph.ObjectMorpher",
      "net.sf.json.JSON",
      "org.apache.commons.beanutils.expression.Resolver",
      "org.apache.commons.collections.map.ListOrderedMap$KeySetView$1",
      "org.apache.commons.beanutils.converters.NumberConverter",
      "net.sf.ezmorph.primitive.AbstractPrimitiveMorpher",
      "net.sf.ezmorph.array.ObjectArrayMorpher",
      "com.test.applications.qmclotserver.easyFun",
      "net.sf.json.util.PropertyExclusionClassMatcher$DefaultPropertyExclusionClassMatcher",
      "org.apache.commons.beanutils.converters.LongConverter",
      "net.sf.json.util.PropertyExclusionClassMatcher",
      "net.sf.json.util.JavaIdentifierTransformer$UnderscoreJavaIdentifierTransformer",
      "org.apache.commons.collections.map.ListOrderedMap$KeySetView",
      "org.apache.commons.beanutils.converters.BigIntegerConverter",
      "org.apache.commons.collections.map.HashedMap",
      "org.apache.commons.beanutils.WeakFastHashMap",
      "org.apache.commons.beanutils.converters.CharacterConverter",
      "net.sf.ezmorph.primitive.AbstractDecimalMorpher",
      "org.apache.commons.beanutils.MappedPropertyDescriptor",
      "org.apache.commons.collections.IterableMap",
      "org.apache.commons.beanutils.Converter",
      "net.sf.json.processors.JsonBeanProcessorMatcher",
      "net.sf.json.util.CycleDetectionStrategy",
      "net.sf.json.JSONObject",
      "net.sf.json.util.CycleDetectionStrategy$LenientNoRefCycleDetectionStrategy",
      "net.sf.ezmorph.MorpherRegistry",
      "org.apache.commons.collections.map.ListOrderedMap$ListOrderedMapEntry",
      "org.apache.commons.beanutils.MethodUtils",
      "net.sf.ezmorph.primitive.ShortMorpher",
      "org.apache.commons.beanutils.BeanUtils",
      "net.sf.ezmorph.array.ShortArrayMorpher",
      "org.apache.commons.lang.exception.NestableRuntimeException",
      "net.sf.json.processors.JsonValueProcessorMatcher",
      "net.sf.ezmorph.array.DoubleArrayMorpher",
      "org.apache.commons.collections.map.ListOrderedMap",
      "org.apache.commons.beanutils.ContextClassLoaderLocal",
      "net.sf.ezmorph.primitive.ByteMorpher",
      "net.sf.json.util.JavaIdentifierTransformer$WhiteSpaceJavaIdentifierTransformer",
      "org.apache.commons.beanutils.converters.DateConverter",
      "net.sf.ezmorph.array.ByteArrayMorpher",
      "org.apache.commons.collections.OrderedIterator",
      "net.sf.ezmorph.primitive.CharMorpher",
      "org.apache.commons.collections.map.MultiKeyMap",
      "net.sf.ezmorph.primitive.FloatMorpher",
      "net.sf.json.util.JsonEventListener",
      "org.apache.commons.collections.map.AbstractHashedMap$HashEntry",
      "net.sf.json.JSONException",
      "org.apache.commons.beanutils.converters.SqlTimeConverter",
      "org.apache.commons.collections.iterators.AbstractEmptyIterator",
      "net.sf.ezmorph.bean.MorphDynaBean",
      "net.sf.json.AbstractJSON$CycleSet",
      "net.sf.json.processors.JsonValueProcessor",
      "org.apache.commons.collections.OrderedMap",
      "org.apache.commons.beanutils.BeanUtilsBean",
      "net.sf.ezmorph.primitive.BooleanMorpher",
      "net.sf.ezmorph.MorphException",
      "org.apache.commons.collections.map.ListOrderedMap$EntrySetView",
      "org.apache.commons.beanutils.ConvertUtils",
      "net.sf.json.JSONArray",
      "org.apache.commons.beanutils.converters.DoubleConverter",
      "org.apache.commons.collections.keyvalue.AbstractMapEntry",
      "org.apache.commons.beanutils.converters.BigDecimalConverter",
      "org.apache.commons.beanutils.BeanUtilsBean$1",
      "com.test.applications.qmclotserver.login",
      "net.sf.json.util.NewBeanInstanceStrategy",
      "net.sf.json.util.JavaIdentifierTransformer$NoopJavaIdentifierTransformer",
      "net.sf.ezmorph.primitive.LongMorpher",
      "net.sf.json.regexp.RegexpUtils",
      "org.apache.commons.beanutils.MethodUtils$MethodDescriptor",
      "net.sf.json.processors.JsonBeanProcessorMatcher$DefaultJsonBeanProcessorMatcher",
      "org.apache.commons.collections.FastHashMap",
      "org.apache.commons.collections.ResettableIterator",
      "org.apache.commons.beanutils.converters.BooleanConverter",
      "org.apache.commons.collections.map.AbstractMapDecorator",
      "org.apache.commons.lang.exception.NestableDelegate",
      "org.apache.commons.beanutils.converters.ClassConverter",
      "net.sf.json.JsonConfig",
      "net.sf.ezmorph.primitive.IntMorpher",
      "org.apache.commons.beanutils.converters.AbstractConverter",
      "org.apache.commons.beanutils.converters.ByteConverter",
      "net.sf.json.JSONNull",
      "net.sf.json.processors.JsonBeanProcessor",
      "org.apache.commons.collections.iterators.EmptyIterator",
      "org.apache.commons.beanutils.converters.ConverterFacade",
      "org.apache.commons.beanutils.converters.FloatConverter",
      "org.apache.commons.beanutils.DynaBean",
      "org.springframework.web.bind.annotation.RequestMethod",
      "net.sf.json.util.NewBeanInstanceStrategy$DefaultNewBeanInstanceStrategy",
      "org.apache.commons.beanutils.DynaProperty",
      "net.sf.ezmorph.array.LongArrayMorpher",
      "net.sf.ezmorph.bean.MorphDynaClass$1",
      "org.apache.commons.beanutils.BeanAccessLanguageException",
      "org.apache.commons.beanutils.converters.SqlDateConverter",
      "org.apache.commons.collections.map.AbstractHashedMap",
      "org.apache.commons.beanutils.converters.FileConverter",
      "net.sf.json.processors.DefaultDefaultValueProcessor",
      "net.sf.json.processors.DefaultValueProcessor",
      "net.sf.ezmorph.object.CharacterObjectMorpher",
      "org.apache.commons.beanutils.PropertyUtilsBean",
      "net.sf.json.util.JavaIdentifierTransformer",
      "org.apache.commons.beanutils.DynaClass",
      "net.sf.ezmorph.array.FloatArrayMorpher",
      "net.sf.ezmorph.object.ClassMorpher",
      "net.sf.ezmorph.object.NumberMorpher",
      "org.apache.commons.logging.impl.Jdk14Logger",
      "net.sf.ezmorph.array.BooleanArrayMorpher",
      "net.sf.json.processors.DefaultValueProcessorMatcher",
      "org.apache.commons.collections.KeyValue",
      "org.apache.commons.collections.keyvalue.AbstractKeyValue",
      "net.sf.json.util.JSONUtils",
      "net.sf.ezmorph.primitive.AbstractIntegerMorpher",
      "org.apache.commons.beanutils.ConversionException",
      "net.sf.json.regexp.JdkRegexpMatcher",
      "org.apache.commons.collections.OrderedMapIterator",
      "net.sf.json.AbstractJSON",
      "net.sf.ezmorph.Morpher",
      "net.sf.json.util.CycleDetectionStrategy$LenientCycleDetectionStrategy",
      "net.sf.json.util.NewBeanInstanceStrategy$1",
      "net.sf.json.processors.PropertyNameProcessorMatcher$DefaultPropertyNameProcessorMatcher",
      "net.sf.json.processors.DefaultValueProcessorMatcher$DefaultDefaultValueProcessorMatcher",
      "net.sf.json.JSONFunction",
      "net.sf.json.util.JavaIdentifierTransformer$StrictJavaIdentifierTransformer",
      "org.apache.commons.beanutils.converters.ShortConverter",
      "net.sf.json.util.CycleDetectionStrategy$StrictCycleDetectionStrategy",
      "org.apache.commons.collections.map.ListOrderedMap$ListOrderedIterator",
      "net.sf.json.util.PropertySetStrategy$DefaultPropertySetStrategy",
      "org.apache.commons.beanutils.converters.StringConverter",
      "net.sf.json.processors.PropertyNameProcessorMatcher",
      "net.sf.json.processors.JsonValueProcessorMatcher$DefaultJsonValueProcessorMatcher",
      "net.sf.ezmorph.object.StringMorpher",
      "org.apache.commons.beanutils.NestedNullException",
      "net.sf.ezmorph.array.AbstractArrayMorpher",
      "org.apache.commons.beanutils.converters.IntegerConverter",
      "org.apache.commons.beanutils.expression.DefaultResolver",
      "org.apache.commons.lang.exception.Nestable",
      "net.sf.json.util.JSONTokener",
      "net.sf.json.processors.PropertyNameProcessor",
      "net.sf.json.util.PropertySetStrategy",
      "org.apache.commons.collections.iterators.AbstractIteratorDecorator",
      "org.apache.commons.beanutils.converters.URLConverter",
      "org.apache.commons.beanutils.converters.CalendarConverter",
      "org.apache.commons.lang.ArrayUtils",
      "net.sf.json.util.PropertyFilter"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(easyFun_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.springframework.web.bind.annotation.RequestMethod",
      "net.sf.ezmorph.MorpherRegistry",
      "net.sf.ezmorph.MorphUtils",
      "net.sf.ezmorph.array.AbstractArrayMorpher",
      "net.sf.ezmorph.array.BooleanArrayMorpher",
      "net.sf.ezmorph.array.CharArrayMorpher",
      "net.sf.ezmorph.array.ByteArrayMorpher",
      "net.sf.ezmorph.array.ShortArrayMorpher",
      "net.sf.ezmorph.array.IntArrayMorpher",
      "net.sf.ezmorph.array.LongArrayMorpher",
      "net.sf.ezmorph.array.FloatArrayMorpher",
      "net.sf.ezmorph.array.DoubleArrayMorpher",
      "net.sf.ezmorph.object.BooleanObjectMorpher",
      "net.sf.ezmorph.object.CharacterObjectMorpher",
      "net.sf.ezmorph.object.StringMorpher",
      "net.sf.ezmorph.object.NumberMorpher",
      "net.sf.ezmorph.object.ClassMorpher",
      "net.sf.ezmorph.array.ObjectArrayMorpher",
      "net.sf.json.util.JSONUtils",
      "net.sf.json.JSONNull",
      "net.sf.json.regexp.RegexpUtils",
      "org.apache.commons.lang.ArrayUtils",
      "org.apache.commons.beanutils.PropertyUtilsBean",
      "org.apache.commons.beanutils.BeanUtilsBean",
      "net.sf.json.AbstractJSON",
      "net.sf.json.JSONObject",
      "org.apache.commons.collections.map.ListOrderedMap",
      "net.sf.json.processors.DefaultValueProcessorMatcher",
      "net.sf.json.processors.JsonBeanProcessorMatcher",
      "net.sf.json.processors.JsonValueProcessorMatcher",
      "net.sf.json.util.NewBeanInstanceStrategy$DefaultNewBeanInstanceStrategy",
      "net.sf.json.util.NewBeanInstanceStrategy",
      "net.sf.json.util.PropertyExclusionClassMatcher",
      "net.sf.json.processors.PropertyNameProcessorMatcher",
      "net.sf.json.JSONArray",
      "net.sf.json.util.CycleDetectionStrategy",
      "net.sf.json.util.JavaIdentifierTransformer",
      "net.sf.json.JsonConfig",
      "org.apache.commons.collections.map.MultiKeyMap",
      "org.apache.commons.collections.map.AbstractHashedMap",
      "org.apache.commons.collections.map.HashedMap",
      "org.apache.commons.lang.exception.NestableRuntimeException",
      "net.sf.json.JSONException",
      "org.apache.commons.lang.exception.NestableDelegate",
      "org.apache.commons.beanutils.expression.DefaultResolver",
      "org.apache.commons.beanutils.PropertyUtils",
      "org.apache.commons.beanutils.WeakFastHashMap",
      "org.apache.commons.beanutils.ConvertUtilsBean",
      "org.apache.commons.beanutils.converters.AbstractConverter",
      "org.apache.commons.beanutils.converters.BooleanConverter",
      "org.apache.commons.beanutils.converters.NumberConverter",
      "org.apache.commons.beanutils.converters.ByteConverter",
      "org.apache.commons.beanutils.converters.CharacterConverter",
      "org.apache.commons.beanutils.converters.DoubleConverter",
      "org.apache.commons.beanutils.converters.FloatConverter",
      "org.apache.commons.beanutils.converters.IntegerConverter",
      "org.apache.commons.beanutils.converters.LongConverter",
      "org.apache.commons.beanutils.converters.ShortConverter",
      "org.apache.commons.beanutils.converters.BigDecimalConverter",
      "org.apache.commons.beanutils.converters.BigIntegerConverter",
      "org.apache.commons.beanutils.converters.StringConverter",
      "org.apache.commons.beanutils.converters.ClassConverter",
      "org.apache.commons.beanutils.converters.DateTimeConverter",
      "org.apache.commons.beanutils.converters.DateConverter",
      "org.apache.commons.beanutils.converters.CalendarConverter",
      "org.apache.commons.beanutils.converters.FileConverter",
      "org.apache.commons.beanutils.converters.SqlDateConverter",
      "org.apache.commons.beanutils.converters.SqlTimeConverter",
      "org.apache.commons.beanutils.converters.SqlTimestampConverter",
      "org.apache.commons.beanutils.converters.URLConverter",
      "org.apache.commons.beanutils.converters.ArrayConverter",
      "org.apache.commons.beanutils.BeanUtils",
      "org.apache.commons.beanutils.MethodUtils",
      "org.apache.commons.collections.iterators.EmptyIterator",
      "org.apache.commons.collections.FastHashMap",
      "org.apache.commons.beanutils.MappedPropertyDescriptor",
      "net.sf.ezmorph.bean.MorphDynaClass",
      "net.sf.ezmorph.bean.MorphDynaBean",
      "org.apache.commons.logging.impl.Jdk14Logger"
    );
  }
}