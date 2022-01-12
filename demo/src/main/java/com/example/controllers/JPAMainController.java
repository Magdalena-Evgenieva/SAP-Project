package com.example.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAMainController {
	private static EntityManagerFactory emf;
	public static EntityManager getEntityManager() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("project");
        }
        return emf.createEntityManager();
    }
	
	
	private static CompanyControllers companyController= new CompanyControllers();
	private static PerfumeController perfumeController = new PerfumeController();
	private static ClientController clientController = new ClientController();
	private static SaleController saleController= new SaleController();
	private static SalesmanController salesmanController = new SalesmanController();
	private static SizeController sizeController = new SizeController();
	private static TypeBrandController typeBrandController= new TypeBrandController();
	private static TypeGenderController typeGenderController = new TypeGenderController();
	private static TypeSenseContoller typeSenseController = new TypeSenseContoller();

	public  CompanyControllers getCompanyControllers() {
		return companyController;
	}
	public static PerfumeController getPerfumeController() {
		return perfumeController;
	} 
	public ClientController getClientController() {
		return clientController;
	}
	public  SaleController getSaleController() {
		return saleController;
	}
	public static SalesmanController getSalesmanController() {
		return salesmanController;
	} 
	public SizeController getSizeController() {
		return sizeController;
	}
	public  TypeBrandController getTypeBrandController() {
		return typeBrandController;
	}
	public static TypeGenderController getTypeGenderController() {
		return typeGenderController;
	} 
	public TypeSenseContoller getTypeSenseContoller() {
		return typeSenseController;
	}
	
}

