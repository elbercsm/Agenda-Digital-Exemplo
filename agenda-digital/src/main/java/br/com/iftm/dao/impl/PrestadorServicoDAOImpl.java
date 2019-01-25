package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().save(prestadorServico);
		sessionFactory.getCurrentSession().flush();
		return prestadorServico;

	}

	@Override
	public List<PrestadorServico> read() {

		// return lista;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		return criteria.list();
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		/*
		 * for (PrestadorServico prestadorServico2 : lista) { if
		 * (prestadorServico2.getCodigo().equals(prestadorServico.getCodigo())) {
		 * prestadorServico2.setNome(prestadorServico.getNome());
		 * prestadorServico2.setBairro(prestadorServico.getBairro());
		 * prestadorServico2.setCidade(prestadorServico.getCidade());
		 * prestadorServico2.setCep(prestadorServico.getCep());
		 * prestadorServico2.setComplemento(prestadorServico.getComplemento());
		 * prestadorServico2.setEmail(prestadorServico.getEmail());
		 * prestadorServico2.setLogradouro(prestadorServico.getLogradouro());
		 * prestadorServico2.setNumero(prestadorServico.getNumero());
		 * prestadorServico2.setTelefone(prestadorServico.getTelefone());
		 * prestadorServico2.setTipoLogradouro(prestadorServico.getTipoLogradouro()); }
		 * } return prestadorServico;
		 */

		sessionFactory.getCurrentSession().update(prestadorServico);
		sessionFactory.getCurrentSession().flush();
		return prestadorServico;
	}

	@Override
	public void delete(Integer id) {

		/*
		 * for (PrestadorServico prestadorServico2 : lista) { if
		 * (prestadorServico2.getCodigo().equals(id)) { lista.remove(prestadorServico2);
		 * break; } }
		 */

		PrestadorServico prestadorServico = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);
		sessionFactory.getCurrentSession().delete(prestadorServico);
		sessionFactory.getCurrentSession().flush();

	}
}
