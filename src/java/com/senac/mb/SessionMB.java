/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.mb;

import com.senac.bean.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author leonardo
 */
@ManagedBean
@SessionScoped
public class SessionMB {
    private boolean logado;
    private Funcionario usuario;

    /**
     * Creates a new instance of SessionMB
     */
    public SessionMB() {
        this.logado = false;
        this.usuario = new Funcionario();
        this.usuario.setNome("Joao Silva");
    }

    public void setUsuario(String usuario) {
        this.usuario.setCpf(usuario);
    }
    
    public String getUsuario() {
        return this.usuario.getCpf();
    }
    
    public void setSenha(String senha) {
        this.usuario.setSenha(senha);
    }
    
    public String getSenha() {
        return this.usuario.getSenha();
    }
 
    public Funcionario getUsuarioLogado() {
        return this.usuario;
    }

    public boolean isLogado() {
        if(this.logado) {
            return true;
        } else {
            this.deslogar();
            return false;
        }
    }

    public String validarLogin() {
        if ("123456".equals(this.usuario.getCpf())
            && "123456".equals(this.usuario.getSenha())) {
                this.logado = true;
                return "template";
        } else {
            this.logado = false;
            FacesContext.getCurrentInstance().addMessage(
                    "formLogin"
                    , new FacesMessage("Senha ou usuario invalido.")
            );
            return null;
        }
    }

    public void deslogar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GDC/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
