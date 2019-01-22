package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoBusiness {

	/**
	 * Metodo responsavel por garantir os parametros obrigatorios, bem como
	 * solicitar a camada de acesso a dados que persista o objeto
	 * {@link TipoServico}
	 * 
	 * @param tipoServico objeto a ser persistido
	 * @return Objeto Persistido
	 * @throws BusinessException
	 */

	TipoServico create(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */

	List<TipoServico> read() throws BusinessException;

	/**
	 * metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome Parte do nome a ser buscado.
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */

	List<TipoServico> readByName(String nome) throws BusinessException;

	/**
	 * Metodo responsavel por persisir(atualizar) na base de dados
	 * 
	 * @param tipoServico objeto a ser ersistido
	 * @return Objeto persistir
	 * @throws BusinessException
	 */

	TipoServico update(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo responsavel por excluir da base de dados o objeto{@link TipoServico}
	 * refere ao id informado
	 * 
	 * @param id
	 * @throws BusinessException
	 */

	void delete(Integer id) throws BusinessException;

}
