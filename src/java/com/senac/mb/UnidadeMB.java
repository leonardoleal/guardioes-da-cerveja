/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.mb;

import com.senac.bean.Unidade;
import com.senac.rn.UnidadeRN;
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
public class UnidadeMB {

    private Unidade unidade;
    private UnidadeRN unidadeRN;
    
    public UnidadeMB() {
        this.unidade = new Unidade();
        this.unidadeRN = new UnidadeRN();
    }

    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> listar() {
        return this.unidadeRN.listar(null);
    }

    public void editar(Unidade unidade) {
        this.unidade = unidade;
    }

    public String salvar() {
        try {
            this.unidadeRN.salvar(this.unidade);
            Mensagem.add("Registro salvo com sucesso!");
            return "/unidade/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Unidade unidade) {
        try {
            this.unidadeRN.excluir(unidade);
            Mensagem.add("Operação executada com sucesso!");
            return "/unidade/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.unidade = new Unidade();
    }
}
