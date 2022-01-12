package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_senses database table.
 * 
 */
@Entity
@Table(name="type_senses")
@NamedQuery(name="TypeSens.findAll", query="SELECT t FROM TypeSens t")
public class TypeSens implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//private String gender;

	private String senses;

	//private String sesnses;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="typeSens")
	private List<Perfume> perfumes;

	public TypeSens() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getGender() {
//		return this.gender;
//	}

//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	public String getSenses() {
		return this.senses;
	}

	public void setSenses(String senses) {
		this.senses = senses;
	}

//	public String getSesnses() {
//		return this.sesnses;
//	}
//
//	public void setSesnses(String sesnses) {
//		this.sesnses = sesnses;
//	}

	public List<Perfume> getPerfumes() {
		return this.perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setTypeSens(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setTypeSens(null);

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
        TypeSens other = (TypeSens)obj;
        if ( senses == null) {
            if (other.senses != null)
                return false;
        } else if (!senses.equals(other.senses))
            return false;
        
        return true;
    }

}