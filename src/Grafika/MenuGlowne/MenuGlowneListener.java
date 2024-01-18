package Grafika.MenuGlowne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.dodajPracownikaUczelni;
import static Main.Main.dodajStudenta;

public class MenuGlowneListener implements ActionListener {
    private MenuGlowne menu;


    public MenuGlowneListener(MenuGlowne menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getButtonStudent()) {
            menu.getPanelGlowny().removeAll();
            menu.rysujPanelStudent(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if(e.getSource() == menu.getButtonDodajStudenta()){
            menu.rysujDodajStudenta(menu.getPanelGlowny());
            menu.rysujPanelStudent(menu.getPanelGlowny(),menu.getOsoba());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getButtonDodajStudenta2()){
            dodajStudenta(menu.getOsoba(), menu.getTextImie().getText(), menu.getTextNazwisko().getText(), menu.getTextPesel().getText(), menu.getTextPlec().getText(),menu.getTextIndeks().getText(),menu.getTextDataUrodzenia().getText(),menu.getTextStopienStudiow().getText(),menu.getTextNumerSemestru().getText());
        }
        if (e.getSource() == menu.getButtonPracownik()){
            menu.getPanelGlowny().removeAll();
            menu.rysujPanelPracownik(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getDodajPracownika()){
            menu.rysujDodajPracownika(menu.getPanelGlowny());
            menu.getPanelGlowny().revalidate();
            menu.getPanelGlowny().repaint();
        }
        if (e.getSource() == menu.getButtonDodajPracownika2()){
            dodajPracownikaUczelni(menu.getOsoba(), menu.getTextImie().getText(), menu.getTextNazwisko().getText(), menu.getTextPesel().getText(), menu.getTextPlec().getText(), menu.getTextZarobki().getText(),menu.getTextStaz().getText(),menu.getTextStanowisko().getText(), menu.getTextDataUrodzenia().getText(),menu.getTextPublikacje().getText(),menu.getTextDorobek().getText());
        }
    }
}
