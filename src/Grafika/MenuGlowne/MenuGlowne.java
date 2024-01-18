package Grafika.MenuGlowne;

import Main.Osoba;
import Main.Serializacja;
import Main.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuGlowne extends JPanel {
    JScrollPane scrollPaneKoszyk;
    private JButton dodajPracownika;
    private JButton buttonDodajPracownika2;
    private JButton buttonWyszukaj;

    private MenuGlowneListener menuGlowneListener = new MenuGlowneListener(this);
    private JFrame frame;
    private JPanel panelGlowny;
    private JPanel panelGorny;
    private JPanel panelGorny2;
    private JButton buttonStudent;
    private JButton buttonPracownik;
    private JButton buttonPracownikNaukowy;
    private JButton buttonDodajStudenta;
    private JButton buttonDodajStudenta2;
    private JTextField textImie;
    private JTextField textNazwisko;
    private JTextField textDataUrodzenia;
    private JTextField textPesel;
    private JTextField textPlec;
    private JTextField textIndeks;
    private JTextField textStopienStudiow;
    private JTextField textNumerSemestru;
    JTextField textZarobki;
    JTextField textStanowisko;
    JTextField textPublikacje;
    JTextField textDorobek;
    ArrayList<Osoba> osoby;
    JButton buttonWyjdz;
    JTextField textStaz;
    public MenuGlowne() {
        super();
    }


    public ActionListener getMenuGlowneListener() {
        return menuGlowneListener;
    }


    public void openMenuGlowne(JFrame frame, ArrayList<Osoba> osoby) {
        this.osoby = osoby;
        this.frame = frame;

        //IMAGE
        ImageIcon logoImage = new ImageIcon("src/Grafika/Images/pwr.png");
        logoImage = scaleIcon(logoImage, 100, 100);

        // PANELs
        panelGorny = new JPanel();
        panelGorny2 = new JPanel();
        panelGlowny = new JPanel();

        // LABELs

        //BUTTONS

        // PANEL GLOWNY
        panelGlowny.setPreferredSize(new Dimension(frame.getWidth(), 1620));
        panelGlowny.setLayout(null);
        panelGlowny.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelGlowny.setBackground(new Color(255, 255, 255));

        //FRAME
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panelGorny);
        frame.add(panelGorny2);
        frame.add(panelGlowny);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // PANEL GORNY
        panelGorny.setPreferredSize(new Dimension(frame.getWidth(), 240));
        panelGorny.setLayout(null);
        panelGorny.setBackground(new Color(176, 33, 33));
        panelGorny.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //BUTTON LOGO
        JLabel logoLabel = new JLabel();
        logoLabel.setText("Politechnika Wrocławska");
        logoLabel.setFont(new Font(null, Font.BOLD, 25));
        logoLabel.setForeground(new Color(244, 214, 133));
        logoLabel.setIcon(logoImage);
        logoLabel.setBounds(0, 0, 1000, 100);
        panelGorny.add(logoLabel);

        //PANEL GORNY2
        panelGorny2.setSize(0,30);
        panelGorny2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelGorny2.setBackground(new Color(176, 33, 33));
        panelGorny2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //BUTTON STUDENT
        buttonStudent = new JButton("STUDENT");
        buttonStudent.setForeground(new Color(244, 214, 133));
        buttonStudent.setPreferredSize(new Dimension(190, 25));
        buttonStudent.setBackground(new Color(196, 17, 17));
        buttonStudent.setFont(new Font(null, Font.BOLD, 13));
        buttonStudent.setFocusable(false);
        buttonStudent.addActionListener(menuGlowneListener);
        panelGorny2.add(buttonStudent);

        //BUTTON PRACOWNIK
        buttonPracownik = new JButton("PRACOWNIK");
        buttonPracownik.setForeground(new Color(244, 214, 133));
        buttonPracownik.setPreferredSize(new Dimension(190, 25));
        buttonPracownik.setBackground(new Color(196, 17, 17));
        buttonPracownik.setFont(new Font(null, Font.BOLD, 13));
        buttonPracownik.setFocusable(false);
        buttonPracownik.addActionListener(menuGlowneListener);
        panelGorny2.add(buttonPracownik);

        //BUTTON PRACOWNIK NAUKOWY
        buttonPracownikNaukowy = new JButton("PRACOWNIK NAUKOWY");
        buttonPracownikNaukowy.setForeground(new Color(244, 214, 133));
        buttonPracownikNaukowy.setPreferredSize(new Dimension(190, 25));
        buttonPracownikNaukowy.setBackground(new Color(196, 17, 17));
        buttonPracownikNaukowy.setFont(new Font(null, Font.BOLD, 13));
        buttonPracownikNaukowy.setFocusable(false);
        buttonPracownikNaukowy.addActionListener(menuGlowneListener);
        panelGorny2.add(buttonPracownikNaukowy);

        //BUTTON WYSZUKAJ
        buttonWyszukaj = new JButton("WYSZUKAJ");
        buttonWyszukaj.setForeground(new Color(244, 214, 133));
        buttonWyszukaj.setPreferredSize(new Dimension(190, 25));
        buttonWyszukaj.setBackground(new Color(196, 17, 17));
        buttonWyszukaj.setFont(new Font(null, Font.BOLD, 13));
        buttonWyszukaj.setFocusable(false);
        buttonWyszukaj.addActionListener(menuGlowneListener);
        panelGorny2.add(buttonWyszukaj);


        // PANEL GLOWNY
        panelGlowny.setPreferredSize(new Dimension(frame.getWidth(), 1620));
        panelGlowny.setLayout(null);
        panelGlowny.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelGlowny.setBackground(new Color(255, 255, 255));


    }

    public void rysujPanelStudent(JPanel panelGlowny) {

        //PANEL STUDENT
        JPanel panelStudent = new JPanel();
        panelStudent.setBounds(0, 0, 190, 1620);
        panelStudent.setBackground(new Color(176, 33, 33));
        panelStudent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelStudent.setLayout(null);
        panelGlowny.add(panelStudent);

        //LABEL STUDENT
        JLabel labelStudent = new JLabel("STUDENT");
        labelStudent.setForeground(new Color(244, 214, 133));
        labelStudent.setFont(new Font(null, Font.BOLD, 25));
        labelStudent.setBounds(30, 0, 120, 50);
        panelStudent.add(labelStudent);

        //BUTTON DODAJSTUDENTA
        buttonDodajStudenta = new JButton();
        buttonDodajStudenta.setText("Dodaj studenta");
        buttonDodajStudenta.setForeground(new Color(244, 214, 133));
        buttonDodajStudenta.setFont(new Font(null, Font.BOLD, 20));
        buttonDodajStudenta.setBackground(new Color(176, 33, 33));
        buttonDodajStudenta.addActionListener(menuGlowneListener);
        buttonDodajStudenta.setFocusable(false);
        buttonDodajStudenta.setBorder(BorderFactory.createEtchedBorder());
        buttonDodajStudenta.setBounds(0, 50, 190, 50);
        panelStudent.add(buttonDodajStudenta);

        //BUTTON DODAJ KURS
        JButton buttonWyszukaj = new JButton();
        buttonWyszukaj.setText("Wyszukaj");
        buttonWyszukaj.setForeground(new Color(244, 214, 133));
        buttonWyszukaj.setFont(new Font(null, Font.BOLD, 20));
        buttonWyszukaj.setBackground(new Color(176, 33, 33));
        buttonWyszukaj.addActionListener(menuGlowneListener);
        buttonWyszukaj.setFocusable(false);
        buttonWyszukaj.setBorder(BorderFactory.createEtchedBorder());
        buttonWyszukaj.setBounds(0, 100, 190, 50);
        panelStudent.add(buttonWyszukaj);

        //BUTTON USUN STUDENTA
        buttonWyjdz = new JButton();
        buttonWyjdz.setText("WYJDZ");
        buttonWyjdz.setForeground(new Color(244, 214, 133));
        buttonWyjdz.setFont(new Font(null, Font.BOLD, 20));
        buttonWyjdz.setBackground(new Color(176, 33, 33));
        buttonWyjdz.addActionListener(menuGlowneListener);
        buttonWyjdz.setFocusable(false);
        buttonWyjdz.setBorder(BorderFactory.createEtchedBorder());
        buttonWyjdz.setBounds(0, 150, 190, 50);
        panelStudent.add(buttonWyjdz);

    }

    public void rysujDodajStudenta(JPanel panelGlowny){
        JPanel panelDodajStudenta = new JPanel();
        panelDodajStudenta.setLayout(null);
        panelDodajStudenta.setBounds(190,0,300,1000);
        panelGlowny.add(panelDodajStudenta);

        JLabel labelImie;
        JLabel labelNazwisko;
        JLabel labelDataUrodzenia;
        JLabel labelPesel;
        JLabel labelPlec;
        JLabel labelIndeks;
        JLabel labelStopienStudiow;
        JLabel labelNumerSemestru;

        //TEXT FIELDY/LABELE
        textImie = new JTextField();
        textImie.setBounds(60, 75, 250, 40);
        panelDodajStudenta.add(textImie);
        labelImie = new JLabel("IMIE");
        labelImie.setBounds(60, 60, 250, 10);
        panelDodajStudenta.add(labelImie);

        textNazwisko = new JTextField();
        textNazwisko.setBounds(60, 150, 250, 40);
        panelDodajStudenta.add(textNazwisko);
        labelNazwisko = new JLabel("NAZWISKO");
        labelNazwisko.setBounds(60, 135, 250, 10);
        panelDodajStudenta.add(labelNazwisko);

        textDataUrodzenia = new JTextField();
        textDataUrodzenia.setBounds(60, 225, 250, 40);
        panelDodajStudenta.add(textDataUrodzenia);
        labelDataUrodzenia = new JLabel("DATA URODZENIA (dd-mm-rrrr)");
        labelDataUrodzenia.setBounds(60, 210, 250, 10);
        panelDodajStudenta.add(labelDataUrodzenia);

        textPesel = new JTextField();
        textPesel.setBounds(60, 300, 250, 40);
        panelDodajStudenta.add(textPesel);
        labelPesel = new JLabel("PESEL");
        labelPesel.setBounds(60, 285, 250, 10);
        panelDodajStudenta.add(labelPesel);

        textPlec = new JTextField();
        textPlec.setBounds(60, 375, 250, 40);
        panelDodajStudenta.add(textPlec);
        labelPlec = new JLabel("PLEC");
        labelPlec.setBounds(60, 360, 250, 10);
        panelDodajStudenta.add(labelPlec);

        textIndeks = new JTextField();
        textIndeks.setBounds(60, 450, 250, 40);
        panelDodajStudenta.add(textIndeks);
        labelIndeks = new JLabel("NR INDEKS");
        labelIndeks.setBounds(60, 435, 250, 10);
        panelDodajStudenta.add(labelIndeks);

        textStopienStudiow = new JTextField();
        textStopienStudiow.setBounds(200, 525, 110, 40);
        panelDodajStudenta.add(textStopienStudiow);
        labelStopienStudiow = new JLabel("STOPIEN STUDIOW");
        labelStopienStudiow.setBounds(200, 510, 200, 10);
        panelDodajStudenta.add(labelStopienStudiow);

        textNumerSemestru = new JTextField();
        textNumerSemestru.setBounds(60, 525, 110, 40);
        panelDodajStudenta.add(textNumerSemestru);
        labelNumerSemestru = new JLabel("SEMESTR");
        labelNumerSemestru.setBounds(60, 510, 110, 10);
        panelDodajStudenta.add(labelNumerSemestru);

        //BUTTON DODAJ
        buttonDodajStudenta2 = new JButton();
        buttonDodajStudenta2.setText("Dodaj");
        buttonDodajStudenta2.setBounds(220,600,90,40);
        buttonDodajStudenta2.setFocusable(false);
        buttonDodajStudenta2.addActionListener(menuGlowneListener);
        panelDodajStudenta.add(buttonDodajStudenta2);
    }
    public void rysujPanelPracownik(JPanel panelGlowny) {

        //PANEL PRACOWNIK
        JPanel panelPracownik = new JPanel();
        panelPracownik.setBounds(0, 0, 190, 1620);
        panelPracownik.setBackground(new Color(176, 33, 33));
        panelPracownik.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelPracownik.setLayout(null);
        panelGlowny.add(panelPracownik);

        //LABEL STUDENT
        JLabel labelStudent = new JLabel("PRACOWNIK");
        labelStudent.setForeground(new Color(244, 214, 133));
        labelStudent.setFont(new Font(null, Font.BOLD, 25));
        labelStudent.setBounds(30, 0, 185, 50);
        panelPracownik.add(labelStudent);

        //BUTTON DODAJSTUDENTA
        dodajPracownika = new JButton();
        dodajPracownika.setText("Dodaj pracownika");
        dodajPracownika.setForeground(new Color(244, 214, 133));
        dodajPracownika.setFont(new Font(null, Font.BOLD, 20));
        dodajPracownika.setBackground(new Color(176, 33, 33));
        dodajPracownika.addActionListener(menuGlowneListener);
        dodajPracownika.setFocusable(false);
        dodajPracownika.setBorder(BorderFactory.createEtchedBorder());
        dodajPracownika.setBounds(0, 50, 190, 50);
        panelPracownik.add(dodajPracownika);

        //BUTTON WYJDZ
        panelPracownik.add(buttonWyjdz);

    }

    public void rysujDodajPracownika(JPanel panelGlowny){
        JPanel panelDodajPracownika = new JPanel();
        panelDodajPracownika.setLayout(null);
        panelDodajPracownika.setBounds(190,0,1000,1000);
        panelGlowny.add(panelDodajPracownika);

        JLabel labelImie;
        JLabel labelNazwisko;
        JLabel labelDataUrodzenia;
        JLabel labelPesel;
        JLabel labelPlec;

        //TEXT FIELDY/LABELE
        textImie = new JTextField();
        textImie.setBounds(60, 25, 250, 40);
        panelDodajPracownika.add(textImie);
        labelImie = new JLabel("IMIE");
        labelImie.setBounds(60, 10, 250, 10);
        panelDodajPracownika.add(labelImie);

        textNazwisko = new JTextField();
        textNazwisko.setBounds(60, 100, 250, 40);
        panelDodajPracownika.add(textNazwisko);
        labelNazwisko = new JLabel("NAZWISKO");
        labelNazwisko.setBounds(60, 85, 250, 10);
        panelDodajPracownika.add(labelNazwisko);

        textDataUrodzenia = new JTextField();
        textDataUrodzenia.setBounds(60, 175, 250, 40);
        panelDodajPracownika.add(textDataUrodzenia);
        labelDataUrodzenia = new JLabel("DATA URODZENIA (dd-mm-rrrr)");
        labelDataUrodzenia.setBounds(60, 160, 250, 10);
        panelDodajPracownika.add(labelDataUrodzenia);

        textPesel = new JTextField();
        textPesel.setBounds(60, 250, 250, 40);
        panelDodajPracownika.add(textPesel);
        labelPesel = new JLabel("PESEL");
        labelPesel.setBounds(60, 235, 250, 10);
        panelDodajPracownika.add(labelPesel);

        textPlec = new JTextField();
        textPlec.setBounds(60, 325, 250, 40);
        panelDodajPracownika.add(textPlec);
        labelPlec = new JLabel("PLEC");
        labelPlec.setBounds(60, 310, 250, 10);
        panelDodajPracownika.add(labelPlec);

        textZarobki = new JTextField();
        textZarobki.setBounds(60, 400, 250, 40);
        panelDodajPracownika.add(textZarobki);
        JLabel labelZarobki = new JLabel("ZAROBKI");
        labelZarobki.setBounds(60, 385, 250, 10);
        panelDodajPracownika.add(labelZarobki);

        textStanowisko = new JTextField();
        textStanowisko.setBounds(200, 475, 110, 40);
        panelDodajPracownika.add(textStanowisko);
        JLabel labelStanowisko = new JLabel("STANOWISKO");
        labelStanowisko.setBounds(200, 460, 200, 10);
        panelDodajPracownika.add(labelStanowisko);

        textPublikacje = new JTextField();
        textPublikacje.setBounds(60, 475, 110, 40);
        panelDodajPracownika.add(textPublikacje);
        JLabel labelPublikacje = new JLabel("IL PUBLIKACJE");
        labelPublikacje.setBounds(60, 460, 110, 10);
        panelDodajPracownika.add(labelPublikacje);

        textDorobek = new JTextField();
        textDorobek.setBounds(60, 550, 110, 40);
        panelDodajPracownika.add(textDorobek);
        JLabel labelDorobek = new JLabel("DOROBEK");
        labelDorobek.setBounds(60, 535, 110, 10);
        panelDodajPracownika.add(labelDorobek);

        textStaz = new JTextField();
        textStaz.setBounds(200, 550, 110, 40);
        panelDodajPracownika.add(textStaz);
        JLabel labelStaz = new JLabel("STAZ");
        labelStaz.setBounds(200, 535, 110, 10);
        panelDodajPracownika.add(labelStaz);


        //BUTTON DODAJ
        buttonDodajPracownika2 = new JButton();
        buttonDodajPracownika2.setText("Dodaj");
        buttonDodajPracownika2.setBounds(220,600,90,40);
        buttonDodajPracownika2.setFocusable(false);
        buttonDodajPracownika2.addActionListener(menuGlowneListener);
        panelDodajPracownika.add(buttonDodajPracownika2);
    }

    public void rysujPanelStudent(JPanel panelGlowny, ArrayList<Osoba> osobas) {
        JPanel panelStudentci = new JPanel();
        panelStudentci.setBackground(new Color(240, 252, 255));
        panelStudentci.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        panelGlowny.add(panelStudentci);
        panelStudentci.setPreferredSize(new Dimension(700, 700));
        panelStudentci.setLayout(new FlowLayout(FlowLayout.CENTER));

        // LABELs
        JLabel labelPustyKoszyk = new JLabel();

        scrollPaneKoszyk = new JScrollPane(panelStudentci);
        JScrollBar szybkoscScrollPaneKoszyk = scrollPaneKoszyk.getVerticalScrollBar();
        szybkoscScrollPaneKoszyk.setUnitIncrement(20);
        szybkoscScrollPaneKoszyk.setBlockIncrement(40);

        scrollPaneKoszyk.setBackground(new Color(240, 252, 255));
        scrollPaneKoszyk.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        scrollPaneKoszyk.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneKoszyk.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneKoszyk.setBounds(600, 0, 700, 1000);

        //PANEL PRODUKT
        if (osoby.isEmpty() && osoby == null) {
            labelPustyKoszyk.setText("BRAK STUDENTOW");
            labelPustyKoszyk.setHorizontalAlignment(JLabel.CENTER);
            labelPustyKoszyk.setVerticalAlignment(JLabel.CENTER);
            labelPustyKoszyk.setPreferredSize(new Dimension(500, 600));
            labelPustyKoszyk.setForeground(Color.lightGray);
            labelPustyKoszyk.setFont(new Font(null, Font.BOLD, 25));
            panelStudentci.add(labelPustyKoszyk);
        } else {
            for (int i = 0; i < osobas.size(); i++) {
                if (osobas.get(i) instanceof Student) {
                    JButton buttonUsun = new JButton("x");
                    Student student = (Student) osobas.get(i);
                    JLabel labelImie = new JLabel("Imie: " + student.getImie());
                    JLabel lanelNazwisko = new JLabel("Nazwisko: " + student.getNazwisko());
                    JLabel labelPesel = new JLabel("PESEL: " + student.getPesel());
                    JPanel panelStudent = new JPanel();
                    int wysokoscPanelProdukt = (scrollPaneKoszyk.getHeight() / 4);

                    panelStudent.setLayout(null);
                    panelStudent.setBackground(new Color(251, 244, 244));
                    panelStudent.setPreferredSize(new Dimension(scrollPaneKoszyk.getWidth() - 25, wysokoscPanelProdukt));

                    labelImie.setBounds(wysokoscPanelProdukt + 10, 5, scrollPaneKoszyk.getWidth() - 50, 18);
                    labelImie.setFont(new Font(null, Font.BOLD, 16));

                    lanelNazwisko.setFont(new Font(null, Font.BOLD, 16));
                    lanelNazwisko.setFont(new Font(null, Font.BOLD, 16));

                    int buttonX = scrollPaneKoszyk.getWidth() - 50;
                    buttonUsun.setBounds(buttonX, 0, 20, 20);
                    buttonUsun.addActionListener(menuGlowneListener);
                    buttonUsun.setFocusable(false);
                    buttonUsun.setFont(new Font(null, Font.PLAIN, 20));
                    buttonUsun.setBorder(null);
                    buttonUsun.setBackground(null);
                    buttonUsun.setForeground(Color.gray);

                    panelStudent.add(labelImie);
                    panelStudent.add(lanelNazwisko);
                    panelStudent.add(labelPesel);
                    panelStudentci.add(panelStudent);
                }
            }
        }
        panelGlowny.add(panelStudentci);
        panelGlowny.add(scrollPaneKoszyk);
    }

    public JButton getButtonStudent() {
        return buttonStudent;
    }

    public JButton getButtonPracownik() {
        return buttonPracownik;
    }

    public JButton getButtonPracownikNaukowy() {
        return buttonPracownikNaukowy;
    }

    public JPanel getPanelGlowny() {
        return panelGlowny;
    }

    public JButton getButtonDodajStudenta() {
        return buttonDodajStudenta;
    }

    public JButton getButtonDodajStudenta2() {
        return buttonDodajStudenta2;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextImie() {
        return textImie;
    }

    public JTextField getTextNazwisko() {
        return textNazwisko;
    }

    public JTextField getTextDataUrodzenia() {
        return textDataUrodzenia;
    }

    public JTextField getTextPesel() {
        return textPesel;
    }

    public JTextField getTextPlec() {
        return textPlec;
    }

    public JTextField getTextIndeks() {
        return textIndeks;
    }

    public JTextField getTextStopienStudiow() {
        return textStopienStudiow;
    }

    public JTextField getTextStaz() {
        return textStaz;
    }

    public JTextField getTextNumerSemestru() {
        return textNumerSemestru;
    }

    public ArrayList<Osoba> getOsoba() {
        return osoby;
    }

    public JButton getDodajPracownika() {
        return dodajPracownika;
    }

    public JPanel getPanelGorny() {
        return panelGorny;
    }

    public JPanel getPanelGorny2() {
        return panelGorny2;
    }

    public JButton getButtonWyszukaj() {
        return buttonWyszukaj;
    }

    public JTextField getTextZarobki() {
        return textZarobki;
    }

    public JTextField getTextStanowisko() {
        return textStanowisko;
    }

    public JTextField getTextPublikacje() {
        return textPublikacje;
    }

    public JTextField getTextDorobek() {
        return textDorobek;
    }

    public JButton getButtonDodajPracownika2() {
        return buttonDodajPracownika2;
    }

    public JButton getButtonWyjdz() {
        return buttonWyjdz;
    }

    public static void main(String[] args) {
        ArrayList<Osoba> osoby = new ArrayList<>();
        File plik = new File("ListaOsob.ser");
        osoby.add(new Student("11111111111", "Dawid", "Pilarski", LocalDate.of(2000,12,12), "mezczyzna", "123123", (byte) 1, (byte) 2));
        Serializacja.odczytSer(osoby, plik);

        JFrame ramka = new JFrame();
        ramka.setSize(1920, 1080);
        ramka.setLayout(new BoxLayout(ramka.getContentPane(), BoxLayout.Y_AXIS));
        ramka.setVisible(true);
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuGlowne menu = new MenuGlowne();
        menu.openMenuGlowne(ramka, osoby);
        Serializacja.zapisSer(osoby, plik);

    }

    public ImageIcon scaleIcon(ImageIcon icon, int x, int y) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        return scaledIcon;
    }
}
