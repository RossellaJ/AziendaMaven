package it.alfa.rossella.dao;

import hibernateUtil.HibernateUtil;
import it.alfa.rossella.bean.ClienteBean;
import it.alfa.rossella.bean.UtenteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
	
	 // 1 create
	
	public boolean inserisciCliente(ClienteBean u){
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
	public boolean readClienteNomeCognome(String nome, String cognome) {
		boolean res=false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ClienteBean u = null;
		try {	
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ClienteBean where nome=:nomeInserito and cognome=:cognomeInserito ");
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			u = (ClienteBean) query.uniqueResult();
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
	
	public boolean readClienteUsername(String username) {
		boolean res=false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		ClienteBean u = null;
		try {	
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ClienteBean where username=:usernameInserito ");
			query.setString("usernameInserito", username);
			u = (ClienteBean) query.uniqueResult();
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
	
	public boolean readClienteUsernamePassword (String username,String password){
		boolean res=false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		UtenteBean u = null;
		try {	
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from ClienteBean where username=:usernameInserito and password=:passwordInserito");
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
	public List<ClienteBean> readTuttiClienti(){
	
	List<ClienteBean> lista = new ArrayList<ClienteBean>();

	Session session = HibernateUtil.openSession();
	Transaction tx = null;
	ClienteBean u = null;
	try {	
		tx = session.getTransaction();
		tx.begin();
		
		Query query = session.createQuery("From ClienteBean");
		
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
	
	public boolean aggiornaCliente(ClienteBean u) {
		
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
	
		public boolean eliminaCliente(ClienteBean u) {

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
				//read cliente con username,restituisce cliente
		public ClienteBean trovaClienteConUsername(String username) {
			
			ClienteBean cbean=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from ClienteBean where username=:x1");
			query.setString("x1", username);
			cbean=(ClienteBean) query.uniqueResult();
			 tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return cbean;
			
	}



}

