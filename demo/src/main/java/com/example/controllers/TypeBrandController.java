package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.Client;
import com.example.models.Size;
import com.example.models.TypeBrand;

import utils.EntityUtils;
import utils.exceptions.EntityDoesNotExistException;


public class TypeBrandController implements EntityUtils<TypeBrand> {
	
	@Override
	public TypeBrand findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(TypeBrand.class, id);
	}
	@Override
	public boolean deleteEntity(TypeBrand t) throws EntityDoesNotExistException {
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
	
	public TypeBrand createEntity (TypeBrand t) {
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
	public boolean updateEntity(TypeBrand t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		TypeBrand old = findTypeBrand(t.getBrand());
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
		List<TypeBrand> typeBrand = getAllEntities();
		
		for(int i = 0; i < typeBrand.size(); i++) {
			String brand = typeBrand.get(i).getBrand();
			String description = typeBrand.get(i).getDescriptions();
			//Date expDate = clients.get(i).getExpirationDate();
			
					
			Object[] rowData = {brand,description};
			table.addRow(rowData);
			
		}
		
	}
  
	public TypeBrand findTypeBrand(String typeBrand) {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeBrand> accs = getAllEntities();
		for(TypeBrand acc : accs) {
			if(acc.getBrand().equals(typeBrand)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<TypeBrand> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<TypeBrand> accs = em.createNamedQuery("TypeBrand.findAll", TypeBrand.class).getResultList();
		return accs;
	}

}
