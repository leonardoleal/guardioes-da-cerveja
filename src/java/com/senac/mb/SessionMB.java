package com.senac.mb;

import com.senac.bean.Funcionario;
import com.senac.db.FuncionarioDB;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    }

    public void setUsuario(String usuario) {
        this.usuario.setCpf(usuario);
    }
    
    public String getUsuario() {
        return this.usuario.getCpf();
    }

    public void setNome(String nome) {
        this.usuario.setNome(nome);
    }
    
    public String getNome() {
        return this.usuario.getNome();
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

    // @TODO Validar no Banco
    public String validarLogin() {
        FuncionarioDB funcionarioDB = new FuncionarioDB();
        List<Funcionario> funcionarios = funcionarioDB.consultarCPFeSenha(this.usuario);

        if ( !funcionarios.isEmpty() ) {
            this.usuario.setNome(funcionarios.get(0).getNome());
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
