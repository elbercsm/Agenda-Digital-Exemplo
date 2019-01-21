package br.com.iftm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.iftm.entity.TipoServico;

@RestController
@RequestMapping(value = "/tiposervico")

public class TipoServicoRest {

	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;
	// CREATE

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico) {

		if (StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido !!");
		}

		// if(tipoServico.getNome() == null || tipoServico.getNome().trim().isEmpty()) {
		// return ResponseEntity.badRequest().body("Nome Requerido !!");
		// }

		tipoServico.setCodigo(indice++);

		lista.add(tipoServico);

		return ResponseEntity.ok(tipoServico);
	}

	// READ
	@GetMapping
	public ResponseEntity<?> read() {
		return ResponseEntity.ok(lista);
	}

	// UPDATE
	@PostMapping
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico) {
		if (tipoServico.getCodigo() == null) {

			return ResponseEntity.badRequest().body("Codigo Requerido!");
		}
		if (StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido");
		}
		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		return ResponseEntity.ok(tipoServico);
	}

	// DELETE
	@DeleteMapping
	
	public ResponseEntity<?> delete(@RequestBody TipoServico tipoServico){
		if (tipoServico.getCodigo() == null) {

			return ResponseEntity.badRequest().body("Codigo Requerido!");
		}
	
		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				lista.remove(tipoServico2);
				break;
			}
		}
		return ResponseEntity.ok().build();
		
	}

}
