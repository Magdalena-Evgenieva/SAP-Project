package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.TypeBrand;
import com.example.models.TypeGender;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;


public class TypeGenderController implements EntityUtils<TypeGender> {
	
	@Override
	public TypeGender findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(TypeGender.class, id);
	}
	@Override
	public boolean deleteEntity(TypeGender t) throws EntityDoesNotExistException {
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
	
	public TypeGender createEntity (TypeGender t) {
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
	public boolean updateEntity(TypeGender t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		TypeGender old = findTypeGender(t.getGender());
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
		List<TypeGender> typeGender = getAllEntities();
		
		for(int i = 0; i < typeGender.size(); i++) {
			String gender = typeGender.get(i).getGender();
		
			//Date expDate = clients.get(i).getExpirationDate();
			
					
			Object[] rowData = {gender};
			table.addRow(rowData);
			
		}
		
	}
  
	public TypeGender findTypeGender(String typeGender) {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeGender> accs = getAllEntities();
		for(TypeGender acc : accs) {
			if(acc.getGender().equals(typeGender)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<TypeGender> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeGender> accs = em.createNamedQuery("TypeGender.findAll", TypeGender.class).getResultList();
		return accs;
	}

}
