package bancodados;

import org.hibernate.Session;

public class ExProdutoDAO {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        ProdutoDAO dao = new ProdutoDAO(session);
        
        //Produto p0 = new Produto(
        //        "Agua Cristal", "Agua Mineral 500ml", 0.70d);
        //dao.salva(p0);
        
        
        //busca um Produto usando o Id
        //Produto produto1 = dao.procura(23L);
        //altera o valor
        //produto1.setPreco(produto1.getPreco()*1.1);
        //produto1.setNome("Agua Aguativa");
        //atualiza o objeto no BD
        //dao.atualiza(produto1);
        
        //busca um Produto usando o Id
        //Produto produto2 = dao.procura(20L);
        //remove o objeto do BD
        //dao.remove(produto2);
        
        //cria um novo objeto
        /*
        Produto produto3 = new Produto();
        produto3.setNome("Café");
        produto3.setDescricao("Arábica");
        produto3.setPreco(12.50d);
        //insere o objeto no BD
        dao.salva(produto3);
         * 
         */
        session.close();
    }
}
