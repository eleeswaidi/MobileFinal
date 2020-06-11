/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import java.util.List;
import projett.entities.Categorie;
import projett.entities.Produit;
import projett.entities.Wishlist;
import projett.services.ServicesCategorie;
import projett.services.ServicesProduit;

/**
 *
 * @author ramij
 */
public class ListeProduitParPromotion extends BaseForm {

    public ListeProduitParPromotion() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentPromotions() {
        return true;
    }

    public ListeProduitParPromotion(com.codename1.ui.util.Resources resourceObjectInstance) {
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
        ServicesCategorie sCategorie = ServicesCategorie.getInstance();
        List<Categorie> listCategories = sCategorie.AfficheCategories();

        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);

        ServicesProduit pdao = ServicesProduit.getInstance();
        List<Produit> pd = pdao.AfficheProduit();
        List<Double> listpromo = new ArrayList();

        for (Produit p : pd) {
            if (p.getPromotion().getValeur() >= 0) {
                if (!listpromo.contains(p.getPromotion().getValeur())) {
                    listpromo.add(p.getPromotion().getValeur());
                }

            }
        }

        for (Double promo : listpromo) {
            Label l = new Label("promotion " + promo + "%");
            l.getAllStyles().setFgColor(0x32CD32);
             Font mediumPlainSystemFont2 = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
            l.getAllStyles().setFont(mediumPlainSystemFont2);
            gui_Container_3.addComponent(l);
            for (Produit produit : pd) {
                if (produit.getPromotion().getValeur() >= 0) {
                    if (produit.getPromotion().getValeur() == promo) {
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

                        gui_Container_3.addComponent(containerProduit);

                    }
                }
            }
        }

    }

}
