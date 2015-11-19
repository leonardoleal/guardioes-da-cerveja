package com.senac.rn;

import com.senac.bean.Cliente;
import com.senac.db.ClienteDB;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.jws.WebService;

@WebService
public class ClienteRN implements CrudGenerico<Cliente>{

    private ClienteDB clienteDB;

    public ClienteRN() {
        this.clienteDB = new ClienteDB();
    }

    @Override
    public void salvar(Cliente cliente) {
        if(cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new RuntimeException("Campo Nome obrigatório!");
        }
        
        if(cliente.getSobrenome() == null || "".equals(cliente.getSobrenome())) {
            throw new RuntimeException("Campo Sobrenome obrigatório!");
        }
        
        if(cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new RuntimeException("Campo Email obrigatório!");
        }
        
        if(cliente.getCpf() == null || "".equals(cliente.getCpf())) {
            throw new RuntimeException("Campo CPF obrigatório!");
        }
        
        this.clienteDB.salvar(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        this.clienteDB.excluir(cliente);
    }
    
    @Override
    public List<Cliente> listar(Cliente cliente) {
        return this.clienteDB.listar(cliente);
    }

    @Override
    public Cliente consultar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
