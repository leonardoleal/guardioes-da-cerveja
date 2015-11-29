package com.senac.mb;

import com.senac.bean.Pedido;
import com.senac.bean.ProdutoPedido;
import com.senac.rn.PedidoRN;
import com.senac.util.Mensagem;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PedidoMB {

    private Pedido pedido;
    private PedidoRN pedidoRN;
    
    public PedidoMB() {
        this.pedido = new Pedido();
        this.pedidoRN = new PedidoRN();
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> listar() {
        return this.pedidoRN.listar(null);
    }

    public void editar(Pedido pedido) {
        this.pedido = pedido;
    }

    public String salvar() {
        try {
            this.pedidoRN.salvar(this.pedido);
            Mensagem.add("Registro salvo com sucesso!");
            return "/pedido/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Pedido pedido) {
        try {
            this.pedidoRN.excluir(pedido);
            Mensagem.add("Operação executada com sucesso!");
            return "/pedido/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.pedido = new Pedido();
    }

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal subTotal = BigDecimal.ZERO;
        
        for(ProdutoPedido p : pedido.getProdutoPedido()) {
            subTotal = p.getValorProduto().multiply(new BigDecimal(p.getQuantidade()));
            total = total.add(subTotal);
        }
        return total;
    }
}
