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
	private List<MMataKuliah> tempListMataKuliahs;
	private HashMap<String, MMataKuliah> tempHashMapKuliahs;
	private byte semester;

	public HashMap<String, MMataKuliah> getTempHashMapKuliahs() {
		return tempHashMapKuliahs;
	}

	public void setTempHashMapKuliahs(
			HashMap<String, MMataKuliah> tempHashMapKuliahs) {
		this.tempHashMapKuliahs = tempHashMapKuliahs;
	}

	public List<MMataKuliah> getTempListMataKuliahs() {
		return tempListMataKuliahs;
	}

	public void setTempListMataKuliahs(List<MMataKuliah> tempListMataKuliahs) {
		this.tempListMataKuliahs = tempListMataKuliahs;
	}

	public byte getSemester() {
		return semester;
	}

	public void setSemester(byte semester) {
		this.semester = semester;
	}

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
			mataKuliah.setMkStatus(true);
			System.out.println(mataKuliah.getMkKodeMk() + ","
					+ mataKuliah.getMkNamaMk() + "," + mataKuliah.getMkSks()
					+ "," + mataKuliah.getMkSemester() + ","
					+ mataKuliah.isMkStatus());
			dao.save(mataKuliah);
			displayInfoMessageToUser("Tambah MataKuliah Berhasil");
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
			displayInfoMessageToUser("Ubah MataKuliah Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// delete
	public void delete() {
		try {
			mataKuliah.setMkStatus(false);
			dao.update(mataKuliah);

			DataTable dataTable = (DataTable) FacesContext.getCurrentInstance()
					.getViewRoot()
					.findComponent(":form_mataKuliah:tbl_mataKuliah");
			if (dataTable != null) {
				dataTable.reset();
			}

			displayInfoMessageToUser("Hapus MataKuliah Berhasil");
		} catch (Exception e) {
			System.out.println("error Karena : " + e.getMessage());
			// TODO: handle exception
		}
	}

	// load all
	public List<MMataKuliah> getMataKuliahs() {
		List<MMataKuliah> listMataKuliahs = new ArrayList<>();
		if (dao == null) {
			System.out.println("dao null");
		} else {
			for (MMataKuliah mMataKuliah : dao.getByCriteria()) {
				if (mMataKuliah.isMkStatus() == true) {
					listMataKuliahs.add(mMataKuliah);
				}
			}

		}
		return listMataKuliahs;
	}

	// getMataKuliah by id
	public MMataKuliah getMataKuliahByID(String kodeMK) {
		return dao.getByIdSTRING(kodeMK);
	}

	// return object MataKuliah null
	public void invalidateMataKuliah() {
		mataKuliah = new MMataKuliah();
	}

	public void listMataKuliahFilter(byte semester) {
		tempHashMapKuliahs = new HashMap<>();
		for (MMataKuliah mMataKuliah : getMataKuliahs()) {
			if (mMataKuliah.getMkSemester() == semester) {
				tempHashMapKuliahs.put(mMataKuliah.getMkKodeMk(), mMataKuliah);
			}
		}

		tempListMataKuliahs = new ArrayList<>();
		for (MMataKuliah mMataKuliah : getTempHashMapKuliahs().values()) {
			tempListMataKuliahs.add(mMataKuliah);
		}

		semester = 0;
	}

	public void handleSemesterChange() {
		if (semester == 1) {
			listMataKuliahFilter((byte) 1);
		} else if (semester == 2) {
			listMataKuliahFilter((byte) 2);
		} else if (semester == 3) {
			listMataKuliahFilter((byte) 3);
		} else if (semester == 4) {
			listMataKuliahFilter((byte) 4);
		} else if (semester == 5) {
			listMataKuliahFilter((byte) 5);
		} else {
			listMataKuliahFilter((byte) 6);
		}
	}
}
