package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Veiculo;
import java.util.List;
import javax.persistence.TypedQuery;

public class VeiculoDAO extends AbstractDAO<Veiculo>{
    public List<Veiculo> buscar(){
        
        TypedQuery<Veiculo> query = getEntityManager().createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        
        return query.getResultList();
    }
    
}
