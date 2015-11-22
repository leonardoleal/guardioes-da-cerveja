package com.senac.db;

import com.senac.bean.Produto;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDB implements CrudGenerico<Produto>{

    private EntityManager em;

    public ProdutoDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Produto bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Produto bean) {
        em.getTransaction().begin();
        em.remove(em.find(Produto.class, bean.getIdProduto()));
        em.getTransaction().commit();
    }

    @Override
    public List<Produto> listar(Produto bean) {
        return em.createQuery("SELECT f FROM Produto f").getResultList();
    }

    @Override
    public Produto consultar(Produto bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
