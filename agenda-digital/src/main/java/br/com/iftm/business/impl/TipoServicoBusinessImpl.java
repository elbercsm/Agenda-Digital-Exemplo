package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class TipoServicoBusinessImpl implements TipoServicoBusiness {

	@Autowired
	private TipoServicoDAO dao;

	// Create
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico create(TipoServico tipoServico) throws BusinessException {

		if (StringUtils.isEmpty(tipoServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		return dao.create(tipoServico);
	}

	// Get
	@Override
	@Transactional(readOnly = true)
	public List<TipoServico> read() throws BusinessException {

		return dao.read();
	}

	@Override
	public TipoServico readById(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("Código Requerido!");
		}

		return dao.readById(id);
	}

	// Get By Name
	@Override
	@Transactional(readOnly = true)
	public List<TipoServico> readByName(String nome) throws BusinessException {

		if (StringUtils.isEmpty(nome)) {

			throw new BusinessException("Nome Requerido!");
		}

		return dao.readByName(nome);
	}

	// Update
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico update(TipoServico tipoServico) throws BusinessException {

		if (tipoServico.getCodigo() == null) {
			throw new BusinessException("Codigo Requerido!");
		}

		if (StringUtils.isEmpty(tipoServico.getNome())) {
			throw new BusinessException("Nome Requerido");
		}

		return dao.update(tipoServico);
	}

	// Delete
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Codigo Requerido!");
		}
		dao.delete(id);
	}

}
