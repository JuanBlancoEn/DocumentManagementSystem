package com.EngeniosBlanco.gestion_documentos;

import com.EngeniosBlanco.gestion_documentos.model.User;
import com.EngeniosBlanco.gestion_documentos.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan("com.EngeniosBlanco.gestion-documentos.model")
public class Main {
    public static void main(String[] args) {
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