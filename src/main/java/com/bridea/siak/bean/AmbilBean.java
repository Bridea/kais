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
			if (mAmbil.getMMahasiswa().getMhsNpm()
					.equals(getTempNPMCariNilai())) {
				listNilaiMahasiswaSesuaiNPM.add(mAmbil);
			}
		}

		if (listNilaiMahasiswaSesuaiNPM.size() < 1) {
			displayInfoMessageToUser("NPM Anda Tidak Terdaftar, Mohon Untuk Dicek kembali");
		}
		System.out.println("setelah di clear : " + mkHashMap.size());
		mkHashMap.clear();
		System.out.println("setelah di clear : " + mkHashMap.size());
		test();
	}

	HashMap<Integer, HashMap<Integer, MAmbil>> mkHashMap;

	/*
	 * List<MAmbil> listMKS1 = new ArrayList<>(); List<MAmbil> listMKS2 = new
	 * ArrayList<>(); List<MAmbil> listMKS3 = new ArrayList<>(); List<MAmbil>
	 * listMKS4 = new ArrayList<>(); List<MAmbil> listMKS5 = new ArrayList<>();
	 * List<MAmbil> listMKS6 = new ArrayList<>();
	 */

	HashMap<Integer, MAmbil> mapMKS1 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS2 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS3 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS4 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS5 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS6 = new HashMap<>();

	public HashMap<Integer, HashMap<Integer, MAmbil>> getMkHashMap() {
		return mkHashMap;
	}

	public void setMkHashMap(
			HashMap<Integer, HashMap<Integer, MAmbil>> mkHashMap) {
		this.mkHashMap = mkHashMap;
	}

	public void sortingMK() {
		System.out.println("Isikan Data Sesuai Semester Ke List");
		for (MAmbil mAmbil : getListNilaiMahasiswaSesuaiNPM()) {
			if (mAmbil.getMMataKuliah().getMkSemester() == 1) {
				mapMKS1.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 2) {
				mapMKS2.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 3) {
				mapMKS3.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 4) {
				mapMKS4.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 5) {
				mapMKS5.put(mAmbil.getAIdAmbil(), mAmbil);
			} else {
				mapMKS6.put(mAmbil.getAIdAmbil(), mAmbil);
			}
		}

		System.out.println("map 1 size : " + mapMKS1.size());
		System.out.println("map 2 size : " + mapMKS2.size());
		System.out.println("map 3 size : " + mapMKS3.size());
		System.out.println("map 4 size : " + mapMKS4.size());
		System.out.println("map 5 size : " + mapMKS5.size());
		System.out.println("map 6 size : " + mapMKS6.size());
	}

	public void clearListMap() {
		mapMKS1.clear();
		mapMKS2.clear();
		mapMKS3.clear();
		mapMKS4.clear();
		mapMKS5.clear();
		mapMKS6.clear();

		System.out
				.println("========================================================================");

		System.out.println("map 1 size : " + mapMKS1.size());
		System.out.println("map 2 size : " + mapMKS2.size());
		System.out.println("map 3 size : " + mapMKS3.size());
		System.out.println("map 4 size : " + mapMKS4.size());
		System.out.println("map 5 size : " + mapMKS5.size());
		System.out.println("map 6 size : " + mapMKS6.size());
	}

	public void addListToHashMap() {
		System.out.println("Membuat New Hasmap Iduk");
		mkHashMap = new HashMap<>();
		System.out.println("Isi Hasmap Iduk sebelum add list : "
				+ mkHashMap.size());
		mkHashMap.put(1, mapMKS1);
		mkHashMap.put(2, mapMKS2);
		mkHashMap.put(3, mapMKS3);
		mkHashMap.put(4, mapMKS4);
		mkHashMap.put(5, mapMKS5);
		mkHashMap.put(6, mapMKS6);
		System.out.println("Isi Hasmap Iduk sesudah add list : "
				+ mkHashMap.size());
	}

	public void test() {
		sortingMK();
		addListToHashMap();
		clearListMap();

		System.out.println("tampil IPS");

		PerhitunganNilaiBean pn = new PerhitunganNilaiBean();

		for (Iterator<HashMap<Integer, MAmbil>> iterator = mkHashMap.values()
				.iterator(); iterator.hasNext();) {
			HashMap<Integer, MAmbil> temAmbils = (HashMap<Integer, MAmbil>) iterator
					.next();
			pn.hitungIPS(temAmbils);
		}
	}
}
