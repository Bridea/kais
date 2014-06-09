package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.model.MAmbil;

@Component("perhitunganNilaiBean")
@Scope("session")
public class PerhitunganNilaiBean {

	private static char grade;
	int pembagiIPK = 0;

	public List<Double> hitungIPS(
			HashMap<Integer, HashMap<Integer, MAmbil>> listAmbilSemesterUtama) {
		/* hitung IPS : total(sks * bobotYgDidapat) / totalSKS per semester */
		int totalBobot = 0;
		int totalSKS = 0;
		boolean statusNilai = false;
		List<Double> listIPS = new ArrayList<>();

		for (Iterator<HashMap<Integer, MAmbil>> iterator1 = listAmbilSemesterUtama
				.values().iterator(); iterator1.hasNext();) {
			HashMap<Integer, MAmbil> listAmbilSemester = (HashMap<Integer, MAmbil>) iterator1
					.next();

			if (listAmbilSemester.size() > 0) {
				for (Iterator<MAmbil> iterator2 = listAmbilSemester.values()
						.iterator(); iterator2.hasNext();) {
					MAmbil mAmbil = (MAmbil) iterator2.next();
					System.out.println(mAmbil.getAGradeNilai());
					if (mAmbil.getAGradeNilai().equals("A")
							|| mAmbil.getAGradeNilai().equals("B")
							|| mAmbil.getAGradeNilai().equals("C")
							|| mAmbil.getAGradeNilai().equals("D")
							|| mAmbil.getAGradeNilai().equals("E")) {
						int tempTotalBobot = mAmbil.getMMataKuliah().getMkSks()
								* hitungBobot((mAmbil.getAGradeNilai()
										.charAt(0)));
						int tempTotalSks = mAmbil.getMMataKuliah().getMkSks();

						totalSKS += tempTotalSks;
						totalBobot += tempTotalBobot;

						statusNilai = true;
					}
				}
				if (statusNilai == true) {
					pembagiIPK += 1;
					statusNilai = false;
				}
			}

			double ips = 0;
			if (totalBobot != 0 && totalSKS != 0) {
				ips = (double) totalBobot / (double) totalSKS;
				System.out.println("total bobot : " + totalBobot);
				System.out.println("total sks : " + totalSKS);
				System.out.println("Semester : " + listAmbilSemester.keySet()
						+ " IPS : " + ips);
				totalBobot = 0;
				totalSKS = 0;
			}
			listIPS.add(ips);

		}

		return listIPS;

	}

	public double hitungIPK(List<Double> listIPS) {
		/* hitung IPk : totalbobotYgDidapat / totalSKS */
		double tempTotalIPS = 0;
		double ipk = 0;

		System.out.println("list ips : " + listIPS);
		for (double ips : listIPS) {
			tempTotalIPS += ips;

		}

		System.out.println("total ips : " + tempTotalIPS);
		System.out.println("pembagi ipk : " + pembagiIPK);

		if (tempTotalIPS != 0 && pembagiIPK != 0) {
			ipk = tempTotalIPS / pembagiIPK;
		}

		System.out.println("IPK : " + ipk);

		return ipk;
	}

	public int hitungBobot(char grades) {
		int bobot = 0;
		switch (grades) {
		case 'A':
			bobot = 4;
			break;
		case 'B':
			bobot = 3;
			break;
		case 'C':
			bobot = 2;
			break;
		case 'D':
			bobot = 1;
			break;
		case 'E':
			bobot = 0;
			break;

		}
		return bobot;
	}

	public double hitungTotalNilai(double nilaiKehadiran, double tugas,
			double uts, double uas) {
		double total = 0.0;
		/* hitung kehadiran : (totalKehadiran /jmlKehadiran * 100) * 10% */
		/* hitung rata-rata tugas : (jmlTotalTugas / jumlahTugas)*20% */
		/* hitung UTS : UTS * 30% */
		/* hitung UAS : UAS *40% */
		/* hitung totalNilai = kehadiran + rata2 + UTS + UAS */
		if (nilaiKehadiran == 0 || tugas == 0 || uts == 0 || uas == 0) {
			total = 0.0;
		} else {
			double kehadiran = (nilaiKehadiran * 0.1);
			double rataRataTugas = (tugas * 0.2);
			double Nuts = (uts * 0.3);
			double Nuas = (uas * 0.4);
			// System.out
			// .println("=======================================================");
			// System.out.println("Total Nilai kehadiran Yg didapat : " +
			// kehadiran);
			// System.out.println("Total Nilai rataRataTugas Yg didapat : "
			// + rataRataTugas);
			// System.out.println("Total Nilai Nuts Yg didapat : " + Nuts);
			// System.out.println("Total Nilai Nuas Yg didapat : " + Nuas);
			//
			total = kehadiran + rataRataTugas + Nuts + Nuas;
			// System.out.println("Total Nilai Yg didapat : " + total);

			/* kondisikan totalNilai untuk menentukan grade&bobot */
		}

		// System.out.println("=======================================================");

		// System.out
		// .println("=======================================================");
		// System.out.println();
		// System.out.println();
		return total;

	}

	public char hitungGrade(double total) {
		if (total == 0.0) {
			grade = 'T';
		} else if (total >= 81.00 && total <= 100.00) {
			grade = 'A';
		} else if (total >= 61.00 && total <= 80.99) {
			grade = 'B';
		} else if (total >= 41.00 && total <= 60.99) {
			grade = 'C';
		} else if (total >= 21.00 && total <= 40.99) {
			grade = 'D';
		} else {
			grade = 'E';
		}
		return grade;
	}
}
