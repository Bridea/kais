package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MMahasiswa;
import com.bridea.siak.model.MUsers;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("mahasiswaBean")
public class MahasiswaBean extends DialogBean {
	@Autowired
	@Qualifier("mahasiswaGenericDAO")
	private GenericDAO<MMahasiswa> dao;

	@Autowired
	private UsersBean usersBean;

	private MMahasiswa mahasiswa;
	private List<MMahasiswa> listMahasiswas;
	private HashMap<String, MMahasiswa> hashMapMahasiswa;

	public List<MMahasiswa> getListMahasiswas() {
		listMahasiswas = new ArrayList<>();
		for (MMahasiswa mMahasiswa : getHashMapMahasiswa().values()) {
			listMahasiswas.add(mMahasiswa);
		}
		return listMahasiswas;
	}

	public HashMap<String, MMahasiswa> getHashMapMahasiswa() {
		List<MMahasiswa> listMahasiswas = getMahasiswas();
		hashMapMahasiswa = new HashMap<>();
		for (MMahasiswa mMahasiswa : listMahasiswas) {
			hashMapMahasiswa.put(mMahasiswa.getMhsNpm(), mMahasiswa);
		}
		return hashMapMahasiswa;
	}

	public MMahasiswa getMahasiswa() {
		if (mahasiswa == null) {
			mahasiswa = new MMahasiswa();
		}
		return mahasiswa;
	}

	public void setMahasiswa(MMahasiswa mahasiswa) {
		System.out.println("masuk set mahasiswa");
		this.mahasiswa = mahasiswa;
	}

	// insert
	public void insert() {
		System.out.println("Masuk Insert mahasiswa");
		try {
			MUsers user = usersBean.insertUserMahasiswa(mahasiswa.getMhsNpm());
			if (user != null) {
				mahasiswa.setMhsJudulPenelitian("-");
				mahasiswa.setMUsers(user);
				mahasiswa.setMhsStatus(true);
				dao.save(mahasiswa);
				displayInfoMessageToUser("Insert Mahasiswa Berhasil");
				invalidateMahasiswa();
			} else {
				System.out.println("Users Null");
			}
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			dao.update(mahasiswa);
			displayInfoMessageToUser("Update Mahasiswa Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			dao.delete(mahasiswa);
			displayInfoMessageToUser("Delete Mahasiswa Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MMahasiswa> getMahasiswas() {
		if (dao == null) {
			System.out.println("dao null");
		} else {
			return dao.getByCriteria();
		}
		return new ArrayList<>();
	}

	// getMahasiswa by id
	public MMahasiswa getMahasiswaByID(String NPM) {
		return dao.getByIdSTRING(NPM);
	}

	// return object Mahasiswa null
	public void invalidateMahasiswa() {
		mahasiswa = new MMahasiswa();
	}

}