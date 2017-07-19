package br.com.userede.junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.userede.constant.Urls;
import br.com.userede.crossbrowser.BrowsersFactory;
import br.com.userede.crossbrowser.Navegadores;
import br.com.userede.pageobject.GerarCpfPage;
import br.com.userede.util.ScreenShots;

public class RunGerarCpf {

	private GerarCpfPage gerarCpfPage = null;
	private WebDriver driver = null;
	
	@Test
	public void run(){
		gerarCpfSucess();
		//gerarCpfError();
	}
	
	public void gerarCpfSucess() {

		try {
			BrowsersFactory factory = new BrowsersFactory();
			driver = factory.getDriver(Navegadores.Chrome);
			driver.manage().window().maximize();
			driver.navigate().to(Urls.URLGERARCPF);
			gerarCpfPage = new GerarCpfPage(driver);
			gerarCpfPage.clickGerarCpf("gerarcpfsucesso");
			gerarCpfPage.clickValidar("validacpfsucesso");
			Assert.assertTrue(gerarCpfPage.validarCpf());
			ScreenShots.gerarEvidencia("gerarcpfsucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.close();
		}

	}
	
	public void gerarCpfError() {

		try {
			BrowsersFactory factory = new BrowsersFactory();
			driver = factory.getDriver(Navegadores.Chrome);
			driver.manage().window().maximize();
			driver.navigate().to(Urls.URLGERARCPF);
			gerarCpfPage = new GerarCpfPage(driver);
			gerarCpfPage.inserirCpf("gerarcpfInvalido","12345678901");
			gerarCpfPage.clickValidar("validacpfInvalido");
			ScreenShots.gerarEvidencia("gerarcpferro");
			Assert.assertTrue(gerarCpfPage.validarCpf());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.close();
		}

	}

}
