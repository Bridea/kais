package com.bridea.siak.util;

import org.primefaces.context.RequestContext;

/**
 * @author WahyudinScatt
 * @date 22 Des 2013
 * @time 10.48.39
 **/

public class DialogBean {

	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	public DialogBean() {
		super();
	}

	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}

	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	protected void closeDialog() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
}
