package com.example.Methods;


import com.example.controllers.ClientController;
import com.example.models.Client;

import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;

public class ClientMethods {
	public static void main(String[] args) {
		Client in = createClient("Avon", "Ul.23","0888675432");
		//insertClient(in);
		//deleteClient(in);
		//updateClient(in);
		
		
	}
	
	public static void insertClient( Client b) {
		ClientController a = new ClientController();
		try {
			a.createEntity(b);
		} catch (EntityAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
	
	public static void updateClient( Client b) throws EntityDoesNotExistException {
		ClientController a = new ClientController();
		Client c = a.findClient(b.getAddress());
		if(c != null) {
			try {
				b.setId(c.getId());
				a.updateEntity(b);
			} catch (EntityDoesNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else { 
			throw new EntityDoesNotExistException();
		}
	}
	
	public static void deleteClient( String addr) {
		ClientController a = new ClientController();
		Client c = a.findClient(addr);
		try {
			a.deleteEntity(c);
		} catch (EntityDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Client createClient( String ClientName, String clientAddress,  String telephone) {
		Client b = new Client();
		b.setNameClient(ClientName);
		b.setAddress(clientAddress);
		b.setTelephone(telephone);
		return b;
		
		
	}

}
