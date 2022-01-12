package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfumes database table.
 * 
 */
@Entity
@Table(name="perfumes")
@NamedQuery(name="Perfume.findAll", query="SELECT p FROM Perfume p")
public class Perfume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String descriptions;

	private String perfume_name;

	private int price;

	private int quantity;

	//bi-directional many-to-one association to Size
	@ManyToOne
	private Size size;

	//bi-directional many-to-one association to TypeBrand
	@ManyToOne
	@JoinColumn(name="Type_brands_id")
	private TypeBrand typeBrand;

	//bi-directional many-to-one association to TypeGender
	@ManyToOne
	@JoinColumn(name="Type_gender_id")
	private TypeGender typeGender;

	//bi-directional many-to-one association to TypeSens
	@ManyToOne
	@JoinColumn(name="Type_senses_id")
	private TypeSens typeSens;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="perfume")
	private List<Sale> sales;

	public Perfume() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getPerfume_name() {
		return this.perfume_name;
	}

	public void setPerfume_name(String perfume_name) {
		this.perfume_name = perfume_name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public TypeBrand getTypeBrand() {
		return this.typeBrand;
	}

	public void setTypeBrand(TypeBrand typeBrand) {
		this.typeBrand = typeBrand;
	}

	public TypeGender getTypeGender() {
		return this.typeGender;
	}

	public void setTypeGender(TypeGender typeGender) {
		this.typeGender = typeGender;
	}

	public TypeSens getTypeSens() {
		return this.typeSens;
	}

	public void setTypeSens(TypeSens typeSens) {
		this.typeSens = typeSens;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setPerfume(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setPerfume(null);

		return sale;
	}
	@Override
	public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Perfume other = (Perfume)obj;
	        if (perfume_name == null) {
	            if (other.perfume_name != null)
	                return false;
	        } else if (!perfume_name.equals(other.perfume_name))
	        	 return false;
	    //gender
	    if (typeGender == null) {
	            if (other.typeGender != null)
	                return false;
	        } else if (!typeGender.equals(other.typeGender))
	        	 return false;
	    //brand
	    if (typeBrand == null) {
	            if (other.typeBrand != null)
	                return false;
	        } else if (!typeBrand.equals(other.typeBrand))
	        	 return false;
	    //sens
	    if (typeSens == null) {
	            if (other.typeSens != null)
	                return false;
	        } else if (!typeSens.equals(other.typeSens))
	            return false;
	        return true;
	    }

}