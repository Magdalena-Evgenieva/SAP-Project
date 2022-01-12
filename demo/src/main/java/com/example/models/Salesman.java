package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salesman database table.
 * 
 */
@Entity
@NamedQuery(name="Salesman.findAll", query="SELECT s FROM Salesman s")
public class Salesman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="salesman_name")
	private String salesmanName;

	private String selesman_email;

	private String selesman_password;

	private String username;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="salesman")
	private List<Sale> sales;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	public Salesman() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSalesmanName() {
		return this.salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public String getSelesman_email() {
		return this.selesman_email;
	}

	public void setSelesman_email(String selesman_email) {
		this.selesman_email = selesman_email;
	}

	public String getSelesman_password() {
		return this.selesman_password;
	}

	public void setSelesman_password(String selesman_password) {
		this.selesman_password = selesman_password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setSalesman(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setSalesman(null);

		return sale;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	@Override
	public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Salesman other = (Salesman)obj;
	        if (salesmanName == null) {
	            if (other.salesmanName != null)
	                return false;
	        } else if (!salesmanName.equals(other.salesmanName))
	        	 return false;
	    //gender
	    if (selesman_email == null) {
	            if (other.selesman_email != null)
	                return false;
	        } else if (!selesman_email.equals(other.selesman_email))
	        	 return false;
	    //brand
	    if (selesman_password == null) {
	            if (other.selesman_password != null)
	                return false;
	        } else if (!selesman_password.equals(other.selesman_password))
	        	 return false;
	    //sens
	    if (username == null) {
	            if (other.username != null)
	                return false;
	        } else if (!username.equals(other.username))
	            return false;
	        return true;
	    }

}