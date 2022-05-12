/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.myapp.entities;

import java.util.Date;


/**
 *
 * @author Utilisateur
 */

public class Reclamation {
       private int idReclamation;
       private String TypeReclamation;
    private String description;
    private Date dateReclamation;
    private String intituleReclamation;
    private String etatReclamation;

    public Reclamation() {
    }

    public Reclamation(String TypeReclamation, String description, Date dateReclamation, String intituleReclamation, String etatReclamation) {
        this.TypeReclamation = TypeReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.intituleReclamation = intituleReclamation;
        this.etatReclamation = etatReclamation;
    }

    public Reclamation(int idReclamation, String TypeReclamation, String description, String intituleReclamation) {
        this.idReclamation = idReclamation;
        this.TypeReclamation = TypeReclamation;
        this.description = description;
        this.intituleReclamation = intituleReclamation;
    }

    public Reclamation(String TypeReclamation, String description, String intituleReclamation) {
        this.TypeReclamation = TypeReclamation;
        this.description = description;
        this.intituleReclamation = intituleReclamation;
    }
    
    

    public int getIdReclamation() {
        return idReclamation;
    }

    public String getTypeReclamation() {
        return TypeReclamation;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public String getIntituleReclamation() {
        return intituleReclamation;
    }

    public String getEtatReclamation() {
        return etatReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public void setTypeReclamation(String TypeReclamation) {
        this.TypeReclamation = TypeReclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public void setIntituleReclamation(String intituleReclamation) {
        this.intituleReclamation = intituleReclamation;
    }

    public void setEtatReclamation(String etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", TypeReclamation=" + TypeReclamation + ", description=" + description + ", dateReclamation=" + dateReclamation + ", intituleReclamation=" + intituleReclamation + ", etatReclamation=" + etatReclamation + '}';
    }
    
    
}
