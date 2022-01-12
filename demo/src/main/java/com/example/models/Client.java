package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String address;

	@Column(name="name_client")
	private String nameClient;

	private String telephone;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="client")
	private List<Sale> sales;

	//bi-directional many-to-one association to Salesman
	@OneToMany(mappedBy="client")
	private List<Salesman> salesmans;

	public Client() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNameClient() {
		return this.nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setClient(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setClient(null);

		return sale;
	}

	public List<Salesman> getSalesmans() {
		return this.salesmans;
	}

	public void setSalesmans(List<Salesman> salesmans) {
		this.salesmans = salesmans;
	}

	public Salesman addSalesman(Salesman salesman) {
		getSalesmans().add(salesman);
		salesman.setClient(this);

		return salesman;
	}

	public Salesman removeSalesman(Salesman salesman) {
		getSalesmans().remove(salesman);
		salesman.setClient(null);

		return salesman;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client)obj;
        if ( address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        
        if ( nameClient == null) {
            if (other.nameClient != null)
                return false;
        } else if (!nameClient.equals(other.nameClient))
            return false;
        
        if ( telephone == null) {
            if (other.telephone != null)
                return false;
        } else if (!telephone.equals(other.telephone))
            return false;
        
        return true;
    }
	

}