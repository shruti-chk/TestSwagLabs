package com.test.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;

import com.test.drivers.Driver;

public class ManageCookies {
	
	static String cookiePath = "./src/test/resources/cookies/Cookiefile.data";

	public static void saveCookie() {

		// Create a file to store Login Information
		File file = new File(cookiePath);

		try {
			// Delete old file if already exists
			file.delete();
			file.createNewFile();
			FileWriter fileW = new FileWriter(file);
			BufferedWriter Bwritecookie = new BufferedWriter(fileW); // Getting the cookie information
			for (Cookie ck : Driver.driver.manage().getCookies()) {
				Bwritecookie.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwritecookie.newLine();
			}
			Bwritecookie.close();
			fileW.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void addCookie() {

		try {

			File file = new File(cookiePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while ((strline = Buffreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();

					Cookie ck = new Cookie(name, value, path);
					System.out.println(ck);
					Driver.driver.manage().addCookie(ck); // This will add the stored cookie to current session
				}
			}
			Buffreader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
