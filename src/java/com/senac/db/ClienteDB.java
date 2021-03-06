package com.senac.db;

import com.senac.bean.Cliente;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class ClienteDB extends EntidadeFactory implements CrudGenerico<Cliente>{

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
