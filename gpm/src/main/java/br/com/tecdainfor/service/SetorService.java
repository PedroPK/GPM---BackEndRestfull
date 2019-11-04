package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.model.Usuario;

@Service
public interface SetorService {

	List<Setor> listarSetores();

	Setor cadastrarSetor(Setor setor);

	void alterarSetor(Setor setor);

	Setor consultarSetor(int id);

	void excluir(int id);

	Usuario consultarUsuario(int iduser);

}
