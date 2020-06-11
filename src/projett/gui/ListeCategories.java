/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import projett.services.*;
import projett.entities.*;

import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.util.List;

/**
 *
 * @author elee
 */
public class ListeCategories extends BaseForm{
    
    
    
     public ListeCategories() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
     @Override
    protected boolean isCurrentCategories() {
        return true;
    }
     
    public ListeCategories(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
       
        
        installSidemenu(resourceObjectInstance);
        
    }
    
     private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
         setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Catégories");
        setName("Catégories");
        addComponent(gui_Container_1);
        ServicesCategorie sCategorie=ServicesCategorie.getInstance();
        List<Categorie> listCategories= sCategorie.AfficheCategories();
        
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
       /* Label titre=new Label("Categories");
        Font mediumPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        titre.getAllStyles().setFont(mediumPlainSystemFont);
        titre.getAllStyles().setMarginLeft(314);
        gui_Container_3.add(titre);*/
        Image imgCollection = resourceObjectInstance.getImage("collection.jpg").fill(1000, 1000);
        com.codename1.ui.Container gui_Container_image = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        gui_Container_image.add(imgCollection);
        gui_Container_3.addComponent(gui_Container_image);
        gui_Container_image.getAllStyles().setMarginLeft(60);
        for(Categorie cat : listCategories){
            Button lb=new Button(cat.getNom());
            gui_Container_3.addComponent(lb);
            lb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    //Dialog.show("salut", cat.getNom(), new Command("Ok")); 
                    ListProduits lproduits=new ListProduits(cat.getId());
                    lproduits.show();
                }
            });
         
        }
        
    }

}
