/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.db;

import com.senac.bean.Unidade;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo
 */
public class UnidadeDB implements CrudGenerico<Unidade>{

    private EntityManager em;

    public UnidadeDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Unidade bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Unidade bean) {
        em.getTransaction().begin();
        em.remove(em.find(Unidade.class, bean.getIdUnidade()));
        em.getTransaction().commit();
    }

    @Override
    public List<Unidade> listar(Unidade bean) {
        return em.createQuery("SELECT u FROM Unidade u").getResultList();
    }

    @Override
    public Unidade consultar(Unidade bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
