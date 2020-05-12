package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		 *  para remover um elemento do banco de dados, ele tem que ser monitorado, ou seja,
		 *   ou ele tem que acabar de ter sido inserido, ou deve ser recuperado do banco de dados (como no exemplo abaixo) e
		 *   ser removido antes do EntityManager ser fechado	 
		 */
		
		em.getTransaction().begin(); // quando não for uma operação de consulta, tem que colocar a transação
		
		Pessoa p = em.find(Pessoa.class, 2);
        em.remove(p);
        
		em.getTransaction().commit();
		
        System.out.println("Pronto!");
        em.close();
        emf.close();
	}

}
