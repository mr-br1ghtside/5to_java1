package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;


//GUI 
public class Demo09 {
	// Objetivo: Listado de los usuarios segun el tipo de usuario (filtro)
	 public static void main(String[] args) {
		 String usuario = JOptionPane.showInputDialog("Ingresa usuario: ");
		 String clave = JOptionPane.showInputDialog("Ingresa clave: ");
		 
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");

		 EntityManager em= fabrica.createEntityManager();
		 
		 //List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).setParameter("xtip", 1).getResultList();
		 String jpql = "select u from Usuario u where u.nom_usua = :xnom";
		 Usuario u = 
				em.createQuery(jpql, Usuario.class).
				 setParameter("xusr", usuario).
				 setParameter("xcla", clave).
				 getSingleResult();
		 
		 // Imprimir el listado usando un "for"
		 
			 
			 System.out.println("Usuario...: " + u.getUsr_usua());
			 System.out.println("Clave...: " + u.getCla_usua());
			 System.out.println("Tipo...: " + u.getIdtipo());
			 System.out.println("----------------------------------");
		 
		 
		 em.close();
	} 
}
