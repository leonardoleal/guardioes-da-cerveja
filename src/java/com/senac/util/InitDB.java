/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.util;

import com.senac.bean.Pais;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "InitDB", urlPatterns = {"/InitDB"}, loadOnStartup = 1)
public class InitDB extends HttpServlet {

    public InitDB() throws ServletException {
        super.init();
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("guiadoservico7PU");
            EntityManager em = emf.createEntityManager();
            
//            Pais p = new Pais();
//            p.setNome("Brasil");
            
            em.getTransaction().begin();
//            em.merge(p);
            em.getTransaction().commit();
            
            em.close();
            
            System.out.println(">>>> Transação concluída. <<<<");
            
        } catch (Exception e) {
            throw new RuntimeException("Falha ao  inserir os registros.");
        }
    }
}
