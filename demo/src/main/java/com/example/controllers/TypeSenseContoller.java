package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;


import com.example.models.TypeSens;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;

public class TypeSenseContoller implements EntityUtils<TypeSens>  {
	
	@Override
	public TypeSens findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(TypeSens.class, id);
	}
	@Override
	public boolean deleteEntity(TypeSens t) throws EntityDoesNotExistException {
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
	public TypeSens createEntity (TypeSens t) {
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
	public boolean updateEntity(TypeSens t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		TypeSens old = findTypeSens(t.getSenses());
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
		List<TypeSens> typeSens = getAllEntities();
		
		for(int i = 0; i < typeSens.size(); i++) {
			String sense = typeSens.get(i).getSenses();
		
			//Date expDate = clients.get(i).getExpirationDate();
			
					
			Object[] rowData = {sense};
			table.addRow(rowData);
			
		}
		
	}
  
	public TypeSens findTypeSens(String typeSens) {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeSens> accs = getAllEntities();
		for(TypeSens acc : accs) {
			if(acc.getSenses().equals(typeSens)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<TypeSens> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeSens> accs = em.createNamedQuery("TypeSens.findAll", TypeSens.class).getResultList();
		return accs;
	}

}
