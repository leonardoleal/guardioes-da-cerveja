package com.senac.mb;

import com.senac.bean.Pais;
import com.senac.rn.PaisRN;
import com.senac.util.Mensagem;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ManagedBean
@RequestScoped
public class PaisMB {

    private Pais pais;
    private PaisRN paisRN;
    
    public PaisMB() {
        this.pais = new Pais();
        this.paisRN = new PaisRN();
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> listar() {
        return this.paisRN.listar(null);
    }

    public void editar(Pais pais) {
        this.pais = pais;
    }

    public String salvar() {
        try {
            this.paisRN.salvar(this.pais);
            Mensagem.add("Registro salvo com sucesso!");
            return "/pais/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String excluir(Pais pais) {
        try {
            this.paisRN.excluir(pais);
            Mensagem.add("Operação executada com sucesso!");
            return "/pais/listar";
        } catch(Exception e) {
            Mensagem.error(e.getMessage());
        }
        return null;
    }

    public String pesquisar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void limpar() {
        this.pais = new Pais();
    }

    public List<Pais> wsClientPaisListar() {
        List<Pais> paises = new ArrayList<Pais>();
        String url  = "http://services.groupkt.com/country/get/all";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response retorno = target.request(MediaType.APPLICATION_JSON).get();

        JsonReader reader = Json.createReader(
                new StringReader(retorno.readEntity(String.class))
        );
        
        JsonObject json = reader.readObject();
        json = json.getJsonObject("RestResponse");
        JsonArray jsonA = json.getJsonArray("result");
        
        for (int i = 0; i < jsonA.size(); i++) {
            JsonObject jpais = jsonA.getJsonObject(i);
            Pais pa = new Pais();
            pa.setNome(jpais.getString("name"));
            paises.add(pa);
        }
        return paises;
    }
}
