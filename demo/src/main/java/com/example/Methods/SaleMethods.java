package com.example.Methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.controllers.ClientController;
import com.example.controllers.SaleController;
import com.example.controllers.SalesmanController;
import com.example.controllers.SizeController;
import com.example.controllers.TypeBrandController;
import com.example.controllers.TypeGenderController;
import com.example.controllers.TypeSenseContoller;
import com.example.controllers.PerfumeController;
import com.example.models.Client;
import com.example.models.Perfume;
import com.example.models.Sale;
import com.example.models.Salesman;
import com.example.models.Size;
import com.example.models.TypeBrand;
import com.example.models.TypeGender;
import com.example.models.TypeSens;

import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;

public class SaleMethods {
	
	public static void main(String[] args) {
		
			}
	
private static Date parseDate(String date) {
	try {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    } catch (ParseException e) {
        return null;
    }
	}

//	# id	Selesman_id	  Client_id	 Item_id	quantity	New_price	Date_
//	1	           1	       8	   1	  20	         150	2020-08-25 12:20:45
// String date, String salesmanUsername,String clientAddres, String perfumeName,   String perfumeGender, String perfumeSize

	public static void updateSale( Sale b) throws EntityDoesNotExistException {
		SaleController a = new SaleController();
		Sale c = a.findSale(b.getDate_(),b.getSalesman(),b.getClient(),b.getPerfume() );
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
	
	public static void insertSale( Sale b) throws EntityAlreadyExistsException  {
		SaleController a = new SaleController();
		a.createEntity(b);
		
	}
	public static void deleteSale( String date, String salesmanUsername, String clientAddres, String perfumeName,   String perfumeGender, String perfumeSize) throws EntityDoesNotExistException {
		SaleController a = new SaleController();
		
		//salesmanUsername
		SalesmanController salec = new SalesmanController();
		Salesman sale = new Salesman();
		sale = salec.findSalesman(salesmanUsername);//moje i id ili druga promenliva da e vij go
		if(sale == null)
		{
		System.out.println("No such salesman username!!");
		}
		
		//date
		Date myDate = parseDate(date);

		//client
				ClientController clientc = new ClientController();
				Client client = new Client();
				client = clientc.findClient(clientAddres);//moje i id ili druga promenliva da e vij go
				if(client == null)
				{
				System.out.println("No such brand!!");
				}
				
				//perfume
				PerfumeController perfc = new PerfumeController();
				//size-perf
				SizeController sizec = new SizeController();
				Size size = new Size();
				size = sizec.findSize(perfumeSize);
				if(size == null)
				{
				System.out.println("No such size!!");
				}
				
				//typegeder-perf
				TypeGenderController genderc = new TypeGenderController();
				TypeGender gender = new TypeGender();
				gender = genderc.findTypeGender(perfumeGender);
				if(gender == null)
				{
				System.out.println("No such gender!!");
				}
				
				
				Perfume perf = perfc.findPerfume(perfumeName, gender, size);//moje i id ili druga promenliva da e vij go
				if(perf == null)
				{
				System.out.println("No such perf!!");
				}
				
		
		Sale c = a.findSale(myDate, sale, client, perf);
		a.deleteEntity(c);

	}

	public static Sale createSale( String salesmanUsername,String clientAddres, String perfumeName,   String perfumeGender, String perfumeSize, int quantity, String date) throws EntityDoesNotExistException {
		Sale b = new Sale();
		Date myDate = parseDate(date);
		b.setDate_(myDate);
		b.setQuantity(quantity);
		//salesman
		SalesmanController salesmanc = new SalesmanController();
		Salesman sman = new Salesman();
		sman = salesmanc.findSalesman(salesmanUsername);//moje i id ili druga promenliva da e vij go
		if(sman == null)
		{
		System.out.println("No such salesman username!!");
		}
		else {
		b.setSalesman(sman);
		}
		//client
		ClientController clientc = new ClientController();
		Client client = new Client();
		client = clientc.findClient(clientAddres);//moje i id ili druga promenliva da e vij go
		if(client == null)
		{
		System.out.println("No such brand!!");
		}
		else {
		b.setClient(client);
		}
		//perfume
		PerfumeController perfc = new PerfumeController();
		//size-perf
		SizeController sizec = new SizeController();
		Size size = new Size();
		size = sizec.findSize(perfumeSize);
		if(size == null)
		{
		System.out.println("No such size!!");
		}
		
		
		//typegeder-perf
		TypeGenderController genderc = new TypeGenderController();
		TypeGender gender = new TypeGender();
		gender = genderc.findTypeGender(perfumeGender);
		if(gender == null)
		{
		System.out.println("No such gender!!");
		}
		
		
		Perfume perf = perfc.findPerfume(perfumeName, gender, size);//moje i id ili druga promenliva da e vij go
		if(perf == null)
		{
		System.out.println("No such perf!!");
		}
		else {
		perf.setQuantity(perf.getQuantity() - quantity);
		PerfumeMethods.updatePerfume(perf);
		b.setPerfume(perf);
		}
		
		return b;
		
		
	}
}
