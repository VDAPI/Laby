package Grafika.MenuGlowne;

import Main.*;
import StrategiaStudent.StypendiumAktywnosc;
import StrategiaStudent.StypendiumSredniaOcen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuGlowne extends JPanel {
    private JRadioButton buttonAktywnosc;
    private JRadioButton buttonSredniaOcen;
    private JRadioButton buttonStaz;
    private JRadioButton buttonIloscPublikacji;
    private JButton buttonStrategia;
    private JButton buttonDodajPracownikaNaukowego;
    private JButton buttonDodajPracownikaNaukowego2;
    private JTextField textNazwaKursu;
    private JTextField textWykladowca;
    private JButton buttonDodajKurs;
    private JButton wyszukajPoIndeksie;
    private JButton wyszukajPoNazwisku;
    private JButton wyszukajStudentaPoNazwisku;
    private JButton WyszukajPoStanowiskuPracownikaUczelni;
    private JButton wyszukajPracownikaPoNazwisku;
    private JButton wyszukajPracownikaNaukowegoPoNazwisku;
    private JButton wyszukajPowyzejWartosciDorobkuT;
    private JButton wyszukajPoStanowisku;
    private JButton dodajPracownika;
    private JButton buttonDodajPracownika2;
    private JButton buttonWyszukaj;
    private JTextField textWyszukaj;
    private JButton buttonDodajStudenta;
    private JTextField textImie;
    private JTextField textNazwisko;
    private JTextField textDataUrodzenia;
    private JTextField textPesel;
    private JTextField textPlec;
    private JTextField textIndeks;
    private JTextField textStopienStudiow;
    private JTextField textNumerSemestru;
    private JButton buttonDodajStudenta2;
    private JPanel panelStudentci;
    private JScrollPane scrollPaneKoszyk;
    Map<JButton, PracownikUczelni> buttonPracownikMap;
    Map<JButton, Student> buttonStudentMap;
    Map<JButton, Student> kursStudentMap;
    Map<JButton, PracownikUczelniNaukowoDydaktyczny> buttonNaukowyMap;
    private MenuGlowneListener menuGlowneListener = new MenuGlowneListener(this);
    private JFrame frame;
    private JPanel panelGlowny;
    private JPanel panelGorny;
    private JPanel panelGorny2;
    private JButton buttonStudent;
    private JButton buttonPracownik;
    private JButton buttonPracownikNaukowy;
    JTextField textZarobki;
    JTextField textStanowisko;
    JTextField textPublikacje;
    JTextField textDorobek;
    ArrayList<Osoba> osoba;
    JButton buttonWyjdz;
    JTextField textStaz;
    public ActionListener getMenuGlowneListener() {
        return menuGlowneListener;
    }

    public void openMenuGlowne(JFrame frame, ArrayList<Osoba> osoby) {
        this.osoba = osoby;
        this.frame = frame;

        //IMAGE
        ImageIcon logoImage = new ImageIcon("src/Grafika/Images/pwr.png");
        logoImage = scaleIcon(logoImage, 100, 100);

        // PANELs
        panelGorny = new JPanel();
        panelGorny2 = new JPanel();
        panelGlowny = new JPanel();

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
        panelGorny2.setSize(0, 30);
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

        //BUTTON WYSZUKAJ
        buttonStrategia = new JButton("STRATEGIA");
        buttonStrategia.setForeground(new Color(244, 214, 133));
        buttonStrategia.setPreferredSize(new Dimension(190, 25));
        buttonStrategia.setBackground(new Color(196, 17, 17));
        buttonStrategia.setFont(new Font(null, Font.BOLD, 13));
        buttonStrategia.setFocusable(false);
        buttonStrategia.addActionListener(menuGlowneListener);
        panelGorny2.add(buttonStrategia);

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
        panelStudent.setBackground(new Color(190, 33, 33));
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
        buttonDodajKurs = new JButton();
        buttonDodajKurs.setText("Wyszukaj");
        buttonDodajKurs.setForeground(new Color(244, 214, 133));
        buttonDodajKurs.setFont(new Font(null, Font.BOLD, 20));
        buttonDodajKurs.setBackground(new Color(176, 33, 33));
        buttonDodajKurs.addActionListener(menuGlowneListener);
        buttonDodajKurs.setFocusable(false);
        buttonDodajKurs.setBorder(BorderFactory.createEtchedBorder());
        buttonDodajKurs.setBounds(0, 100, 190, 50);
        panelStudent.add(buttonDodajKurs);
    }
    public void rysujDodajStudenta(JPanel panelGlowny) {
        JPanel panelDodajStudenta = new JPanel();
        panelDodajStudenta.setLayout(null);
        panelDodajStudenta.setBounds(190, 0, 400, 1000);
        panelGlowny.add(panelDodajStudenta);

        JLabel labelImie;
        JLabel labelNazwisko;
        JLabel labelDataUrodzenia;
        JLabel labelPesel;
        JLabel labelPlec;
        JLabel labelIndeks;
        JLabel labelStopienStudiow;
        JLabel labelNumerSemestru;
        JLabel labelNazwaKursu;
        JLabel labelWykladowca;

        //TEXT FIELDY/LABELE
        textImie = new JTextField();
        textImie.setBounds(60, 25, 250, 40);
        panelDodajStudenta.add(textImie);
        labelImie = new JLabel("IMIE");
        labelImie.setBounds(60, 10, 250, 10);
        panelDodajStudenta.add(labelImie);

        textNazwisko = new JTextField();
        textNazwisko.setBounds(60, 100, 250, 40);
        panelDodajStudenta.add(textNazwisko);
        labelNazwisko = new JLabel("NAZWISKO");
        labelNazwisko.setBounds(60, 85, 250, 10);
        panelDodajStudenta.add(labelNazwisko);

        textDataUrodzenia = new JTextField();
        textDataUrodzenia.setBounds(60, 175, 250, 40);
        panelDodajStudenta.add(textDataUrodzenia);
        labelDataUrodzenia = new JLabel("DATA URODZENIA (rrrr-mm-dd)");
        labelDataUrodzenia.setBounds(60, 160, 250, 10);
        panelDodajStudenta.add(labelDataUrodzenia);

        textPesel = new JTextField();
        textPesel.setBounds(60, 250, 250, 40);
        panelDodajStudenta.add(textPesel);
        labelPesel = new JLabel("PESEL");
        labelPesel.setBounds(60, 235, 250, 10);
        panelDodajStudenta.add(labelPesel);

        textPlec = new JTextField();
        textPlec.setBounds(60, 325, 250, 40);
        panelDodajStudenta.add(textPlec);
        labelPlec = new JLabel("PLEC");
        labelPlec.setBounds(60, 310, 250, 10);
        panelDodajStudenta.add(labelPlec);

        textIndeks = new JTextField();
        textIndeks.setBounds(60, 400, 250, 40);
        panelDodajStudenta.add(textIndeks);
        labelIndeks = new JLabel("NR INDEKS");
        labelIndeks.setBounds(60, 385, 250, 10);
        panelDodajStudenta.add(labelIndeks);

        textStopienStudiow = new JTextField();
        textStopienStudiow.setBounds(200, 475, 110, 40);
        panelDodajStudenta.add(textStopienStudiow);
        labelStopienStudiow = new JLabel("STOPIEN STUDIOW");
        labelStopienStudiow.setBounds(200, 460, 200, 10);
        panelDodajStudenta.add(labelStopienStudiow);

        textNumerSemestru = new JTextField();
        textNumerSemestru.setBounds(60, 475, 110, 40);
        panelDodajStudenta.add(textNumerSemestru);
        labelNumerSemestru = new JLabel("SEMESTR");
        labelNumerSemestru.setBounds(60, 460, 110, 10);
        panelDodajStudenta.add(labelNumerSemestru);

        textNazwaKursu = new JTextField();
        textNazwaKursu.setBounds(60, 600, 110, 40);
        panelDodajStudenta.add(textNazwaKursu);
        labelNazwaKursu = new JLabel("KURS");
        labelNazwaKursu.setBounds(60, 585, 110, 10);
        panelDodajStudenta.add(labelNazwaKursu);

        textWykladowca = new JTextField();
        textWykladowca.setBounds(200, 600, 110, 40);
        panelDodajStudenta.add(textWykladowca);
        labelWykladowca = new JLabel("WYKLADOWCA");
        labelWykladowca.setBounds(200, 585, 110, 10);
        panelDodajStudenta.add(labelWykladowca);

        //BUTTON DODAJ
        buttonDodajStudenta2 = new JButton();
        buttonDodajStudenta2.setText("Dodaj");
        buttonDodajStudenta2.setBounds(220, 525, 90, 40);
        buttonDodajStudenta2.setFocusable(false);
        buttonDodajStudenta2.addActionListener(menuGlowneListener);
        panelDodajStudenta.add(buttonDodajStudenta2);
    }

    public void rysujStrategie(JPanel panelGlowny) {
        JPanel panelDodajStudenta = new JPanel();
        panelDodajStudenta.setLayout(null);
        panelDodajStudenta.setBounds(190, 0, 400, 1000);
        panelGlowny.add(panelDodajStudenta);

        //RADIO BUTTONS
        buttonAktywnosc = new JRadioButton();
        buttonSredniaOcen = new JRadioButton();
        buttonStaz = new JRadioButton();
        buttonIloscPublikacji = new JRadioButton();

        //GROUP
        ButtonGroup groupStypendium = new ButtonGroup();
        groupStypendium.add(buttonAktywnosc);
        groupStypendium.add(buttonSredniaOcen);
        ButtonGroup groupPensja = new ButtonGroup();
        groupPensja.add(buttonStaz);
        groupPensja.add(buttonIloscPublikacji);

        //AKTYWNOSC
        buttonAktywnosc.setText("Aktywnosc");
        buttonAktywnosc.setBackground(null);
        buttonAktywnosc.setFocusable(false);
        buttonAktywnosc.setBounds(65, 65, 100, 30);
        buttonAktywnosc.addActionListener(menuGlowneListener);
        buttonAktywnosc.setSelected(true);
        panelDodajStudenta.add(buttonAktywnosc);
        //AKTYWNOSC
        buttonSredniaOcen.setText("Srednia ocen");
        buttonSredniaOcen.setBackground(null);
        buttonSredniaOcen.setFocusable(false);
        buttonSredniaOcen.setBounds(65, 95, 100, 30);
        buttonSredniaOcen.addActionListener(menuGlowneListener);
        panelDodajStudenta.add(buttonSredniaOcen);

        //STAZ
        buttonStaz.setText("Staz");
        buttonStaz.setBackground(null);
        buttonStaz.setFocusable(false);
        buttonStaz.setBounds(65, 200, 100, 30);
        buttonStaz.addActionListener(menuGlowneListener);
        buttonStaz.setSelected(true);
        panelDodajStudenta.add(buttonStaz);
        //IL PUBLIKACJI
        buttonIloscPublikacji.setText("Ilosc publikacji");
        buttonIloscPublikacji.setBackground(null);
        buttonIloscPublikacji.setFocusable(false);
        buttonIloscPublikacji.setBounds(65, 230, 100, 30);
        buttonIloscPublikacji.addActionListener(menuGlowneListener);
        panelDodajStudenta.add(buttonIloscPublikacji);
    }

    public void rysujPanelStudentow(JPanel panelGlowny, Class<? extends Osoba> klasa, ArrayList<Osoba> osoby) {
        panelStudentci = new JPanel();
        panelStudentci.setBackground(new Color(240, 252, 255));
        panelStudentci.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        panelGlowny.add(panelStudentci);
        panelStudentci.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonStudentMap = new HashMap();
        buttonPracownikMap = new HashMap<JButton, PracownikUczelni>();
        buttonNaukowyMap = new HashMap<>();
        kursStudentMap = new HashMap<JButton, Student>();

        scrollPaneKoszyk = new JScrollPane(panelStudentci);
        JScrollBar szybkoscScrollPaneKoszyk = scrollPaneKoszyk.getVerticalScrollBar();
        szybkoscScrollPaneKoszyk.setUnitIncrement(20);
        szybkoscScrollPaneKoszyk.setBlockIncrement(40);

        scrollPaneKoszyk.setBackground(new Color(240, 252, 255));
        scrollPaneKoszyk.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        scrollPaneKoszyk.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneKoszyk.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneKoszyk.setBounds(590, 0, 1000, 850);

        for (int i = 0; i < osoby.size(); i++) {
            if (klasa.isAssignableFrom(osoby.get(i).getClass())) {
                JButton buttonUsun = new JButton("Usun");
                JLabel labelImie = new JLabel("IMIE: " + osoby.get(i).getImie());
                JLabel lanelNazwisko = new JLabel("NAZWISKO: " + osoby.get(i).getNazwisko());
                JLabel labelPesel = new JLabel("PESEL: " + osoby.get(i).getPesel());
                JLabel labelPlec = new JLabel("PLEC: " + osoby.get(i).getPlec());
                JLabel labelDataUrodzenia = new JLabel("DATA UR: " + osoby.get(i).getDataUrodzenia());
                JPanel panelStudent = new JPanel();

                panelStudent.setLayout(null);
                panelStudent.setBackground(new Color(251, 244, 244));
                panelStudent.setPreferredSize(new Dimension(700, 200));
                panelStudent.setBorder(BorderFactory.createEtchedBorder());
                panelStudent.setSize(700, 700);

                labelImie.setBounds(10, 10, 300, 18);
                labelImie.setFont(new Font(null, Font.BOLD, 16));
                lanelNazwisko.setBounds(10, 30, 300, 18);
                lanelNazwisko.setFont(new Font(null, Font.BOLD, 16));
                labelPesel.setBounds(10, 50, 300, 18);
                labelPesel.setFont(new Font(null, Font.BOLD, 16));
                labelPlec.setBounds(10,70,300,18);
                labelPlec.setFont(new Font(null, Font.BOLD, 16));
                labelDataUrodzenia.setBounds(10,90,300,18);
                labelDataUrodzenia.setFont(new Font(null, Font.BOLD, 16));

                buttonUsun.setBounds(575, 5, 100, 20);
                buttonUsun.addActionListener(menuGlowneListener);
                buttonUsun.setFocusable(false);
                buttonUsun.setFont(new Font(null, Font.PLAIN, 12));
                buttonUsun.setBorder(null);
                buttonUsun.setBackground(null);
                buttonUsun.setForeground(Color.gray);

                if (osoby.get(i) instanceof Student) {
                    JLabel labelIndeks = new JLabel("INDEKS: " + osoby.get(i).getIndeks());
                    JLabel labelStStu = new JLabel("ST. STUDIOW: " + ((Student) osoby.get(i)).getStopienStudiow());
                    JLabel labelNrSem = new JLabel("NR SEMESTRU: " + ((Student) osoby.get(i)).getNrSemestru());
                    labelIndeks.setBounds(10, 110, 300, 18);
                    labelIndeks.setFont(new Font(null, Font.BOLD, 16));
                    labelStStu.setBounds(10, 130, 300, 18);
                    labelStStu.setFont(new Font(null, Font.BOLD, 16));
                    labelNrSem.setBounds(10, 150, 300, 18);
                    labelNrSem.setFont(new Font(null, Font.BOLD, 16));

                    JButton dodajKurs = new JButton("Dodaj kurs");
                    dodajKurs.setBounds(500, 160, 100, 20);
                    dodajKurs.addActionListener(menuGlowneListener);
                    dodajKurs.setFocusable(false);
                    dodajKurs.setFont(new Font(null, Font.PLAIN, 12));
                    dodajKurs.setBorder(null);
                    dodajKurs.setBackground(null);
                    dodajKurs.setForeground(Color.gray);
                    int y = 10;
                    for (int j = 0; j < ((Student) osoby.get(i)).getKursy().size(); j++) {
                        JLabel kurs = new JLabel((((Student) osoby.get(i)).getKursy().get(j).getNazwa()));
                        JLabel prowadzacy = new JLabel((((Student) osoby.get(i)).getKursy().get(j).getProwadzacy()));
                        kurs.setBounds(310, y, 200, 20);
                        prowadzacy.setBounds(310, y + 15, 200, 20);
                        panelStudent.add(kurs);
                        panelStudent.add(prowadzacy);
                        y += 35;
                    }
                    panelStudent.add(labelIndeks);
                    panelStudent.add(labelNrSem);
                    panelStudent.add(labelStStu);
                    panelStudent.add(dodajKurs);
                    kursStudentMap.put(dodajKurs, (Student) osoby.get(i));
                    buttonStudentMap.put(buttonUsun, (Student) osoby.get(i));
                }else  if(osoby.get(i) instanceof Pracownik){
                    JLabel zarobki = new JLabel("ZAROBKI: " + ((Pracownik) osoby.get(i)).getZarobki());
                    JLabel staz = new JLabel("STAZ: " + ((Pracownik) osoby.get(i)).getStaz());
                    JLabel stanowisko = new JLabel("STANOWISKO: " + osoby.get(i).getStanowisko());
                    zarobki.setBounds(10, 110, 300, 18);
                    zarobki.setFont(new Font(null, Font.BOLD, 16));
                    staz.setBounds(10, 130, 300, 18);
                    staz.setFont(new Font(null, Font.BOLD, 16));
                    stanowisko.setBounds(10, 150, 300, 18);
                    stanowisko.setFont(new Font(null, Font.BOLD, 16));
                    panelStudent.add(zarobki);
                    panelStudent.add(staz);
                    panelStudent.add(stanowisko);
                } else if (osoby.get(i) instanceof PracownikUczelni) {
                    buttonPracownikMap.put(buttonUsun, (PracownikUczelni) osoby.get(i));
                    JLabel dorobek = new JLabel("WARTOSC DOROBKU: " + osoby.get(i).getWartoscDorobku());
                    dorobek.setBounds(10, 170, 300, 18);
                    dorobek.setFont(new Font(null, Font.BOLD, 16));
                    panelStudent.add(dorobek);
                } else if (osoby.get(i) instanceof PracownikUczelniNaukowoDydaktyczny){
                    buttonNaukowyMap.put(buttonUsun, (PracownikUczelniNaukowoDydaktyczny) osoby.get(i));
                }
                panelStudent.add(labelPlec);
                panelStudent.add(labelDataUrodzenia);
                panelStudent.add(labelImie);
                panelStudent.add(lanelNazwisko);
                panelStudent.add(labelPesel);
                panelStudent.add(buttonUsun);
                panelStudentci.add(panelStudent);
            }
        }
        panelStudentci.setPreferredSize(new Dimension(700, panelStudentci.getComponentCount() * 200));
        panelGlowny.add(scrollPaneKoszyk);
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
    }
    public void rysujPanelPracownikNaukowy(JPanel panelGlowny) {
        //PANEL PRACOWNIK
        JPanel panelPracownik = new JPanel();
        panelPracownik.setBounds(0, 0, 190, 1620);
        panelPracownik.setBackground(new Color(176, 33, 33));
        panelPracownik.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelPracownik.setLayout(null);
        panelGlowny.add(panelPracownik);

        //LABEL STUDENT
        JLabel labelStudent = new JLabel("NAUKOWY");
        labelStudent.setForeground(new Color(244, 214, 133));
        labelStudent.setFont(new Font(null, Font.BOLD, 25));
        labelStudent.setBounds(30, 0, 185, 50);
        panelPracownik.add(labelStudent);

        //BUTTON DODAJSTUDENTA
        buttonDodajPracownikaNaukowego = new JButton();
        buttonDodajPracownikaNaukowego.setText("Dodaj naukowego");
        buttonDodajPracownikaNaukowego.setForeground(new Color(244, 214, 133));
        buttonDodajPracownikaNaukowego.setFont(new Font(null, Font.BOLD, 20));
        buttonDodajPracownikaNaukowego.setBackground(new Color(176, 33, 33));
        buttonDodajPracownikaNaukowego.addActionListener(menuGlowneListener);
        buttonDodajPracownikaNaukowego.setFocusable(false);
        buttonDodajPracownikaNaukowego.setBorder(BorderFactory.createEtchedBorder());
        buttonDodajPracownikaNaukowego.setBounds(0, 50, 190, 50);
        panelPracownik.add(buttonDodajPracownikaNaukowego);
    }

    public void rysujDodajPracownika(JPanel panelGlowny) {
        JPanel panelDodajPracownika = new JPanel();
        panelDodajPracownika.setLayout(null);
        panelDodajPracownika.setBounds(190, 0, 400, 1000);
        panelGlowny.add(panelDodajPracownika);

        JLabel labelImie;
        JLabel labelNazwisko;
        JLabel labelDataUrodzenia;
        JLabel labelPesel;
        JLabel labelPlec;

        //TEXT FIELDY/LABELE
        textImie = new JTextField();
        textImie.setBounds(60, 50, 250, 40);
        panelDodajPracownika.add(textImie);
        labelImie = new JLabel("IMIE");
        labelImie.setBounds(60, 40, 250, 10);
        panelDodajPracownika.add(labelImie);

        textNazwisko = new JTextField();
        textNazwisko.setBounds(60, 125, 250, 40);
        panelDodajPracownika.add(textNazwisko);
        labelNazwisko = new JLabel("NAZWISKO");
        labelNazwisko.setBounds(60, 110, 250, 10);
        panelDodajPracownika.add(labelNazwisko);

        textDataUrodzenia = new JTextField();
        textDataUrodzenia.setBounds(60, 200, 250, 40);
        panelDodajPracownika.add(textDataUrodzenia);
        labelDataUrodzenia = new JLabel("DATA URODZENIA (dd-mm-rrrr)");
        labelDataUrodzenia.setBounds(60, 185, 250, 10);
        panelDodajPracownika.add(labelDataUrodzenia);

        textPesel = new JTextField();
        textPesel.setBounds(60, 275, 250, 40);
        panelDodajPracownika.add(textPesel);
        labelPesel = new JLabel("PESEL");
        labelPesel.setBounds(60, 260, 250, 10);
        panelDodajPracownika.add(labelPesel);

        textPlec = new JTextField();
        textPlec.setBounds(60, 350, 250, 40);
        panelDodajPracownika.add(textPlec);
        labelPlec = new JLabel("PLEC");
        labelPlec.setBounds(60, 335, 250, 10);
        panelDodajPracownika.add(labelPlec);

        textZarobki = new JTextField();
        textZarobki.setBounds(60, 425, 250, 40);
        panelDodajPracownika.add(textZarobki);
        JLabel labelZarobki = new JLabel("ZAROBKI");
        labelZarobki.setBounds(60, 410, 250, 10);
        panelDodajPracownika.add(labelZarobki);

        textStanowisko = new JTextField();
        textStanowisko.setBounds(60, 500, 250, 40);
        panelDodajPracownika.add(textStanowisko);
        JLabel labelStanowisko = new JLabel("STANOWISKO");
        labelStanowisko.setBounds(60, 485, 250, 10);
        panelDodajPracownika.add(labelStanowisko);

        textDorobek = new JTextField();
        textDorobek.setBounds(60, 575, 110, 40);
        panelDodajPracownika.add(textDorobek);
        JLabel labelDorobek = new JLabel("DOROBEK");
        labelDorobek.setBounds(60, 560, 110, 10);
        panelDodajPracownika.add(labelDorobek);

        textStaz = new JTextField();
        textStaz.setBounds(200, 575, 110, 40);
        panelDodajPracownika.add(textStaz);
        JLabel labelStaz = new JLabel("STAZ");
        labelStaz.setBounds(200, 560, 110, 10);
        panelDodajPracownika.add(labelStaz);


        //BUTTON DODAJ
        buttonDodajPracownika2 = new JButton();
        buttonDodajPracownika2.setText("Dodaj");
        buttonDodajPracownika2.setBounds(220, 625, 90, 40);
        buttonDodajPracownika2.setFocusable(false);
        buttonDodajPracownika2.addActionListener(menuGlowneListener);
        panelDodajPracownika.add(buttonDodajPracownika2);
    }

    public void rysujDodajPracownikaNaukowego(JPanel panelGlowny) {
        JPanel panelDodajPracownika = new JPanel();
        panelDodajPracownika.setLayout(null);
        panelDodajPracownika.setBounds(190, 0, 400, 1000);
        panelGlowny.add(panelDodajPracownika);

        JLabel labelImie;
        JLabel labelNazwisko;
        JLabel labelDataUrodzenia;
        JLabel labelPesel;
        JLabel labelPlec;

        //TEXT FIELDY/LABELE
        textImie = new JTextField();
        textImie.setBounds(60, 50, 250, 40);
        panelDodajPracownika.add(textImie);
        labelImie = new JLabel("IMIE");
        labelImie.setBounds(60, 40, 250, 10);
        panelDodajPracownika.add(labelImie);

        textNazwisko = new JTextField();
        textNazwisko.setBounds(60, 125, 250, 40);
        panelDodajPracownika.add(textNazwisko);
        labelNazwisko = new JLabel("NAZWISKO");
        labelNazwisko.setBounds(60, 110, 250, 10);
        panelDodajPracownika.add(labelNazwisko);

        textDataUrodzenia = new JTextField();
        textDataUrodzenia.setBounds(60, 200, 250, 40);
        panelDodajPracownika.add(textDataUrodzenia);
        labelDataUrodzenia = new JLabel("DATA URODZENIA (dd-mm-rrrr)");
        labelDataUrodzenia.setBounds(60, 185, 250, 10);
        panelDodajPracownika.add(labelDataUrodzenia);

        textPesel = new JTextField();
        textPesel.setBounds(60, 275, 250, 40);
        panelDodajPracownika.add(textPesel);
        labelPesel = new JLabel("PESEL");
        labelPesel.setBounds(60, 260, 250, 10);
        panelDodajPracownika.add(labelPesel);

        textPlec = new JTextField();
        textPlec.setBounds(60, 350, 250, 40);
        panelDodajPracownika.add(textPlec);
        labelPlec = new JLabel("PLEC");
        labelPlec.setBounds(60, 335, 250, 10);
        panelDodajPracownika.add(labelPlec);

        textZarobki = new JTextField();
        textZarobki.setBounds(60, 425, 250, 40);
        panelDodajPracownika.add(textZarobki);
        JLabel labelZarobki = new JLabel("ZAROBKI");
        labelZarobki.setBounds(60, 410, 250, 10);
        panelDodajPracownika.add(labelZarobki);

        textStanowisko = new JTextField();
        textStanowisko.setBounds(60, 500, 250, 40);
        panelDodajPracownika.add(textStanowisko);
        JLabel labelStanowisko = new JLabel("STANOWISKO");
        labelStanowisko.setBounds(60, 485, 250, 10);
        panelDodajPracownika.add(labelStanowisko);

        textPublikacje = new JTextField();
        textPublikacje.setBounds(60, 575, 110, 40);
        panelDodajPracownika.add(textPublikacje);
        JLabel labelPublikacje = new JLabel("IL PUBLIKACJE");
        labelPublikacje.setBounds(60, 560, 110, 10);
        panelDodajPracownika.add(labelPublikacje);

        textStaz = new JTextField();
        textStaz.setBounds(200, 575, 110, 40);
        panelDodajPracownika.add(textStaz);
        JLabel labelStaz = new JLabel("STAZ");
        labelStaz.setBounds(200, 560, 110, 10);
        panelDodajPracownika.add(labelStaz);


        //BUTTON DODAJ
        buttonDodajPracownikaNaukowego2= new JButton();
        buttonDodajPracownikaNaukowego2.setText("Dodaj");
        buttonDodajPracownikaNaukowego2.setBounds(220, 625, 90, 40);
        buttonDodajPracownikaNaukowego2.setFocusable(false);
        buttonDodajPracownikaNaukowego2.addActionListener(menuGlowneListener);
        panelDodajPracownika.add(buttonDodajPracownikaNaukowego2);
    }
    public void rysujPanelWyszukiwanie(JPanel panelGlowny) {
        //PANEL STUDENT
        JPanel panelWyszukaj = new JPanel();
        panelWyszukaj.setBounds(0, 0, 590, 1620);
        panelWyszukaj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelWyszukaj.setLayout(null);
        panelGlowny.add(panelWyszukaj);

        //LABEL STUDENT
        JLabel labelStudent = new JLabel("WYSZUKIWANIE");
        labelStudent.setFont(new Font(null, Font.BOLD, 25));
        labelStudent.setBounds(200, 30, 250, 50);
        panelWyszukaj.add(labelStudent);

        //TEXT
        textWyszukaj = new JTextField();
        textWyszukaj.setBounds(20, 80, 250, 40);
        panelWyszukaj.add(textWyszukaj);

        //BUTTONS
        wyszukajStudentaPoNazwisku = new JButton("Studenta po nazwisku");
        wyszukajStudentaPoNazwisku.setBounds(20, 150, 300, 50);
        wyszukajStudentaPoNazwisku.addActionListener(menuGlowneListener);
        wyszukajStudentaPoNazwisku.setBackground(Color.WHITE);
        wyszukajStudentaPoNazwisku.setFocusable(false);
        panelWyszukaj.add(wyszukajStudentaPoNazwisku);

        wyszukajPracownikaPoNazwisku = new JButton("Pracownika po nazwisku");
        wyszukajPracownikaPoNazwisku.setBounds(20, 200, 300, 50);
        wyszukajPracownikaPoNazwisku.addActionListener(menuGlowneListener);
        wyszukajPracownikaPoNazwisku.setBackground(Color.WHITE);
        wyszukajPracownikaPoNazwisku.setFocusable(false);
        panelWyszukaj.add(wyszukajPracownikaPoNazwisku);

        wyszukajPracownikaNaukowegoPoNazwisku = new JButton("Pracownika naukowego po nazwisku");
        wyszukajPracownikaNaukowegoPoNazwisku.setBounds(20, 250, 300, 50);
        wyszukajPracownikaNaukowegoPoNazwisku.addActionListener(menuGlowneListener);
        wyszukajPracownikaNaukowegoPoNazwisku.setBackground(Color.WHITE);
        wyszukajPracownikaNaukowegoPoNazwisku.setFocusable(false);
        panelWyszukaj.add(wyszukajPracownikaNaukowegoPoNazwisku);

        wyszukajPowyzejWartosciDorobkuT = new JButton("Powyzej dorobku T");
        wyszukajPowyzejWartosciDorobkuT.setBounds(20, 300, 300, 50);
        wyszukajPowyzejWartosciDorobkuT.addActionListener(menuGlowneListener);
        wyszukajPowyzejWartosciDorobkuT.setBackground(Color.WHITE);
        wyszukajPowyzejWartosciDorobkuT.setFocusable(false);
        panelWyszukaj.add(wyszukajPowyzejWartosciDorobkuT);

        wyszukajPoStanowisku = new JButton("Po stanowisku pracownika naukowego");
        wyszukajPoStanowisku.setBounds(20, 350, 300, 50);
        wyszukajPoStanowisku.addActionListener(menuGlowneListener);
        wyszukajPoStanowisku.setBackground(Color.WHITE);
        wyszukajPoStanowisku.setFocusable(false);
        panelWyszukaj.add(wyszukajPoStanowisku);

        WyszukajPoStanowiskuPracownikaUczelni = new JButton("Po stanowisku pracownika uczelni");
        WyszukajPoStanowiskuPracownikaUczelni.setBounds(20, 400, 300, 50);
        WyszukajPoStanowiskuPracownikaUczelni.addActionListener(menuGlowneListener);
        WyszukajPoStanowiskuPracownikaUczelni.setBackground(Color.WHITE);
        WyszukajPoStanowiskuPracownikaUczelni.setFocusable(false);
        panelWyszukaj.add(WyszukajPoStanowiskuPracownikaUczelni);

        wyszukajPoNazwisku = new JButton("Po nazwisku");
        wyszukajPoNazwisku.setBounds(20, 450, 300, 50);
        wyszukajPoNazwisku.addActionListener(menuGlowneListener);
        wyszukajPoNazwisku.setBackground(Color.WHITE);
        wyszukajPoNazwisku.setFocusable(false);
        panelWyszukaj.add(wyszukajPoNazwisku);

        wyszukajPoIndeksie = new JButton("Po indeksie");
        wyszukajPoIndeksie.setBounds(20, 500, 300, 50);
        wyszukajPoIndeksie.addActionListener(menuGlowneListener);
        wyszukajPoIndeksie.setBackground(Color.WHITE);
        wyszukajPoIndeksie.setFocusable(false);
        panelWyszukaj.add(wyszukajPoIndeksie);
    }

    public JButton getWyszukajStudentaPoNazwisku() {
        return wyszukajStudentaPoNazwisku;
    }

    public JButton getWyszukajPracownikaPoNazwisku() {
        return wyszukajPracownikaPoNazwisku;
    }

    public JButton getWyszukajPracownikaNaukowegoPoNazwisku() {
        return wyszukajPracownikaNaukowegoPoNazwisku;
    }

    public JButton getWyszukajPowyzejWartosciDorobkuT() {
        return wyszukajPowyzejWartosciDorobkuT;
    }

    public JButton getWyszukajPoStanowisku() {
        return wyszukajPoStanowisku;
    }

    public JTextField getTextWyszukaj() {
        return textWyszukaj;
    }

    public JButton getWyszukajPoNazwisku() {
        return wyszukajPoNazwisku;
    }

    public JButton getWyszukajPoStanowiskuPracownikaUczelni() {
        return WyszukajPoStanowiskuPracownikaUczelni;
    }

    public JButton getWyszukajPoIndeksie() {
        return wyszukajPoIndeksie;
    }

    public JTextField getTextNazwaKursu() {
        return textNazwaKursu;
    }

    public JTextField getTextWykladowca() {
        return textWykladowca;
    }

    public JButton getButtonDodajPracownikaNaukowego() {
        return buttonDodajPracownikaNaukowego;
    }

    public JButton getButtonDodajPracownikaNaukowego2() {
        return buttonDodajPracownikaNaukowego2;
    }

    public JButton getButtonDodajKurs() {
        return buttonDodajKurs;
    }

    public Map<JButton, PracownikUczelniNaukowoDydaktyczny> getButtonNaukowyMap() {
        return buttonNaukowyMap;
    }

    public JRadioButton getButtonAktywnosc() {
        return buttonAktywnosc;
    }

    public JRadioButton getButtonSredniaOcen() {
        return buttonSredniaOcen;
    }

    public JRadioButton getButtonStaz() {
        return buttonStaz;
    }

    public JRadioButton getButtonIloscPublikacji() {
        return buttonIloscPublikacji;
    }

    public JButton getButtonStrategia() {
        return buttonStrategia;
    }
    public JButton getButtonDodajStudenta() {
        return buttonDodajStudenta;
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

    public JTextField getTextNumerSemestru() {
        return textNumerSemestru;
    }

    public JButton getButtonDodajStudenta2() {
        return buttonDodajStudenta2;
    }

    public JPanel getPanelStudentci() {
        return panelStudentci;
    }

    public JScrollPane getScrollPaneKoszyk() {
        return scrollPaneKoszyk;
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


    public JFrame getFrame() {
        return frame;
    }


    public JTextField getTextStaz() {
        return textStaz;
    }


    public ArrayList<Osoba> getOsoba() {
        return this.osoba;
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

    public Map<JButton, Student> getKursStudentMap() {
        return kursStudentMap;
    }

    public JButton getButtonDodajPracownika2() {
        return buttonDodajPracownika2;
    }

    public JButton getButtonWyjdz() {
        return buttonWyjdz;
    }
    public Map<JButton, PracownikUczelni> getButtonPracownikMap() {
        return buttonPracownikMap;
    }

    public Map<JButton, Student> getButtonStudentMap() {
        return buttonStudentMap;
    }

    public static void main(String[] args) {
        ArrayList<Osoba> osoby = new ArrayList<>();
        File plik = new File("ListaOsob.ser");
        Serializacja.odczytSer(osoby, plik);

        JFrame ramka = new JFrame();
        ramka.setSize(1920, 1080);
        ramka.setLayout(new BoxLayout(ramka.getContentPane(), BoxLayout.Y_AXIS));
        ramka.setVisible(true);
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuGlowne menu = new MenuGlowne();
        menu.openMenuGlowne(ramka, osoby);
        ramka.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Dziala");
                ramka.setVisible(false);
                Serializacja.zapisSer(osoby, plik);

            }
        });
    }

    public ImageIcon scaleIcon(ImageIcon icon, int x, int y) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        return scaledIcon;
    }

}
