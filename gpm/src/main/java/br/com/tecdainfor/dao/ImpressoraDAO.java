package br.com.tecdainfor.dao;

import java.util.List;

import br.com.tecdainfor.model.Impressora;

public interface ImpressoraDAO {

	Impressora cadastrarImpressora(Impressora impressora);

	Impressora alterarImpressora(Impressora impressora);

	Impressora consultarImpressora(int id);

	List<Impressora> listarImpSetor(String nome);

	Impressora excluir(int id);

	List<Impressora> listarImpressoras();

}