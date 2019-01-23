package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.impl.PrestadorServicoBusinessImpl;
import br.com.iftm.entity.PrestadorServico;

@RestController
@RequestMapping(value = "/prestadorservico")
public class PrestadorServicoRest {

	@Autowired
	private PrestadorServicoBusinessImpl business;
	// CREATE

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody PrestadorServico prestadorServico) {

		try {

			prestadorServico = business.create(prestadorServico);

			return ResponseEntity.ok(prestadorServico);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// READ
	@GetMapping
	public ResponseEntity<?> read() {

		try {

			return ResponseEntity.ok(business.read());
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

	}

	@GetMapping("/filtro/nome")

	public ResponseEntity<?> readyByName(@PathParam("nome") String nome) {

		try {

			List<PrestadorServico> readByName = business.readByName(nome);

			if (readByName.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(readByName);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	// UPDATE
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico prestadorServico) {

		try {
			prestadorServico = business.update(prestadorServico);
			return ResponseEntity.ok(prestadorServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

	}

	// DELETE
	@RequestMapping(value = "/{id}")

	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {
			business.delete(id);
			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
