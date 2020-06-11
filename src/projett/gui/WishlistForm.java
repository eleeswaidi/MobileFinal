/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;
import java.util.List;
import projett.entities.Produit;
import projett.entities.Wishlist;

/**
 *
 * @author Lou44
 */
public class WishlistForm extends BaseForm {

    public WishlistForm(Form previous) {
        
        setTitle("My wishlist" + "(" + Wishlist.getInstance().wl.size() + ")");
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

//         Toolbar.setGlobalToolbar(true);
//Style s = UIManager.getInstance().getComponentStyle("Title");
//
//
//TextField searchField = new TextField("", "Toolbar Search"); // <1>
//searchField.getHintLabel().setUIID("Title");
//searchField.setUIID("Title");
//searchField.getAllStyles().setAlignment(Component.LEFT);
//getToolbar().setTitleComponent(searchField);
//FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
//searchField.addDataChangeListener((i1, i2) -> { // <2>
//    String t = searchField.getText();
//    if(t.length() < 1) {
//        for(Component cmp : getContentPane()) {
//            cmp.setHidden(false);
//            cmp.setVisible(true);
//        }
//    } else {
//        t = t.toLowerCase();
//        for(Component cmp : getContentPane()) {
//            String val = null;
//            
//            if(cmp instanceof Label) {
//                val = ((Label)cmp).getText();
//            } else {
//                
//                    val = (String)cmp.getPropertyValue("text");
//                
//            }
//            boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
//            cmp.setHidden(!show); // <3>
//            cmp.setVisible(show);
//        }
//    }
//    getContentPane().animateLayout(250);
//});
//getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
//    searchField.startEditingAsync(); // <4>
//});
        getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : getContentPane()) {
                    String val = null;
                    
                    if (cmp instanceof Label) {
                        val = ((Label) cmp).getText();
                    } else {
                        
                        val = (String) cmp.getPropertyValue("text");
                        
                    }
                    boolean show = val != null && val.toLowerCase().indexOf(text) > -1;
                    cmp.setHidden(!show);
                    cmp.setVisible(show);
                }
                getContentPane().animateLayout(150);
            }
        }, 4);
        
        com.codename1.ui.TextArea gui_Text_Area_11 = new com.codename1.ui.TextArea();
        addComponent(gui_Text_Area_11);
        if (Wishlist.getInstance().wl.size() == 1) {
            gui_Text_Area_11.setText(Wishlist.getInstance().wl.size() + " produit dans votre wishlist ");
            gui_Text_Area_11.setUIID("SmallFontLabel");
            gui_Text_Area_11.setName("Text_Area_1");
        } else {
            gui_Text_Area_11.setText(Wishlist.getInstance().wl.size() + " produits dans votre wishlist ");
            gui_Text_Area_11.setUIID("SmallFontLabel");
            gui_Text_Area_11.setName("Text_Area_1");
        }
        
        com.codename1.ui.TextArea gui_Text_Area_111 = new com.codename1.ui.TextArea();
        addComponent(gui_Text_Area_111);
        gui_Text_Area_111.setText("Total : " + Double.toString(Wishlist.getInstance().total()) + " Dt");
        gui_Text_Area_111.setUIID("SmallFontLabel");
        gui_Text_Area_111.setName("Text_Area_1");
        Font mediumPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
        gui_Text_Area_111.getAllStyles().setFont(mediumPlainSystemFont);
        gui_Text_Area_11.getAllStyles().setFont(mediumPlainSystemFont);
        for (int i = 0; i < Wishlist.getInstance().wl.size(); i++) {
//             com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//             com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//             com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
            com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
//             com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
            com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
//             com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
//             com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
            
            gui_Label_2.setText("---------------------------------------------------------------------------");
            gui_Label_2.setUIID("SmallFontLabel");
            gui_Label_2.setName("Text_Area_1");
            addComponent(gui_Label_2);
//        addComponent(gui_Container_1);
//        
//        gui_Container_1.setName("Container_1");
//        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
//        gui_Container_2.setName("Container_2");
//        gui_Container_2.addComponent(gui_Label_1);
//        gui_Label_1.setText("");
//        gui_Label_1.setUIID("SmallFontLabel");
//        gui_Label_1.setName("Label_1");
//        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Container_4.setName("Container_4");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_4.addComponent(gui_Label_4);
            //gui_Label_4.setUIID("Padding2");
            gui_Label_4.setName("Label_4");
            //gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
            gui_Label_4.setText("X");
//        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
//        gui_Container_3.setName("Container_3");
//        gui_Container_3.addComponent(gui_Label_3);
//        gui_Container_3.addComponent(gui_Label_2);
//        gui_Container_3.addComponent(gui_Text_Area_1);
            
            gui_Label_3.setText(Wishlist.getInstance().wl.get(i).getNom());
            gui_Label_3.setName("Label_3");
            addComponent(gui_Label_3);
            //gui_Label_2.setText(Double.toString(ServiceProduit.getInstance().getAllProducts().get(i).getPrix_vente()) + "Dt");
//        gui_Label_2.setUIID("RedLabel");
//        gui_Label_2.setName("Label_2");
            //gui_Text_Area_1.setText(ServiceProduit.getInstance().getAllProducts().get(i).getDescription());
//        gui_Text_Area_1.setUIID("SmallFontLabel");
//        gui_Text_Area_1.setName("Text_Area_1");
//        gui_Container_2.setName("Container_2");
            gui_Container_4.setName("Container_4");
            addComponent(gui_Container_4);

//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_3.setName("Container_3");
//        addComponent(gui_Label_6);
//        gui_Container_1.setName("Container_1");
//            gui_Label_6.setText("");
//            gui_Label_6.setUIID("Separator");
//            gui_Label_6.setName("Label_6");
            Button btn = new Button();
            btn.addActionListener((ActionListener) (ActionEvent e)
                    -> {
                if (Dialog.show("Suppression", "Voulez vous vraiment supprimer le produit du wishlist", "Ok", "Cancel")) {
                    
                    Produit p = new Produit();
                    p.setNom(gui_Label_3.getText());
                    int indexx = -1;
                    for (int d = 0; d < Wishlist.getInstance().wl.size(); d++) {
                        if (p.getNom().equals(Wishlist.getInstance().wl.get(d).getNom())) {
                            indexx = d;                            
                        }
                    }
                    Wishlist.getInstance().wl.remove(indexx);
                    System.out.println(Wishlist.getInstance().toString());
                    new WishlistForm(previous).show();
                }
            });
            
            gui_Container_4.setLeadComponent(btn);
            
        }
    }
    
}
