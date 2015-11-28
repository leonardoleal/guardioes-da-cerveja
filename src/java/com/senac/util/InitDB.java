package com.senac.util;

import com.senac.bean.Cliente;
import com.senac.bean.Funcionario;
import com.senac.bean.Pais;
import com.senac.bean.Pedido;
import com.senac.bean.Produto;
import com.senac.bean.ProdutoPedido;
import com.senac.db.ClienteDB;
import com.senac.db.FuncionarioDB;
import com.senac.db.ProdutoDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "InitDB", urlPatterns = {"/InitDB"}, loadOnStartup = 1)
public class InitDB extends HttpServlet {

    public InitDB() throws ServletException {
        super.init();
        
        try {
            
//            this.testInserePais();
//            this.testInserePedido();
            
            System.out.println(">>>> Transação concluída. <<<<");
            
        } catch (Exception e) {
            throw new RuntimeException("Falha ao  inserir os registros.");
        }
    }
    
    public void testInserePais() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
            EntityManager em = emf.createEntityManager();
            
            Pais p = new Pais();
            p.setNome("Brasil");
            
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            
            em.close();
    }
    
    public void testInserePedido() {
         FuncionarioDB fd= new FuncionarioDB();
            List<Funcionario> fc = fd.listar(new Funcionario());
            Funcionario funcionario = fc.get(0);
            
            ClienteDB cd= new ClienteDB();
            List<Cliente> cc = cd.listar(new Cliente());
            Cliente cliente = cc.get(0);
            
            ProdutoDB pd= new ProdutoDB();
            List<Produto> pc = pd.listar(new Produto());
            Produto produto = pc.get(0);

            Pedido pedido = new Pedido();
//            pedido.setIdPedido(1);
            pedido.setData(new Date());  
            pedido.setFuncionario(funcionario);
            pedido.setCliente(cliente);

            Collection<ProdutoPedido> produtosPedido = new ArrayList<ProdutoPedido>();
            ProdutoPedido produtoPedido = null;

            produtoPedido = new ProdutoPedido();
            produtoPedido.setProduto(produto);
            produtoPedido.setPedido(pedido);
            produtoPedido.setQuantidade(10);
            produtosPedido.add(produtoPedido);
            
            produtoPedido = new ProdutoPedido();
            produtoPedido.setProduto(produto);
            produtoPedido.setPedido(pedido);
            produtoPedido.setQuantidade(9);
            produtosPedido.add(produtoPedido);

            produtoPedido = new ProdutoPedido();
            produtoPedido.setProduto(produto);
            produtoPedido.setPedido(pedido);
            produtoPedido.setQuantidade(8);
            produtosPedido.add(produtoPedido);

            pedido.setProdutoPedido(produtosPedido);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist( pedido );
            em.getTransaction().commit();


            em.close();

            em = emf.createEntityManager();
            Cliente clienteDoBanco = em.find( Cliente.class, cliente.getIdCliente());
            System.out.println(
                "A quantidade de pedidos deve ser maior do que zero =>" + clienteDoBanco.getPedidoCollection().size());
            em.close();
    }
}
