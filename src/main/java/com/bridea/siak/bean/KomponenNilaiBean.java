package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MAmbil;
import com.bridea.siak.model.MKomponenNilai;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("komponenNilaiBean")
public class KomponenNilaiBean extends DialogBean {

	@Autowired
	@Qualifier("komponenNilaiGenericDAO")
	private GenericDAO<MKomponenNilai> dao;

	private MKomponenNilai komponenNilai;
	private List<MKomponenNilai> listKomponenNilais;
	private HashMap<Integer, MKomponenNilai> hashMapKomponenNilai;

	public List<MKomponenNilai> getListKomponenNilais() {
		listKomponenNilais = new ArrayList<>();

		for (MKomponenNilai mKomponenNilai : getHashMapKomponenNilai().values()) {
			listKomponenNilais.add(mKomponenNilai);
		}

		return listKomponenNilais;
	}

	public HashMap<Integer, MKomponenNilai> getHashMapKomponenNilai() {
		List<MKomponenNilai> listKomponenNilais = getKomponenNilais();
		hashMapKomponenNilai = new HashMap<>();
		for (MKomponenNilai mKomponenNilai : listKomponenNilais) {
			hashMapKomponenNilai.put(mKomponenNilai.getKnIdKomponenNilai(),
					mKomponenNilai);
		}
		return hashMapKomponenNilai;
	}

	public MKomponenNilai getKomponenNilai() {
		if (komponenNilai == null) {
			komponenNilai = new MKomponenNilai();
		}
		return komponenNilai;
	}

	public void setKomponenNilai(MKomponenNilai KomponenNilai) {
		this.komponenNilai = KomponenNilai;
	}

	// insert
	public void insert(MAmbil mAmbil) {
		System.out.println("Masuk Insert");
		try {
			komponenNilai = new MKomponenNilai(mAmbil, (byte) 0, 0, 0, 0);
			dao.save(komponenNilai);
//			displayInfoMessageToUser("Tambah Komponen Nilai Berhasil");
			invalidateKomponenNilai();
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void update(MKomponenNilai nilai) {
		try {
			dao.update(nilai);
			displayInfoMessageToUser("Ubah Nilai Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			dao.delete(komponenNilai);
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MKomponenNilai> getKomponenNilais() {
		if (dao == null) {
			System.out.println("dao null");
		} else {
			return dao.getByCriteria();
		}
		return new ArrayList<>();
	}

	// getKomponenNilai by id
	public MKomponenNilai getKomponenNilaiByID(String kodeMK) {
		return dao.getByIdSTRING(kodeMK);
	}

	// return object KomponenNilai null
	public void invalidateKomponenNilai() {
		komponenNilai = new MKomponenNilai();
	}
}
