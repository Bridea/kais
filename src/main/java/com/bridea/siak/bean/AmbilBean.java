package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MAmbil;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("ambilBean")
public class AmbilBean extends DialogBean {

	@Autowired
	@Qualifier("ambilGenericDAO")
	private GenericDAO<MAmbil> dao;

	@Autowired
	private MahasiswaBean mahasiswaBean;

	private MAmbil ambil;
	private List<MAmbil> listAmbils;

	private String tempNPM;

	// Edit Nilai
	private List<MAmbil> listAmbilsBy;

	private String tempKodeMK;
	private String tempKodeDosen;

	// Edit Nilai

	// USER (MAHASISWA)
	// Temp User memasukan NPM Untuk Melihat Nilai
	private String tempNPMCariNilai;

	private List<MAmbil> listNilaiMahasiswaSesuaiNPM;

	// USER (MAHASISWA)

	public List<MAmbil> getListAmbils() {
		listAmbils = new ArrayList<>();
		listAmbils = getAmbils();
		return listAmbils;
	}

	public List<MAmbil> getListAmbilsBy() {
		return listAmbilsBy;
	}

	public MAmbil getAmbil() {
		if (ambil == null) {
			ambil = new MAmbil();
		}
		return ambil;
	}

	public void setAmbil(MAmbil ambil) {
		this.ambil = ambil;
	}

	public String getTempNPM() {
		return tempNPM;
	}

	public void setTempNPM(String tempNPM) {
		this.tempNPM = tempNPM;
	}

	public String getTempNPMCariNilai() {
		return tempNPMCariNilai;
	}

	public void setTempNPMCariNilai(String tempNPMCariNilai) {
		this.tempNPMCariNilai = tempNPMCariNilai;
	}

	public List<MAmbil> getListNilaiMahasiswaSesuaiNPM() {
		return listNilaiMahasiswaSesuaiNPM;
	}

	public void setListNilaiMahasiswaSesuaiNPM(
			List<MAmbil> listNilaiMahasiswaSesuaiNPM) {
		this.listNilaiMahasiswaSesuaiNPM = listNilaiMahasiswaSesuaiNPM;
	}

	public String getTempKodeMK() {
		return tempKodeMK;
	}

	public void setTempKodeMK(String tempKodeMK) {
		this.tempKodeMK = tempKodeMK;
	}

	public String getTempKodeDosen() {
		return tempKodeDosen;
	}

	public void setTempKodeDosen(String tempKodeDosen) {
		this.tempKodeDosen = tempKodeDosen;
	}

	// insert
	public void insert() {
		System.out.println("Masuk Insert");
		try {
			dao.save(ambil);
			displayInfoMessageToUser("Insert Ambil Berhasil");
			invalidateAmbil();
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getStackTrace());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			dao.update(ambil);
			displayInfoMessageToUser("Update Ambil Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void updateNilai(MAmbil pAmbil, char nilai) {
		try {
			dao.update(pAmbil);
			displayInfoMessageToUser("Update Ambil Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			dao.delete(ambil);
			displayInfoMessageToUser("Delete Ambil Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MAmbil> getAmbils() {
		if (dao == null) {
			System.out.println("dao null");
		} else {
			return dao.getByCriteria();
		}
		return new ArrayList<>();
	}

	// getMahasiswa by id
	public MAmbil getAmbilByID(Long idAmbil) {
		return dao.getByIdLONG(idAmbil);
	}

	// return object Ambil null
	public void invalidateAmbil() {
		ambil = new MAmbil();
	}

	/*
	 * ========================================================================
	 * FUNGSI USER
	 * ========================================================================
	 */

	public void searchNilaiByNPM() {
		listNilaiMahasiswaSesuaiNPM = new ArrayList<>();
		List<MAmbil> listNilaiMhs = getAmbils();
		for (MAmbil mAmbil : listNilaiMhs) {
			if (mAmbil.getMMahasiswa().getMhsNpm()
					.equals(getTempNPMCariNilai())) {
				listNilaiMahasiswaSesuaiNPM.add(mAmbil);
			}
		}

		if (listNilaiMahasiswaSesuaiNPM.size() < 1) {
			displayInfoMessageToUser("NPM Anda Tidak Terdaftar, Mohon Untuk Dicek kembali");
		}
	}
}
