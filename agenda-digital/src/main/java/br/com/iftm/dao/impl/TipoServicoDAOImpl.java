package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public TipoServico create(TipoServico tipoServico) {

		sessionFactory.getCurrentSession().save(tipoServico);
		sessionFactory.getCurrentSession().flush();
		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);
		return criteria.list();
	}

	@Override
	public List<TipoServico> readByName(String nome) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase());
		return criteria.list();

	}

	@Override
	public TipoServico update(TipoServico tipoServico) {

		sessionFactory.getCurrentSession().update(tipoServico);
		sessionFactory.getCurrentSession().flush();
		return tipoServico;
	}

	@Override
	public void delete(Integer id) {

		TipoServico tipoServico = new TipoServico();
		tipoServico.setCodigo(id);

		sessionFactory.getCurrentSession().delete(tipoServico);

	}

	@Override
	public TipoServico readById(Integer id) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select t from TipoServico t where t.codigo = :codigo").setParameter("codigo", id);

		return (TipoServico) query.getSingleResult();
	}
}
