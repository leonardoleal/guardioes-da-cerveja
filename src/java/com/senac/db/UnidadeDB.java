package com.senac.db;

import com.senac.bean.Unidade;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class UnidadeDB extends EntidadeFactory implements CrudGenerico<Unidade>{
    
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
