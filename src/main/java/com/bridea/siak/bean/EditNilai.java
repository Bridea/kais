package com.bridea.siak.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.model.MAmbil;

@Component("editNilai")
@Scope("session")
public class EditNilai {

	private List<MAmbil> listKontrakMatakuliah;

	@Autowired
	private AmbilBean ambilBean;

	@PostConstruct
	public void init() {
		listKontrakMatakuliah = ambilBean.getAmbils();
	}

	public List<MAmbil> getListKontrakMatakuliah() {
		return listKontrakMatakuliah;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		System.out.println(oldValue.toString().charAt(1));
		Object newValue = event.getNewValue();
		System.out.println(newValue.toString().charAt(1));

		MAmbil ambil = listKontrakMatakuliah.get(event.getRowIndex());
		System.out.println(ambil.getAIdAmbil());

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Id Kontrak :" + ambil.getAIdAmbil()
							+ ", Old: " + oldValue + ", New:" + newValue);
			ambilBean.updateNilai(ambil, newValue.toString().charAt(1));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
