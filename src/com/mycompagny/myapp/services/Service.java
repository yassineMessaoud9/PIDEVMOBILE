/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompagny.myapp.entities.Activite;

import com.compagny.myapp.utils.Statics;
import com.mycompagny.myapp.entities.Adresse;
import com.mycompagny.myapp.entities.Agencelocation;
import com.mycompagny.myapp.entities.Hotel;
import com.mycompagny.myapp.entities.Plat;
import com.mycompagny.myapp.entities.Reclamation;
import com.mycompagny.myapp.entities.ReservationHotel;
import com.mycompagny.myapp.entities.SessionManager;
import com.mycompagny.myapp.entities.Utilisateur;
import com.mycompagny.myapp.entities.Voiture;
import com.mycompagny.myapp.entities.compagnieaerienne;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class Service {

    public ArrayList<Plat> Plat;
    public ArrayList<Utilisateur> utilisateurs;
    public ArrayList<Adresse> Adresse;
    public ArrayList<compagnieaerienne> compagnieaerienne;
    public ArrayList<Hotel> Hotel;
    public ArrayList<ReservationHotel> ReservationHotel;
    public ArrayList<Agencelocation> Agencelocation;
    public ArrayList<Voiture> Voiture;

    public static Service instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    public ArrayList<Reclamation> Reclamation;

    public Service() {
        req = new ConnectionRequest();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public ArrayList<Plat> parseActivites(String jsonText) {
        try {

            System.out.println(jsonText);
            Plat = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Plat a = new Plat();

                float id = Float.parseFloat(obj.get("idplat").toString());
                a.setIdPlat((int) id);
                a.setDescription(obj.get("description").toString());
                Plat.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return Plat;
    }

    public ArrayList<Plat> getAllPlats() {
        String url = Statics.BASE_URL + "Plataffichemobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Plat = parseActivites(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Plat;
    }

    public boolean AddPlat(Plat u) {
        String url = Statics.BASE_URL + "Platajout/?nomplat=" + u.getNomPlat() + "&prixplat=" + u.getPrixPlat() + "&photoplat=" + u.getPhotoPlat() + "&description=" + u.getDescription(); //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Utilisateur> parseUtilisateur(String jsonText) {
        try {

            System.out.println(jsonText);
            utilisateurs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Utilisateur a = new Utilisateur();

                float id = Float.parseFloat(obj.get("id").toString());
                a.setIdU((int) id);
                a.setNom(obj.get("nom").toString());
                a.setPrenom(obj.get("prenom").toString());
                a.setEmail(obj.get("email").toString());
                a.setRole(obj.get("roles").toString());
                a.setAdresse(obj.get("adresse").toString());
                a.setPays(obj.get("pays").toString());
                a.setActive(obj.get("activated").toString());

                utilisateurs.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return utilisateurs;
    }

    public ArrayList<Utilisateur> getAllUtilisateur() {
        String url = Statics.BASE_URL + "usermobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                utilisateurs = parseUtilisateur(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return utilisateurs;
    }

    public boolean AddUtilisateur(Utilisateur u) {
        String url = Statics.BASE_URL + "RegisterMobclient/?nom=" + u.getNom() + "&prenom=" + u.getPrenom() + "&adresse=" + u.getAdresse() + "&password=" + u.getMotpasse() + "&email=" + u.getEmail() + "&pays=" + u.getPays() + "&pays=" + u.getPays() + "&photo=" + u.getPhoto();
        //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public void signin(TextField username, TextField password, Resources rs) {

        String url = Statics.BASE_URL + "loginMobclient/?email=" + username.getText().toString() + "&password=" + password.getText().toString();
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);

        req.addResponseListener((e) -> {

            JSONParser j = new JSONParser();

            String json = new String(req.getResponseData()) + "";

            try {

                if (json.equals("failed")) {
                    Dialog.show("Echec d'authentification", "Username ou mot de passe éronné", "OK", null);
                } else {
                    System.out.println("data ==" + json);

                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    //Session 
                    float id = Float.parseFloat(user.get("id").toString());
                    SessionManager.setId((int) id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i

                    SessionManager.setPassowrd(user.get("password").toString());
                    SessionManager.setUserName(user.get("username").toString());
                    SessionManager.setEmail(user.get("email").toString());

                    //photo 
                    if (user.get("photo") != null) {
                        SessionManager.setPhoto(user.get("photo").toString());
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public ArrayList<Adresse> parseAdresses(String jsonText) {
        try {

            System.out.println(jsonText);
            Adresse = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Adresse a = new Adresse();

                float id = Float.parseFloat(obj.get("idadresse").toString());
                a.setIdadresse((int) id);
                a.setPaysadresse(obj.get("paysadresse").toString());
                a.setRueadresse(obj.get("rueadresse").toString());
                float contact = Float.parseFloat(obj.get("contactadresse").toString());
                a.setContactadresse((int) contact);
                Adresse.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return Adresse;
    }

    public ArrayList<compagnieaerienne> parseCompagnie(String jsonText) {
        try {

            System.out.println(jsonText);
            compagnieaerienne = new ArrayList<>();
            Adresse = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                compagnieaerienne a = new compagnieaerienne();

                float id = Float.parseFloat(obj.get("idcompagnie").toString());
                a.setIdcompagnie((int) id);
                a.setNomcompagnie(obj.get("nomcompagnie").toString());
                a.setIdadresse(this.parseAdresse(obj));

                /* float idadr = Float.parseFloat(obj.get("idadresse").toString());
                a.setIdadresse((int) idadr */
 /* a.setPays(obj.get("idadresse.paysadresse").toString());*/
                compagnieaerienne.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return compagnieaerienne;
    }

    private Adresse parseAdresse(Map<String, Object> map) {

        Adresse adr = new Adresse();

        try {

            Map<String, String> object = (Map<String, String>) map.get("idadresse");

            adr.setPaysadresse(object.get("paysadresse"));
        } catch (NullPointerException ex) {

            System.out.println("Something went wrong: " + ex.getMessage());
        }

        return adr;
    }

    public ArrayList<Adresse> getAllActivites() {
        String url = Statics.BASE_URL + "Adressemobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Adresse = parseAdresses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Adresse;
    }

    public ArrayList<compagnieaerienne> getAllcompagnie() {
        String url = Statics.BASE_URL + "Compagnieaeriennemobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                compagnieaerienne = parseCompagnie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.print(compagnieaerienne + "aaaaaaaaaaaaaaaaaaaaa" + compagnieaerienne);
        return compagnieaerienne;
    }

    public boolean AddAdresse(Adresse u) {
        String url = Statics.BASE_URL + "AjouteAdresse/?paysadresse=" + u.getPaysadresse() + "&rueadresse=" + u.getRueadresse() + "&contactadresse=" + u.getContactadresse(); //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean SendMail(String to, String Obj, String Text) {
        String url = Statics.BASE_URL + "email/" + to + "/" + Obj + "/" + Text; //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean editActivite(Adresse u) {

        String url = Statics.BASE_URL + "updateadresse/=" + u.getPaysadresse() + "&rueadresse=" + u.getRueadresse() + "&contactadresse=" + u.getContactadresse(); //création de l'URL
        req.setUrl(url);
        System.out.println(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteActivite(int id_a) {
        String url = Statics.BASE_URL + "supprimeradresse/" + id_a;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deletePlat(int id_a) {
        String url = Statics.BASE_URL + "supp/" + id_a;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public static Image getScreenshot() {
        Form form = Display.getInstance().getCurrent();
        if (form != null) {
            Image screenshot = Image.createImage(form.getWidth(), form.getHeight());
            form.paintComponent(screenshot.getGraphics(), true);
            return screenshot;
        } else {
            return null;
        }
    }

    public ArrayList<Reclamation> parseReclamation(String jsonText) {
        try {

            System.out.println(jsonText);
            Reclamation = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Reclamation a = new Reclamation();

                float id = Float.parseFloat(obj.get("idreclamation").toString());
                a.setIdReclamation((int) id);

                a.setIntituleReclamation(obj.get("intitulereclamation").toString());
                a.setTypeReclamation(obj.get("typereclamation").toString());
                a.setDescription(obj.get("description").toString());

                //a.setDateReclamation(Date.valueOf(obj.get("datereclamation").toString()));
                // float cat = Float.parseFloat(obj.get("catAge").toString());
                Reclamation.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return Reclamation;
    }

    public ArrayList<Reclamation> getAllReclamation() {
        String url = "http://127.0.0.1:8000/reclamation/rec/RecMobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Reclamation = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Reclamation;
    }

    public boolean AddReclamation(Reclamation u) {

        String url = Statics.BASE_URL + "reclamation/add/jsonadd?titre=" + u.getIntituleReclamation() + "&type=" + u.getTypeReclamation() + "&description=" + u.getDescription(); //création de l'URL;

        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteReclamation(int id_a) {
        String url = Statics.BASE_URL + "reclamation/del/" + id_a;
        req.setUrl(url);
        //req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Hotel> parseHotels(String jsonText) {
        try {

            System.out.println(jsonText);
            Hotel = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Hotel a = new Hotel();

                float id = Float.parseFloat(obj.get("idHotel").toString());
                a.setIdhotel((int) id);
                a.setNomhotel(obj.get("nomhotel").toString());
                a.setAdresse(obj.get("adresse").toString());
                float etoile = Float.parseFloat(obj.get("etoile").toString());
                a.setEtoile((int) etoile);
                float nbrchembre = Float.parseFloat(obj.get("nbrchambre").toString());
                a.setNbrChambre((int) nbrchembre);
                a.setPhoto(obj.get("photo").toString());

                Hotel.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return Hotel;
    }

    public ArrayList<ReservationHotel> parseActivites2(String jsonText) {
        try {

            System.out.println(jsonText);
            ReservationHotel = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                ReservationHotel a = new ReservationHotel();

                float id = Float.parseFloat(obj.get("idreservationhotel").toString());
                a.setIdReservationHotel((int) id);
                a.setTypeChambre(obj.get("typechambre").toString());
                float nbrnuit = Float.parseFloat(obj.get("nbrnuit").toString());
                a.setNbrNuit((int) nbrnuit);
                float nbpersonne = Float.parseFloat(obj.get("nbrpersonne").toString());
                a.setNbrPersonne((int) nbpersonne);
                float idu = Float.parseFloat(obj.get("idu").toString());
                a.setIdU((int) idu);
                // float idhotel = Float.parseFloat(obj.get("etoile").toString());
                a.setIdTourisme(this.parseCategory(obj));

                ReservationHotel.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return ReservationHotel;
    }

    private Hotel parseCategory(Map<String, Object> map) {

        Hotel h = new Hotel();

        try {

            Map<String, String> object = (Map<String, String>) map.get("idhotel");

            h.setNomhotel(object.get("nomhotel"));
        } catch (NullPointerException ex) {

            System.out.println("Something went wrong: " + ex.getMessage());
        }

        return h;
    }

    public ArrayList<Hotel> getAllHotels() {
        String url = Statics.BASE_URL + "DashboardAdminMobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Hotel = parseHotels(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Hotel;
    }

    public ArrayList<ReservationHotel> getAllActivitesHotel() {
        String url = Statics.BASE_URL + "DashboardAdminMobileReser";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationHotel = parseActivites2(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return ReservationHotel;
    }

    public boolean AddHotel(Hotel u) {
        String url = Statics.BASE_URL + "hotelsAjout/?nomhotel=" + u.getNomhotel() + "&adresse=" + u.getAdresse() + "&etoile=" + u.getEtoile() + "&nbrchambre=" + u.getNbrChambre() + "&photo=" + u.getPhoto(); //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean editActiviteHotel(Hotel u) {
        System.out.println(u);
        String ch = "0308ab928edd715bd261ef1af50e0b91.jpeg";
        String url = Statics.BASE_URL + "DashboardAdminMobile2/" + u.getIdhotel() + "?" + "nomhotel" + u.getNomhotel() + "&adresse=" + u.getAdresse() + "&etoile=" + u.getEtoile() + "&nbrchambre=" + u.getNbrChambre() + "&photo=" + u.getPhoto(); //création de l'URL
        //création de l'URL
        req.setUrl(url);
        System.out.println(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteActiviteHotel(int idhotel) {
        String url = Statics.BASE_URL + "DashboardAdminMobile3/" + idhotel;
        req.setUrl(url);
        req.setHttpMethod("DELETE");
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Agencelocation> parseAgence(String jsonText) {
        try {

            System.out.println(jsonText);
            Agencelocation = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Agencelocation a = new Agencelocation();

                float id = Float.parseFloat(obj.get("idagence").toString());
                a.setIdAgence((int) id);
                a.setNomAgence(obj.get("nomagence").toString());
                float contact = Float.parseFloat(obj.get("contactagence").toString());
                a.setContactAgence((int) contact);
                a.setAddressAgence(obj.get("addressagence").toString());
                a.setLogoAgence(obj.get("logoagence").toString());

                Agencelocation.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return Agencelocation;
    }

    public ArrayList<Voiture> parseActivitesVoiture(String jsonText) {
        try {

            System.out.println("hedha json" + jsonText);
            Voiture = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Voiture a = new Voiture();

                float id = Float.parseFloat(obj.get("idVoiture").toString());
                a.setId_voiture((int) id);

                float maticule = Float.parseFloat(obj.get("matricule").toString());
                a.setMatricule((int) maticule);

                a.setMarqueVoiture(obj.get("marquevoiture").toString());
                a.setPhotoVoiture(obj.get("photovoiture").toString());

                float nbplace = Float.parseFloat(obj.get("nbplace").toString());
                a.setNbplace((int) nbplace);

                float nbrchevaux = Float.parseFloat(obj.get("nbrchevaux").toString());
                a.setNbrchevaux((int) nbrchevaux);

                float tarif = Float.parseFloat(obj.get("tarif").toString());
                a.setTarif((int) tarif);

                a.setIdagence(this.parseAg(obj));

                //int idAgence = Integer.parseInt(obj.get("idagence.").toString());
                // a.setIdAgence((int) idAgence);   
                Voiture.add(a);

            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        System.out.println("hedha voiture" + Voiture);
        return Voiture;
    }

    private Agencelocation parseAg(Map<String, Object> map) {

        Agencelocation A = new Agencelocation();

        try {

            Map<String, String> object = (Map<String, String>) map.get("idagence");

            A.setNomAgence(object.get("nomagence"));
        } catch (NullPointerException ex) {

            System.out.println("Something went wrong: " + ex.getMessage());
        }

        return A;
    }

    public ArrayList<Agencelocation> getAllAgence() {
        String url = Statics.BASE_URL + "agencelocationmobile";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Agencelocation = parseAgence(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Agencelocation;
    }

    public ArrayList<Agencelocation> getAllStat() {
        String url = Statics.BASE_URL + "voituremobile/stat";
        req.setUrl(url);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Voiture = parseActivitesVoiture(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        return Agencelocation;
    }

    public ArrayList<Voiture> getAllActivitesvoiture() {
        String url = Statics.BASE_URL + "voituremobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new com.codename1.ui.events.ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Voiture = parseActivitesVoiture(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(req);

        System.out.println("tttt " + Voiture);
        return Voiture;
    }

    public boolean AddAgencelocation(Agencelocation u) {
        String url = Statics.BASE_URL + "AjouteAgence/?nomagence=" + u.getNomAgence() + "&contactagence=" + u.getContactAgence() + "&addressagence=" + u.getAddressAgence() + "&logoagence=" + u.getLogoAgence(); //création de l'URL
        //  String url = Statics.BASE_URL + "create";
        req.setUrl(url);
        req.addResponseListener((e) -> {
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            String str = new String(req.getResponseData());
            System.out.println("data" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean editAgence(Agencelocation u) {
        String ch = "0308ab928edd715bd261ef1af50e0b91.jpeg";
        String url = Statics.BASE_URL + "updateagence/" + u.getIdAgence() + "?nomagence=" + u.getNomAgence() + "&contactagence=" + u.getContactAgence() + "&addressagence=" + u.getAddressAgence() + "&logoagence=" + u.getLogoAgence(); //création de l'URL
        req.setUrl(url);
        System.out.println(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteVoiture(int id_a) {
        String url = Statics.BASE_URL + "voituremobile/suppVoiture/" + id_a;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
