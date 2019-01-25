package br.com.iftm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.iftm.entity.enums.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADOR_SERVICO", schema = "AGENDADIGITAL")
@SequenceGenerator(name = "SQ_PRESTADOR_SERVICO", sequenceName = "SQ_PRESTADOR_SERVICO", initialValue = 1, allocationSize = 1, schema = "AGENDADIGITAL")
public class PrestadorServico {

	@Id
	@Column(name = "COD_PRESTADOR_SERVICO")
	@GeneratedValue(generator = "SQ_PRESTADOR_SERVICO", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "NOME_PRESTADOR_SERVICO", nullable = false, length = 100)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "COD_CIDADE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_PRESTADOR_SERV_TB_CIDADE"))
	private Cidade cidade;

	@Column(name = "BAIRRO_PRESTADOR_SERVICO", nullable = false, length = 50)
	private String bairro;

	@Column(name = "CEP_PRESTADOR_SERVICO", nullable = true, length = 50)
	private String cep;

	@Column(name = "TIPO_LOG_PRESTADOR_SERVICO", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;

	@Column(name = "LOG_PRESTADOR_SERVICO", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "NUMERO_PRESTADOR_SERVICO", nullable = true, length = 100)
	private Integer numero;

	@Column(name = "COMP_PRESTADOR_SERVICO", nullable = true, length = 200)
	private String complemento;

	@Column(name = "EMAIL_PRESTADOR_SERVICO", nullable = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	@JoinTable(name = "TB_SERVICO_CREDENCIADO", schema = "AGENDADIGITAL", joinColumns = {
			@JoinColumn(name = "COD_PRESTADOR_SERVICO") }, inverseJoinColumns = {
					@JoinColumn(name = "COD_TIPOSERVICO") })

	private Set<TipoServico> tipoServicos;

	public Integer getCodigo() {
		return codigo;
	}

	public Set<TipoServico> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(Set<TipoServico> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<Telefone> getTelefone() {
		return telefones;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefones = telefone;
	}

}
