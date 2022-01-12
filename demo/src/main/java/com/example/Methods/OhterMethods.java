package com.example.Methods;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.controllers.JPAMainController;
import com.example.controllers.SalesmanController;
import com.example.models.Sale;
import com.example.models.Salesman;

public class OhterMethods {
	public static void main(String[] args) {
//		getSalesFromMail("KarinaP");
//		System.out.println("--------------------------------");
//		getSalesFromTo(2020, 8, 2, 2020, 9, 30);
//	
	}
public static List<Sale> getSalesFromMail(String username) {
	SalesmanController smanc = new SalesmanController();
	Salesman sman = new Salesman();
	sman = smanc.findSalesman(username);
	if(sman == null)
	{
	System.out.println("No salesman whith this email!!");
	return null;
	}
	
	EntityManager em = JPAMainController.getEntityManager();
	List<Sale> sls = em.createNamedQuery("Sale.findAllSalesFromId", Sale.class).setParameter("sman", sman).getResultList();
	for(Sale sl:sls)
	{
		sl.print();
		System.out.println("-----------");
	}
	return sls;
}
public static List<Sale> getSalesFromTo(int fyear, int fmounth, int fday,int tyear,int tmounth,int tday) {
	String date1 = String.valueOf(fyear) + "-" + String.valueOf(fmounth) + "-" + String.valueOf(fday);
	String date2 = String.valueOf(tyear) + "-" + String.valueOf(tmounth) + "-" + String.valueOf(tday);
	EntityManager em = JPAMainController.getEntityManager();
	List<Sale> sls = em.createNamedQuery("Sale.findAllSalesWithinDates", Sale.class).setParameter("date1", date1).setParameter("date2", date2).getResultList();
	for(Sale sl:sls)
	{
		sl.print();
		System.out.println("-----------");
	}
	return sls;
}
}
