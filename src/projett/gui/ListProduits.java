/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;
import projett.entities.Categorie;
import projett.entities.Produit;
import projett.entities.Wishlist;
import projett.services.ServicesCategorie;
import projett.services.ServicesProduit;

/**
 *
 * @author elee
 */
public class ListProduits extends BaseForm {
    Form current = this;
    public ListProduits(int idCategorie) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), idCategorie);
    }

    public ListProduits(com.codename1.ui.util.Resources resourceObjectInstance, int idCategorie) {
        this.idCategorie = idCategorie;
        initGuiBuilderComponents(resourceObjectInstance);

        installSidemenu(resourceObjectInstance);

    }

    int idCategorie;
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Produits");
        setName("ProduitsForm");

        addComponent(gui_Container_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);

        ServicesProduit servproduits = ServicesProduit.getInstance();
        List<Produit> produits = servproduits.AfficheProduit(idCategorie);

        for (Produit produit : produits) {
            Container containerProduit = new com.codename1.ui.Container(BoxLayout.y());

            //
            EncodedImage placeholder = EncodedImage.createFromImage(resourceObjectInstance.getImage(produit.getNomFile()), true);
            URLImage background = URLImage.createToStorage(placeholder, "http://localhost/PI-DEV-PROD/web/photos/" + produit.getNomFile(), "http://localhost/PI-DEV-PROD/web/photos/" + produit.getNomFile(), URLImage.RESIZE_SCALE
            );

            background.fetch();

            ImageViewer img = new ImageViewer(background);
            //

            Label nomImage = new Label(produit.getNomFile());
            Label nomproduit = new Label(produit.getNom());
            Label description = new Label(produit.getDescription());
            nomproduit.setText(produit.getNom());
            Label prix = new Label(Integer.toString(produit.getPrix()) + "Dt");
            Font mediumPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
            prix.getAllStyles().setFont(mediumPlainSystemFont);
            nomproduit.getAllStyles().setFont(mediumPlainSystemFont);
            description.getAllStyles().setFont(mediumPlainSystemFont);
            containerProduit.addComponent(img);
            containerProduit.addComponent(nomproduit);
            containerProduit.addComponent(description);
            containerProduit.addComponent(prix);
            Button btn = new Button("Ajouter à wishlist!");
            containerProduit.addComponent(btn);
            
            
            btn.addActionListener((ActionListener) (ActionEvent e)
                -> {

            Produit p = new Produit();
            p.setNom(nomproduit.getText());
            p.setPrix(produit.getPrix());
            if (Wishlist.getInstance().ajouter(p)) {

                System.out.println(Wishlist.getInstance().toString());
                new WishlistForm(current).show();
                
            } else {
                Dialog.show("Verification", "Ce produit existe déja dans votre wishlist ", new Command("Ok"));
            }

        });

            
            if (produit.getPromotion().getValeur() >= 0) {
                prix.getAllStyles().setStrikeThru(true);
                prix.getAllStyles().setFgColor(0x8B0000);
                float promo = (float) (produit.getPrix() - ((produit.getPrix() * produit.getPromotion().getValeur()) / 100));
                Label prom = new Label(Float.toString(promo) + "Dt");
                containerProduit.addComponent(prom);
            }

            gui_Container_3.addComponent(containerProduit);

        }

    }
}
