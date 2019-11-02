package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecdainfor.dao.ComputadorDAO;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Setor;

@Service
public class ComputadorServiceImpl implements ComputadorService{

	@Autowired
	private ComputadorDAO repository;
	
	
	@Override
	public List<Computador> listarComputadores() {
	
		return this.repository.listarComputadores();
	}

	@Override
	public List<Setor> listaSetor() {
	
		return this.repository.listaSetor();
	}

	@Override
	public Setor consultarSetor(int idsetor) {
		
		return this.repository.consultarSetor(idsetor);
	}

	@Override
	public void cadastrarComputador(Computador computador2) {
	 this.repository.cadastrarComputador(computador2);
		
	}

	@Override
	public void excluir(int codigo) {
		this.repository.excluir(codigo);
		
	}

	@Override
	public Computador consultarComputador(int id) {
	
		return this.repository.consultarComputador(id);
	}

}
