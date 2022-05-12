/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activite.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompagny.gui.BaseForm;
import com.mycompagny.myapp.entities.Adresse;
import com.mycompagny.myapp.services.Service;

/**
 *
 * @author Gamer
 */
public class modifyadresse extends BaseForm {
    String Imagecode;
    String filePath = "";

    public modifyadresse(Resources res) {
        setTitle("Add Adresse");
        setLayout(BoxLayout.y());
        TextField paysAdresse = new TextField("", "paysadresse");
        paysAdresse.getStyle().setFgColor(154245);
        TextField rueAdresse = new TextField("", "rueadresse");
        rueAdresse.getStyle().setFgColor(154245);
        TextField contactAdresse = new TextField("", "contactadresse");
        contactAdresse.getStyle().setFgColor(154245);
        

        
        Button btnValider = new Button("Valider");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((paysAdresse.getText().length() == 0) || (rueAdresse.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Adresse plat = new Adresse(paysAdresse.getText(),rueAdresse.getText(),Integer.parseInt(contactAdresse.getText()));
                        if (Service.getInstance().AddAdresse(plat)) {
                            Dialog.show("Success", "modifier", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }

                }
            }
        });
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
        /*    previous.showBack();*/
        }); 
        addAll(paysAdresse, rueAdresse, contactAdresse,btnValider);
                Button retour = new Button("Retour");
        retour.addActionListener(e
                -> {

            new Menu(res).show();

        });
        add(retour);

    }
    
}
