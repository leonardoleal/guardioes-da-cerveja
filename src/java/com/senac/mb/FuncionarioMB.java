/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.mb;

import com.senac.bean.Funcionario;
import com.senac.rn.FuncionarioRN;
import com.senac.util.Mensagem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author leonardo
 */
@ManagedBean
@RequestScoped
public class FuncionarioMB {

    private Funcionario funcionario;
    private FuncionarioRN funcionarioRN;
    
    public FuncionarioMB() {
        this.funcionario = new Funcionario();
        this.funcionarioRN = new FuncionarioRN();
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getConfirmaSenha() {
        return "";
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.funcionarioRN.setConfirmaSenha(confirmaSenha);
    }

    public List<Funcionario> listar() {
        return this.funcionarioRN.listar(null);
    }

    public void editar(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String salvar() {
        try {
            this.funcionarioRN.salvar(this.funcionario);
            Mensagem.add("Registro salvo com sucesso!");
            return "/funcionario/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Funcionario funcionario) {
        try {
            this.funcionarioRN.excluir(funcionario);
            Mensagem.add("Operação executada com sucesso!");
            return "/funcionario/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.funcionario = new Funcionario();
    }
}
