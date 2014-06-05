package com.bridea.siak.bean;

import java.util.HashMap;
import java.util.Iterator;
import com.bridea.siak.model.MAmbil;

public class PerhitunganNilaiBean {

	private static char grade;

	public void hitungIPS(HashMap<Integer, MAmbil> listAmbilSemester) {
		/* hitung IPS : total(sks * bobotYgDidapat) / totalSKS per semester */
		int totalBobot = 0;
		int totalSKS = 0;
		for (Iterator<MAmbil> iterator = listAmbilSemester.values().iterator(); iterator
				.hasNext();) {
			MAmbil mAmbil = (MAmbil) iterator.next();
			int tempTotalBobot = mAmbil.getMMataKuliah().getMkSks()
					* hitungBobot((mAmbil.getAGradeNilai().charAt(0)));
			int tempTotalSks = mAmbil.getMMataKuliah().getMkSks();

			totalSKS += tempTotalSks;
			totalBobot += tempTotalBobot;
		}

		double ips = (double) totalBobot / (double) totalSKS;
		System.out.println("Semester : " + listAmbilSemester.keySet()
				+ " IPS : " + ips);
		
		System.out.println("============================================================================");
	}

	public void hitungIPK() {
		/* hitung IPk : totalbobotYgDidapat / totalSKS */
		
		
		
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

	public char hitungGrade(double nilaiKehadiran, double tugas, double uts,
			double uas) {

		/* hitung kehadiran : (totalKehadiran /jmlKehadiran * 100) * 10% */
		/* hitung rata-rata tugas : (jmlTotalTugas / jumlahTugas)*20% */
		/* hitung UTS : UTS * 30% */
		/* hitung UAS : UAS *40% */
		/* hitung totalNilai = kehadiran + rata2 + UTS + UAS */
		if (nilaiKehadiran == 0 || tugas == 0 || uts == 0 || uas == 0) {
			return 'T';
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
			double total = kehadiran + rataRataTugas + Nuts + Nuas;
			// System.out.println("Total Nilai Yg didapat : " + total);

			/* kondisikan totalNilai untuk menentukan grade&bobot */
			if (total >= 81.00 && total <= 100.00) {
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

			System.out.println("Total Grade Yg didapat : " + total);

		}

		// System.out.println("=======================================================");

		// System.out
		// .println("=======================================================");
		// System.out.println();
		// System.out.println();
		return grade;

	}

}
