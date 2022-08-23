
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.dao.AcessorioDAO;
import br.edu.ifsp.pep.modelo.Acessorio;
import br.edu.ifsp.pep.modelo.Veiculo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TesteVeiculoAcessorio {
    private static AcessorioDAO acessorioDAO = new AcessorioDAO();
    private static VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public static void main(String[] args) {
        adicionarAcessorios();
        adicionarVeiculos(0);
        adicionarVeiculos(3);
        exibirVeiculos();
    }
    
    private static void adicionarAcessorios(){
        for(int i=0;i<10;i++){
            Acessorio acessorio = new Acessorio();
            acessorio.setDescricao("Acessorio "+i);
            
            acessorioDAO.inserir(acessorio);
        }
    }
    private static void adicionarVeiculos(int qtdAcessorios){
        List<Acessorio> acessoriosExistentes = acessorioDAO.buscar();
        
        for(int i=0;i<10;i++){
            List<Acessorio> acessorios = new ArrayList<>();
            Veiculo veiculo = new Veiculo();
            veiculo.setAno_fabricacao(2000+i);
            veiculo.setAno_modelo(2000);
            veiculo.setData_cadastro(new Date());
            veiculo.setFabricante("Fabricante "+i);
            veiculo.setModelo("Modelo "+i);
            veiculo.setTipo_combustivel("Alcool/Gasolina");
            veiculo.setValor(new BigDecimal(1000 * i));
            
            if(qtdAcessorios>0){
                for(int y=0;y<qtdAcessorios;y++){
                    acessorios.add(acessoriosExistentes.get(y));
                }
                veiculo.setAcessorios(acessorios);
            }
            
            veiculoDAO.inserir(veiculo);
        }
    }
    
    private static void exibirAcessorios(List<Acessorio> acessorios){
        for(Acessorio a : acessorios){
            System.out.println("Descricao: "+a.getDescricao());
        }
        System.out.println("");
    }
        
    private static void exibirVeiculos(){
        for(Veiculo v : veiculoDAO.buscar()){
            System.out.println("Codigo: "+v.getCodigo());
//            System.out.println("Ano de Fabricação: "+v.getAno_fabricacao());
//            System.out.println("Ano do Modelo: "+v.getAno_modelo());
//            System.out.println("Data de Cadastro: "+v.getData_cadastro());
            System.out.println("Modelo: "+v.getModelo());
            System.out.println("Fabricante: "+v.getFabricante());
//            System.out.println("Tipo de Combustível: "+v.getTipo_combustivel());
//            System.out.println("Valor: "+v.getValor());
            if(!v.getAcessorios().isEmpty()){
                System.out.println("\nAcessorios ");
                exibirAcessorios(v.getAcessorios());
            }
            System.out.println("");
        }
    }
        
    
}
