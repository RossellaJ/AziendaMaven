package it.alfa.rossella.dao;

import hibernateUtil.HibernateUtil;
import it.alfa.rossella.model.Voce;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {
	// 1- Create

		public boolean creaVoce(Voce v) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.persist(v);

				tx.commit();

				res = true;

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return res;

		}
		
		//2)Leggi voce
		
		public Voce leggiVoceConId(long v_id) {

			Voce v = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				v = session.get(Voce.class, v_id);

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return v;

		}

		// 2- Read ( con nome )

		public Voce leggiVoceConNome(String nome) {

			Voce v = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Voce where nome=:nomeInserito ");

				query.setString("nomeInserito", nome);

				v = (Voce) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return v;

		}

		// read Tutte le voci
		
		@SuppressWarnings("unchecked")
		public List<Voce> getTutteleVoci(long idRubrica){
			
			List<Voce> lista=null;
			
			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Voce where idRubrica=:idInserito ");

				query.setLong("idInserito", idRubrica);

				lista = (List<Voce>) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}
			
			return lista;
			
			
		}
		
		
		
		
		
		
		// 4- Update

		public boolean aggiornaVoce(Voce v) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.update(v);

				tx.commit();

				res = true;

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return res;

		}
	//Delete
		public boolean eliminaVoce(Voce v) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.delete(v);

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
