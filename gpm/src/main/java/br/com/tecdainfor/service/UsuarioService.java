package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.tecdainfor.model.Usuario;

@Service
public interface UsuarioService {
	
	
	List<Usuario> findAll();

	void save(Usuario usuario);

	List<Usuario> findByName(String nome);

	void deleteById(int id);

	Usuario getOne(int id);

	Usuario autenticarUsuario(int matricula, String senha);
	


}
