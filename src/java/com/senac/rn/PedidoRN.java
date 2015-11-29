package com.senac.rn;

import com.senac.bean.Pedido;
import com.senac.db.PedidoDB;
import com.senac.mb.SessionMB;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.jws.WebService;

@WebService
public class PedidoRN implements CrudGenerico<Pedido>{

    private PedidoDB pedidoDB;

    public PedidoRN() {
        this.pedidoDB = new PedidoDB();
    }

    @Override
    public void salvar(Pedido pedido) {
        if(pedido.getData() == null) {
            throw new RuntimeException("Campo Data é obrigatório!");
        }
        
        if(pedido.getCliente() == null) {
            throw new RuntimeException("Campo Cliente é obrigatório!");
        }
        
        if(pedido.getProdutoPedido().size() > 0) {
            throw new RuntimeException("É obrigatório ter produtos no pedido!");
        }

        SessionMB sessao = new SessionMB();
        pedido.setFuncionario(sessao.getUsuarioLogado());
        
        this.pedidoDB.salvar(pedido);
    }

    @Override
    public void excluir(Pedido pedido) {
        this.pedidoDB.excluir(pedido);
    }
    
    @Override
    public List<Pedido> listar(Pedido pedido) {
        return this.pedidoDB.listar(pedido);
    }

    @Override
    public Pedido consultar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
