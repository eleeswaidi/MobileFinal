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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import projett.entities.*;
import projett.entities.*;
import projett.utils.Statics;
import java.io.IOException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ServicesCategorie {

    public ArrayList<Categorie> categoriesCp;
    public String result = "";
    public static ServicesCategorie instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    public ArrayList<Categorie> categories;

    private ServicesCategorie() {
        req = new ConnectionRequest();
    }

    public static ServicesCategorie getInstance() {
        if (instance == null) {
            instance = new ServicesCategorie();
        }
        return instance;
    }

    public ArrayList<Categorie> AfficheCategories() {
        String url = Statics.BASE_URL + "AfficheCategoriesMobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categoriesCp = parseCategorieCP(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categoriesCp;
    }

    public ArrayList<Categorie> parseCategorieCP(String jsonText) {
        try {
            categories = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Categorie t = new Categorie();
                float id = Float.parseFloat(obj.get("id").toString());
                float countpromo = Float.parseFloat(obj.get("countPromo").toString());
                t.setId((int) id);
                t.setCountpromo((int)countpromo);
                t.setNom(obj.get("nom").toString());
                categories.add(t);
            }

        } catch (IOException ex) {

        }
        return categories;
    }
    public boolean deleteCategorie (int id) {
        String url = Statics.BASE_URL + "SupprimerCategoriesMobile/"+id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
    

}
