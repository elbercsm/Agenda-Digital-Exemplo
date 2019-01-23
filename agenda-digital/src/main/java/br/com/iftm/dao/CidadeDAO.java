package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

public interface CidadeDAO {

	Cidade create(Cidade cidade);

	List<Cidade> read();

	List<Cidade> readByName(String nome);

	Cidade update(Cidade cidade);

	void delete(Integer id);

	List<Cidade> readByEstado(Estado estado);

}
