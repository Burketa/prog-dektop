package bancodados;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil {
    private static SessionFactory factory;
    static {
        AnnotationConfiguration cfg = 
                new AnnotationConfiguration();
        Set<String> stringPropertyNames = cfg.getProperties().stringPropertyNames();
        cfg.addAnnotatedClass(Produto.class);
        factory = cfg.buildSessionFactory();
    }
    public static Session getSession() {
        return factory.openSession();
    }
}