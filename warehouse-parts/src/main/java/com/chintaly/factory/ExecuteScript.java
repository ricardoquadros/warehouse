package com.chintaly.factory;

import org.primefaces.PrimeFaces;

public class ExecuteScript {

	public static String executeScript() {
		PrimeFaces.current().executeScript("showModal();");
		
		return "";
	}

}
