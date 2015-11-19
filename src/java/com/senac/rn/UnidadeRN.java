package com.senac.rn;

import com.senac.bean.Unidade;
import com.senac.db.UnidadeDB;
import com.senac.util.CrudGenerico;
import java.util.List;

public class UnidadeRN implements CrudGenerico<Unidade>{

    private UnidadeDB unidadeDB;

    public UnidadeRN() {
        this.unidadeDB = new UnidadeDB();
    }

    @Override
    public void salvar(Unidade unidade) {
        if(unidade.getDescricao() == null || "".equals(unidade.getDescricao())) {
            throw new RuntimeException("Campo Descrição obrigatório!");
        }
        
        this.unidadeDB.salvar(unidade);
    }

    @Override
    public void excluir(Unidade unidade) {
        this.unidadeDB.excluir(unidade);
    }
    
    @Override
    public List<Unidade> listar(Unidade unidade) {
        return this.unidadeDB.listar(unidade);
    }

    @Override
    public Unidade consultar(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
