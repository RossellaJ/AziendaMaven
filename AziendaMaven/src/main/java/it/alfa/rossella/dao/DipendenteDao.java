package it.alfa.rossella.dao;

import hibernateUtil.HibernateUtil;
import it.alfa.rossella.bean.DipendenteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDao {
	 // 1 create
	
		public boolean inserisciDipendente(DipendenteBean u){
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
		//2a read uno
		public boolean readDipendenteNomeCognome(String nome, String cognome) {
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			DipendenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from DipendenteBean where nome=:nomeInserito and cognome=:cognomeInserito ");
				query.setString("nomeInserito", nome);
				query.setString("cognomeInserito", cognome);
				u = (DipendenteBean) query.uniqueResult();
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
		
		public boolean readDipendenteUsername(String username) {
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			DipendenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from DipendenteBean where username=:usernameInserito ");
				query.setString("usernameInserito", username);
				u = (DipendenteBean) query.uniqueResult();
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
		
		public boolean readDipendenteUsernamePassword (String username,String password){
			boolean res=false;
			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			DipendenteBean u = null;
			try {	
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from DipendenteBean where username=:usernameInserito and password=:passwordInserito");
				query.setString("usernameInserito", username);
				query.setString("passwordInserito", password);
				u = (DipendenteBean) query.uniqueResult();
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
		public List<DipendenteBean> readTuttiDipendente(){
		
		List<DipendenteBean> lista = new ArrayList<DipendenteBean>();

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		DipendenteBean u = null;
		try {	
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createQuery("From DipendenteBean");
			
			lista= query.list();
				
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();			
		}
		
		return lista;
		}
		//3 update
		
		public boolean aggiornaDipendente(DipendenteBean u) {
			
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
		
			public boolean eliminaDipendente(DipendenteBean u) {

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
			//read DipendenteBean con username,restituisce DipendenteBean
			public DipendenteBean trovaDipendenteConUsername(String username) {
				DipendenteBean dbean=null;
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
				tx=session.getTransaction();
				tx.begin();
				Query query=session.createQuery("from DipendenteBean where username=:x1");
				query.setString("x1", username);
				dbean=(DipendenteBean) query.uniqueResult();
				 tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				return dbean;
				
		}
			
				
				
}
