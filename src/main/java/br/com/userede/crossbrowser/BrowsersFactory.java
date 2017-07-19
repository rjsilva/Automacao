package br.com.userede.crossbrowser;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.userede.util.File;

public class BrowsersFactory {

	private static String drivePath = "src/drivers/";
	
	public WebDriver getDriver(Navegadores navegador) throws IOException {

		switch (navegador) {
		case Chrome:
			Properties prop = File.getProp();
			//drivePath = prop.getProperty("props.browser.chrome");
			System.setProperty("webdriver.chrome.driver", drivePath + "chromedriver");
			return new ChromeDriver();
		case FireFox:
			return new FirefoxDriver();
		}

		return null;
	}

}
