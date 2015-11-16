/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.mb;

import com.senac.bean.Cliente;
import com.senac.rn.ClienteRN;
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
public class ClienteMB {

    private Cliente cliente;
    private ClienteRN clienteRN;
    
    public ClienteMB() {
        this.cliente = new Cliente();
        this.clienteRN = new ClienteRN();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> listar() {
        return this.clienteRN.listar(null);
    }

    public void editar(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() {
        try {
            this.clienteRN.salvar(this.cliente);
            Mensagem.add("Registro salvo com sucesso!");
            return "/cliente/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Cliente cliente) {
        try {
            this.clienteRN.excluir(cliente);
            Mensagem.add("Operação executada com sucesso!");
            return "/cliente/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.cliente = new Cliente();
    }
}
