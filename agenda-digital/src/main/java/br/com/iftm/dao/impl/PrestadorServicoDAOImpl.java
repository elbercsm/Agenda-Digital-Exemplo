package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
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

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		return criteria.list();
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().update(prestadorServico);
		sessionFactory.getCurrentSession().flush();
		return prestadorServico;
	}

	@Override
	public void delete(Integer id) {

		PrestadorServico prestadorServico = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);
		sessionFactory.getCurrentSession().delete(prestadorServico);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public List<PrestadorServico> readByFiltros(FiltroPrestadorDTO filtroPrestadoDTO) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		Criteria CriteriaCidade = criteria.createCriteria("cidade");

		if (!StringUtils.isEmpty(filtroPrestadoDTO.getNome())) {
			criteria.add(Restrictions.like("nome", filtroPrestadoDTO.getNome(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (filtroPrestadoDTO.getEstado() != null) {
			CriteriaCidade.add(Restrictions.eq("estado", filtroPrestadoDTO.getEstado()));
		}
		if (filtroPrestadoDTO.getCidade() != null && filtroPrestadoDTO.getCidade().getCodigo() != null) {
			criteria.add(Restrictions.eq("cidade", filtroPrestadoDTO.getCidade()));
		}
		/*
		 * if (filtroPrestadoDTO.getTiposServicos() != null &&
		 * filtroPrestadoDTO.getTiposServicos().isEmpty()) {
		 * CriteriaCidade.add(Restrictions.in("tipoServicos",
		 * filtroPrestadoDTO.getTiposServicos())); }
		 */

		return criteria.list();

	}
}
