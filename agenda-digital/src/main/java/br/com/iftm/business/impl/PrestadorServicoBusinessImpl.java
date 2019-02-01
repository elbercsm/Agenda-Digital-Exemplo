package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired
	private PrestadorServicoDAO dao;

	// Create
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getTipoLogradouro() == null)) {
			throw new BusinessException("Tipo Logradouro Requerido!");
		}
		if (StringUtils.isEmpty(prestadorServico.getLogradouro() == null)) {
			throw new BusinessException("Logradouro Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getBairro() == null)) {
			throw new BusinessException("Bairro Requerido!");
		}
		if (prestadorServico.getNumero() == null) {
			throw new BusinessException("Bairro Requerido!");
		}
		if (prestadorServico.getTelefone().isEmpty() || prestadorServico.getTelefone() == null) {
			throw new BusinessException("Pelo menos um telefone é Requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefone()) {
			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}
			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero de telefone Requerido!");
			}
			telefone.setPrestadorServico(prestadorServico);

		}

		if (prestadorServico.getTipoServicos() == null || prestadorServico.getTipoServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um tipo de Servico Requerido!");
		}
		for (TipoServico tipoServico : prestadorServico.getTipoServicos()) {
			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Tipo Servico Requerido!");
			}
		}

		return dao.create(prestadorServico);
	}

	// Get
	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() throws BusinessException {

		return dao.read();
	}

	// Update
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException {

		if (prestadorServico.getCodigo() == null) {
			throw new BusinessException("Nome Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getTipoLogradouro() == null)) {
			throw new BusinessException("Tipo Logradouro Requerido!");
		}
		if (StringUtils.isEmpty(prestadorServico.getLogradouro() == null)) {
			throw new BusinessException("Logradouro Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getBairro() == null)) {
			throw new BusinessException("Bairro Requerido!");
		}
		if (prestadorServico.getNumero() == null) {
			throw new BusinessException("Bairro Requerido!");
		}
		if (prestadorServico.getTelefone().isEmpty() || prestadorServico.getTelefone() == null) {
			throw new BusinessException("Pelo menos um telefone é Requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefone()) {
			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}
			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero de telefone Requerido!");
			}
			telefone.setPrestadorServico(prestadorServico);

		}

		if (prestadorServico.getTipoServicos() == null || prestadorServico.getTipoServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um tipo de Servico Requerido!");
		}
		for (TipoServico tipoServico : prestadorServico.getTipoServicos()) {
			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Tipo Servico Requerido!");
			}
		}

		return dao.update(prestadorServico);
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

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> readByFiltros(FiltroPrestadorDTO filtroPrestadoDTO) throws BusinessException {

		return dao.readByFiltros(filtroPrestadoDTO);
	}
}
