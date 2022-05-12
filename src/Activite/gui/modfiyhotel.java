/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activite.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.gui.BaseForm;
import com.mycompagny.myapp.entities.Hotel;
import com.mycompagny.myapp.services.Service;

/**
 *
 * @author MediaHelp
 */
public class modfiyhotel extends BaseForm {


    
    Form current;
    public modfiyhotel(Resources res , Hotel r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
     //   TextField nbrChambre = new TextField(r.getNbrChambre(), "Objet" , 20 , TextField.ANY);
        TextField adresse = new TextField(r.getAdresse(), "adresse" , 3 , TextField.ANY);
               TextField nbrch = new TextField(String.valueOf(r.getNbrChambre()) , "nbrchambre" , 5 , TextField.ANY);
                              TextField nom = new TextField(String.valueOf(r.getNomhotel()) , "nomhotel" , 2 , TextField.ANY);
                                                            TextField etoile = new TextField(String.valueOf(r.getEtoile()) , "etoile" , 4 , TextField.ANY);

                                                            TextField photo = new TextField(String.valueOf(r.getPhoto()) , "photo" , 6, TextField.ANY);

 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
     //   ComboBox etatCombo = new ComboBox();
        
     //   etatCombo.addItem("Non Traiter");
        
    //    etatCombo.addItem("Traiter");
        
      
        
        
        
        
        
      //  objet.setUIID("NewsTopLine");
        adresse.setUIID("NewsTopLine");
        //    etat.setUIID("NewsTopLine");
                etoile.setUIID("NewsTopLine");
                                nbrch.setUIID("NewsTopLine");
                              photo.setUIID("NewsTopLine");
                                                            nom.setUIID("NewsTopLine");




        //adresq.setSingleLineTextArea(true);
        adresse.setSingleLineTextArea(true);
                etoile.setSingleLineTextArea(true);
                                nbrch.setSingleLineTextArea(true);
                          photo.setSingleLineTextArea(true);
                nom.setSingleLineTextArea(true);



        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
       //    r.setObjet(objet.getText());
           r.setAdresse(adresse.getText());
           
           r.setEtoile(Integer.parseInt(etoile.getText()));

          r.setNbrChambre(Integer.parseInt(nbrch.getText()));
                 r.setPhoto(photo.getText());

                       r.setNomhotel(photo.getText());

       
       //appel fonction modfier reclamation men service
       
       if(Service.getInstance().editActiviteHotel(r)) { // if true
           new  modfiyhotel(res,r).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
                      new  modfiyhotel(res,r).show();

       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
             //   new FloatingHint(objet),
                createLineSeparator(),
                new FloatingHint(adresse),
               new FloatingHint(etoile),
                 new FloatingHint(nbrch),
                 new FloatingHint(photo),
               new FloatingHint(nom),

                 


                createLineSeparator(),
              //  etatCombo,
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }

}
