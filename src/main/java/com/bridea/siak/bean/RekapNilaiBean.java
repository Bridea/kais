package com.bridea.siak.bean;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.model.MKomponenNilai;
import com.bridea.siak.util.JSFMessageUtil;

import net.sf.jasperreports.engine.JRDataSource;

@Component("rekapNilaiBean")
@Scope("session")
public class RekapNilaiBean extends AbstractBaseReportBean {

	@Autowired
	private EditNilai editNilai;
	@Autowired
	private KomponenNilaiBean komponenNilaiBean;

	private String tempKodeMataKuliah;
	private String tempKodeDosen;
	private String tempKelas;
	private String tempWaktu;

	public String getTempKodeMataKuliah() {
		return tempKodeMataKuliah;
	}

	public void setTempKodeMataKuliah(String tempKodeMataKuliah) {
		this.tempKodeMataKuliah = tempKodeMataKuliah;
	}

	public String getTempKodeDosen() {
		return tempKodeDosen;
	}

	public void setTempKodeDosen(String tempKodeDosen) {
		this.tempKodeDosen = tempKodeDosen;
	}

	public String getTempKelas() {
		return tempKelas;
	}

	public void setTempKelas(String tempKelas) {
		this.tempKelas = tempKelas;
	}

	public String getTempWaktu() {
		return tempWaktu;
	}

	public void setTempWaktu(String tempWaktu) {
		this.tempWaktu = tempWaktu;
	}

	private final String COMPILE_FILE_NAME = "rekap-nilai";

	private List<MKomponenNilai> listKomponenNilais;

	public List<MKomponenNilai> getListKomponenNilais() {
		return listKomponenNilais;
	}

	public void setListKomponenNilais(List<MKomponenNilai> listKomponenNilais) {
		this.listKomponenNilais = listKomponenNilais;
	}

	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}

	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> reportParameters = new HashMap<String, Object>();

		reportParameters.put("ReportTitle", "SIAK APIKES");

		return reportParameters;
	}

	@Override
	protected JRDataSource getJRDataSource() {
		// return your custom datasource implementation
		RekapNilaiDataSources dataSource = new RekapNilaiDataSources();
		dataSource.setListKomponenNilais(getListKomponenNilais());
		return dataSource;
	}

	public String execute() {
		try {
			// listKomponenNilais = new ArrayList<>();
			// filterMk();

			super.prepareReport();
		} catch (Exception e) {
			// make your own exception handling
			e.printStackTrace();
		}
		return null;
	}

	public void filterMk() {
		listKomponenNilais = new ArrayList<>();
		List<MKomponenNilai> tempList = komponenNilaiBean
				.getListKomponenNilais();
		System.out.println(tempList.size());
		for (MKomponenNilai mKomponenNilai : tempList) {
			if (mKomponenNilai.getMAmbil().getMMataKuliah().getMkKodeMk()
					.equals(getTempKodeMataKuliah())
					&& mKomponenNilai.getMAmbil().getMDosen().getDKodeDosen()
							.equals(getTempKodeDosen())
					&& mKomponenNilai.getMAmbil().getAKelas()
							.equals(getTempKelas())
					&& mKomponenNilai.getMAmbil().getAWaktu()
							.equals(getTempWaktu())) {
				listKomponenNilais.add(mKomponenNilai);
			}
		}
		if (listKomponenNilais.size() < 0) {
			JSFMessageUtil messageUtil = new JSFMessageUtil();
			messageUtil
					.sendInfoMessageToUser("Data Nilai Yang Anda Cari Tidak Tersedia");
		}
		System.out.println(listKomponenNilais.size());
	}
}
