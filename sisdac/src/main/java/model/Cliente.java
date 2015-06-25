package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import enums.TipoPessoa;

@Entity
@Table(name="tbl_cliente")
public class Cliente {
	@Id
	@Column(name="cli_id")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	
	@Column(name="cli_nome", nullable = false)
	private String nome;
	
	@Column(name="cli_documento", nullable = false)
	private String documento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cli_tipo_pessoa", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@Column(name="cli_email", nullable = false)
	private String email;
	
	@OneToMany(mappedBy="cliente", cascade =CascadeType.ALL)
	private List<EnderecoX> enderecos = new ArrayList<>();

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<EnderecoX> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoX> enderecos) {
		this.enderecos = enderecos;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
