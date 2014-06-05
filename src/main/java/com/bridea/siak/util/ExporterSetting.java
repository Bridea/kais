package com.bridea.siak.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfTable;

@ManagedBean(name = "exporterSetting")
@SessionScoped
public class ExporterSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}
	}

	public void preProcessPDF(Object document) throws IOException,
			BadElementException, DocumentException {

		Document pdf = (Document) document;
		try {
			pdf.setPageSize(PageSize.A4.rotate());
			pdf.setMargins(3, 3, 4, 4);

			pdf.open();
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			String logo = servletContext.getRealPath("") + File.separator
					+ "resources" + File.separator + "img" + File.separator
					+ "header.png";
			Image.getInstance(logo).setAbsolutePosition(0, 0);
			pdf.add(Image.getInstance(logo));

			// pdf.add(Image.getInstance(logo));
			Paragraph paragraph = new Paragraph("DATA MAHASISWA",
					FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,
							new Color(0, 0, 0)));
			paragraph.setSpacingBefore(10);
			pdf.add(paragraph);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			pdf.add(new Phrase("Tanggal : " + formato.format(new Date())));
			/* pdf.newPage(); */

			/*
			 * HeaderFooter header = new HeaderFooter(
			 * Phrase.getInstance("Data Mahasiswa"), true);
			 * 
			 * pdf.setHeader(header); HeaderFooter footer = new HeaderFooter(new
			 * Phrase("This is page "), new Phrase(".")); pdf.setFooter(footer);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!pdf.isOpen()) {
			pdf.open();
		}
	}
}
