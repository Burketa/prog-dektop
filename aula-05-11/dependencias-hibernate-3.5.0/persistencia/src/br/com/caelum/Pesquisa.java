package br.com.caelum;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Pesquisa {

	public static void main(String[] args) {
		AnnotationConfiguration ac = new AnnotationConfiguration();
		ac.configure();

		SessionFactory factory = ac.buildSessionFactory();
		Session session = factory.openSession();

		Evento e = (Evento) session.load(Evento.class, 2);

		for (Foto f : e.getFotos()) {
			System.out.println(f.getArquivo());
		}

	}
}
