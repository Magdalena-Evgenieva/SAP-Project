package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_gender database table.
 * 
 */
@Entity
@Table(name="type_gender")
@NamedQuery(name="TypeGender.findAll", query="SELECT t FROM TypeGender t")
public class TypeGender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//private String gender;

	private String gender;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="typeGender")
	private List<Perfume> perfumes;

	public TypeGender() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Perfume> getPerfumes() {
		return this.perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setTypeGender(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setTypeGender(null);

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
        TypeGender other = (TypeGender)obj;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        
        return true;
    }


}