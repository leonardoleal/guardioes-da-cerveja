/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.rn;

import com.senac.bean.Pais;
import com.senac.db.PaisDB;
import com.senac.util.CrudGenerico;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class PaisRN implements CrudGenerico<Pais>{

    private PaisDB paisDB;

    public PaisRN() {
        this.paisDB = new PaisDB();
    }

    @Override
    public void salvar(Pais pais) {
        if(pais.getNome() == null || "".equals(pais.getNome())) {
            throw new RuntimeException("Campo Nome obrigatório!");
        }
        
        this.paisDB.salvar(pais);
    }

    @Override
    public void excluir(Pais pais) {
        this.paisDB.excluir(pais);
    }
    
    @Override
    public List<Pais> listar(Pais pais) {
        return this.paisDB.listar(pais);
    }

    @Override
    public Pais consultar(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
