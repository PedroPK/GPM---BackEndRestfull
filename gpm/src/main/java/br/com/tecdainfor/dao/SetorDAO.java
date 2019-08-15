package br.com.tecdainfor.dao;

import java.util.List;

import br.com.tecdainfor.model.Setor;

public interface SetorDAO {
	
	Setor cadastrarSetor(Setor computador);

	Setor alterarSetor(Setor computador);

	Setor consultarSetor(int id);

	Setor excluir(int id);

	List<Setor> listarSetores();


}
