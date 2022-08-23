package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Acessorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AcessorioDAO {
    private EntityManagerFactory emf;
    
    public AcessorioDAO(){
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }
    
    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    
    public void inserir(Acessorio acessorio){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Acessorio acessorio){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(acessorio);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public List<Acessorio> buscar(){
        
        TypedQuery<Acessorio> query = getEntityManager().createQuery("SELECT a FROM Acessorio a", Acessorio.class);
        
        return query.getResultList();
    }
    
}
