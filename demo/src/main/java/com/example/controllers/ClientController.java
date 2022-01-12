package com.example.controllers;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import java.util.Date;
import java.util.List;


import javax.swing.table.DefaultTableModel;
import utils.EntityUtils;
import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;

import com.example.models.Client;


public class ClientController implements EntityUtils<Client> {
	
	
	
	public Client findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Client.class, id);
	}
	
	public boolean deleteEntity(Client t) throws EntityDoesNotExistException {
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
	
	
 public Client createEntity (Client t) throws EntityAlreadyExistsException {
	 EntityManager em = JPAMainController.getEntityManager();
	if(findClient(t.getAddress()) != null) {
		throw new EntityAlreadyExistsException("The account: " + t.getNameClient() + "at the addres" + t.getAddress() + " already exists");
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
     }
     return t;
 }
 
 public boolean updateEntity(Client t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Client old = findClient(t.getAddress());
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

	
	public void initializeTable(DefaultTableModel table) {
		List<Client> clients = getAllEntities();
		
		for(int i = 0; i < clients.size(); i++) {
			String Address = clients.get(i).getAddress();
			String name = clients.get(i).getNameClient();
			String Telephone = clients.get(i).getTelephone();
			//Date expDate = clients.get(i).getExpirationDate();
			
					
					
					
			
			Object[] rowData = {Address, name, Telephone};
			table.addRow(rowData);
			
		}
		
	}

	public Client findClient(String address) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Client> accs = getAllEntities();
		for(Client acc : accs) {
			if(acc.getAddress().equals(address)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	
	public List<Client> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Client> accs = em.createNamedQuery("Client.findAll", Client.class).getResultList();
		return accs;
	}

}
