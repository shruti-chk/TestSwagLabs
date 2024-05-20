package com.test.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.tngtech.junit.dataprovider.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	public static Object[][] provideLoginData() throws EncryptedDocumentException, IOException {
		ReadXLSData readData = new ReadXLSData();
		return readData.getData("login");
	}
	
	@DataProvider
	public static Object[][] provideCheckoutData() throws EncryptedDocumentException, IOException {
		ReadXLSData readData = new ReadXLSData();
		return readData.getData("checkout");
	}

}
