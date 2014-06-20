package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MAmbil;
import com.bridea.siak.model.MMahasiswa;
import com.bridea.siak.util.DialogBean;
import com.sun.org.apache.regexp.internal.recompile;

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
	private String tempNPMCariNilai = "";

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
		tempKodeDosen = ambil.getMDosen().getDKodeDosen();
		tempKodeMK = ambil.getMMataKuliah().getMkKodeMk();
		tempNPM = ambil.getMMahasiswa().getMhsNpm();
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
				ambil.setAWaktu(this.ambil.getAWaktu());
				ambil.setAGradeNilai("-");
				System.out.println(ambil.getMMahasiswa().getMhsNpm() + ","
						+ ambil.getAKelas() + "," + ambil.getALahanPraktek()
						+ "," + ambil.getMDosen().getDKodeDosen() + ","
						+ ambil.getMMataKuliah().getMkKodeMk());

				dao.save(ambil);
				komponenNilaiBean.insert(ambil);
			}
			mahasiswaBean
					.setListMahasiswasSelected(new ArrayList<MMahasiswa>());
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
			displayInfoMessageToUser("Ubah Kontrak Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void updateNilai(int idAmbil, double nilai, String grade) {
		try {
			ambil = getAmbilByID(idAmbil);
			ambil.setANilai(nilai);
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

			DataTable dataTable = (DataTable) FacesContext.getCurrentInstance()
					.getViewRoot().findComponent(":form_ambil:tbl_ambil");
			if (dataTable != null) {
				dataTable.reset();
			}

			displayInfoMessageToUser("Hapus Ambil Berhasil");
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
		tempKodeDosen = "";
		tempKodeMK = "";
	}

	/*
	 * ========================================================================
	 * FUNGSI USER
	 * ========================================================================
	 */

	public boolean checkNPM() {
		boolean status = true;
		System.out.println("masuk check NPM");
		if (!getTempNPMCariNilai().equals("")) {
			MMahasiswa mahasiswaTemp = new MMahasiswa();
			mahasiswaTemp = mahasiswaBean
					.getMahasiswaByID(getTempNPMCariNilai());
			if (mahasiswaTemp.isMhsStatus() == false) {
				displayInfoMessageToUser("NPM Anda Tidak Terdaftar, Mohon Untuk Dicek kembali");
				status = false;
			}
		} else {
			status = false;
			displayInfoMessageToUser("NPM Tidak Boleh Kosong");
		}

		if (status) {
			searchNilaiByNPM();
		}
		return status;
	}

	public void searchNilaiByNPM() {
		listNilaiMahasiswaSesuaiNPM = new ArrayList<>();
		List<MAmbil> listNilaiMhs = getAmbils();
		for (MAmbil mAmbil : listNilaiMhs) {
			if (mAmbil.getMMahasiswa().getMhsNpm()
					.equals(getTempNPMCariNilai())) {
				listNilaiMahasiswaSesuaiNPM.add(mAmbil);
			}
		}

		System.out.println("setelah di clear : " + mkTreeMap.size());
		mkTreeMap.clear();
		System.out.println("setelah di clear : " + mkTreeMap.size());
		clearListMap();
		test();
	}

	TreeMap<String, HashMap<Integer, MAmbil>> mkTreeMap = new TreeMap<>();
	HashMap<Integer, HashMap<Integer, MAmbil>> tempMKHashMap = new HashMap<>();
	int semesterTerakhir = 0;

	HashMap<Integer, MAmbil> mapMKS1 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS2 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS3 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS4 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS5 = new HashMap<>();
	HashMap<Integer, MAmbil> mapMKS6 = new HashMap<>();

	public int getSemesterTerakhir() {
		return semesterTerakhir;
	}

	public void setSemesterTerakhir(int semesterTerakhir) {
		this.semesterTerakhir = semesterTerakhir;
	}

	public HashMap<Integer, HashMap<Integer, MAmbil>> getTempMKHashMap() {
		return tempMKHashMap;
	}

	public void setTempMKHashMap(
			HashMap<Integer, HashMap<Integer, MAmbil>> tempMKHashMap) {
		this.tempMKHashMap = tempMKHashMap;
	}

	public TreeMap<String, HashMap<Integer, MAmbil>> getMkTreeMap() {
		return mkTreeMap;
	}

	public void setMkTreeMap(TreeMap<String, HashMap<Integer, MAmbil>> mkTreeMap) {
		this.mkTreeMap = mkTreeMap;
	}

	public void sortingMK() {
		System.out.println("list mahasiswa : "
				+ getListNilaiMahasiswaSesuaiNPM().size());
		for (MAmbil mAmbil : getListNilaiMahasiswaSesuaiNPM()) {
			if (mAmbil.getMMataKuliah().getMkSemester() == 1) {
				if (semesterTerakhir < 1) {
					semesterTerakhir = 1;
				}
				mapMKS1.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 2) {
				if (semesterTerakhir < 2) {
					semesterTerakhir = 2;
				}
				mapMKS2.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 3) {
				if (semesterTerakhir < 3) {
					semesterTerakhir = 3;
				}
				mapMKS3.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 4) {
				if (semesterTerakhir < 4) {
					semesterTerakhir = 4;
				}
				mapMKS4.put(mAmbil.getAIdAmbil(), mAmbil);
			} else if (mAmbil.getMMataKuliah().getMkSemester() == 5) {
				if (semesterTerakhir < 5) {
					semesterTerakhir = 5;
				}
				mapMKS5.put(mAmbil.getAIdAmbil(), mAmbil);
			} else {
				if (semesterTerakhir < 6) {
					semesterTerakhir = 6;
				}
				mapMKS6.put(mAmbil.getAIdAmbil(), mAmbil);
			}
		}

	}

	public void clearListMap() {
		mapMKS1.clear();
		mapMKS2.clear();
		mapMKS3.clear();
		mapMKS4.clear();
		mapMKS5.clear();
		mapMKS6.clear();

	}

	public void addTempListToHashMap() {
		tempMKHashMap = new HashMap<>();
		tempMKHashMap.put(1, mapMKS1);
		tempMKHashMap.put(2, mapMKS2);
		tempMKHashMap.put(3, mapMKS3);
		tempMKHashMap.put(4, mapMKS4);
		tempMKHashMap.put(5, mapMKS5);
		tempMKHashMap.put(6, mapMKS6);
	}

	public void addListToHashMap() {
		mkTreeMap = new TreeMap<>();
		switch (semesterTerakhir) {
		case 0:
			mkTreeMap = new TreeMap<>();
			break;
		case 1:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			break;
		case 2:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			mkTreeMap.put(2 + " : " + listIPS.get(1), mapMKS2);
			break;
		case 3:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			mkTreeMap.put(2 + " : " + listIPS.get(1), mapMKS2);
			mkTreeMap.put(3 + " : " + listIPS.get(2), mapMKS3);
			break;
		case 4:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			mkTreeMap.put(2 + " : " + listIPS.get(1), mapMKS2);
			mkTreeMap.put(3 + " : " + listIPS.get(2), mapMKS3);
			mkTreeMap.put(4 + " : " + listIPS.get(3), mapMKS4);
			break;
		case 5:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			mkTreeMap.put(2 + " : " + listIPS.get(1), mapMKS2);
			mkTreeMap.put(3 + " : " + listIPS.get(2), mapMKS3);
			mkTreeMap.put(4 + " : " + listIPS.get(3), mapMKS4);
			mkTreeMap.put(5 + " : " + listIPS.get(4), mapMKS5);
			break;
		case 6:
			mkTreeMap.put(1 + " : " + listIPS.get(0), mapMKS1);
			mkTreeMap.put(2 + " : " + listIPS.get(1), mapMKS2);
			mkTreeMap.put(3 + " : " + listIPS.get(2), mapMKS3);
			mkTreeMap.put(4 + " : " + listIPS.get(3), mapMKS4);
			mkTreeMap.put(5 + " : " + listIPS.get(4), mapMKS5);
			mkTreeMap.put(6 + " : " + listIPS.get(5), mapMKS6);
			break;
		}
	}

	private List<Double> listIPS = new ArrayList<>();
	private double ipk = 0;

	public List<Double> getListIPS() {
		return listIPS;
	}

	public void setListIPS(List<Double> listIPS) {
		this.listIPS = listIPS;
	}

	public double getIpk() {
		return ipk;
	}

	public void setIpk(double ipk) {
		this.ipk = ipk;
	}

	public void test() {
		sortingMK();
		addTempListToHashMap();
		// clearListMap();

		System.out.println("tampil IPS");

		PerhitunganNilaiBean pn = new PerhitunganNilaiBean();

		listIPS = pn.hitungIPS(tempMKHashMap);
		setListIPS(listIPS);

		addListToHashMap();

		double tempIpk = pn.hitungIPK(listIPS);

		setIpk(checkIpk(tempIpk));
	}

	public double checkIpk(double ipk) {
		String tempIpk = String.valueOf(ipk);
		if (tempIpk.length() > 4) {
			String subStringIpk = tempIpk.substring(0, 4);
			return Double.parseDouble(subStringIpk);
		}
		return ipk;
	}
}
