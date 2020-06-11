/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.entities;

import java.util.Date;


public class Promotion {
    private int	id;

     private   Date dateDebut;
     private  Date  dateFin;
     private double   valeur;
     private int produit;

     
    public Promotion(int id,int produit, Date dateDebut, Date dateFin, double valeur) {
        this.id = id;
      
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.valeur = valeur;
        this.produit = produit;
                }

    public Promotion(Date dateDebut, Date dateFin, int valeur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.valeur = valeur;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public Promotion() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", valeur=" + valeur + ", produit=" + produit + '}';
    }

  

    public void setId(int id) {
        this.id = id;
    }

    

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Promotion(int id, Date dateDebut, Date dateFin, double valeur) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.valeur = valeur;
    }
     
     
}
