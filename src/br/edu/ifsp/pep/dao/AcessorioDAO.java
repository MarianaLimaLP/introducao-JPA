package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Acessorio;
import java.util.List;
import javax.persistence.TypedQuery;

public class AcessorioDAO extends AbstractDAO<Acessorio>{
    public List<Acessorio> buscar(){
        
        TypedQuery<Acessorio> query = getEntityManager().createQuery("SELECT a FROM Acessorio a", Acessorio.class);
        
        return query.getResultList();
    }
    
}
