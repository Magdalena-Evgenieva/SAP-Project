package com.example.Methods;

import com.example.controllers.PerfumeController;
import com.example.controllers.SalesmanController;
import com.example.controllers.SizeController;
import com.example.controllers.TypeBrandController;
import com.example.controllers.TypeGenderController;
import com.example.controllers.TypeSenseContoller;
import com.example.models.Perfume;
import com.example.models.Salesman;
import com.example.models.Size;
import com.example.models.TypeBrand;
import com.example.models.TypeGender;
import com.example.models.TypeSens;

import utils.exceptions.EntityAlreadyExistsException;
import utils.exceptions.EntityDoesNotExistException;

public class PerfumeMethods {
	
	public static void main(String[] args) {
		//Perfume perf = createPerfume("Maxima", "male", "DIOR", "50mL", "Fresh", "For your better half", 150, 50);
		//insertPerfume(perf);
//		try {
//			updatePerfume(perf);
//		} catch (EntityDoesNotExistException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//deletePerfume(perf);
	//	printSalesFromTo(2020,8,2,2020,9,2);
	//printSalesFromMail("martinT@magiperfumes.com");
	
	}
	
	public static void updatePerfume( Perfume b) throws EntityDoesNotExistException {
		PerfumeController a = new PerfumeController();
		Perfume c = a.findPerfume(b.getPerfume_name(), b.getTypeGender(), b.getSize());
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
	
	public static void insertPerfume( Perfume b) throws EntityAlreadyExistsException  {
		PerfumeController a = new PerfumeController();
		a.createEntity(b);
		
	}
	public static void deletePerfume( String name,   String genderName, String sizeName) throws EntityDoesNotExistException {
		PerfumeController a = new PerfumeController();
		Perfume b = new Perfume();
		b.setPerfume_name(name);
		//size
		SizeController sizec = new SizeController();
		Size size = new Size();
		size = sizec.findSize(sizeName);
		if(size == null)
		{
		System.out.println("No such size!!");
		}
		else {
		b.setSize(size);
		}
		

		TypeGenderController genderc = new TypeGenderController();
		TypeGender gender = new TypeGender();
		gender = genderc.findTypeGender(genderName);
		if(gender == null)
		{
		System.out.println("No such gender!!");
		}
		else {
		b.setTypeGender(gender);
		}
		
		Perfume c = a.findPerfume(b.getPerfume_name(), b.getTypeGender(), b.getSize());
		a.deleteEntity(c);

	}

	public static Perfume createPerfume( String name,   String genderName,String brandName, String sizeName, String senseName ,String description , int price, int quantity) throws EntityDoesNotExistException {
		Perfume b = new Perfume();
		b.setDescriptions(description);
		b.setPerfume_name(name);
		b.setPrice(price);
		b.setQuantity(quantity);
		//size
		SizeController sizec = new SizeController();
		Size size = new Size();
		size = sizec.findSize(sizeName);
		if(size == null)
		{
		System.out.println("No such size!!");
		}
		else {
		b.setSize(size);
		}
		//typebrand
		TypeBrandController brandc = new TypeBrandController();
		TypeBrand brand = new TypeBrand();
		brand = brandc.findTypeBrand(brandName);
		if(brand == null)
		{
		System.out.println("No such brand!!");
		}
		else {
		b.setTypeBrand(brand);
		}
		//typesensec
		TypeSenseContoller sensec = new TypeSenseContoller();
		TypeSens sense = new TypeSens();
		sense = sensec.findTypeSens(senseName);
		if(sense == null)
		{
		System.out.println("No such sense!!");
		}
		else {
		b.setTypeSens(sense);
		}
		
		//typegeder
		TypeGenderController genderc = new TypeGenderController();
		TypeGender gender = new TypeGender();
		gender = genderc.findTypeGender(genderName);
		if(gender == null)
		{
		System.out.println("No such gender!!");
		}
		else {
		b.setTypeGender(gender);
		}
		return b;
		
		
	}


}
