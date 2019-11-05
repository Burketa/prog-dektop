package bancodados;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoDAO {

    private Session session;

    public ProdutoDAO(Session session) {
        this.session = session;
    }

    public void salva(Produto p) {
        Transaction tx = this.session.beginTransaction();
        this.session.save(p);
        tx.commit();
    }

    public void remove(Produto p) {
        Transaction tx = this.session.beginTransaction();
        this.session.delete(p);
        tx.commit();
    }

    public void atualiza(Produto p) {
        Transaction tx = this.session.beginTransaction();
        this.session.update(p);
        tx.commit();
    }
    
    public Produto procura(Long id) {
        return (Produto) 
                this.session.load(Produto.class, id);
    }

    public List<Produto> listaTudo() {
        return this.session.createCriteria(
                Produto.class).list();
    }
    
    public List<Produto> pagina(int inicio, int quantia) {
        return this.session.createCriteria(Produto.class)
                .setMaxResults(quantia)
                .setFirstResult(inicio).list();
    }

    public List <Produto> listaprodutos(Long id){
        return session.createQuery(
                "from Produto where id>"+id).list();
    }

    public List <Produto> listaprodutosSQL(String sql){
        return session.createSQLQuery(sql).addEntity(
                Produto.class).list();
    }
}
