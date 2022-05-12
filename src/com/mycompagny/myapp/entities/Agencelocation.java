/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.myapp.entities;

/**
 *
 * @author ons
 */
public class Agencelocation {
       private int idAgence;
    private String nomAgence;
    private int contactAgence;
    private String addressAgence;
    private String logoAgence;

    public Agencelocation(String nomAgence, int contactAgence, String addressAgence, String logoAgence) {
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.addressAgence = addressAgence;
        this.logoAgence = logoAgence;
    }

    public Agencelocation() {
    }

    @Override
    public String toString() {
        return "Agencelocation{" + "idAgence=" + idAgence + ", nomAgence=" + nomAgence + ", contactAgence=" + contactAgence + ", addressAgence=" + addressAgence + ", logoAgence=" + logoAgence + '}';
    }

    public Agencelocation(int idAgence, String nomAgence, int contactAgence, String addressAgence, String logoAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.addressAgence = addressAgence;
        this.logoAgence = logoAgence;
    }

    public Agencelocation(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public int getContactAgence() {
        return contactAgence;
    }

    public void setContactAgence(int contactAgence) {
        this.contactAgence = contactAgence;
    }

    public String getAddressAgence() {
        return addressAgence;
    }

    public void setAddressAgence(String addressAgence) {
        this.addressAgence = addressAgence;
    }

    public String getLogoAgence() {
        return logoAgence;
    }

    public void setLogoAgence(String logoAgence) {
        this.logoAgence = logoAgence;
    }
    
}

