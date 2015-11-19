package com.senac.rn;

import com.senac.bean.Funcionario;
import com.senac.db.FuncionarioDB;
import com.senac.util.CrudGenerico;
import java.util.List;

public class FuncionarioRN implements CrudGenerico<Funcionario>{

    private FuncionarioDB funcionarioDB;
    private String confirmaSenha;

    public FuncionarioRN() {
        this.funcionarioDB = new FuncionarioDB();
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        if(funcionario.getNome() == null || "".equals(funcionario.getNome())) {
            throw new RuntimeException("Campo Nome obrigatório!");
        }
        
        if(funcionario.getSobrenome() == null || "".equals(funcionario.getSobrenome())) {
            throw new RuntimeException("Campo Sobrenome obrigatório!");
        }
        
        if(funcionario.getEmail() == null || "".equals(funcionario.getEmail())) {
            throw new RuntimeException("Campo Email obrigatório!");
        }
        
        if(funcionario.getCpf() == null || "".equals(funcionario.getCpf())) {
            throw new RuntimeException("Campo CPF obrigatório!");
        }
        
        if(funcionario.getSenha() == null || "".equals(funcionario.getSenha())) {
            throw new RuntimeException("Campo Senha obrigatório!");
        }
        
        if(this.getConfirmaSenha() == null || "".equals(this.getConfirmaSenha())) {
            throw new RuntimeException("Campo Confirmar Senha obrigatório!");
        }
        
        if(!funcionario.getSenha().equals(this.confirmaSenha)) {
            throw new RuntimeException("As senhas não coincidem!");
        }
        
        this.funcionarioDB.salvar(funcionario);
    }

    @Override
    public void excluir(Funcionario funcionario) {
        this.funcionarioDB.excluir(funcionario);
    }
    
    @Override
    public List<Funcionario> listar(Funcionario funcionario) {
        return this.funcionarioDB.listar(funcionario);
    }

    @Override
    public Funcionario consultar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
