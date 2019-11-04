package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.tecdainfor.dao.UsuarioDAO;
import br.com.tecdainfor.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO repository;
	
	

	@Override
	public List<Usuario> findAll() {
		
		return this.repository.listarUsuarios();
	}


	@Override
	public void save(Usuario usuario) {
		this.repository.cadastrarUsuario(usuario);
		
	}


	@Override
	public List<Usuario> findByName(String nome) {
		
		return this.repository.consultarUsuarioNome(nome);
	}


	@Override
	public void deleteById(int id) {
		this.repository.excluir(id);
		
	}


	@Override
	public Usuario getOne(int id) {
		// TODO Auto-generated method stub
		return this.repository.consultarUsuarioCodigo(id);
	}


	@Override
	public Usuario autenticarUsuario(int matricula, String senha) {
		// TODO Auto-generated method stub
		return this.repository.autenticarUsuario(matricula, senha);
	}
	
	

}
