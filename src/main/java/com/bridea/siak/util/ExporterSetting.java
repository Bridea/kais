package com.bridea.siak.util;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;

@ManagedBean(name="exporterSetting")
@SessionScoped
public class ExporterSetting implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {

        Document pdf = (Document) document;
        try {
            pdf.setPageSize(PageSize.A4.rotate());
            pdf.setMargins(2, 2, 2, 2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!pdf.isOpen()) {
            pdf.open();
        }
	}

}
