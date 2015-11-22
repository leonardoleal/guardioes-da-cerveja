package com.senac.rn;

import com.senac.bean.Produto;
import com.senac.db.ProdutoDB;
import com.senac.util.CrudGenerico;
import java.util.List;

public class ProdutoRN implements CrudGenerico<Produto>{

    private ProdutoDB produtoDB;
    private String confirmaSenha;

    public ProdutoRN() {
        this.produtoDB = new ProdutoDB();
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public void salvar(Produto produto) {
        if(produto.getNome() == null || "".equals(produto.getNome())) {
            throw new RuntimeException("Campo Nome obrigatório!");
        }
        
        if(produto.getValor() == null || "".equals(produto.getValor())) {
            throw new RuntimeException("Campo Valor obrigatório!");
        }
        
        if(produto.getDescricao() == null || "".equals(produto.getDescricao())) {
            throw new RuntimeException("Campo Descrição obrigatório!");
        }
        
        if(produto.getPais() == null || produto.getPais().getIdPais() < 0) {
            throw new RuntimeException("Campo País obrigatório!");
        }
        
        if(produto.getUnidade() == null || produto.getUnidade().getIdUnidade() < 0) {
            throw new RuntimeException("Campo Unidade obrigatório!");
        }
        
        this.produtoDB.salvar(produto);
    }

    @Override
    public void excluir(Produto produto) {
        this.produtoDB.excluir(produto);
    }
    
    @Override
    public List<Produto> listar(Produto produto) {
        return this.produtoDB.listar(produto);
    }

    @Override
    public Produto consultar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
