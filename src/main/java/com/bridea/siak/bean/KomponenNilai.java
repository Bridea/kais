package com.bridea.siak.bean;

public class KomponenNilai {
	
	private double kehadiran;
	private double rTugas;
	private double uts;
	private double uas;
	private int sks;
	private int mkKe;
	


	public KomponenNilai(double kehadiran, double rTugas, double uts, double uas,int sks,int mkKe) {

		this.kehadiran = kehadiran;
		this.rTugas = rTugas;
		this.uts = uts;
		this.uas = uas;
		this.sks = sks;
		this.mkKe = mkKe;
	}



	public KomponenNilai() {
		
	}

	public double getKehadiran() {
		return kehadiran;
	}

	public void setKehadiran(double kehadiran) {
		this.kehadiran = kehadiran;
	}

	public double getrTugas() {
		return rTugas;
	}

	public void setrTugas(double rTugas) {
		this.rTugas = rTugas;
	}

	public double getUts() {
		return uts;
	}

	public void setUts(double uts) {
		this.uts = uts;
	}

	public double getUas() {
		return uas;
	}

	public void setUas(double uas) {
		this.uas = uas;
	}
	

	public int getSks() {
		return sks;
	}

	public void setSks(int sks) {
		this.sks = sks;
	}


	public int getMkKe() {
		return mkKe;
	}

	public void setMkKe(int mkKe) {
		this.mkKe = mkKe;
	}

	
}
