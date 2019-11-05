package bancodados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AdicionaProduto {
    public static void main(String[] args) {
        //Configurar a classe de trabalho.
        AnnotationConfiguration cfg = 
                    new AnnotationConfiguration();
        cfg.addAnnotatedClass(Produto.class);
        //Criar um objeto gerador de sessoes.
        SessionFactory factory = cfg.buildSessionFactory();
        //criar uma sessao.
        Session session = factory.openSession();
        for (int i = 1; i < 20; i++) {
            //cria um objeto da classe Produto.
            Produto p = new Produto("Nome-" + i, 
                    "Descrição-" + i, i * 100.50);
            //criar uma transacao.
            Transaction tx = session.beginTransaction();
            session.save(p);
            System.out.println("ID do produto: " + p.getId());
            //processar as instrucoes SQL (enviar para o banco).
            tx.commit();
        }
        //busca pela chave primaria, id == 10.
        //Produto encontrado = (Produto) 
        //        session.load(Produto.class, 10L);
        //System.out.println(encontrado.getNome());
        //System.out.println(encontrado.getDescricao());
        //fechar a sessao.
        session.close();
    }
}
