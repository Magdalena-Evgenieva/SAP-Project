package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;


import com.example.models.Perfume;
import com.example.models.Size;
import com.example.models.TypeGender;

import utils.EntityUtils;
import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;


public class PerfumeController implements EntityUtils<Perfume> {
	

	@Override
	public Perfume findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Perfume.class, id);
	}
	@Override
	public boolean deleteEntity(Perfume t) throws EntityDoesNotExistException {
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
	
	public Perfume createEntity (Perfume t) throws EntityAlreadyExistsException {
		 EntityManager em = JPAMainController.getEntityManager();
		 if(findPerfume(t.getPerfume_name(),t.getTypeGender(), t.getSize()) != null) {
				throw new EntityAlreadyExistsException("The product: " + t.getPerfume_name()  + " already exists");
					//exception message
		 }else {
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
	 }
	@Override
	public boolean updateEntity(Perfume t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Perfume old = findPerfume(t.getPerfume_name(), t.getTypeGender(), t.getSize());
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
		List<Perfume> perfume = getAllEntities();
		
		for(int i = 0; i < perfume.size(); i++) {
			String descriptions = perfume.get(i).getDescriptions();
			String perfume_name = perfume.get(i).getPerfume_name();
			int price = perfume.get(i).getPrice();
			int quantity = perfume.get(i).getQuantity();
			//Date expDate = clients.get(i).getExpirationDate();
			
					
					
					
			
			Object[] rowData = {descriptions, perfume_name, price,quantity};
			table.addRow(rowData);
			
		}
		
	}

	public Perfume findPerfume(String perfume_name,TypeGender typeGender, Size size) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Perfume> accs = getAllEntities();
		for(Perfume acc : accs) {
			if(acc.getPerfume_name().equals(perfume_name) && acc.getTypeGender().equals(typeGender) && acc.getSize().equals(size)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<Perfume> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Perfume> accs = em.createNamedQuery("Perfume.findAll", Perfume.class).getResultList();
		return accs;
	}

}
