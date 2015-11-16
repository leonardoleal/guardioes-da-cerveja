/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.db;

import com.senac.bean.Cliente;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo
 */
public class ClienteDB implements CrudGenerico<Cliente>{

    private EntityManager em;

    public ClienteDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Cliente bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Cliente bean) {
        em.getTransaction().begin();
        em.remove(em.find(Cliente.class, bean.getIdCliente()));
        em.getTransaction().commit();
    }

    @Override
    public List<Cliente> listar(Cliente bean) {
        return em.createQuery("SELECT c FROM Cliente c").getResultList();
    }

    @Override
    public Cliente consultar(Cliente bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
