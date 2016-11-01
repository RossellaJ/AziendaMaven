package it.alfa.rossella;

import javax.persistence.Entity;

@Entity
public class DipendenteBean extends UtenteBean implements DataBean{
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	
	private double stipendio;
	private String posizione;
	
	
	public DipendenteBean() {
	}

	public DipendenteBean(String nome, String cognome,
			String username, String password, char ruolo,String posizione, double stipendio) {
		super(nome,cognome,username,password,ruolo);
		this.posizione = posizione;
		this.stipendio = stipendio;
}
	


	public DipendenteBean(double stipendio, String posizione) {
		super();
		this.stipendio = stipendio;
		this.posizione = posizione;
	}


	public double getStipendio() {
		return stipendio;
	}


	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}


	public String getPosizione() {
		return posizione;
	}


	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}


	@Override
	public boolean isValid() {
boolean res=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				ruolo=='d' &&
				!posizione.isEmpty() && posizione!=null &&
				stipendio!=0 ){
			res=true;
		}
		
		return res;
}
}
	
	


