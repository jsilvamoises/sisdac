import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Cliente;
import model.EnderecoX;
import enums.TipoPessoa;

@ManagedBean
public class Teste {
	@Inject
	EntityManager manager;
	public static void main(String[] args) {
		new Teste().start();
	}
	
	
	private void start(){
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
		Cliente cliente = new Cliente();	
		cliente.setDocumento("215.049.798-00");
		cliente.setNome("MOISES JUVENAL DA SILVA");
		cliente.setEmail("jsilva.moises@gmail.com");
		cliente.setTipoPessoa(TipoPessoa.FISICA);
		
		EnderecoX endereco = new EnderecoX();
		endereco.setCep("13.221-300");
		endereco.setCidade("Varzea Paulista");
		endereco.setCliente(cliente);
		endereco.setComplemento("casa");
		endereco.setLogradouro("bertioga 49");
		endereco.setNumero("49");
		endereco.setUf("sp");
		cliente.getEnderecos().add(endereco);
		manager.persist(cliente);
//		tx.commit();
	}

}
