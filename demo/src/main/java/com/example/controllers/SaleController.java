package com.example.controllers;

import java.util.List;
import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.Client;
import com.example.models.Perfume;
import com.example.models.Sale;
import com.example.models.Salesman;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;


public class SaleController implements EntityUtils<Sale> {

	@Override
	public Sale findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Sale.class, id);
	}
	@Override
	public boolean deleteEntity(Sale t) throws EntityDoesNotExistException {
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
	
	public Sale createEntity (Sale t) {
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
	public boolean updateEntity(Sale t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Sale old = findSale(t.getDate_(),t.getSalesman(),t.getClient(),t.getPerfume());
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
		List<Sale> sale = getAllEntities();
		
		for(int i = 0; i < sale.size(); i++) {
			Date date = sale.get(i).getDate_();
			int price = sale.get(i).getNew_price();
			int quantity = sale.get(i).getQuantity();
			
			//Date expDate = clients.get(i).getExpirationDate();
			
					
			Object[] rowData = {date, price, quantity};
			table.addRow(rowData);
			
		}
		
	}
   
	public Sale findSale(Date date,Salesman salesman,Client client,Perfume perfume ) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Sale> accs = getAllEntities();
		for(Sale acc : accs) {
			if(acc.getDate_() == date && acc.getClient().equals(client) && acc.getSalesman().equals(salesman) && acc.getPerfume().equals(perfume)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	@Override
	public List<Sale> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Sale> accs = em.createNamedQuery("Sale.findAll", Sale.class).getResultList();
		return accs;
	}

}
