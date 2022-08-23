package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class VeiculoDAO {
    private EntityManagerFactory emf;
    
    public VeiculoDAO(){
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }
    
    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    
    public void inserir(Veiculo veiculo){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Veiculo veiculo){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public List<Veiculo> buscar(){
        
        TypedQuery<Veiculo> query = getEntityManager().createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        
        return query.getResultList();
    }
    
}
