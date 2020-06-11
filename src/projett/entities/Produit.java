package projett.entities;

import java.util.Objects;

    public class Produit {

    private int idp; 
    private String nom;
    private String description;
    private int prix; 
    private int quantite;
    private int categorie;
    private String nomfile ;
    private Promotion promotion;
    
    public Produit(int id, String nom, int prix, String description, int quantite,String nomfile) {
        this.idp = id;
        this.nom = nom;
        this.prix = prix;
        this.description= description;
        this.quantite= quantite;
        this.nomfile=nomfile;
    }

    @Override
    public String toString() {
        return "Produit{" + "idp=" + idp + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite +  '}';
    }

    public String getNomfile() {
        return nomfile;
    }

    public void setNomfile(String nomfile) {
        this.nomfile = nomfile;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
    
    public Produit(String nom, int prix, String description, int quantite) {
        //this.idp = id;
        this.nom = nom;
        this.prix = prix;
        this.description= description;
        this.quantite= quantite;
    }
    
    public Produit (){}

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getIdP() {
        return idp;
    }

    public void setIdP(int id) {
        this.idp = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String libelle) {
        this.nom = libelle;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idp;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Float.floatToIntBits(this.prix);
        hash = 97 * hash + this.quantite;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.idp != other.idp) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNomFile() {
        return nomfile;
    }

    public void setNomFile(String image) {
        this.nomfile = image;
    }

    public Produit(String nom, String description, int prix, int quantite, int categorie, String image) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
        this.nomfile = image;
    }
    
    
}