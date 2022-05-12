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
import com.mycompagny.myapp.entities.Agencelocation;
import com.mycompagny.myapp.services.Service;

/**
 *
 * @author MediaHelp
 */
public class modifyagence extends BaseForm {


    
    Form current;
    public modifyagence(Resources res , Agencelocation r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
     //   super.addSideMenu(res);
        
     //   TextField nbrChambre = new TextField(r.getNbrChambre(), "Objet" , 20 , TextField.ANY);
        TextField nomagence = new TextField(r.getNomAgence(), "nomagence" , 3 , TextField.ANY);
               TextField contactagence = new TextField(String.valueOf(r.getContactAgence()) , "contactagence" , 5 , TextField.ANY);
                              TextField adresse = new TextField(String.valueOf(r.getAddressAgence()) , "adresseagence" , 2 , TextField.ANY);
                                                            TextField logo = new TextField(String.valueOf(r.getLogoAgence()) , "logoagence" , 4 , TextField.ANY);

                                                       //     TextField photo = new TextField(String.valueOf(r.getPhoto()) , "photo" , 6, TextField.ANY);

 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
     //   ComboBox etatCombo = new ComboBox();
        
     //   etatCombo.addItem("Non Traiter");
        
    //    etatCombo.addItem("Traiter");
        
      
        
        
        
        
        
      //  objet.setUIID("NewsTopLine");
        nomagence.setUIID("NewsTopLine");
        //    etat.setUIID("NewsTopLine");
                contactagence.setUIID("NewsTopLine");
                                adresse.setUIID("NewsTopLine");
                              logo.setUIID("NewsTopLine");
                                                         //  nom.setUIID("NewsTopLine");




        //adresq.setSingleLineTextArea(true);
        adresse.setSingleLineTextArea(true);
                nomagence.setSingleLineTextArea(true);
                                contactagence.setSingleLineTextArea(true);
                          logo.setSingleLineTextArea(true);
                          //nom.setSingleLineTextArea(true);



        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
       //    r.setObjet(objet.getText());
           r.setAddressAgence(adresse.getText());
           
           r.setContactAgence(Integer.parseInt(contactagence.getText()));

                 r.setLogoAgence(logo.getText());
                            r.setNomAgence(nomagence.getText());
                          


                    //   r.setNomhotel(photo.getText());

       
       //appel fonction modfier reclamation men service
       
       if(Service.getInstance().editAgence(r)) { // if true
          
          // new  modifyagence(res,r).show();
               Dialog.show("Success","modifier",new Command("OK"));
  
 
                 new AllAgencelocation(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
                      new AllAgencelocation(res).show();

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
               new FloatingHint(nomagence),
                 new FloatingHint(contactagence),
                 new FloatingHint(logo),
          //     new FloatingHint(nom),

                 


                createLineSeparator(),
              //  etatCombo,
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
                Button retour = new Button("Retour");
        retour.addActionListener(e
                -> {

            new Menu(res).show();

        });
        add(retour);

    }

}