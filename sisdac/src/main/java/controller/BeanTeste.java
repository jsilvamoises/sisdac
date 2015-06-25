package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Cliente;
import model.UsuarioX;

@ManagedBean
@ViewScoped
public class BeanTeste  implements Serializable{
  
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioX usuario;
	
	@Inject
	EntityManager manager;	
	private List<Integer> lista = new ArrayList<Integer>();
	
	public BeanTeste() {
		
		
	}
	
	

	public UsuarioX getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioX usuario) {
		this.usuario = usuario;
	}

	public List<Integer> getLista() {
		for(int i = 0 ; i <50; i ++){
			lista.add(i);
		}
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	
	
	public void Logar(){
		List<Cliente> l = manager.createQuery("from Cliente", Cliente.class).getResultList();
		usuario.setLogin("Moises Juvenal da Silva");
	}
	
	

}
