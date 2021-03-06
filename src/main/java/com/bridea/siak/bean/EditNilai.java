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
	@Autowired
	private AmbilBean ambilBean;

	private MKomponenNilai komponenNilai;

	@PostConstruct
	public void init() {
		System.out.println("Masuk Init");
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
		if (listNilaiMahasiswa.size() != komponenNilaiBean.getKomponenNilais()
				.size()) {
			listNilaiMahasiswa = komponenNilaiBean.getKomponenNilais();
		}

		return listNilaiMahasiswa;
	}

	public double checkNilai(double nilai) {
		String tempNilai = String.valueOf(nilai);
		System.out.println("tempNilai.length() : "+tempNilai.length());
		if (tempNilai.length() > 5) {
			String subStringNilai = tempNilai.substring(0, 5);
			return Double.parseDouble(subStringNilai);
		}
		return nilai;
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

		int idKomponen = komponenNilai.getKnIdKomponenNilai();
		double kehadiran = komponenNilai.getKnNilaiKehadiran();
		double tugas = komponenNilai.getKnNilaiTugas();
		double uts = komponenNilai.getKnNilaiUts();
		double uas = komponenNilai.getKnNilaiUas();

		PerhitunganNilaiBean pn = new PerhitunganNilaiBean();
		double nilai = pn.hitungTotalNilai(kehadiran, tugas, uts, uas);
		char grade = pn.hitungGrade(nilai);
		String gradeNilai = "";

		if (grade == 'T') {
			gradeNilai = "BL";
		} else {
			gradeNilai = String.valueOf(grade);
		}

		komponenNilaiBean.update(komponenNilai);

		ambilBean.updateNilai(idKomponen, checkNilai(nilai), gradeNilai);

		System.out.println(gradeNilai);
		System.out.println("get deui");
		listNilaiMahasiswa = komponenNilaiBean.getKomponenNilais();
		getListNilaiMahasiswa();

		/*
		 * UIData table = (UIData) event.getComponent();
		 * System.out.println(table.getClientId() + ":" + table.getRowIndex() +
		 * ":grade_nilai"); String updateClientId = table.getClientId() + ":" +
		 * table.getRowIndex() + ":grade_nilai";
		 * FacesContext.getCurrentInstance().getPartialViewContext()
		 * .getRenderIds().add(updateClientId);
		 */

		/* new LoginBean().redirect("/staff.akademik.jsf"); */

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", ", Old: " + oldValue + ", New:" + newValue
							+ "Grade Nilai : " + gradeNilai);
		}

	}
}
