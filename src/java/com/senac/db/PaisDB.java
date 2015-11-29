package com.senac.db;

import com.senac.bean.Pais;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class PaisDB extends EntidadeFactory implements CrudGenerico<Pais>{

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
