package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MMataKuliah;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("mataKuliahBean")
public class MataKuliahBean extends DialogBean {

	@Autowired
	@Qualifier("mataKuliahGenericDAO")
	private GenericDAO<MMataKuliah> dao;

	private MMataKuliah mataKuliah;
	private List<MMataKuliah> listMataKuliahs;
	private HashMap<String, MMataKuliah> hashMapMatakuliah;

	public List<MMataKuliah> getListMataKuliahs() {
		listMataKuliahs = new ArrayList<>();

		for (MMataKuliah mMataKuliah : getHashMapMatakuliah().values()) {
			listMataKuliahs.add(mMataKuliah);
		}

		return listMataKuliahs;
	}

	public HashMap<String, MMataKuliah> getHashMapMatakuliah() {
		List<MMataKuliah> listMataKuliahs = getMataKuliahs();
		hashMapMatakuliah = new HashMap<>();
		for (MMataKuliah mMataKuliah : listMataKuliahs) {
			hashMapMatakuliah.put(mMataKuliah.getMkKodeMk(), mMataKuliah);
		}
		return hashMapMatakuliah;
	}

	public MMataKuliah getMataKuliah() {
		if (mataKuliah == null) {
			mataKuliah = new MMataKuliah();
		}
		return mataKuliah;
	}

	public void setMataKuliah(MMataKuliah mataKuliah) {
		this.mataKuliah = mataKuliah;
	}

	// insert
	public void insert() {
		System.out.println("Masuk Insert");
		try {
			dao.save(mataKuliah);
			displayInfoMessageToUser("Insert MataKuliah Berhasil");
			invalidateMataKuliah();
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			dao.update(mataKuliah);
			displayInfoMessageToUser("Update MataKuliah Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			dao.delete(mataKuliah);
			displayInfoMessageToUser("Delete MataKuliah Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MMataKuliah> getMataKuliahs() {
		if (dao == null) {
			System.out.println("dao null");
		} else {
			return dao.getByCriteria();
		}
		return new ArrayList<>();
	}

	// getMataKuliah by id
	public MMataKuliah getMataKuliahByID(String kodeMK) {
		return dao.getByIdSTRING(kodeMK);
	}

	// return object MataKuliah null
	public void invalidateMataKuliah() {
		mataKuliah = new MMataKuliah();
	}
}
