package it.alfa.rossella.dao;

import hibernateUtil.HibernateUtil;
import it.alfa.rossella.bean.UtenteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDao {
	
		 // 1 create
		
		public boolean creaUtente(UtenteBean u){
			boolean res=false;
			
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			try{
				tx=session.getTransaction();
				tx.begin();
				session.persist(u);
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();
			}
			return res;

		}
		//2a read utente con nome e cognome
		public boolean readUtenteNomeCognome(String nome, String cognome) {
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			UtenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from UtenteBean where nome=:nomeInserito and cognome=:cognomeInserito ");
				query.setString("nomeInserito", nome);
				query.setString("cognomeInserito", cognome);
				u = (UtenteBean) query.uniqueResult();
				if(u!=null){
					res=true;
				}			
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();			
			}		
			return res;
		}
		
		//read utente con username
		public boolean readUtenteUsername(String username) {
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			UtenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from UtenteBean where username=:usernameInserito ");
				query.setString("usernameInserito", username);
				u = (UtenteBean) query.uniqueResult();
				if(u!=null){
					res=true;
				}			
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();			
			}		
			return res;
		}
			
		//read utente con username,restituisce utente
		public UtenteBean trovaUtenteConUsername(String username) {
			
			UtenteBean ubean=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from UtenteBean where username=:x1");
			query.setString("x1", username);
			ubean=(UtenteBean) query.uniqueResult();
			 tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return ubean;
			
	}
		//read utente con username e password
				public UtenteBean getUtenteUsernamePassword (String username,String password){
					
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
					UtenteBean u = null;
					try {	
						tx = session.getTransaction();
						tx.begin();
						Query query = session.createQuery("from UtenteBean where username=:usernameInserito and password=:passwordInserito");
						query.setString("usernameInserito", username);
						query.setString("passwordInserito", password);
						u = (UtenteBean) query.uniqueResult();
									
						tx.commit();
						
					} catch (Exception ex) {
						tx.rollback();
					} finally {
						session.close();			
					}		
					return u;
					
				}
				
		//read utente con username e password
		public boolean readUtenteUsernamePassword (String username,String password){
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			UtenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from UtenteBean where username=:usernameInserito and password=:passwordInserito");
				query.setString("usernameInserito", username);
				query.setString("passwordInserito", password);
				u = (UtenteBean) query.uniqueResult();
				if(u!=null){
					res=true;
				}			
				tx.commit();
				res = true;
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();			
			}		
			return res;
			
		}
		
		//2b read tutti
		public List<UtenteBean> readTuttiUtenti(){
		
		List<UtenteBean> listaUtenti = new ArrayList<UtenteBean>();

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		UtenteBean u = null;
		try {	
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createQuery("From UtenteBean");
			
			listaUtenti= query.list();
				
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();			
		}
		
		return listaUtenti;
		}
		//3 update
		
		public boolean aggiornaUtente(UtenteBean u) {
			
			boolean res = false;
			
			Session session = HibernateUtil.openSession();
			
			Transaction tx = null;
			
			try {
				
				tx = session.getTransaction();
				
				tx.begin();
				
				session.update(u);
				
				tx.commit();
				
				res = true;
				
			} catch (Exception ex) {
				
				tx.rollback();
				
			} finally {
				
				session.close();
				
			}
			
			return res;
			
		}
		//4 delete
		
			public boolean eliminaUtente(UtenteBean u) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.delete(u);

					tx.commit();

					res = true;

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return res;

			}



}
