package br.com.caelum;

import java.util.Arrays;
import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class InsereBanco {

	public static void main(String[] args) {
		AnnotationConfiguration ac = new AnnotationConfiguration();
		ac.configure();

		SessionFactory factory = ac.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		Evento evento = new Evento();
		evento.setTitulo("java day");
		evento.setData(Calendar.getInstance());
		evento.setLocal("SJRP");
		evento.setPreco(50.5);


		Foto f = new Foto();
		f.setArquivo(" x.jpg");

		evento.setFotos(Arrays.asList(f));

		session.persist(f);
		session.persist(evento);


		session.getTransaction().commit();



	}
}
