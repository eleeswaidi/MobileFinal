/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import projett.entities.*;
import projett.utils.Statics;

/**
 *
 * @author elee
 */
public class ServicesProduit {

    public String result = "";
    public static ServicesProduit instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    public ArrayList<Produit> produits;

    private ServicesProduit() {
        req = new ConnectionRequest();
    }

    public static ServicesProduit getInstance() {
        if (instance == null) {
            instance = new ServicesProduit();
        }
        return instance;
    }

    public ArrayList<Produit> AfficheProduit(int idCat) {
        String url = Statics.BASE_URL + "AfficheProduitById/" + idCat;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }

    public ArrayList<Produit> AfficheProduit() {
        String url = Statics.BASE_URL + "AfficheProduitAll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }

    public ArrayList<Produit> parseProduit(String jsonText) {
        try {
            produits = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Produit p = new Produit();
                float id = Float.parseFloat(obj.get("id").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                float quantite = Float.parseFloat(obj.get("quantite").toString());
                p.setIdp((int) id);
                p.setQuantite((int) quantite);
                p.setNom(obj.get("nom").toString());
                p.setDescription(obj.get("description").toString());
                p.setNomFile(obj.get("nomfile").toString());
                p.setPrix((int) prix);
                float valeurpromotion = Float.parseFloat(obj.get("promotion").toString());
                Promotion promotion = new Promotion();
                promotion.setValeur(valeurpromotion);
                p.setPromotion(promotion);
                produits.add(p);

            }

        } catch (IOException ex) {

        }
        return produits;
    }

}
