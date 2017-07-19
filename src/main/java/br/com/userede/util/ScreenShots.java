package br.com.userede.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lowagie.text.DocumentException;

public class ScreenShots {

	private static WebDriver driver;
	private static List<String> imagens = new ArrayList<String>();

	public ScreenShots(WebDriver driver) {
		this.driver = driver;
	}

	public static void gerarEvidencia(String teste) throws InvalidFormatException, IOException, DocumentException {

		FileInputStream word = new FileInputStream("src/template/template.docx");
		XWPFDocument doc = new XWPFDocument(word);	
		XWPFParagraph p = doc.createParagraph();
		XWPFRun xwpfRun = null;
		xwpfRun	= p.createRun();
		int format = doc.PICTURE_TYPE_PNG;
		for (String imgFile : imagens) {
			
			xwpfRun.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(500), Units.toEMU(500)); // 200x200// pixels
		}
		FileOutputStream out = new FileOutputStream(new File("/users/yamanuser/Documents/" + teste + ".docx"));
		doc.write(out);
		out.close();
		imagens.clear();
	}

	public static void prints(String nome) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String caminho = "/Users/yamanuser/Documents/novo/" + nome + ".png";
		FileUtils.copyFile(scrFile, new File(caminho));
		imagens.add(caminho);
	}

}
