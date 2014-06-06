package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MDosen;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("dosenBean")
public class DosenBean extends DialogBean {

	@Autowired
	@Qualifier("dosenGenericDAO")
	private GenericDAO<MDosen> dao;

	private MDosen dosen;
	private List<MDosen> listDosens;
	private HashMap<String, MDosen> hashMapDosen;

	public List<MDosen> getListDosens() {
		listDosens = new ArrayList<>();
		System.out.println("new list dosen : " + listDosens.size());

		for (MDosen mDosen : getHashMapDosen().values()) {
			listDosens.add(mDosen);
		}

		System.out.println("getlist dosen : " + listDosens.size());

		return listDosens;
	}

	public HashMap<String, MDosen> getHashMapDosen() {
		List<MDosen> listDosens = getDosens();
		hashMapDosen = new HashMap<>();
		for (MDosen mDosen : listDosens) {
			hashMapDosen.put(mDosen.getDKodeDosen(), mDosen);
		}
		return hashMapDosen;
	}

	public MDosen getDosen() {
		if (dosen == null) {
			dosen = new MDosen();
		}
		return dosen;
	}

	public void setDosen(MDosen dosen) {
		this.dosen = dosen;
	}

	// insert
	public void insert() {
		System.out.println("Masuk Insert");
		try {
			dosen.setDStatus(true);
			dao.save(dosen);
			displayInfoMessageToUser("Tambah Dosen Berhasil");
			invalidateDosen();
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			dao.update(dosen);
			displayInfoMessageToUser("Ubah Dosen Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			dosen.setDStatus(false);
			dao.update(dosen);
			displayInfoMessageToUser("Hapus Dosen Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MDosen> getDosens() {
		List<MDosen> listDosens = new ArrayList<>();
		if (dao == null) {
			System.out.println("dao null");
		} else {
			System.out.println("dao : " + dao.getByCriteria().size());
			for (MDosen mDosen : dao.getByCriteria()) {
				if (mDosen.isDStatus() == true) {
					listDosens.add(mDosen);
				}
			}
		}
		return listDosens;
	}

	// getdosen by id
	public MDosen getDosenByID(String kodeDosen) {
		return dao.getByIdSTRING(kodeDosen);
	}

	// return object Dosen null
	public void invalidateDosen() {
		dosen = new MDosen();
	}

}
