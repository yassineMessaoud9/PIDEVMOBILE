/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.myapp.entities;

/**
 *
 * @author Gamer
 */
public class Adresse {
     private int idadresse ;
 private String paysadresse;
 private String rueadresse;
 private int contactadresse;
   
    public Adresse(int idadresse, String paysadresse, String rueadresse, int contactadresse) {
        this.idadresse = idadresse;
        this.paysadresse = paysadresse;
        this.rueadresse = rueadresse;
        this.contactadresse = contactadresse;
    }

    public Adresse(String paysadresse, String rueadresse, int contactadresse) {
        this.paysadresse = paysadresse;
        this.rueadresse = rueadresse;
        this.contactadresse = contactadresse;
    }

    public Adresse() {
    }

    public Adresse(int idadresse) {
        this.idadresse = idadresse;
    }
    

    public int getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(int idadresse) {
        this.idadresse = idadresse;
    }

    public String getPaysadresse() {
        return paysadresse;
    }

    public void setPaysadresse(String paysadresse) {
        this.paysadresse = paysadresse;
    }

    public String getRueadresse() {
        return rueadresse;
    }

    public void setRueadresse(String rueadresse) {
        this.rueadresse = rueadresse;
    }

    public int getContactadresse() {
        return contactadresse;
    }

    public void setContactadresse(int contactadresse) {
        this.contactadresse = contactadresse;
    }

    @Override
    public String toString() {
        return "adresse{" + "idadresse=" + idadresse + ", paysadresse=" + paysadresse + ", rueadresse=" + rueadresse + ", contactadresse=" + contactadresse + '}';
    }

    
}
