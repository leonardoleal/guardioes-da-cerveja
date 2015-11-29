package com.senac.db;

import com.senac.bean.Funcionario;
import com.senac.util.CrudGenerico;
import com.senac.util.EntidadeFactory;
import java.util.List;

public class FuncionarioDB extends EntidadeFactory implements CrudGenerico<Funcionario>{
    
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

    public List<Funcionario> consultarCPFeSenha(Funcionario bean) {
        return em.createNamedQuery("Funcionario.findByCPFeSenha").setParameter("cpf", bean.getCpf()).setParameter("senha",bean.getSenha()).getResultList();
    }
}
