package Grafika.MenuGlowne;

import Main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.*;
import static Main.Wyszukaj.*;


public class MenuGlowneListener implements ActionListener {
    private MenuGlowne menu;

    public MenuGlowneListener(MenuGlowne menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if (e.getSource() == menu.getButtonAktywnosc()){
            menu.getPanelGlowny().removeAll();
            menu.rysujStrategie(menu.getPanelGlowny());
        }
        if (e.getSource() == menu.getButtonSredniaOcen()){
            menu.getPanelGlowny().removeAll();
            menu.rysujStrategie(menu.getPanelGlowny());
        }
        if (e.getSource() == menu.getButtonIloscPublikacji()){
            menu.getPanelGlowny().removeAll();
            menu.rysujStrategie(menu.getPanelGlowny());
        }
        if (e.getSource() == menu.getButtonStaz()){
            menu.getPanelGlowny().removeAll();
            menu.rysujStrategie(menu.getPanelGlowny());
        }*/
        if (e.getSource() == menu.getButtonStudent()) {
            menu.getPanelGlowny().removeAll();
            menu.rysujPanelStudent(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getButtonDodajStudenta()) {
            menu.rysujDodajStudenta(menu.getPanelGlowny());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), Student.class, menu.getOsoba());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getButtonDodajStudenta2()) {
            dodajStudenta(menu.getOsoba(), menu.getTextImie().getText(), menu.getTextNazwisko().getText(), menu.getTextPesel().getText(), menu.getTextPlec().getText(), menu.getTextIndeks().getText(), menu.getTextDataUrodzenia().getText(), menu.getTextStopienStudiow().getText(), menu.getTextNumerSemestru().getText());
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
            menu.rysujPanelStudentow(menu.getPanelGlowny(), Student.class, menu.getOsoba());
        }
        if (e.getSource() == menu.getButtonPracownik()) {
            menu.getPanelGlowny().removeAll();
            menu.rysujPanelPracownik(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getDodajPracownika()) {
            menu.rysujDodajPracownika(menu.getPanelGlowny());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelni.class, menu.getOsoba());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getButtonDodajPracownika2()) {
            dodajPracownikaUczelni(menu.getOsoba(), menu.getTextImie().getText(), menu.getTextNazwisko().getText(), menu.getTextPesel().getText(), menu.getTextPlec().getText(), menu.getTextZarobki().getText(), menu.getTextStaz().getText(), menu.getTextStanowisko().getText(), menu.getTextDataUrodzenia().getText(), menu.getTextDorobek().getText());
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelni.class, menu.getOsoba());
        }
        if (e.getSource() == menu.getButtonWyszukaj()) {
            menu.getPanelGlowny().removeAll();
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
            menu.rysujPanelStudentow(menu.getPanelGlowny(),Osoba.class,menu.getOsoba());
            menu.rysujPanelWyszukiwanie(menu.getPanelGlowny());
        }
        if (e.getSource() == menu.getWyszukajStudentaPoNazwisku()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), Student.class, wyszukajPoNazwisku(menu.getOsoba(), menu.getTextWyszukaj().getText(), Student.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }

        if (e.getSource() == menu.getWyszukajPracownikaPoNazwisku()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelni.class, wyszukajPoNazwisku(menu.getOsoba(), menu.getTextWyszukaj().getText(), PracownikUczelni.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }

        if (e.getSource() == menu.getWyszukajPracownikaNaukowegoPoNazwisku()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelniNaukowoDydaktyczny.class, wyszukajPoNazwisku(menu.getOsoba(), menu.getTextWyszukaj().getText(), PracownikUczelniNaukowoDydaktyczny.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }

        if (e.getSource() == menu.getWyszukajPoStanowisku()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelniNaukowoDydaktyczny.class, wyszukajPracownikaAdministracyjnegoPoStanowusku(menu.getOsoba(), menu.getTextWyszukaj().getText(), PracownikUczelniNaukowoDydaktyczny.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }

        if (e.getSource() == menu.getWyszukajPoStanowiskuPracownikaUczelni()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelni.class, wyszukajPracownikaAdministracyjnegoPoStanowusku(menu.getOsoba(), menu.getTextWyszukaj().getText(), PracownikUczelni.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getWyszukajPoNazwisku()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), Osoba.class, wyszukajPoNazwisku(menu.getOsoba(), menu.getTextWyszukaj().getText(), Osoba.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getWyszukajPoIndeksie()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), Student.class, wyszukajStudentaPoIndeksie(menu.getOsoba(), menu.getTextWyszukaj().getText()));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getWyszukajPowyzejWartosciDorobkuT()) {
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelni.class, wyszukajPracownikaUczelniOWartosciDorobkuPowyzejT(menu.getOsoba(), Integer.parseInt(String.valueOf(menu.getTextWyszukaj().getText())), PracownikUczelni.class));
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if(e.getSource()instanceof JButton) {
            if (e.getSource() instanceof JButton && menu.getKursStudentMap() != null) {
                JButton sourceButton = (JButton) e.getSource();
                Student data = menu.getKursStudentMap().get(sourceButton);

                if (data != null) {

                    menu.getOsoba().get(menu.getOsoba().indexOf(data)).dodajKurs(menu.getTextNazwaKursu().getText(), menu.getTextWykladowca().getText());
                    menu.getPanelGlowny().remove(menu.getPanelStudentci());
                    menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
                    menu.rysujPanelStudentow(menu.getPanelGlowny(), Student.class, menu.getOsoba());
                    menu.getPanelStudentci().revalidate();
                    menu.getPanelStudentci().repaint();
                }
            }
            if (e.getSource() instanceof JButton && menu.getButtonStudentMap() != null || menu.getButtonPracownikMap() != null) {
                JButton sourceButton = (JButton) e.getSource();
                Student produktToRemove = menu.getButtonStudentMap().get(sourceButton);
                PracownikUczelni pracownikToRemove = menu.getButtonPracownikMap().get(sourceButton);
                PracownikUczelniNaukowoDydaktyczny naukowyToRemove = menu.getButtonNaukowyMap().get(sourceButton);

                if (produktToRemove != null || pracownikToRemove != null || naukowyToRemove != null) {
                    if (produktToRemove instanceof Student) {
                        menu.getOsoba().remove(produktToRemove);
                    }
                    if (pracownikToRemove instanceof PracownikUczelni) {
                        menu.getOsoba().remove(pracownikToRemove);
                    }
                    if (naukowyToRemove instanceof PracownikUczelniNaukowoDydaktyczny) {
                        menu.getOsoba().remove(naukowyToRemove);
                    }
                    menu.getPanelStudentci().remove(sourceButton.getParent());
                    menu.getPanelStudentci().revalidate();
                    menu.getPanelStudentci().repaint();
                    menu.getPanelStudentci().setPreferredSize(new Dimension(700, menu.getPanelStudentci().getComponentCount() * 200));
                }
            }
        }
        if (e.getSource()==menu.getButtonDodajPracownikaNaukowego()){
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelniNaukowoDydaktyczny.class, menu.getOsoba());
            menu.rysujDodajPracownikaNaukowego(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource()==menu.getButtonDodajPracownikaNaukowego2()){
            dodajPracownikaNaukowegoo(menu.getOsoba(), menu.getTextImie().getText(), menu.getTextNazwisko().getText(), menu.getTextPesel().getText(), menu.getTextPlec().getText(), menu.getTextZarobki().getText(), menu.getTextStaz().getText(), menu.getTextStanowisko().getText(), menu.getTextDataUrodzenia().getText(), menu.getTextPublikacje().getText());
            menu.getPanelGlowny().remove(menu.getPanelStudentci());
            menu.getPanelGlowny().remove(menu.getScrollPaneKoszyk());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
            menu.rysujPanelStudentow(menu.getPanelGlowny(), PracownikUczelniNaukowoDydaktyczny.class, menu.getOsoba());
        }
        if(e.getSource()==menu.getButtonPracownikNaukowy()){
            menu.getPanelGlowny().removeAll();
            menu.rysujPanelPracownikNaukowy(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource()==menu.getButtonStrategia()){
            menu.getPanelGlowny().removeAll();
            menu.rysujStrategie(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
    }
}
