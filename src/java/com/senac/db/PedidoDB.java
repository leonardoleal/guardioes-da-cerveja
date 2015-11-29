package com.senac.db;

import com.senac.bean.Pedido;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class PedidoDB extends EntidadeFactory implements CrudGenerico<Pedido>{
    
    @Override
    public void salvar(Pedido bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Pedido bean) {
        em.getTransaction().begin();
        em.remove(em.find(Pedido.class, bean.getIdPedido()));
        em.getTransaction().commit();
    }

    @Override
    public List<Pedido> listar(Pedido bean) {
        return em.createQuery("SELECT p FROM Pedido p").getResultList();
    }

    @Override
    public Pedido consultar(Pedido bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
