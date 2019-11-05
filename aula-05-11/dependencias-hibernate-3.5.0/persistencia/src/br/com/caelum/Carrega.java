package br.com.caelum;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Carrega {

	public static void main(String[] args) {
		AnnotationConfiguration ac = new AnnotationConfiguration();
		ac.configure();

		SessionFactory factory = ac.buildSessionFactory();
		Session session = factory.openSession();


		session.beginTransaction();

		Evento e = (Evento) session.load(Evento.class, 1);
		System.out.println(e.getTitulo());

		e.setPreco(20);


		session.getTransaction().commit();
	}
}
