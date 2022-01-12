package OneToManyS_D;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Departamento")
public class Departamento {
	private long id_depto;
	private String nom_depto;
	
	private Sede sede;
	
	public Departamento()	{
		
	}
	
	public Departamento(String nom_depto) {
		this.nom_depto = nom_depto;
	}	
	
	@Id
	@Column(name = "id_depto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public long getId_depto() {
		return id_depto;
	}

	public void setId_depto(long id_depto) {
		this.id_depto = id_depto;
	}
	
	@ManyToOne
    @JoinColumn(name = "id_sede")
    public Sede getSede()	{
    	return sede;
    }

	public String getNom_depto() {
		return nom_depto;
	}

	public void setNom_depto(String nom_depto) {
		this.nom_depto = nom_depto;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
}