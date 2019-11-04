package br.com.tecdainfor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Setor;

@Service
public interface ComputadorService {

	List<Computador> listarComputadores();

	List<Setor> listaSetor();

	Setor consultarSetor(int idsetor);

	void cadastrarComputador(Computador computador2);

	void excluir(int codigo);

	Computador consultarComputador(int id);

}
