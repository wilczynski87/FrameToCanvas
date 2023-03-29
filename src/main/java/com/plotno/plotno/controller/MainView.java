package com.plotno.plotno.controller;

import com.plotno.plotno.data.DodajObraz;
import com.plotno.plotno.data.ListaObrazow;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
public class MainView extends VerticalLayout {

    ListaObrazow listaObrazow;
    
    public MainView(ListaObrazow listaObrazow) { 
      setWidthFull();
      this.listaObrazow = listaObrazow;

      DodajObraz dodajObraz = new DodajObraz(listaObrazow);
      listaObrazow.setWidth("1000px");

      add( 
      new H1("Prosze podac parametry, Panie Stróżyk:")
      ,listaObrazow
      ,dodajObraz
      );
    }

}
