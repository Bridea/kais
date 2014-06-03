package com.bridea.siak.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.bridea.siak.model.MMahasiswa;

/**
 * @author WahyudinScatt
 * @date 18 Feb 2014
 * @time 22.23.24
 **/

public class MahasiswaDataModel extends ListDataModel<MMahasiswa> implements
		SelectableDataModel<MMahasiswa>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MahasiswaDataModel(List<MMahasiswa> data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MMahasiswa getRowData(String rowKey) {
		List<MMahasiswa> mahasiswas = (List<MMahasiswa>) getWrappedData();

		for (MMahasiswa mahasiswa : mahasiswas) {
			if (mahasiswa.getMhsNpm().equals(rowKey))
				return mahasiswa;
		}

		return null;
	}

	@Override
	public Object getRowKey(MMahasiswa mMahasiswa) {
		// TODO Auto-generated method stub
		return mMahasiswa.getMhsNpm();
	}

}
