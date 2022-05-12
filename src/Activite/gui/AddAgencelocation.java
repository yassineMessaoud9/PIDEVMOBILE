/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temFade file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activite.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
//import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.mycompagny.gui.BaseForm;
import com.mycompagny.myapp.entities.Activite;
import com.mycompagny.myapp.entities.Agencelocation;

import com.mycompagny.myapp.services.Service;
import java.io.ByteArrayOutputStream;
//import java.io.IOException;

public class AddAgencelocation extends BaseForm {

    String Imagecode;
    String filePath = "";

    public AddAgencelocation(Resources res, Form previous) {
        setTitle("Add Agence");
        setLayout(BoxLayout.y());
        TextField NomAgence = new TextField("", "nomagence");
        NomAgence.getStyle().setFgColor(154245);
        TextField ContactAgence = new TextField("", "contactagence");
        ContactAgence.getStyle().setFgColor(154245);
        TextField AdresseAgence = new TextField("", "addressagence");
        AdresseAgence.getStyle().setFgColor(154245);
        TextField LogoAgence = new TextField("", "logoagence");
        LogoAgence.getStyle().setFgColor(154245);

       
        Button btnValider = new Button("Valider");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((NomAgence.getText().length() == 0) || (ContactAgence.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Agencelocation agence = new Agencelocation(NomAgence.getText(), Integer.parseInt(ContactAgence.getText()),AdresseAgence.getText(),LogoAgence.getText());
                        if (Service.getInstance().AddAgencelocation(agence)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
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
            previous.showBack();
        }); 
        addAll(NomAgence, ContactAgence, AdresseAgence, LogoAgence, btnValider);
    }
/*
    protected String saveFileToDevice(String hi, String ext) throws IOException {
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest();
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath();
            int index = hi.lastIndexOf("/");
            hi = hi.substring(index + 1);
            return hi;
        } catch (URISyntaxException ex) {
        }
        return "null";
    }*/
}
