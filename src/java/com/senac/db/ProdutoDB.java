package com.senac.db;

import com.senac.bean.Produto;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class ProdutoDB extends EntidadeFactory implements CrudGenerico<Produto>{
    
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
