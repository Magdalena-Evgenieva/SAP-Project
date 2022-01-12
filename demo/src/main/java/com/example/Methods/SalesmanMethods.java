package com.example.Methods;

import com.example.controllers.SalesmanController;
import com.example.controllers.ClientController;
import com.example.controllers.TypeBrandController;
import com.example.controllers.TypeGenderController;
import com.example.controllers.TypeSenseContoller;
import com.example.models.Salesman;

import com.example.models.Client;
import com.example.models.TypeBrand;
import com.example.models.TypeGender;
import com.example.models.TypeSens;

import utils.exceptions.EntityDoesNotExistException;

public class SalesmanMethods {
	public static void main(String[] args) {
		Salesman in = createSalesman("Petur Keranov", "peturKra@magiperfumes.com", "12345", "pk47", "Sofia,ul.Hristo Botev");
		//insertSalesman(in);
		//deleteSalesman(in);
		try {
			updateSalesman(in);
		} catch (EntityDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void insertSalesman( Salesman b) {
		SalesmanController a = new SalesmanController();
		a.createEntity(b);
		
	}
	
	public static void updateSalesman( Salesman b) throws EntityDoesNotExistException {
		SalesmanController a = new SalesmanController();
		Salesman c = a.findSalesman(b.getUsername());
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
	
	
	public static void deleteSalesman( String username) {
		SalesmanController a = new SalesmanController();
		Salesman c = a.findSalesman(username);
		try {
			a.deleteEntity(c);
		} catch (EntityDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Salesman createSalesman( String salesmanName, String selesman_email, String selesman_password, String username, String client_address) {
		Salesman b = new Salesman();
		b.setSalesmanName(salesmanName);
		b.setSelesman_email(selesman_email);
		b.setSelesman_password(selesman_password);
		b.setUsername(username);
		//Client
		ClientController clientc = new ClientController();
		Client Client = new Client();
		Client = clientc.findClient(client_address);
		if(Client == null)
		{
		System.out.println("No such client!!");
		}
		else {
		b.setClient(Client);
		}
	
		return b;
		
		
	}

}
