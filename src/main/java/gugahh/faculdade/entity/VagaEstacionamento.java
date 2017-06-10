package gugahh.faculdade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VAGA_ESTACIONAMENTO")
public class VagaEstacionamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VAGA_ESTAC_ID", nullable=false)
	long id;

	String codVaga;
	
	public long getId() {
		return id;
	}

	public String getCodVaga() {
		return codVaga;
	}

	public void setCodVaga(String codVaga) {
		this.codVaga = codVaga;
	}

}
