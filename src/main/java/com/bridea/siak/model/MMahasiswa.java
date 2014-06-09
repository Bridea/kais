package com.bridea.siak.model;

// default package
// Generated Jun 9, 2014 10:29:45 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MMahasiswa generated by hbm2java
 */
@Entity
@Table(name = "m_mahasiswa", catalog = "siak")
public class MMahasiswa implements java.io.Serializable {

	private String mhsNpm;
	private String mhsNamaLengkap;
	private String mhsTempatLahir;
	private Date mhsTanggalLahir;
	private char mhsJnsKelamin;
	private String mhsAgama;
	private String mhsAsalSekolah;
	private String mhsAlamat;
	private String mhsNamaOrangTua;
	private String mhsPekerjaanOrangTua;
	private String mhsJudulPenelitian;
	private boolean mhsStatus;
	private Set<MAmbil> MAmbils = new HashSet<MAmbil>(0);

	public MMahasiswa() {
	}

	public MMahasiswa(String mhsNpm, String mhsNamaLengkap,
			String mhsTempatLahir, Date mhsTanggalLahir, char mhsJnsKelamin,
			String mhsAgama, String mhsAsalSekolah, String mhsAlamat,
			String mhsNamaOrangTua, String mhsPekerjaanOrangTua,
			String mhsJudulPenelitian, boolean mhsStatus) {
		this.mhsNpm = mhsNpm;
		this.mhsNamaLengkap = mhsNamaLengkap;
		this.mhsTempatLahir = mhsTempatLahir;
		this.mhsTanggalLahir = mhsTanggalLahir;
		this.mhsJnsKelamin = mhsJnsKelamin;
		this.mhsAgama = mhsAgama;
		this.mhsAsalSekolah = mhsAsalSekolah;
		this.mhsAlamat = mhsAlamat;
		this.mhsNamaOrangTua = mhsNamaOrangTua;
		this.mhsPekerjaanOrangTua = mhsPekerjaanOrangTua;
		this.mhsJudulPenelitian = mhsJudulPenelitian;
		this.mhsStatus = mhsStatus;
	}

	public MMahasiswa(String mhsNpm, String mhsNamaLengkap,
			String mhsTempatLahir, Date mhsTanggalLahir, char mhsJnsKelamin,
			String mhsAgama, String mhsAsalSekolah, String mhsAlamat,
			String mhsNamaOrangTua, String mhsPekerjaanOrangTua,
			String mhsJudulPenelitian, boolean mhsStatus, Set<MAmbil> MAmbils) {
		this.mhsNpm = mhsNpm;
		this.mhsNamaLengkap = mhsNamaLengkap;
		this.mhsTempatLahir = mhsTempatLahir;
		this.mhsTanggalLahir = mhsTanggalLahir;
		this.mhsJnsKelamin = mhsJnsKelamin;
		this.mhsAgama = mhsAgama;
		this.mhsAsalSekolah = mhsAsalSekolah;
		this.mhsAlamat = mhsAlamat;
		this.mhsNamaOrangTua = mhsNamaOrangTua;
		this.mhsPekerjaanOrangTua = mhsPekerjaanOrangTua;
		this.mhsJudulPenelitian = mhsJudulPenelitian;
		this.mhsStatus = mhsStatus;
		this.MAmbils = MAmbils;
	}

	@Id
	@Column(name = "mhs_npm", unique = true, nullable = false, length = 10)
	public String getMhsNpm() {
		return this.mhsNpm;
	}

	public void setMhsNpm(String mhsNpm) {
		this.mhsNpm = mhsNpm;
	}

	@Column(name = "mhs_nama_lengkap", nullable = false, length = 60)
	public String getMhsNamaLengkap() {
		return this.mhsNamaLengkap;
	}

	public void setMhsNamaLengkap(String mhsNamaLengkap) {
		this.mhsNamaLengkap = mhsNamaLengkap;
	}

	@Column(name = "mhs_tempat_lahir", nullable = false, length = 50)
	public String getMhsTempatLahir() {
		return this.mhsTempatLahir;
	}

	public void setMhsTempatLahir(String mhsTempatLahir) {
		this.mhsTempatLahir = mhsTempatLahir;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mhs_tanggal_lahir", nullable = false, length = 10)
	public Date getMhsTanggalLahir() {
		return this.mhsTanggalLahir;
	}

	public void setMhsTanggalLahir(Date mhsTanggalLahir) {
		this.mhsTanggalLahir = mhsTanggalLahir;
	}

	@Column(name = "mhs_jns_kelamin", nullable = false, length = 1)
	public char getMhsJnsKelamin() {
		return this.mhsJnsKelamin;
	}

	public void setMhsJnsKelamin(char mhsJnsKelamin) {
		this.mhsJnsKelamin = mhsJnsKelamin;
	}

	@Column(name = "mhs_agama", nullable = false, length = 15)
	public String getMhsAgama() {
		return this.mhsAgama;
	}

	public void setMhsAgama(String mhsAgama) {
		this.mhsAgama = mhsAgama;
	}

	@Column(name = "mhs_asal_sekolah", nullable = false, length = 60)
	public String getMhsAsalSekolah() {
		return this.mhsAsalSekolah;
	}

	public void setMhsAsalSekolah(String mhsAsalSekolah) {
		this.mhsAsalSekolah = mhsAsalSekolah;
	}

	@Column(name = "mhs_alamat", nullable = false, length = 65535)
	public String getMhsAlamat() {
		return this.mhsAlamat;
	}

	public void setMhsAlamat(String mhsAlamat) {
		this.mhsAlamat = mhsAlamat;
	}

	@Column(name = "mhs_nama_orang_tua", nullable = false, length = 60)
	public String getMhsNamaOrangTua() {
		return this.mhsNamaOrangTua;
	}

	public void setMhsNamaOrangTua(String mhsNamaOrangTua) {
		this.mhsNamaOrangTua = mhsNamaOrangTua;
	}

	@Column(name = "mhs_pekerjaan_orang_tua", nullable = false, length = 60)
	public String getMhsPekerjaanOrangTua() {
		return this.mhsPekerjaanOrangTua;
	}

	public void setMhsPekerjaanOrangTua(String mhsPekerjaanOrangTua) {
		this.mhsPekerjaanOrangTua = mhsPekerjaanOrangTua;
	}

	@Column(name = "mhs_judul_penelitian", nullable = false, length = 50)
	public String getMhsJudulPenelitian() {
		return this.mhsJudulPenelitian;
	}

	public void setMhsJudulPenelitian(String mhsJudulPenelitian) {
		this.mhsJudulPenelitian = mhsJudulPenelitian;
	}

	@Column(name = "mhs_status", nullable = false)
	public boolean isMhsStatus() {
		return this.mhsStatus;
	}

	public void setMhsStatus(boolean mhsStatus) {
		this.mhsStatus = mhsStatus;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "MMahasiswa")
	public Set<MAmbil> getMAmbils() {
		return this.MAmbils;
	}

	public void setMAmbils(Set<MAmbil> MAmbils) {
		this.MAmbils = MAmbils;
	}

}
