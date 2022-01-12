//package com.example.controllers;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import  com.example.models.*;
//
//import utils.exceptions.EntityDoesNotExistException;
//
//public class Test {
//
//	
//	public static void main(String[] args) {
//			//Perfume perf = createPerfume("Maxima", "male", "DIOR", "50mL", "Fresh", "For your other half", 150, 50);
//			//insertPerfume(perf);
//			//deletePerfume(perf);
//		//	printSalesFromTo(2020,8,2,2020,9,2);
//		printSalesFromMail("martinT@magiperfumes.com");
//		
//		}
//	public static void printSalesFromMail(String email) {
//		SalesmanController smanc = new SalesmanController();
//		Salesman sman = new Salesman();
//		sman = smanc.findSalesman(email);//moje i id ili druga promenliva da e
//		if(sman == null)
//		{
//		System.out.println("No salesman whith this email!!");
//		return;
//		}
//		
//		EntityManager em = JPAMainController.getEntityManager();
//		List<Sale> sls = em.createNamedQuery("Sale.findAllSalesFromId", Sale.class).setParameter("sman", sman).getResultList();
//		for(Sale sl:sls)
//		{
//			sl.print();
//			System.out.println("-----------");
//		}
//	}
//	public static void printSalesFromTo(int fyear, int fmounth, int fday,int tyear,int tmounth,int tday) {
//		String date1 = String.valueOf(fyear) + "-" + String.valueOf(fmounth) + "-" + String.valueOf(fday);
//		String date2 = String.valueOf(tyear) + "-" + String.valueOf(tmounth) + "-" + String.valueOf(tday);
//		EntityManager em = JPAMainController.getEntityManager();
//		List<Sale> sls = em.createNamedQuery("Sale.findAllSalesWithinDates", Sale.class).setParameter("date1", date1).setParameter("date2", date2).getResultList();
//		for(Sale sl:sls)
//		{
//			sl.print();
//			System.out.println("-----------");
//		}
//	}
//	public static void insertPerfume( Perfume b) {
//		PerfumeController a = new PerfumeController();
//		a.createEntity(b);
//		
//	}
//	public static void deletePerfume( Perfume b) {
//		PerfumeController a = new PerfumeController();
//		Perfume c = a.findPerfume(b.getPerfume_name());
//		try {
//			a.deleteEntity(c);
//		} catch (EntityDoesNotExistException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//	public static Perfume createPerfume( String name,   String genderName,String brandName, String sizeName, String senseName ,String description , int price, int quantity) {
//		Perfume b = new Perfume();
//		b.setDescriptions(description);
//		b.setPerfume_name(name);
//		b.setPrice(price);
//		b.setQuantity(quantity);
//		//size
//		SizeController sizec = new SizeController();
//		Size size = new Size();
//		size = sizec.findSize(sizeName);//moje i id ili druga promenliva da e vij go
//		if(size == null)
//		{
//		System.out.println("No such size!!");
//		}
//		else {
//		b.setSize(size);
//		}
//		//typebrand
//		TypeBrandController brandc = new TypeBrandController();
//		TypeBrand brand = new TypeBrand();
//		brand = brandc.findTypeBrand(brandName);//moje i id ili druga promenliva da e vij go
//		if(brand == null)
//		{
//		System.out.println("No such brand!!");
//		}
//		else {
//		b.setTypeBrand(brand);
//		}
//		//typesensec
//		TypeSenseContoller sensec = new TypeSenseContoller();
//		TypeSens sense = new TypeSens();
//		sense = sensec.findTypeSens(senseName);//moje i id ili druga promenliva da e vij go
//		if(sense == null)
//		{
//		System.out.println("No such sense!!");
//		}
//		else {
//		b.setTypeSens(sense);
//		}
//		
//		//typegeder
//		TypeGenderController genderc = new TypeGenderController();
//		TypeGender gender = new TypeGender();
//		gender = genderc.findTypeGender(genderName);//moje i id ili druga promenliva da e vij go
//		if(gender == null)
//		{
//		System.out.println("No such gender!!");
//		}
//		else {
//		b.setTypeGender(gender);
//		}
//		return b;
//		
//		
//	}
//
//
//}
