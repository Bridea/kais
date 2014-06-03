package com.bridea.siak.util;

/** 
 * @author WahyudinScatt
 * @date 10 Des 2013
 * @time 19.20.56
 **/

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean extendedRender = false;
	private boolean customRender = true;
	private boolean tableRender = false;
	private boolean layoutRender = false;

	// selected include contents.
	private String selectedIncludePath = "/WEB-INF/includes/main/dashboard.xhtml";

	/**
	 * Gets the currently selected content include path.
	 * 
	 * @return currently selected content include path.
	 */
	@SuppressWarnings("rawtypes")
	public String getSelectedIncludePath() {
		// check for a currently selected path to be ready for ui:include
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String requestedPath = (String) map.get("includePath");
		if ((null != requestedPath) && (requestedPath.length() > 0)) {
			selectedIncludePath = requestedPath;
		}
		return selectedIncludePath;
	}

	/**
	 * Sets the selected content include path to the specified path.
	 * 
	 * @param selectedIncludePath
	 *            the specified content include path.
	 */
	public void setSelectedIncludePath(String selectedIncludePath) {
		this.selectedIncludePath = selectedIncludePath;
	}

	/**
	 * Action Listener for the changes the selected content path in the facelets
	 * version of component showcase.
	 * 
	 * @param event
	 *            JSF Action Event.
	 */
	@SuppressWarnings("rawtypes")
	public void navigationPathChange(ActionEvent event) {

		// get from the context content include path to show as well
		// as the title associated with the link.
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		selectedIncludePath = (String) map.get("includePath");
	}

	public boolean getExtendedRender() {
		return extendedRender;
	}

	public boolean getCustomRender() {
		return customRender;
	}

	public boolean getTableRender() {
		return tableRender;
	}

	public boolean getLayoutRender() {
		return layoutRender;
	}

	public void setExtendedRender(boolean extendedRender) {
		this.extendedRender = extendedRender;
	}

	public void setCustomRender(boolean customRender) {
		this.customRender = customRender;
	}

	public void setTableRender(boolean tableRender) {
		this.tableRender = tableRender;
	}

	public void setLayoutRender(boolean layoutRender) {
		this.layoutRender = layoutRender;
	}
}
