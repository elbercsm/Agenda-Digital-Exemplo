package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	private List<PrestadorServico> lista = new ArrayList<>();

	private int indice = 0;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {

		prestadorServico.setCodigo(indice++);

		lista.add(prestadorServico);

		return prestadorServico;
	}

	@Override
	public List<PrestadorServico> read() {

		return lista;
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		for (PrestadorServico prestadorServico2 : lista) {

			if (prestadorServico2.getCodigo().equals(prestadorServico.getCodigo())) {
				prestadorServico2.setNome(prestadorServico.getNome());
				prestadorServico2.setBairro(prestadorServico.getBairro());
				prestadorServico2.setCidade(prestadorServico.getCidade());
				prestadorServico2.setCep(prestadorServico.getCep());
				prestadorServico2.setComplemento(prestadorServico.getComplemento());
				prestadorServico2.setEmail(prestadorServico.getEmail());
				prestadorServico2.setLogradouro(prestadorServico.getLogradouro());
				prestadorServico2.setNumero(prestadorServico.getNumero());
				prestadorServico2.setTelefone(prestadorServico.getTelefone());
				prestadorServico2.setTipoLogradouro(prestadorServico.getTipoLogradouro());
			}
		}
		return prestadorServico;

	}

	@Override
	public void delete(Integer id) {

		for (PrestadorServico prestadorServico2 : lista) {

			if (prestadorServico2.getCodigo().equals(id)) {
				lista.remove(prestadorServico2);
				break;
			}
		}

	}
}
