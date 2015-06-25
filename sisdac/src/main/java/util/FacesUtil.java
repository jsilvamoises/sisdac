/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Moises
 */

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 *
 * @author Moises
 */
public class FacesUtil {

	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, message,
								message));
	}

	public static void addWarnMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	public static void addFatalMessage(String message) {
		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, message,
								message));
	}

	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	public static void showDialogMessageErro(String title, String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				title, msg);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void showDialogMessageFatal(String title, String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,
				title, msg);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void showDialogMessageInfo(String title, String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				title, msg);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static void showDialogMessageWarn(String title, String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
				title, msg);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public static boolean isNotPostback() {
		return !isPostBack();
	}

	public static boolean isPostBack() {
		return FacesContext.getCurrentInstance().isPostback();
	}

}
