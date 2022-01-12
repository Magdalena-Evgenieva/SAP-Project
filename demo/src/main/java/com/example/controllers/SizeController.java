package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.Client;
import com.example.models.Size;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;

public class SizeController implements EntityUtils<Size> {
	
	
	@Override
	public Size findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Size.class, id);
	}
	@Override
	public boolean deleteEntity(Size t) throws EntityDoesNotExistException {
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
	
	public Size createEntity (Size t) {
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
	public boolean updateEntity(Size t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Size old = findSize(t.getSize());
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
		List<Size> sizes = getAllEntities();
		
		for(int i = 0; i < sizes.size(); i++) {
			String size = sizes.get(i).getSize();
			//Date expDate = clients.get(i).getExpirationDate();
			
					
					
					
			
			Object[] rowData = {size};
			table.addRow(rowData);
			
		}
		
	}
  
	public Size findSize(String size) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Size> accs = getAllEntities();
		for(Size acc : accs) {
			if(acc.getSize().equals(size)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<Size> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Size> accs = em.createNamedQuery("Size.findAll", Size.class).getResultList();
		return accs;
	}

}
