package com.test.runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses({com.test.testcases.TestLoginLogout.class,com.test.testcases.TestCart.class,com.test.testcases.TestCheckout.class })
public class TestRunner {


}
