package br.com.iftm.entity;

import br.com.iftm.entity.enums.Estado;

//@Entity
//@Table(name = "TB_CIDADE")
public class Cidade {

	private String nome;
	private Estado estado;
	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
