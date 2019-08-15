package br.com.tecdainfor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.tecdainfor.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	@javax.transaction.Transactional
	public Usuario cadastrarUsuario(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	@javax.transaction.Transactional
	public Usuario loginUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@javax.transaction.Transactional
	public void esqueciSenhaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	@javax.transaction.Transactional
	public void alterarSenhaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	@javax.transaction.Transactional
	public Usuario alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return manager.merge(usuario);
	}
	
	@javax.transaction.Transactional
	public Usuario consultarUsuarioCodigo(int id) {
		// TODO Auto-generated method stub
		return manager.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@javax.transaction.Transactional
	public List<Usuario> consultarUsuarioNome(String nome) {
		// TODO Auto-generated method stub
		List<Usuario> usuario = manager.createQuery("SELECT u FROM Usuario u WHERE u.nome LIKE '" + nome + "%'").getResultList();		
		return usuario;
	
	}
	
	@javax.transaction.Transactional
	public Usuario excluir(int id) {
		// TODO Auto-generated method stub
		Usuario usuario = this.consultarUsuarioCodigo(id);
		manager.remove(usuario);
		return usuario;
	}
	
	@javax.transaction.Transactional
	public List<Usuario> listarUsuarios(){
		// TODO Auto-generated method stub
		return manager.createQuery("SELECT u FROM Usuario u ORDER BY u.nome", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> consultaPagina(String numeroPagina) {
		// TODO Auto-generated method stub
		int total_por_pagina = 6;
		if (numeroPagina == null || (numeroPagina != null && numeroPagina.trim().isEmpty())){
			numeroPagina = "0";
		}
		int offSet = (Integer.parseInt(numeroPagina) * total_por_pagina) - total_por_pagina; 
		
		if (offSet < 0){
			offSet = 0;
		}
		
		/*Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.setFirstResult(offSet);
		criteria.setMaxResults(total_por_pagina);
		criteria.addOrder(Order.asc("id"));*/

		return null;
	}

}
