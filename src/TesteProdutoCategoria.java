
import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class TesteProdutoCategoria {
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public static void main(String[] args) {
        adicionarProdutos();
        
        reajustarPrecoProdutos(5);
        
        exibirProdutos();
    }
    
    private static void teste(){
        EntityManager em = Persistence.createEntityManagerFactory("aula1PU").createEntityManager();
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
    }
    
    private static void adicionarProdutos(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        for(int i=0;i<10;i++){
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria "+i);
            categoriaDAO.inserir(categoria);
        
            Produto produto = new Produto();
            produto.setDescricao("Produto "+i);
            produto.setPreco(new BigDecimal(60.0 * (i+1)));
            produto.setQuantidade(100);
            
            produto.setCategoria(categoria);
            
            produtoDAO.inserir(produto);
        }
    }
    
    private static void reajustarPrecoProdutos(double porcentagem){
        List<Produto> produtos = produtoDAO.buscar();
        
        for(Produto produto : produtos){
            float preco = produto.getPreco().floatValue();
            produto.setPreco(new BigDecimal(preco + (preco * (porcentagem/100))));
            produtoDAO.alterar(produto);
        }
    }
        
    private static void exibirProdutos(){
        List<Produto> produtos = produtoDAO.buscar();
        
        for(Produto p : produtos){
            System.out.println("Descricao: "+p.getDescricao());
            System.out.println("Preco: "+p.getPreco());
            System.out.println("Quantidade: "+p.getQuantidade());
            System.out.println("Categoria: "+p.getCategoria().getDescricao());
            System.out.println("");
        }
    }
        
    
}
