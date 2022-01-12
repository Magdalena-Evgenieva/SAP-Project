package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_brands database table.
 * 
 */
@Entity
@Table(name="type_brands")
@NamedQuery(name="TypeBrand.findAll", query="SELECT t FROM TypeBrand t")
public class TypeBrand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String brand;

	//private String brand;

	private String descriptions;

	//private String descriptions;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="typeBrand")
	private List<Perfume> perfumes;

	public TypeBrand() {
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getDescriptions() {
		return descriptions;
	}



	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}



	public List<Perfume> getPerfumes() {
		return perfumes;
	}



	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}



	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setTypeBrand(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setTypeBrand(null);

		return perfume;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeBrand other = (TypeBrand)obj;
        if ( brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        
        if ( descriptions == null) {
            if (other.descriptions != null)
                return false;
        } else if (!descriptions.equals(other.descriptions))
            return false;
        
        return true;
    }

}