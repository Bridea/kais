package com.bridea.siak.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.model.MKomponenNilai;

@Component("editNilai")
@Scope("session")
public class EditNilai {

	private List<MKomponenNilai> listNilaiMahasiswa;

	@Autowired
	private KomponenNilaiBean komponenNilaiBean;

	private MKomponenNilai komponenNilai;

	@PostConstruct
	public void init() {
		listNilaiMahasiswa = komponenNilaiBean.getKomponenNilais();
	}

	public MKomponenNilai getKomponenNilai() {
		if (komponenNilai == null) {
			System.out.println("null");
		}
		return komponenNilai;
	}

	public void setKomponenNilai(MKomponenNilai komponenNilai) {
		this.komponenNilai = komponenNilai;
	}

	public List<MKomponenNilai> getListNilaiMahasiswa() {
		return listNilaiMahasiswa;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		System.out.println(oldValue);
		Object newValue = event.getNewValue();
		System.out.println(newValue);

		DataTable s = (DataTable) event.getSource();
		System.out.println("s : " + s.getRowData());

		Object object = s.getRowData();

		komponenNilai = (MKomponenNilai) object;

		System.out.println(komponenNilai.getKnIdKomponenNilai());
		System.out.println(komponenNilai.getKnNilaiKehadiran());
		System.out.println(komponenNilai.getKnNilaiTugas());
		System.out.println(komponenNilai.getKnNilaiUts());
		System.out.println(komponenNilai.getKnNilaiUas());

		komponenNilaiBean.update(komponenNilai);

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", ", Old: " + oldValue + ", New:" + newValue);
		}
	}

}
