package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MAmbil;
import com.bridea.siak.model.MKomponenNilai;
import com.bridea.siak.model.MMahasiswa;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("ambilBean")
public class AmbilBean extends DialogBean {

	@Autowired
	@Qualifier("ambilGenericDAO")
	private GenericDAO<MAmbil> dao;

	@Autowired
	private MahasiswaBean mahasiswaBean;
	@Autowired
	private MataKuliahBean mataKuliahBean;
	@Autowired
	private DosenBean dosenBean;
	@Autowired
	private KomponenNilaiBean komponenNilaiBean;

	private MAmbil ambil;
	private List<MAmbil> listAmbils;

	// Edit Nilai
	private List<MAmbil> listAmbilsBy;

	private String tempNPM;
	private String tempKodeMK;
	private String tempKodeDosen;

	// Edit Nilai

	// USER (MAHASISWA)
	// Temp User memasukan NPM Untuk Melihat Nilai
	private String tempNPMCariNilai;

	private List<MAmbil> listNilaiMahasiswaSesuaiNPM;

	private MMahasiswa mahasiswa;

	// USER (MAHASISWA)

	public List<MAmbil> getListAmbils() {
		listAmbils = new ArrayList<>();
		listAmbils = getAmbils();
		return listAmbils;
	}

	public MMahasiswa getMahasiswa() {
		for (MMahasiswa tempMahasiswa : mahasiswaBean.getListMahasiswas()) {
			if (tempMahasiswa.getMhsNpm().equals(tempNPMCariNilai)) {
				return tempMahasiswa;
			}
		}
		return mahasiswa;
	}

	public void setMahasiswa(MMahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
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

	public String getTempNPM() {
		return tempNPM;
	}

	public void setTempNPM(String tempNPM) {
		this.tempNPM = tempNPM;
	}

	// insert
	public void insert() {
		System.out.println("Masuk Insert : ambil");
		try {
			for (MMahasiswa mahasiswa : mahasiswaBean
					.getListMahasiswasSelected()) {
				System.out.println(mahasiswa.getMhsNpm());
				MAmbil ambil = new MAmbil();
				ambil.setMMahasiswa(mahasiswa);
				ambil.setMMataKuliah(mataKuliahBean
						.getMataKuliahByID(getTempKodeMK()));
				ambil.setMDosen(dosenBean.getDosenByID(getTempKodeDosen()));
				ambil.setALahanPraktek("-");
				ambil.setAKelas(this.ambil.getAKelas());
				ambil.setAGradeNilai("-");
				System.out.println(ambil.getMMahasiswa().getMhsNpm() + ","
						+ ambil.getAKelas() + "," + ambil.getALahanPraktek()
						+ "," + ambil.getMDosen().getDKodeDosen() + ","
						+ ambil.getMMataKuliah().getMkKodeMk());

				dao.save(ambil);
				komponenNilaiBean.insert(ambil);
			}
			displayInfoMessageToUser("Kontrak Matakuliah Berhasil");
			invalidateAmbil();
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getStackTrace());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			ambil.setMMahasiswa(mahasiswaBean.getMahasiswaByID(getTempNPM()));
			ambil.setMMataKuliah(mataKuliahBean
					.getMataKuliahByID(getTempKodeMK()));
			ambil.setMDosen(dosenBean.getDosenByID(getTempKodeDosen()));
			dao.update(ambil);
			displayInfoMessageToUser("Update Ambil Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void updateNilai(int idAmbil, String grade) {
		try {
			ambil = getAmbilByID(idAmbil);
			ambil.setAGradeNilai(grade);
			dao.update(ambil);
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
	public MAmbil getAmbilByID(int idAmbil) {
		return dao.getByIdINT(idAmbil);
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
			if (mAmbil.getMMahasiswa().getMhsNpm().equals("12.001.128")) {
				listNilaiMahasiswaSesuaiNPM.add(mAmbil);
			}
		}

		if (listNilaiMahasiswaSesuaiNPM.size() < 1) {
			displayInfoMessageToUser("NPM Anda Tidak Terdaftar, Mohon Untuk Dicek kembali");
		}
		test();
	}

	HashMap<Integer, List<MAmbil>> mkHashMap = new HashMap<>();

	List<MAmbil> listMKS1 = new ArrayList<>();
	List<MAmbil> listMKS2 = new ArrayList<>();
	List<MAmbil> listMKS3 = new ArrayList<>();
	List<MAmbil> listMKS4 = new ArrayList<>();
	List<MAmbil> listMKS5 = new ArrayList<>();
	List<MAmbil> listMKS6 = new ArrayList<>();

	public HashMap<Integer, List<MAmbil>> getMkHashMap() {
		mkHashMap.put(1, listMKS1);
		mkHashMap.put(2, listMKS2);
		mkHashMap.put(3, listMKS3);
		mkHashMap.put(4, listMKS4);
		mkHashMap.put(5, listMKS5);
		mkHashMap.put(6, listMKS6);
		return mkHashMap;
	}

	public void setMkHashMap(HashMap<Integer, List<MAmbil>> mkHashMap) {
		this.mkHashMap = mkHashMap;
	}

	public void sortingMK() {
		for (MAmbil mAmbil : getListNilaiMahasiswaSesuaiNPM()) {
			if (mAmbil.getMMataKuliah().getMkSemester() == 1) {
				listMKS1.add(mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 2) {
				listMKS2.add(mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 3) {
				listMKS3.add(mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 4) {
				listMKS4.add(mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 5) {
				listMKS5.add(mAmbil);
			} else {
				listMKS6.add(mAmbil);
			}
		}
	}

	public void test() {
		getMkHashMap();
		sortingMK();

		for (Iterator iterator = mkHashMap.values().iterator(); iterator
				.hasNext();) {
			List<MAmbil> temAmbils = (List<MAmbil>) iterator.next();

			for (MAmbil mAmbil : temAmbils) {
				System.out.println("semester : "
						+ mAmbil.getMMataKuliah().getMkSemester());
			}
		}
	}
}
