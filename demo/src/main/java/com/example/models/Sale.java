package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the sales database table.
 * 
 */
@Entity
@Table(name="sales")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
@NamedQuery(
	    name="Sale.findAllSalesWithinDates",
	    query="SELECT s FROM Sale s WHERE FUNC('date',s.date_) >= :date1 AND FUNC('date',s.date_) <= :date2 "
	)
@NamedQuery(
	    name="Sale.findAllSalesFromId",
	    query="SELECT s FROM Sale s WHERE s.salesman = :sman "
	)
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_;
	
	private int new_price;

	private int quantity;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	@JoinColumn(name="Item_id")
	private Perfume perfume;

	//bi-directional many-to-one association to Salesman
	@ManyToOne
	@JoinColumn(name="Selesman_id")
	private Salesman salesman;

	public Sale() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_() {
		return this.date_;
	}

	public void setDate_(Date date_) {
		this.date_ = date_;
	}


	public int getNew_price() {
		return this.new_price;
	}

	public void setNew_price(int new_price) {
		this.new_price = new_price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	public Salesman getSalesman() {
		return this.salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}
	public void print() {
		System.out.println(id);
		System.out.println(perfume.getPerfume_name());
		System.out.println(client.getNameClient());
		System.out.println(salesman.getSalesmanName());
		System.out.println(new_price);
		System.out.println(quantity);

	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sale other = (Sale)obj;
        if (date_ == null) {
            if (other.date_ != null)
                return false;
        } else if (!date_.equals(other.date_))
        	 return false;
    //gender
    if (new_price == 0) {
            if (other.new_price != 0)
                return false;
        } else if (!(new_price == other.new_price))
        	 return false;
    //brand
    if (quantity == 0) {
            if (other.quantity != 0)
                return false;
        } else if (!(quantity == other.quantity))
        	 return false;
    //sens
    if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
    
    if (perfume == null) {
        if (other.perfume != null)
            return false;
    } else if (!perfume.equals(other.perfume))
        return false;
    
    if (salesman == null) {
        if (other.salesman != null)
            return false;
    } else if (!salesman.equals(other.salesman))
        return false;
    return true;
    
   	}
	



}