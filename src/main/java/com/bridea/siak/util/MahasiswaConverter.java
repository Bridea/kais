package com.bridea.siak.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridea.siak.bean.MahasiswaBean;
import com.bridea.siak.model.MMahasiswa;

@FacesConverter(forClass = MMahasiswa.class, value = "mahasiswaConverter")
public class MahasiswaConverter implements Converter {

	@Autowired
	private MahasiswaBean mahasiswaBean;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) {
		System.out.println("Masuk Get Object");
		MMahasiswa mahasiswa = null;
		try {
			mahasiswa = mahasiswaBean.getMahasiswaByID(newValue);
		} catch (Throwable ex) {
		}
		return mahasiswa;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("Masuk Get String");
		String val = null;
		try {
			MMahasiswa mahasiswa = (MMahasiswa) value;
			val = mahasiswa.getMhsNpm();
		} catch (Throwable ex) {
		}
		return val;
	}

}
