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
import com.mycompagny.myapp.entities.Plat;
import com.mycompagny.myapp.services.Service;
import java.io.ByteArrayOutputStream;
//import java.io.IOException;

public class AddPlat extends BaseForm {

    String Imagecode;
    String filePath = "";

    public AddPlat(Resources res, Form previous) {
        setTitle("Add Plat");
        setLayout(BoxLayout.y());
        TextField NomPlat = new TextField("", "nomplat");
        NomPlat.getStyle().setFgColor(154245);
        TextField prixplat = new TextField("", "prixplat");
        prixplat.getStyle().setFgColor(154245);
        TextField photoplat = new TextField("", "photoplat");
        photoplat.getStyle().setFgColor(154245);
        TextField description = new TextField("", "description");
        description.getStyle().setFgColor(154245);

        /*Button photoButton = new Button("Ajouter une Image");
        photoButton.setTextPosition(Label.BOTTOM);

        CheckBox multiSelect = new CheckBox("Multi-select");

        photoButton.addActionListener((ActionEvent e) -> {
            if (FileChooser.isAvailable()) {

                FileChooser.setOpenFilesInPlace(true);

                FileChooser.showOpenDialog(multiSelect.isSelected(), ".jpg,.jpeg,.png/plain", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource() == null) {
                        add("No file was selected");
                        revalidate();
                        return;
                    }
                    if (multiSelect.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }
                    //menna 7atta el photoButton.setBadgeText(namePic); 9a3din ntal3ou fi esm taswira el 7a9ani 
                    String file = (String) e2.getSource();

                    System.out.println(file);
                    String extension = null;
                    if (file.lastIndexOf(".") > 0) {
                        extension = file.substring(file.lastIndexOf(".") + 1);
                        StringBuilder hi = new StringBuilder(file);

                        if (file.startsWith("file://")) {
                        } else {
                            hi.delete(0, 7);
                        }
                        int lastIndexPeriod = hi.toString().lastIndexOf(".");
                        Log.p(hi.toString());
                        String ext = hi.toString().substring(lastIndexPeriod);
                        String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
                        try {
                            String namePic = saveFileToDevice(file, ext);
                            System.out.println(namePic);
                            //cr.setFilename("file",namePic);//any unique name you want
                            // photoButton.getIcon().setImageName(namePic);
                            photoButton.setBadgeText(namePic); //7atit l'esm fl badge ta3 button bch najjam nesta3mlou el berra ml cha9lalla hadhi
                        } catch (IOException ex) {
                        }
                    }
                    if (file == null) {
                        add("No file was selected");
                        revalidate();
                    } else {
                        Image logo;
                        try {
                            logo = Image.createImage(file).scaledSmallerRatio(256, 256);
                            photoButton.setIcon(logo); //lenna bch tatla3lk taswira 9bal ma ta3ml submit
                            //lenna nbdaw fl enregistrement ta3 taswira
                            String imageFile = FileSystemStorage.getInstance().getAppHomePath() + photoButton.getBadgeText();
                            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                                //System.out.println(imageFile);
                                ImageIO.getImageIO().save(logo, os, ImageIO.FORMAT_PNG, 1);//3mlna save lel image fi wost file system storage
                                System.out.println();
                            } catch (IOException err) {
                            }
                        } catch (IOException ex) {
                        }
                        revalidate();

                    }
                });
            }
        });
         */
        Button btnValider = new Button("Valider");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((NomPlat.getText().length() == 0) || (prixplat.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Plat plat = new Plat(NomPlat.getText(), Double.parseDouble(prixplat.getText()), photoplat.getText(), description.getText());
                        if (Service.getInstance().AddPlat(plat)) {
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
        addAll(NomPlat, prixplat, photoplat, description, btnValider);
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
