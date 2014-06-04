package com.bridea.siak.util;

import java.io.Serializable; 

import com.bridea.siak.model.Login;

public class Visit implements Serializable {

	private Login currentPemiih;
	static Visit visit;

	public static Visit getInstance() {
		if (visit == null) {
			visit = new Visit();
		}
		return visit;
	}

	public Login getCurrentPemiih() {
		return currentPemiih;
	}

	public void setCurrentPemiih(Login currentPemiih) {
		this.currentPemiih = currentPemiih;
	}

}
