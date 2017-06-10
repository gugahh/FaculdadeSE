package gugahh.faculdade.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Cacheable
@Table(name="PAIS")
public class Pais {
	
	public Pais() {
		super();
	}
	
	public Pais (String nome) {
		this();
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAIS_ID", nullable=false)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
}
