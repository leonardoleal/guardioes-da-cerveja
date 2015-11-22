package com.senac.mb;

import com.senac.bean.Produto;
import com.senac.rn.ProdutoRN;
import com.senac.util.Mensagem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProdutoMB {

    private Produto produto;
    private ProdutoRN produtoRN;
    
    public ProdutoMB() {
        this.produto = new Produto();
        this.produtoRN = new ProdutoRN();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getConfirmaSenha() {
        return "";
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.produtoRN.setConfirmaSenha(confirmaSenha);
    }

    public List<Produto> listar() {
        return this.produtoRN.listar(null);
    }

    public void editar(Produto produto) {
        this.produto = produto;
    }

    public String salvar() {
        try {
            this.produtoRN.salvar(this.produto);
            Mensagem.add("Registro salvo com sucesso!");
            return "/produto/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Produto produto) {
        try {
            this.produtoRN.excluir(produto);
            Mensagem.add("Operação executada com sucesso!");
            return "/produto/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.produto = new Produto();
    }
}
