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
public class compagnieaerienne {
    private int idcompagnie ;
private String nomcompagnie ;
private Adresse idadresse ;
private String pays;

    public compagnieaerienne(int idcompagnie, String nomcompagnie, String pays) {
        this.idcompagnie = idcompagnie;
        this.nomcompagnie = nomcompagnie;
        this.pays = pays;
    }

    public compagnieaerienne(String nomcompagnie, String pays) {
        this.nomcompagnie = nomcompagnie;
        this.pays = pays;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    


    public compagnieaerienne(int idcompagnie, String nomcompagnie, Adresse idadresse) {
        this.idcompagnie = idcompagnie;
        this.nomcompagnie = nomcompagnie;
        this.idadresse = idadresse;
    }

    public compagnieaerienne(String nomcompagnie, Adresse idadresse) {
        this.nomcompagnie = nomcompagnie;
        this.idadresse = idadresse;
    }

    public compagnieaerienne() {
    }

    public compagnieaerienne(int idcompagnie) {
        this.idcompagnie = idcompagnie;
    }
    

    public int getIdcompagnie() {
        return idcompagnie;
    }

    public void setIdcompagnie(int idcompagnie) {
        this.idcompagnie = idcompagnie;
    }

    public String getNomcompagnie() {
        return nomcompagnie;
    }

    public void setNomcompagnie(String nomcompagnie) {
        this.nomcompagnie = nomcompagnie;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    @Override
    public String toString() {
        return "compagnieaerienne{" + "idcompagnie=" + idcompagnie + ", nomcompagnie=" + nomcompagnie + ", idadresse=" + idadresse + '}';
    }



  

    public compagnieaerienne(int idcompagnie, String nomcompagnie) {
        this.idcompagnie = idcompagnie;
        this.nomcompagnie = nomcompagnie;
    }
    
    
    

    
}
