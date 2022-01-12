package com.example.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

import com.example.models.Company;
import com.example.models.Salesman;

import utils.EntityUtils;
import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;
import utils.exceptions.UnsuccessfulLoginException;

public class CompanyControllers implements EntityUtils<Company> {
	

	public Company findEntity(long id) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		return em.find(Company.class, id);
	}

	public boolean deleteEntity(Company t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		if (findEntity(t.getId()) == null) {
			throw new EntityDoesNotExistException();
		} else {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				if (!em.contains(t))
					t = em.merge(t);
				em.remove(t);
				transaction.commit();
				return true;
			} catch (PersistenceException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				em.close();
			}
		}
		return false;
	}

	public Company createEntity(Company t) throws EntityAlreadyExistsException {
		EntityManager em = JPAMainController.getEntityManager();
		if(findCompany(t.getUsername()) != null) {
			throw new EntityAlreadyExistsException("The account: " + t.getUsername() + " already exists");
				//exception message
	 }else {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(t);
			transaction.commit();
		} catch (PersistenceException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	 }
		return t;
	}

	public boolean updateEntity(Company t) throws EntityDoesNotExistException {
		EntityManager em = JPAMainController.getEntityManager();
		Company old = findCompany(t.getUsername());
		if (old == null)
			throw new EntityDoesNotExistException();
		else {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				t = em.merge(t);
				transaction.commit();
			} catch (PersistenceException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			em.close();
		}

		return false;
	}

	public void initializeTable(DefaultTableModel table) {
		List<Company> company = getAllEntities();

		for (int i = 0; i < company.size(); i++) {
			String companyName = company.get(i).getCompany_name();
			String fb = company.get(i).getFb();
			String instagram = company.get(i).getInstagram();
			String password = company.get(i).getPasswordTo();
			String username = company.get(i).getUsername();
			String twitter = company.get(i).getTwitter();
			// Date expDate = clients.get(i).getExpirationDate();

			Object[] rowData = { companyName, fb, instagram, password, username, twitter };
			table.addRow(rowData);

		}

	}

	public Company findCompany(String username) {
		EntityManager em = JPAMainController.getEntityManager();
		List<Company> accs = getAllEntities();
		for (Company acc : accs) {
			if (acc.getUsername().equals(username)) {
				System.out.println(acc.getId());
				return acc;
			}
		}
		return null;
	}

	public List<Company> getAllEntities() {
		EntityManager em = JPAMainController.getEntityManager();
		List<Company> accs = em.createNamedQuery("Company.findAll", Company.class).getResultList();
		return accs;
	}
	public boolean logIn(String username, String password) throws UnsuccessfulLoginException{
		EntityManager em = JPAMainController.getEntityManager();
		Company account = findCompany(username);
			if(account != null)
				if(account.getPasswordTo().equals(password)) {
					System.out.println("admin loged");
					return true;
				}
		return false;
	}

}
