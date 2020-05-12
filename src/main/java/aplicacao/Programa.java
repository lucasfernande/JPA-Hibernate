package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	 
		Pessoa p1 = new Pessoa(null, "Mano Brownie", "maninho@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria da Silva", "maria@gmail.com");
		Pessoa p3 = new Pessoa(null, "Carlos Júnior", "carlos@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); // iniciando a transação		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
        em.getTransaction().commit(); // finalizando e confirmando a transação
        
        System.out.println("Pronto!");
	}

}
