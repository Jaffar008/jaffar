package PdfGenerate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

class ConvertToPdf {

	public static void main(String[] args) {
		
		FileInputStream fis=null;
		DataInputStream in=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		File sourceFile =new File("D:\\Mini statement\\Ministatement2.txt");
		File destFile=new File("D:\\temp\\ministatemnet.pdf");
		try {
			com.itextpdf.text.Document pdfDoc =new com.itextpdf.text.Document();
			PdfWriter writer = PdfWriter.getInstance(pdfDoc,new FileOutputStream(destFile));
			pdfDoc.open();
			pdfDoc.setMarginMirroring(true);
			pdfDoc.setMargins(36, 72, 108, 180);
			pdfDoc.topMargin();
			
			BaseFont courier =BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.EMBEDDED);
			Font myFont=new Font(courier);
			
			Font bold_font=new Font();
			
			bold_font.setStyle(Font.BOLD);
			bold_font.setSize(14);
			
			myFont.setStyle(Font.NORMAL);
			myFont.setSize(9);
			
			pdfDoc.add(new com.itextpdf.text.Paragraph("\n"));
			
			if(sourceFile.exists()) {
				fis=new FileInputStream(sourceFile);
				in =new DataInputStream(fis);
				isr =new InputStreamReader(in);
				br=new BufferedReader(isr);
				
				String strLine;
				while((strLine=br.readLine())!= null) {
					com.itextpdf.text.Paragraph para=new com.itextpdf.text.Paragraph(strLine+ "\n",myFont);
					para.setAlignment(Element.ALIGN_JUSTIFIED);
					pdfDoc.add(para);
				}
				System.out.println("text File COnverted to PDF successfully");
			}
			else {
				System.out.println("no file exists!");
			}
			pdfDoc.close();
			writer.close();
		}
		catch(Exception ex) {
			System.out.println("Error:1: "+ex.getMessage());
		}
		finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(fis!=null) {
					fis.close();
				}
				if(in!=null) {
					in.close();  
				}
				if(isr!=null) {
					isr.close();
				}
			}
			catch(Exception ex) {
				System.out.println("Error:2: "+ex.getMessage());
			}
		}
		
		
		
		
	}

}