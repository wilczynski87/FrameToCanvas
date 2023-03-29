package com.plotno.plotno.data;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.awt.Color;

@StyleSheet("./style.css")
public class Obraz extends HorizontalLayout {
    public static int iloscObrazow = 1;

    @Autowired
    ListaObrazow listaObrazow;

    H2 title = new H2("Obraz: " + iloscObrazow);
    Div image = new Div();
    VerticalLayout wymiary = new VerticalLayout();
    HorizontalLayout wys = new HorizontalLayout();
    HorizontalLayout szer = new HorizontalLayout();

    public Obraz(Double wysokosc, Double szerokosc) {
        
        wys.add(new Span("Wysokość: " + wysokosc.toString()));
        szer.add(new Span("Szerokość: " + szerokosc.toString()));
        
        wymiary.add(title, wys, szer, removeButton());
        image.setHeight(wysokosc.floatValue(), Unit.PIXELS);
        image.setWidth(szerokosc.floatValue(), Unit.PIXELS);
        image.addClassName("wielkoscObrazu");

        // create object of Random class
        Random obj = new Random();
        int randNum = obj.nextInt(0xffffff + 1);
        // format it as hexadecimal string and print
        String colorCode = String.format("#%06x", randNum);

        image.getStyle().set("background", colorCode);

        add(image, wymiary);

        iloscObrazow++;
    }

    private Button removeButton() {
        addClickShortcut(Key.ENTER); 
        Button removeButton = new Button("usuń obraz"); 
        removeButton.addClickListener(e -> {            
            this.removeFromParent();
        });
        return removeButton; 
    }
    
}
