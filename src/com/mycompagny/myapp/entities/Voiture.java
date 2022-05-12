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
public class Voiture {
    private int idVoiture ;
    private int matricule ;
    private String marquevoiture;
    private String photovoiture;
    private int nbplace;
    private int nbrchevaux;
    private int tarif;
    private Agencelocation idagence;
    private String nomAgence;

    public Agencelocation getIdagence() {
        return idagence;
    }

    public void setIdagence(Agencelocation idagence) {
        this.idagence = idagence;
    }

    public Voiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Voiture() {
    }

    public Voiture(int idVoiture, int matricule, String marquevoiture, String photovoiture, int nbplace, int nbrchevaux, int tarif, Agencelocation idagence, String nomAgence) {
        this.idVoiture = idVoiture;
        this.matricule = matricule;
        this.marquevoiture = marquevoiture;
        this.photovoiture = photovoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idagence = idagence;
        this.nomAgence = nomAgence;
    }

    public Voiture(int matricule, String marquevoiture, String photovoiture, int nbplace, int nbrchevaux, int tarif, Agencelocation idagence, String nomAgence) {
        this.matricule = matricule;
        this.marquevoiture = marquevoiture;
        this.photovoiture = photovoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idagence = idagence;
        this.nomAgence = nomAgence;
    }

    public Voiture(int matricule, String marquevoiture, String photovoiture, int nbplace, int nbrchevaux, int tarif, Agencelocation idagence) {
        this.matricule = matricule;
        this.marquevoiture = marquevoiture;
        this.photovoiture = photovoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idagence = idagence;
    }

    public Voiture(int idVoiture, int matricule, String marquevoiture, String photovoiture, int nbplace, int nbrchevaux, int tarif, Agencelocation idagence) {
        this.idVoiture = idVoiture;
        this.matricule = matricule;
        this.marquevoiture = marquevoiture;
        this.photovoiture = photovoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idagence = idagence;
    }

    public Voiture(int matricule, String marquevoiture, String photovoiture, int nbplace, int nbrchevaux, int tarif) {
        this.matricule = matricule;
        this.marquevoiture = marquevoiture;
        this.photovoiture = photovoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
    }

    public int getId_voiture() {
        return idVoiture;
    }

    public void setId_voiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getMarqueVoiture() {
        return marquevoiture;
    }

    public void setMarqueVoiture(String marquevoiture) {
        this.marquevoiture = marquevoiture;
    }

    public String getPhotoVoiture() {
        return photovoiture;
    }

    public void setPhotoVoiture(String photovoiture) {
        this.photovoiture = photovoiture;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public int getNbrchevaux() {
        return nbrchevaux;
    }

    public void setNbrchevaux(int nbrchevaux) {
        this.nbrchevaux = nbrchevaux;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public Voiture(Agencelocation idagence) {
        this.idagence = idagence;
    }



    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    @Override
    public String toString() {
        return "Voiture{" + "matricule=" + matricule + ", marquevoiture=" + marquevoiture + ", photovoiture=" + photovoiture + ", nbplace=" + nbplace + ", nbrchevaux=" + nbrchevaux + ", tarif=" + tarif + ", idagence=" + idagence + '}';
    }

  
  
    
}
