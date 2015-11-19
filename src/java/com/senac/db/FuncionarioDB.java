/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.db;

import com.senac.bean.Funcionario;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo
 */
public class FuncionarioDB implements CrudGenerico<Funcionario>{

    private EntityManager em;

    public FuncionarioDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Funcionario bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Funcionario bean) {
        em.getTransaction().begin();
        em.remove(em.find(Funcionario.class, bean.getIdFuncionario()));
        em.getTransaction().commit();
    }

    @Override
    public List<Funcionario> listar(Funcionario bean) {
        return em.createQuery("SELECT f FROM Funcionario f").getResultList();
    }

    @Override
    public Funcionario consultar(Funcionario bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
