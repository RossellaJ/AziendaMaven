package it.alfa.rossella.bean;

import javax.persistence.Entity;



@Entity
public class ClienteBean extends UtenteBean implements DataBean{
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private String ragioneSociale;
	private String partitaIva;
	
	
	
	public ClienteBean() {
		super();
	}




	public ClienteBean(String nome, String cognome,
			String username, String password, char ruolo,String ragioneSociale, String partitaIva) {
		super(nome,cognome,username,password,ruolo);
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
}




	public ClienteBean(String ragioneSociale, String partitaIva) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
	}



	public String getRagioneSociale() {
		return ragioneSociale;
	}



	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}



	public String getPartitaIva() {
		return partitaIva;
	}



	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}



	@Override
	public boolean isValid() {
		
boolean res=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				ruolo=='c' &&
				
				!ragioneSociale.isEmpty() && ragioneSociale!=null &&
				!partitaIva.isEmpty() && partitaIva!=null) {
			res=true;
		}
		
		return res;
}
	}
	
	
	


