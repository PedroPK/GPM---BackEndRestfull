package br.com.tecdainfor.dao;

import java.util.List;

import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.model.Usuario;

public interface SetorDAO {
	
	Setor cadastrarSetor(Setor computador);

	Setor alterarSetor(Setor computador);

	Setor consultarSetor(int id);

	Setor excluir(int id);

	List<Setor> listarSetores();

	Usuario consultarUsuario(int chefeSetorIdRef);


}
