package gugahh.faculdade.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Cacheable
@Entity
public class UF {
	
	@Id
	private String sigla;
	
	@Column(nullable=false)
	private String nome;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private Pais pais;
	
	public UF() {
		super();
	}
	
	public UF(String sigla, String nome, Pais pais) {
		this();
		this.sigla = sigla;
		this.nome = nome;
		this.pais = pais;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

}
