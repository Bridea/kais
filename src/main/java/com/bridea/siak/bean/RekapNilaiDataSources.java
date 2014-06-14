package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridea.siak.model.MKomponenNilai;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class RekapNilaiDataSources implements JRDataSource {

	/*
	 * private Object[][] data = { { "103040132", "100", "100", "100", "100",
	 * "100", "A", "Algoritma dan Pemrograman II" }, { "103040132", "100",
	 * "100", "100", "100", "100", "A", "Algoritma dan Pemrograman II" }, {
	 * "103040132", "100", "100", "100", "100", "100", "A",
	 * "Algoritma dan Pemrograman II" }, { "103040132", "100", "100", "100",
	 * "100", "100", "A", "Algoritma dan Pemrograman II" }, { "103040132",
	 * "100", "100", "100", "100", "100", "B", "Algoritma dan Pemrograman II" }
	 * };
	 */
	@Autowired
	private EditNilai editNilai;

	private List<MKomponenNilai> listKomponenNilais = new ArrayList<>();

	private int index = -1;

	public List<MKomponenNilai> getListKomponenNilais() {
		return listKomponenNilais;
	}

	public void setListKomponenNilais(List<MKomponenNilai> listKomponenNilais) {
		this.listKomponenNilais = listKomponenNilais;
	}

	public RekapNilaiDataSources() {
		super();
	}

	public boolean next() throws JRException {
		index++;
		return (index < listKomponenNilais.size());
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;

		String fieldName = field.getName();

		if (fieldName.equals("npm")) {
			value = listKomponenNilais.get(index).getMAmbil().getMMahasiswa()
					.getMhsNpm();
		} else if (fieldName.equals("kehadiran")) {
			value = listKomponenNilais.get(index).getKnNilaiKehadiran();
		} else if (fieldName.equals("tugas")) {
			value = listKomponenNilais.get(index).getKnNilaiTugas();
		} else if (fieldName.equals("uts")) {
			value = listKomponenNilais.get(index).getKnNilaiUts();
		} else if (fieldName.equals("uas")) {
			value = listKomponenNilais.get(index).getKnNilaiUas();
		} else if (fieldName.equals("nilai")) {
			value = listKomponenNilais.get(index).getMAmbil().getANilai();
		} else if (fieldName.equals("grade")) {
			value = listKomponenNilais.get(index).getMAmbil().getAGradeNilai();
		} else if (fieldName.equals("matakuliah")) {
			value = listKomponenNilais.get(index).getMAmbil().getMMataKuliah()
					.getMkNamaMk();
		} else if (fieldName.equals("dosen")) {
			value = listKomponenNilais.get(index).getMAmbil().getMDosen()
					.getDNamaDosen();
		} else if (fieldName.equals("kelas")) {
			value = listKomponenNilais.get(index).getMAmbil().getAKelas();
		} else if (fieldName.equals("waktu")) {
			value = listKomponenNilais.get(index).getMAmbil().getAWaktu();
		}

		return value;
	}
}
