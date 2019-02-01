package br.com.iftm.business;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoBusiness {

	PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException;

	List<PrestadorServico> read() throws BusinessException;

	PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException;

	void delete(Integer id) throws BusinessException;

	List<PrestadorServico> readByFiltros(@RequestBody FiltroPrestadorDTO filtroPrestadoDTO) throws BusinessException;
}
