package com.bridea.siak.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PerhitunganNilaiBean {

	private static char grade;
	private Map<Integer, Integer> bobotM;
	private static double[] ips = new double[6];
	static double tempB = 0;
	static double bB = 0;
	static int tempSks = 0;
	static int tempSmester = 1;
	static int semesters = 0;

	public static void hitungIPS(int semester, KomponenNilai kn) {

		/* hitung IPS : (sks *bobotYgDidapat) / totalSKS per semester */

		if (tempSmester == semester) {
			double bobots = hitungBobot(hitungGrade(kn.getKehadiran(),
					kn.getrTugas(), kn.getUts(), kn.getUas()));
			tempB = kn.getSks() * bobots;
			bB = bB + tempB;
			tempSks = tempSks + kn.getSks();

			System.out.println("Semester " + semester + "Matakuliah Ke "
					+ kn.getMkKe() + " SKS : " + kn.getSks() + " * bobot : "
					+ bobots + "= Nbobot " + tempB);
			System.out
					.println("=======================================================");
			if (semester == 6) {
				System.out.println("msuk kondisi semester 6");
				ips[semester - 1] = bB / tempSks;
				System.out.println("IPS Nbobot " + bB + " NSKS " + tempSks);
				System.out.println("IPS SEMESTER " + (semester - 1) + ":"
						+ ips[semester - 1]);
			}

		} else {

			tempSmester = semester;
			ips[semester - 2] = bB / tempSks;

			System.out.println("IPS Nbobot " + bB + " NSKS " + tempSks);
			System.out.println("IPS SEMESTER " + (semester - 1) + ":"
					+ ips[semester - 2]);
			bB = 0;
			tempSks = 0;
			System.out
					.println("=======================================================");

			double bobots = hitungBobot(hitungGrade(kn.getKehadiran(),
					kn.getrTugas(), kn.getUts(), kn.getUas()));
			tempB = kn.getSks() * bobots;
			bB = bB + tempB;
			tempSks = tempSks + kn.getSks();
			System.out.println("Semester " + semester + "Matakuliah Ke "
					+ kn.getMkKe() + " SKS : " + kn.getSks() + " * bobot : "
					+ bobots + "= Nbobot " + tempB);

		}

		System.out
				.println("=======================================================");

	}

	public void hitungIPK() {
		/* hitung IPk : totalbobotYgDidapat / totalSKS */
	}

	public static int hitungBobot(char grades) {
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

	public static char hitungGrade(double nilaiKehadiran, double tugas,
			double uts, double uas) {

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

	public static void main(String[] args) {
		// new PerhitunganNilaiBean().hitungGrade(45.5, 40.5, 40, 43);

		KomponenNilai kn11 = new KomponenNilai(45.5, 40.5, 40, 43, 2, 1);
		KomponenNilai kn12 = new KomponenNilai(55.5, 50.5, 50, 53, 2, 2);
		KomponenNilai kn13 = new KomponenNilai(65.5, 60.5, 60, 43, 3, 3);
		KomponenNilai kn14 = new KomponenNilai(25.5, 30.5, 60, 43, 3, 4);
		KomponenNilai kn15 = new KomponenNilai(45.5, 90.5, 80, 43, 3, 5);
		KomponenNilai kn16 = new KomponenNilai(95.5, 90.5, 80, 73, 3, 6);
		KomponenNilai kn17 = new KomponenNilai(85.5, 80.5, 80, 43, 3, 7);

		KomponenNilai kn21 = new KomponenNilai(45.5, 40.5, 40, 43, 2, 1);
		KomponenNilai kn22 = new KomponenNilai(55.5, 70.5, 50, 53, 2, 2);
		KomponenNilai kn23 = new KomponenNilai(65.5, 60.5, 60, 43, 2, 3);
		KomponenNilai kn24 = new KomponenNilai(25.5, 60.5, 60, 43, 2, 4);
		KomponenNilai kn25 = new KomponenNilai(45.5, 90.5, 80, 73, 3, 5);
		KomponenNilai kn26 = new KomponenNilai(95.5, 90.5, 80, 73, 3, 6);
		KomponenNilai kn27 = new KomponenNilai(85.5, 80.5, 80, 43, 3, 7);

		KomponenNilai kn31 = new KomponenNilai(45.5, 40.5, 40, 43, 3, 1);
		KomponenNilai kn32 = new KomponenNilai(55.5, 50.5, 50, 53, 3, 2);
		KomponenNilai kn33 = new KomponenNilai(65.5, 60.5, 60, 43, 3, 3);
		KomponenNilai kn34 = new KomponenNilai(25.5, 30.5, 60, 63, 3, 4);
		KomponenNilai kn35 = new KomponenNilai(45.5, 90.5, 40, 43, 3, 5);
		KomponenNilai kn36 = new KomponenNilai(95.5, 90.5, 80, 73, 3, 6);
		KomponenNilai kn37 = new KomponenNilai(85.5, 30.5, 80, 43, 3, 7);

		KomponenNilai kn41 = new KomponenNilai(45.5, 60.5, 40, 43, 2, 1);
		KomponenNilai kn42 = new KomponenNilai(55.5, 60.5, 50, 53, 2, 2);
		KomponenNilai kn43 = new KomponenNilai(65.5, 60.5, 60, 43, 3, 3);
		KomponenNilai kn44 = new KomponenNilai(25.5, 30.5, 60, 43, 3, 4);
		KomponenNilai kn45 = new KomponenNilai(45.5, 90.5, 70, 43, 3, 5);
		KomponenNilai kn46 = new KomponenNilai(95.5, 90.5, 70, 73, 2, 6);
		KomponenNilai kn47 = new KomponenNilai(85.5, 70.5, 80, 43, 2, 7);

		KomponenNilai kn51 = new KomponenNilai(45.5, 30.5, 40, 43, 2, 1);
		KomponenNilai kn52 = new KomponenNilai(55.5, 50.5, 40, 53, 2, 2);
		KomponenNilai kn53 = new KomponenNilai(65.5, 60.5, 40, 43, 2, 3);
		KomponenNilai kn54 = new KomponenNilai(25.5, 30.5, 40, 43, 2, 4);
		KomponenNilai kn55 = new KomponenNilai(45.5, 90.5, 40, 43, 2, 5);
		KomponenNilai kn56 = new KomponenNilai(95.5, 90.5, 80, 73, 2, 6);
		KomponenNilai kn57 = new KomponenNilai(85.5, 80.5, 80, 43, 2, 7);

		KomponenNilai kn61 = new KomponenNilai(45.5, 40.5, 40, 43, 2, 1);
		KomponenNilai kn62 = new KomponenNilai(55.5, 50.5, 50, 53, 2, 2);
		KomponenNilai kn63 = new KomponenNilai(65.5, 50.5, 60, 43, 2, 3);
		KomponenNilai kn64 = new KomponenNilai(25.5, 50.5, 60, 43, 2, 4);
		KomponenNilai kn65 = new KomponenNilai(45.5, 90.5, 80, 43, 2, 5);
		KomponenNilai kn66 = new KomponenNilai(95.5, 90.5, 50, 73, 3, 6);
		KomponenNilai kn67 = new KomponenNilai(85.5, 80.5, 50, 43, 3, 7);

		List<KomponenNilai> sm1 = new ArrayList<>();
		sm1.add(kn11);
		sm1.add(kn12);
		sm1.add(kn13);
		sm1.add(kn14);
		sm1.add(kn15);
		sm1.add(kn16);
		sm1.add(kn17);

		List<KomponenNilai> sm2 = new ArrayList<>();
		sm2.add(kn21);
		sm2.add(kn22);
		sm2.add(kn23);
		sm2.add(kn24);
		sm2.add(kn25);
		sm2.add(kn26);
		sm2.add(kn27);

		List<KomponenNilai> sm3 = new ArrayList<>();
		sm3.add(kn31);
		sm3.add(kn32);
		sm3.add(kn33);
		sm3.add(kn34);
		sm3.add(kn35);
		sm3.add(kn36);
		sm3.add(kn37);

		List<KomponenNilai> sm4 = new ArrayList<>();
		sm4.add(kn41);
		sm4.add(kn42);
		sm4.add(kn43);
		sm4.add(kn44);
		sm4.add(kn45);
		sm4.add(kn46);
		sm4.add(kn47);

		List<KomponenNilai> sm5 = new ArrayList<>();
		sm5.add(kn51);
		sm5.add(kn52);
		sm5.add(kn53);
		sm5.add(kn54);
		sm5.add(kn55);
		sm5.add(kn56);
		sm5.add(kn57);

		List<KomponenNilai> sm6 = new ArrayList<>();
		sm6.add(kn61);
		sm6.add(kn62);
		sm6.add(kn63);
		sm6.add(kn64);
		sm6.add(kn65);
		sm6.add(kn66);
		sm6.add(kn67);

		HashMap<Integer, List<KomponenNilai>> nilai = new HashMap<>();
		nilai.put(1, sm1);
		nilai.put(2, sm2);
		nilai.put(3, sm3);
		nilai.put(4, sm4);
		nilai.put(5, sm5);
		nilai.put(6, sm6);
		//
		// for (Iterator iterator = nilai.values().iterator();
		// iterator.hasNext();) {
		// List<KomponenNilai> listKomponenNilais = (List<KomponenNilai>)
		// iterator.next();
		//
		// }
		//

		Set set = nilai.entrySet();
		Iterator j = set.iterator();

		while (j.hasNext()) {
			Map.Entry me = (Map.Entry) j.next();
			//
			// System.out.println("K : "+me.getKey()+" V : "+ me.getValue());
			List<KomponenNilai> s = (List<KomponenNilai>) me.getValue();
			int semester = (int) me.getKey();
			for (int i = 0; i < s.size(); i++) {

				new PerhitunganNilaiBean().hitungIPS(semester, s.get(i));
			}

		}

		for (int i = 0; i < ips.length; i++) {
			System.out.println("IPS SEMESTER " + i + ":" + ips[i]);
		}
	}

}
