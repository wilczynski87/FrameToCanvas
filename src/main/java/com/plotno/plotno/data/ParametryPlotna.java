package com.plotno.plotno.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.plotno.plotno.controller.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;

public class ParametryPlotna extends FormLayout{
    // @Autowired
    // ListaPlocien listaPlocien;
    
    NumberField wysokosc = new NumberField();
    NumberField cena = new NumberField();
    Div cmSuffix = new Div();
    Div zlSuffix = new Div();

    public ParametryPlotna(ListaPlocien listaPlocien) {
        cmSuffix.setText("cm");
        wysokosc.setSuffixComponent(cmSuffix);
        wysokosc.setLabel("Wysokość: ");

        zlSuffix.setText("zł");
        cena.setSuffixComponent(zlSuffix);
        cena.setLabel("Cena: ");

        add(wysokosc
        ,cena
        ,submitButton(listaPlocien));
    }

    private Button submitButton(ListaPlocien listaPlocien) {

        Button guzik = new Button("dodaj płótno: ");
        guzik.addClickListener(e -> {
            if(wysokosc.getValue() == null || wysokosc.getValue() == 0 || cena.getValue() == null || cena.getValue() == 0) {
                Notification.show("Panie Stróżyk! obraz nie może nie mieć wymiarów!");
                return;
            }
            Material plotno = new Material(wysokosc.getValue().intValue(), cena.getValue());
            Notification.show("Utworzono plotno: " + Material.lp);
            // System.out.println();
            // System.out.println("lista plucien w Parametry plutna:");
            // System.out.println(listaPlocien);
            // System.out.println();
            listaPlocien.dodajPlotno(plotno);
        });
        return guzik; 
    }
}
