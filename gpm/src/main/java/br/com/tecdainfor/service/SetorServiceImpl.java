package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecdainfor.dao.SetorDAO;
import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.model.Usuario;

@Service
public class SetorServiceImpl implements SetorService{

	@Autowired
	private SetorDAO repository;
	
	@Override
	public List<Setor> listarSetores() {
		
		return this.repository.listarSetores();
	}

	@Override
	public Setor cadastrarSetor(Setor setor) {

		return this.repository.cadastrarSetor(setor);
	}

	@Override
	public void alterarSetor(Setor setor) {
		this.repository.alterarSetor(setor);
		
	}

	@Override
	public Setor consultarSetor(int id) {
		// TODO Auto-generated method stub
		return this.repository.consultarSetor(id);
	}

	@Override
	public void excluir(int id) {
		this.repository.excluir(id);
		
	}

	@Override
	public Usuario consultarUsuario(int iduser) {
		
		return this.consultarUsuario(iduser);
	}

}
