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

		/*
		 * cidade.setCodigo(indice++); lista.add(cidade); return cidade;
		 */

		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();
		return cidade;
	}

	@Override
	public List<Cidade> read() {

		// return lista;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public List<Cidade> readByName(String nome) {

		/*
		 * List<Cidade> listaRetorno = new ArrayList<>(); for (Cidade cidade : lista) {
		 * if (cidade.getNome().toUpperCase().contains(nome.toUpperCase())) {
		 * listaRetorno.add(cidade); } } return listaRetorno;
		 */

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase());
		return criteria.list();
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) {

		/*
		 * List<Cidade> listaRetorno = new ArrayList<>(); for (Cidade cidade : lista) {
		 * if (cidade.getEstado().equals(estado)) { listaRetorno.add(cidade); } } return
		 * listaRetorno;
		 */
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("estado", estado));
		return criteria.list();
	}

	@Override
	public Cidade update(Cidade cidade) {

		/*
		 * for (Cidade cidade2 : lista) { if
		 * (cidade2.getCodigo().equals(cidade.getCodigo())) {
		 * cidade2.setNome(cidade.getNome()); cidade2.setEstado(cidade.getEstado()); } }
		 * return cidade;
		 */

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();
		return cidade;

	}

	@Override
	public void delete(Integer id) {

		/*
		 * for (Cidade cidade2 : lista) { if (cidade2.getCodigo().equals(id)) {
		 * lista.remove(cidade2); break; } }
		 */

		Cidade cidade = new Cidade();
		cidade.setCodigo(id);

		sessionFactory.getCurrentSession().delete(cidade);
	}

}
