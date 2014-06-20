package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.dao.GenericDAO;
import com.bridea.siak.model.MMahasiswa;
import com.bridea.siak.util.DialogBean;

@Scope("session")
@Component("mahasiswaBean")
public class MahasiswaBean extends DialogBean {
	@Autowired
	@Qualifier("mahasiswaGenericDAO")
	private GenericDAO<MMahasiswa> dao;

	private MMahasiswa mahasiswa;
	private List<MMahasiswa> listMahasiswas;
	private HashMap<String, MMahasiswa> hashMapMahasiswa;

	private MahasiswaDataModel mahasiswaDataModel;
	private List<MMahasiswa> listMahasiswasSelected;

	public List<MMahasiswa> getListMahasiswasSelected() {
		return listMahasiswasSelected;
	}

	public void setListMahasiswasSelected(
			List<MMahasiswa> listMahasiswasSelected) {
		this.listMahasiswasSelected = listMahasiswasSelected;
	}

	public MahasiswaDataModel getMahasiswaDataModel() {
		getListMahasiswas();
		mahasiswaDataModel = new MahasiswaDataModel(listMahasiswas);
		return mahasiswaDataModel;
	}

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

			mahasiswa.setMhsJudulPenelitian("-");
			mahasiswa.setMhsStatus(true);
			dao.save(mahasiswa);
			displayInfoMessageToUser("Tambah Mahasiswa Berhasil");
			invalidateMahasiswa();

		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// update
	public void update() {
		try {
			dao.update(mahasiswa);
			displayInfoMessageToUser("Ubah Mahasiswa Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			mahasiswa.setMhsStatus(false);
			dao.update(mahasiswa);

			DataTable dataTable = (DataTable) FacesContext.getCurrentInstance()
					.getViewRoot()
					.findComponent(":form_mahasiswa:tbl_mahasiswa");
			if (dataTable != null) {
				dataTable.reset();
			}

			displayInfoMessageToUser("Hapus Mahasiswa Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MMahasiswa> getMahasiswas() {
		List<MMahasiswa> listMahasiswas = new ArrayList<>();
		if (dao == null) {
			System.out.println("dao null");
		} else {
			System.out.println("dao : " + dao.getByCriteria().size());
			for (MMahasiswa mMahasiswa : dao.getByCriteria()) {
				if (mMahasiswa.isMhsStatus() == true) {
					listMahasiswas.add(mMahasiswa);
				}
			}
		}
		return listMahasiswas;
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