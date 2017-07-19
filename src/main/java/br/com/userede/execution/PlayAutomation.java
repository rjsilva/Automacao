
package br.com.userede.execution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import com.lowagie.text.DocumentException;

public class PlayAutomation {

	public static void main(String[] args) throws IOException, InvalidFormatException, DocumentException {
		
		

		XWPFDocument doc = new XWPFDocument();
		XWPFTable table = null;
		XWPFRun r1 = null;

		table = doc.createTable(7, 6);

		XWPFParagraph p1 = table.getRow(0).getCell(0).addParagraph();
		table.getRow(0).getCell(0).setColor("ffcc99");
		table.getRow(0).getCell(1).setColor("ffcc99");
		 // First Row
		CTHMerge hMerge = CTHMerge.Factory.newInstance();
		hMerge.setVal(STMerge.RESTART);
		table.getRow(0).getCell(0).getCTTc().getTcPr().setHMerge(hMerge);

		CTHMerge hMerge1 = CTHMerge.Factory.newInstance();
		hMerge.setVal(STMerge.CONTINUE);
		table.getRow(0).getCell(1).getCTTc().getTcPr().setHMerge(hMerge1);
		
		
		
		r1 = p1.createRun();
		r1.setBold(true);
		r1.setText("PROJETO – Carteira Digital - Portal");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(10);

		XWPFParagraph p2 = table.getRow(1).getCell(0).getParagraphs().get(0);
		p2 = table.getRow(1).getCell(0).getParagraphs().get(0);
		r1 = p2.createRun();
		r1.setBold(true);
		r1.setText("Ambiente:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(10);
		table.getRow(1).getCell(1).setText("Desenvolvimento:");

		p2 = table.getRow(1).getCell(3).getParagraphs().get(0);
		r1 = p2.createRun();
		r1.setBold(true);
		r1.setText("Data Teste:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(10);
		table.getRow(1).getCell(4).setText("16/07/2017");

		XWPFParagraph p3 = table.getRow(2).getCell(0).getParagraphs().get(0);
		r1 = p3.createRun();
		r1.setBold(true);
		r1.setText("ID + Nome CT:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);

		XWPFParagraph p4 = table.getRow(3).getCell(0).getParagraphs().get(0);
		r1 = p4.createRun();
		r1.setBold(true);
		r1.setText("Objetivo::");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);

		XWPFParagraph p5 = table.getRow(4).getCell(0).getParagraphs().get(0);
		r1 = p5.createRun();
		r1.setBold(true);
		r1.setText("Resultado Esperado:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);

		XWPFParagraph p6 = table.getRow(5).getCell(0).getParagraphs().get(0);
		r1 = p6.createRun();
		r1.setBold(true);
		r1.setText("Resultado Obtido:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);

		XWPFParagraph p7 = table.getRow(6).getCell(0).getParagraphs().get(0);
		r1 = p7.createRun();
		r1.setBold(true);
		r1.setText("Executor:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);
		table.getRow(6).getCell(1).setText("Automacao");

		p7 = table.getRow(6).getCell(2).getParagraphs().get(0);
		r1 = p7.createRun();
		r1.setBold(true);
		r1.setText("Sprint:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(20);
		table.getRow(6).getCell(3).setText("38");

		p7 = table.getRow(6).getCell(4).getParagraphs().get(0);
		r1 = p7.createRun();
		r1.setBold(true);
		r1.setText("Ciclo Teste:");
		r1.setItalic(true);
		r1.setFontFamily("Arial");
		r1.setTextPosition(5);
		table.getRow(6).getCell(5).setText("84");

		FileOutputStream out = new FileOutputStream(new File("/users/yamanuser/Documents/teste.docx"));
		doc.write(out);
		out.close();
	}

}
