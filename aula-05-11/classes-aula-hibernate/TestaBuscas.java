package bancodados;
import java.util.List;
import org.hibernate.Session;
public class TestaBuscas {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        ProdutoDAO dao = new ProdutoDAO(session);
        
        //System.out.println("*****Listando Tudo*******");
        //List <Produto> minhalista = dao.listaTudo();
        //for (Produto p : minhalista) {
        //    System.out.println(p.getNome());
        //}
        
        //System.out.println("*****Listando Paginado*******");
        //for (Produto p : dao.pagina(3, 10)) {
        //    System.out.println(p.getNome());
        //}
        
        System.out.println("***Listando a partir do p elemento***");
        List <Produto> lista1 = dao.listaprodutos(18L);
        for (Produto p : lista1) {
            System.out.println(p.getNome());
       }
        
        List <Produto> prods = dao.listaprodutosSQL("select * from Produto order by preco");
        System.out.println("***Listando a partir do SQL***");
        for (Produto p : prods) {
            System.out.println(p.getNome());
        }
    }
}
