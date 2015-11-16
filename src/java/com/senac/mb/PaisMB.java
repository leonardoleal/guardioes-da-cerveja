/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.mb;

import com.senac.bean.Pais;
import com.senac.rn.PaisRN;
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
public class PaisMB {

    private Pais pais;
    private PaisRN paisRN;
    
    public PaisMB() {
        this.pais = new Pais();
        this.paisRN = new PaisRN();
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> listar() {
        return this.paisRN.listar(null);
    }

    public void editar(Pais pais) {
        this.pais = pais;
    }

    public String salvar() {
        try {
            this.paisRN.salvar(this.pais);
            Mensagem.add("Registro salvo com sucesso!");
            return "/pais/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Pais pais) {
        try {
            this.paisRN.excluir(pais);
            Mensagem.add("Operação executada com sucesso!");
            return "/pais/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.pais = new Pais();
    }
}
