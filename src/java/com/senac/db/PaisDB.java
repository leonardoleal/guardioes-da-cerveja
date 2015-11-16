/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.db;

import com.senac.bean.Pais;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo
 */
public class PaisDB implements CrudGenerico<Pais>{

    private EntityManager em;

    public PaisDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Pais bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Pais bean) {
        em.getTransaction().begin();
        em.remove(em.find(Pais.class, bean.getIdPais()));
        em.getTransaction().commit();
    }

    @Override
    public List<Pais> listar(Pais bean) {
        return em.createQuery("SELECT p FROM Pais p").getResultList();
    }

    @Override
    public Pais consultar(Pais bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
