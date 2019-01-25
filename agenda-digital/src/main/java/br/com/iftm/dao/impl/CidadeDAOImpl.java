package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

@Repository
public class CidadeDAOImpl implements CidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private List<Cidade> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public Cidade create(Cidade cidade) {

		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();
		return cidade;
	}

	@Override
	public List<Cidade> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public List<Cidade> readByName(String nome) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase());
		return criteria.list();
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("estado", estado));
		return criteria.list();
	}

	@Override
	public Cidade update(Cidade cidade) {

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();
		return cidade;

	}

	@Override
	public void delete(Integer id) {

		Cidade cidade = new Cidade();
		cidade.setCodigo(id);

		sessionFactory.getCurrentSession().delete(cidade);
	}

}
