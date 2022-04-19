package org.sample;

import org.base.BaseClass;
import org.testng.annotations.*;

public class Sample extends BaseClass {
	
	@BeforeClass
	private void BeforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	private void AfterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	private void BeforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	private void AfterMethod() {
		System.out.println("After Method");
	}
	@Test
	private void Test() {
		System.out.println("Test");
	}
	

}
