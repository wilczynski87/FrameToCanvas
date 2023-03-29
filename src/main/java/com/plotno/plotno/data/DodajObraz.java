package com.plotno.plotno.data;
import java.util.List;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;

public class DodajObraz extends FormLayout {

    NumberField wysokosc = new NumberField();
    NumberField szerokosc = new NumberField();
    Div cmSuffix = new Div();
    Div cmSuffix2 = new Div();

    public DodajObraz(ListaObrazow listaObrazow) {
        addClassName("dodaj-wyciecie");

        cmSuffix.setText("cm");
        wysokosc.setSuffixComponent(cmSuffix);
        wysokosc.setLabel("Wysokość");

        cmSuffix2.setText("cm");
        szerokosc.setSuffixComponent(cmSuffix2);
        szerokosc.setLabel("Szerokość");
    
        this.setResponsiveSteps(new ResponsiveStep("0", 1));

        add(wysokosc, szerokosc, submitButton(listaObrazow));
    }
    // dodaj obraz

    private Button submitButton(ListaObrazow listaObrazow) {
        addClickShortcut(Key.ENTER);

        Button guzik = new Button("dodaj obraz");
        guzik.addClickListener(e -> {
            if(wysokosc.getValue() == null || wysokosc.getValue() == 0 || szerokosc.getValue() == null || szerokosc.getValue() == 0) {
                Notification.show("Panie Stróżyk! obraz nie może nie mieć wymiarów!");
                return;
            }
            Obraz obraz = new Obraz(wysokosc.getValue(), szerokosc.getValue());
            listaObrazow.add(obraz);
            Notification.show("ilosc obrazow: " + listaObrazow.getComponentCount());
        });
        return guzik; 
    }
    
}
