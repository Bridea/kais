package com.bridea.siak.util;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilBean {

	public static Object getAnotherbean(String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getApplication().getVariableResolver()
				.resolveVariable(fc, beanName);
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static void setValueExpression(String expression, Object value) {
		ExpressionFactory elFactory = getFacesContext().getApplication()
				.getExpressionFactory();
		ELContext elContext = getFacesContext().getELContext();
		ValueExpression valueExp = elFactory.createValueExpression(elContext,
				expression, Object.class);
		valueExp.setValue(elContext, value);
	}

	public static void addMessage(String id, String message) {
		System.out.println("Masuk Add Message");
		UtilBean.getFacesContext().addMessage(id,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));

	}
}
