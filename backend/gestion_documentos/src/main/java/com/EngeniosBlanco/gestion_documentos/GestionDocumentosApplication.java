package com.EngeniosBlanco.gestion_documentos;

import com.EngeniosBlanco.gestion_documentos.model.User;
import com.EngeniosBlanco.gestion_documentos.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.EngeniosBlanco.gestion_documentos.model")
@ComponentScan(basePackages = "com.EngeniosBlanco.gestion_documentos")
public class GestionDocumentosApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionDocumentosApplication.class, args);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Crear usuario
		User user = new User("usuario123", "passwordSeguro", "usuario@gmail");
		session.persist(user);

		tx.commit();
		session.close();

		System.out.println("Usuario insertado con ID: " + user.getId());


	}
}
