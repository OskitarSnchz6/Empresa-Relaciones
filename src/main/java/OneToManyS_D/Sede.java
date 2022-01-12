package OneToManyS_D;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Sede")
public class Sede {
	private long id_sede;
    private String nom_sede;
    
    private Set<Departamento> departamentos;
    
    public Sede() {
    }
             
    public Sede(String nom_sede) {
        this.nom_sede = nom_sede;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    public long getId_sede() {
        return id_sede;
    }
 
    public void setId_sede(long id_sede) {
        this.id_sede = id_sede;
    }
 
     @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
     public Set<Departamento> getDepartamentos()	{
    	 return departamentos;
     }
     
	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public String getNom_sede()	{
		return nom_sede;
	}
  
     public void setNom_sede(String nom_sede) {
         this.nom_sede = nom_sede;
     }
}