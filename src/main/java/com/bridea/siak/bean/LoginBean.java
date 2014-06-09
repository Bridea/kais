package com.bridea.siak.bean;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bridea.siak.model.Login;
import com.bridea.siak.util.DialogBean;
import com.bridea.siak.util.UtilBean;
import com.bridea.siak.util.Visit;

/*@ManagedBean(name = "loginBean")
 @SessionScoped*/
@Component("loginBean")
@Scope("session")
public class LoginBean extends DialogBean {

	private boolean renderLogout;
	private int jumlah;

	private String passwordAdmin;

	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public boolean isRenderLogout() {
		return renderLogout;
	}

	public void setRenderLogout(boolean renderLogout) {
		this.renderLogout = renderLogout;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	// tambahan

	public String redirect(String inp_url) {

		FacesContext ctx = FacesContext.getCurrentInstance();

		ExternalContext extContext = ctx.getExternalContext();
		String url = extContext.encodeActionURL(ctx.getApplication()
				.getViewHandler().getActionURL(ctx, inp_url));
		try {

			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);

		}
		return null;

	}

	// fungsion Login

	private boolean cekData() {
		// pengecekan id pemilih yang finger dengan data pemilih
		if (getPasswordAdmin().equals("admin")) {
			return true;
		}

		return false;
	}

	public void doLogin() {
		System.out.println("Masuk Do Login");
		if (cekData()) {
			System.out.println("Check Data True");
			Visit visit = new Visit();
			visit.setCurrentPemiih(login);
			System.out.println("Visit ==> " + visit);
			UtilBean.setValueExpression("#{sessionScope.visit}", visit);
			redirect("/staff.akademik.jsf");
		} else {
			System.out.println("Check Data False");
		}
	}

	// logout
	public String popUpLogout() {
		renderLogout = true;
		return null;
	}

	public String cancelLogout() {
		renderLogout = false;
		return null;
	}

	public void doLogout() {
		HttpSession session = (HttpSession) UtilBean.getFacesContext()
				.getExternalContext().getSession(false);
		session.removeAttribute("#{sessionScope.visit}");
		if (session != null) {
			session.invalidate();
		}
		redirect("/login.jsf");
	}

}
