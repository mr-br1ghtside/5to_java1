package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;


//GUI 
public class Demo08 {
	// Objetivo: Listado de los usuarios segun el tipo de usuario (filtro)
	 public static void main(String[] args) {
		 String usuario = JOptionPane.showInputDialog("Ingresa usuario: ");
		 String clave = JOptionPane.showInputDialog("Ingresa clave: ");
		
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");

		 EntityManager em= fabrica.createEntityManager();
		 
		 // select * from tb_usuarios where idtipo = ?
		 //String jpql = "select u from Usuario u where u.idtipo = :xtip";
		 //List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).setParameter("xtip", 1).getResultList();
		 String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		 try {
			Usuario u = 
					 em.createQuery(jpql, Usuario.class).
					 setParameter("xusr", usuario).
					 setParameter("xcla", clave).
					 getSingleResult();
			 
			 // Abrir la ventana
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
		}
			 
		 
		
		 em.close();
	} 
}
