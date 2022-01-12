package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.Client;
import com.example.models.Sale;
import com.example.models.Salesman;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;
import utils.exceptions.UnsuccessfulLoginException;


public class SalesmanController implements EntityUtils<Salesman> {
	
	@Override
	public Salesman findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Salesman.class, id);
	}
	@Override
	public boolean deleteEntity(Salesman t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		if(findEntity(t.getId()) == null) {
			throw new EntityDoesNotExistException();
		}
		else {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				if(!em.contains(t))
					t = em.merge(t);
				em.remove(t);
				transaction.commit();
				return true;
			}catch (PersistenceException e) {
				transaction.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			}
			return false;
		}
	public Salesman createEntity (Salesman t) {
		 EntityManager em = JPAMainController.getEntityManager();
		 //TODO proverka dali ima
		 EntityTransaction transaction = em.getTransaction();
	     transaction.begin();
	     try {
	         em.persist(t);
	         transaction.commit();
	     }catch (PersistenceException e) {
	         transaction.rollback();
	         e.printStackTrace();
	     }finally {
	         em.close();
	     }
	     return t;
	 }
	@Override
	public boolean updateEntity(Salesman t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Salesman old = findSalesman(t.getUsername());
		if(old == null)
			throw new EntityDoesNotExistException();
		else {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				t = em.merge(t);
				transaction.commit();
			}catch(PersistenceException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			em.close();
		}
	
			
		return false;
	}

	@Override
	public void initializeTable(DefaultTableModel table) {
		List<Salesman> salesman = getAllEntities();
		
		for(int i = 0; i < salesman.size(); i++) {
			String salesman_name = salesman.get(i).getSalesmanName();
			String salesman_email = salesman.get(i).getSelesman_email();
			String salesman_password = salesman.get(i).getSelesman_password();
			String username = salesman.get(i).getUsername();
			
			//Date expDate = clients.get(i).getExpirationDate();
			
					
			Object[] rowData = {salesman_name, salesman_email, salesman_password,username};
			table.addRow(rowData);
			
		}
		
	}
   
	public Salesman findSalesman(String username) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Salesman> accs = getAllEntities();
		for(Salesman acc : accs) {
			if(acc.getUsername().equals(username)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	@Override
	public List<Salesman> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Salesman> accs = em.createNamedQuery("Salesman.findAll", Salesman.class).getResultList();
		return accs;
	}
	
	public boolean logIn(String username, String password) throws UnsuccessfulLoginException{
		EntityManager em = JPAMainController.getEntityManager();
		Salesman account = findSalesman(username);
			if(account != null)
				if(account.getSelesman_password().equals(password))
					return true;
		return false;
	}

}
