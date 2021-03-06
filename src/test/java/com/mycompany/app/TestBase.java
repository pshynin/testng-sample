package com.mycompany.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by pshynin on 11/8/16.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(FunctionCreateFileTests.class);

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " With parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " With parameters " + Arrays.asList(p));
  }

  @BeforeSuite
  public void setUp() throws Exception {
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
  }
}
