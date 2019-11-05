package aulaHibernate;

import javax.annotation.processing.SupportedSourceVersion;
import static javax.lang.model.SourceVersion.RELEASE_7;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

 @SupportedSourceVersion(RELEASE_7)
public class GeraTabelas {
   
    public static void main(String[] args) {
        // Cria uma configuracao para a classe Produto
        AnnotationConfiguration cfg = 
                new AnnotationConfiguration();
        cfg.addAnnotatedClass(Produto.class);
        //..poderia adicionar outras classes...
        new SchemaExport(cfg).create(true, true);
    }
}