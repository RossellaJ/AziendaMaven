package it.alfa.rossella.dao;

import it.alfa.rossella.AdminBean;
import it.alfa.rossella.servizi.Servizi;

public class Main {

	public static void main(String[] args) {
		
		AdminDao aDao = new AdminDao();
		
		Servizi s = new Servizi();
		String passNonCodificata = "123";
		String passCodificata = s.convertiPass(passNonCodificata);
		
		AdminBean aB = new AdminBean("Rossella","Pilotta","ross",passCodificata,'a',"alto");
		
		s.registraUtente(aB);
		

		
	}

}
