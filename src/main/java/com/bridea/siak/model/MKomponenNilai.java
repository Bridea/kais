package com.bridea.siak.model;

// default package
// Generated Jun 9, 2014 11:11:32 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * MKomponenNilai generated by hbm2java
 */
@Entity
@Table(name = "m_komponen_nilai", catalog = "siak")
public class MKomponenNilai implements java.io.Serializable {

	private int knIdKomponenNilai;
	private MAmbil MAmbil;
	private byte knNilaiKehadiran;
	private double knNilaiTugas;
	private double knNilaiUts;
	private double knNilaiUas;

	public MKomponenNilai() {
	}

	public MKomponenNilai(MAmbil MAmbil, byte knNilaiKehadiran,
			double knNilaiTugas, double knNilaiUts, double knNilaiUas) {
		this.MAmbil = MAmbil;
		this.knNilaiKehadiran = knNilaiKehadiran;
		this.knNilaiTugas = knNilaiTugas;
		this.knNilaiUts = knNilaiUts;
		this.knNilaiUas = knNilaiUas;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "MAmbil"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "kn_id_komponen_nilai", unique = true, nullable = false)
	public int getKnIdKomponenNilai() {
		return this.knIdKomponenNilai;
	}

	public void setKnIdKomponenNilai(int knIdKomponenNilai) {
		this.knIdKomponenNilai = knIdKomponenNilai;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public MAmbil getMAmbil() {
		return this.MAmbil;
	}

	public void setMAmbil(MAmbil MAmbil) {
		this.MAmbil = MAmbil;
	}

	@Column(name = "kn_nilai_kehadiran", nullable = false)
	public byte getKnNilaiKehadiran() {
		return this.knNilaiKehadiran;
	}

	public void setKnNilaiKehadiran(byte knNilaiKehadiran) {
		this.knNilaiKehadiran = knNilaiKehadiran;
	}

	@Column(name = "kn_nilai_tugas", nullable = false, precision = 22, scale = 0)
	public double getKnNilaiTugas() {
		return this.knNilaiTugas;
	}

	public void setKnNilaiTugas(double knNilaiTugas) {
		this.knNilaiTugas = knNilaiTugas;
	}

	@Column(name = "kn_nilai_uts", nullable = false, precision = 22, scale = 0)
	public double getKnNilaiUts() {
		return this.knNilaiUts;
	}

	public void setKnNilaiUts(double knNilaiUts) {
		this.knNilaiUts = knNilaiUts;
	}

	@Column(name = "kn_nilai_uas", nullable = false, precision = 22, scale = 0)
	public double getKnNilaiUas() {
		return this.knNilaiUas;
	}

	public void setKnNilaiUas(double knNilaiUas) {
		this.knNilaiUas = knNilaiUas;
	}

}
