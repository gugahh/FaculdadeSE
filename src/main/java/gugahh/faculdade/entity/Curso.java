package gugahh.faculdade.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CURSO")
public class Curso {
	
	public Curso() {
		super();
	}
	
	public Curso(String nomeCurso) {
		this();
		this.nomeCurso = nomeCurso;
		this.dataCriacao = new Date();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CURSO_ID", nullable=false)
	long id;
	
	@Column(name="NOME_CURSO", nullable=false)
	String nomeCurso;
	
	@Column(name="DATA_CRIACAO", nullable=false)
	Date dataCriacao;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	List<Professor> professores; //(targetEntity=entity.Professor.class, mappedBy="curso")

	public long getId() {
		return id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeCurso=" + nomeCurso + ", dataCriacao=" + dataCriacao + "]";
	}
	
}
