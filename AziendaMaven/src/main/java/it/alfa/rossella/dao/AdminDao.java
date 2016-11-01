package it.alfa.rossella.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import it.alfa.rossella.AdminBean;


public class AdminDao {
	
	public boolean createAdmin(AdminBean a)
	{
		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(a);
		
		 result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;	
	}

	
		
	//read admin con username,restituisce admin
			public AdminBean trovaAdminConUsername(String username) {
				
				AdminBean abean=null;
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
				tx=session.getTransaction();
				tx.begin();
				Query query=session.createQuery("from AdminBean where username=:x1");
				query.setString("x1", username);
				abean=(AdminBean) query.uniqueResult();
				 tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				return abean;
				
		}

}