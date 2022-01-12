package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String size;

	//private String size;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="size")
	private List<Perfume> perfumes;

	public Size() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Perfume> getPerfumes() {
		return this.perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setSize(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setSize(null);

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
        Size other = (Size)obj;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        
        return true;
    }

}