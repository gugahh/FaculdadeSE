package gugahh.faculdade.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	public Endereco() {
		super();
	}
	
	private String pais;
	private String municipio;
	private String logradouro;
	private String numeroApto;
	private String complemento;
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroApto() {
		return numeroApto;
	}
	public void setNumeroApto(String numeroApto) {
		this.numeroApto = numeroApto;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
