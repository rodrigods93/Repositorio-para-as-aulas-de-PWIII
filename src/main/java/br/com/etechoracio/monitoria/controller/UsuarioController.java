package br.com.etechoracio.monitoria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.model.dao.UsuarioDAO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired 
	//O framework fica responsavel por instanciar o objeto não sendo necessario que eu faça o processo.
	private UsuarioDAO usuarioDAO; // o usuarioDAO minusculo é um objeto.
	
	@PostMapping // ele explicita o modo que vai ser enviado no caso sera o POST
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usr) {//O requestbody indica que eu vou recener o usuario
		//no corpo da requisição.
		Usuario salvo = usuarioDAO.save(usr);
		return ResponseEntity.ok(salvo);
	}
	
	@GetMapping
	public List<Usuario> listarTodos(){
		return usuarioDAO.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id,@RequestBody Usuario usr) {
		if(usuarioDAO.existsById(id)) {
			Usuario salvo = usuarioDAO.save(usr);
			return ResponseEntity.ok(salvo);
		}
		return ResponseEntity.noContent().build(); //informa que não tem conteudo para atualizar.
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletar(@PathVariable Long id) {
		
		if(usuarioDAO.existsById(id)) {
			usuarioDAO.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorID(@PathVariable Long id){
		Optional<Usuario> resultado = usuarioDAO.findById(id);
		if(resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	

}
