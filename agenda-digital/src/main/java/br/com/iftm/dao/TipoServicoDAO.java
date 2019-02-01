package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoDAO {

	/**
	 * Metodo responsavel por persistir o objeto {@link TipoServico} na base de
	 * dados.
	 * 
	 * @param tipoServico objeto a ser persistido
	 * @return Lista de {@link TipoServico}
	 */

	TipoServico create(TipoServico tipoServico);

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * 
	 * @return Lista de {@link TipoServico}
	 */

	List<TipoServico> read();

	/**
	 * metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome Parte do nome a ser buscado.
	 * @return Lista de {@link TipoServico}
	 */

	List<TipoServico> readByName(String nome);

	/**
	 * Metodo responsavel por persisir(atualizar) na base de dados
	 * 
	 * @param tipoServico objeto a ser ersistido
	 * @return Objeto persistir
	 */

	TipoServico update(TipoServico tipoServico);

	/**
	 * Metodo responsavel por excluir da base de dados o objeto{@link TipoServico}
	 * refere ao id informado
	 * 
	 * @param id
	 */

	void delete(Integer id);

	TipoServico readById(Integer id);

}
