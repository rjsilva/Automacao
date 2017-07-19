package br.com.userede.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.userede.helper.AbsRobot;
import br.com.userede.util.ScreenShots;


public class GerarCpfPage {

	private AbsRobot robot;
	
	public GerarCpfPage(WebDriver driver){
		
		this.robot = new AbsRobot(driver);
		new ScreenShots(driver);
	}
	

	private By gerarCpf = By.id("btn-gerar-cpf");
	
	private By validarCpf = By.className("btn");
	
	private By cpfSucesso = By.id("checkSign");
	
	private By cpfErro = By.id("xSign");
	
	private By campoCpf = By.id("numero");

	public By getCampoCpf() {
		return campoCpf;
	}

	public void clickGerarCpf(String nomeEvidencia) throws IOException {
		robot.findElement(gerarCpf).click();
		ScreenShots.prints(nomeEvidencia);
	}

	public void clickValidar(String nomeEvidencia) throws IOException{
		robot.findElement(validarCpf).click();
		ScreenShots.prints(nomeEvidencia);
	}
	
	public Boolean validarCpf() throws IOException{
		return robot.findElement(cpfSucesso).isDisplayed();
	}
	public void inserirCpf(String nomeEvidencia, String cpfInvalido) throws IOException{
		robot.findElement(campoCpf).sendKeys(cpfInvalido);
		ScreenShots.prints(nomeEvidencia);
	}

}
