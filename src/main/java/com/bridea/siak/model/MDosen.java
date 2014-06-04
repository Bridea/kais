package com.bridea.siak.model;

// default package
// Generated Jun 4, 2014 1:41:50 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MDosen generated by hbm2java
 */
@Entity
@Table(name = "m_dosen", catalog = "siak")
public class MDosen implements java.io.Serializable {

	private String DKodeDosen;
	private String DNamaDosen;
	private String DNidn;
	private String DRiwayatPendidikan;
	private String DAlamat;
	private String DKontak;
	private boolean DStatus;
	private Set<MAmbil> MAmbils = new HashSet<MAmbil>(0);

	public MDosen() {
	}

	public MDosen(String DKodeDosen, String DNamaDosen, String DNidn,
			String DRiwayatPendidikan, String DAlamat, String DKontak,
			boolean DStatus) {
		this.DKodeDosen = DKodeDosen;
		this.DNamaDosen = DNamaDosen;
		this.DNidn = DNidn;
		this.DRiwayatPendidikan = DRiwayatPendidikan;
		this.DAlamat = DAlamat;
		this.DKontak = DKontak;
		this.DStatus = DStatus;
	}

	public MDosen(String DKodeDosen, String DNamaDosen, String DNidn,
			String DRiwayatPendidikan, String DAlamat, String DKontak,
			boolean DStatus, Set<MAmbil> MAmbils) {
		this.DKodeDosen = DKodeDosen;
		this.DNamaDosen = DNamaDosen;
		this.DNidn = DNidn;
		this.DRiwayatPendidikan = DRiwayatPendidikan;
		this.DAlamat = DAlamat;
		this.DKontak = DKontak;
		this.DStatus = DStatus;
		this.MAmbils = MAmbils;
	}

	@Id
	@Column(name = "d_kode_dosen", unique = true, nullable = false, length = 8)
	public String getDKodeDosen() {
		return this.DKodeDosen;
	}

	public void setDKodeDosen(String DKodeDosen) {
		this.DKodeDosen = DKodeDosen;
	}

	@Column(name = "d_nama_dosen", nullable = false, length = 60)
	public String getDNamaDosen() {
		return this.DNamaDosen;
	}

	public void setDNamaDosen(String DNamaDosen) {
		this.DNamaDosen = DNamaDosen;
	}

	@Column(name = "d_nidn", nullable = false, length = 16)
	public String getDNidn() {
		return this.DNidn;
	}

	public void setDNidn(String DNidn) {
		this.DNidn = DNidn;
	}

	@Column(name = "d_riwayat_pendidikan", nullable = false, length = 20)
	public String getDRiwayatPendidikan() {
		return this.DRiwayatPendidikan;
	}

	public void setDRiwayatPendidikan(String DRiwayatPendidikan) {
		this.DRiwayatPendidikan = DRiwayatPendidikan;
	}

	@Column(name = "d_alamat", nullable = false, length = 65535)
	public String getDAlamat() {
		return this.DAlamat;
	}

	public void setDAlamat(String DAlamat) {
		this.DAlamat = DAlamat;
	}

	@Column(name = "d_kontak", nullable = false, length = 13)
	public String getDKontak() {
		return this.DKontak;
	}

	public void setDKontak(String DKontak) {
		this.DKontak = DKontak;
	}

	@Column(name = "d_status", nullable = false)
	public boolean isDStatus() {
		return this.DStatus;
	}

	public void setDStatus(boolean DStatus) {
		this.DStatus = DStatus;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "MDosen")
	public Set<MAmbil> getMAmbils() {
		return this.MAmbils;
	}

	public void setMAmbils(Set<MAmbil> MAmbils) {
		this.MAmbils = MAmbils;
	}

}
