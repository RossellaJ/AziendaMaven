package it.alfa.rossella.bean;

import javax.persistence.Entity;

@Entity
public class AdminBean extends UtenteBean implements DataBean{
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private String livelloAccesso;
	
	

	public AdminBean() {
		super();
		this.livelloAccesso="";
	}
	
	
	public AdminBean(String nome, String cognome, String username, String password, char ruolo, String livelloAccesso) {
		super(nome,cognome,username,password,ruolo);
		this.livelloAccesso = livelloAccesso;
}
	
	public AdminBean(String livelloAccesso) {
		super();
		this.livelloAccesso = livelloAccesso;
	}

	public String getLivelloAccesso() {
		return livelloAccesso;
	}

	public void setLivelloAccesso(String livelloAccesso) {
		this.livelloAccesso = livelloAccesso;
	}


	@Override
	public boolean isValid() {
boolean res=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				ruolo=='a' &&
				
				!livelloAccesso.isEmpty() && livelloAccesso!=null) {
			res=true;
		}
		
		return res;
}
	
	
	
	
	
	

}
