/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett.entities;

import java.util.Objects;

/**
 *
 * @author elee
 */
public class Categorie { 
    
    private int id; 
    private String nom; 
    private int countpromo;
    
    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public int getCountpromo() {
        return countpromo;
    }

    public void setCountpromo(int countpromo) {
        this.countpromo = countpromo;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nom);
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
        final Categorie other = (Categorie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
    
    public Categorie (){}

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
   
    
    
    
}
