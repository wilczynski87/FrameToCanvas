package com.plotno.plotno.controller;

import com.plotno.plotno.data.DodajObraz;
import com.plotno.plotno.data.ListaObrazow;
import com.plotno.plotno.data.ListaPlocien;
import com.plotno.plotno.data.ParametryPlotna;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
public class MainView extends VerticalLayout {

    ListaObrazow listaObrazow;
    ListaPlocien listaPlocien;
    
    ParametryPlotna parametryPlotna;
    
    public MainView(ListaObrazow listaObrazow, ListaPlocien listaPlocien) { 
      this.listaObrazow = listaObrazow;
      this.listaPlocien = listaPlocien;

      DodajObraz dodajObraz = new DodajObraz(listaObrazow);
      listaObrazow.setWidth("100%");

      parametryPlotna = new ParametryPlotna(listaPlocien);
      HorizontalLayout plotna = new HorizontalLayout(parametryPlotna, listaPlocien);
      plotna.setWidth("100%");
      // System.out.println();
      // System.out.println("lista plucien w Main:");
      // System.out.println(listaPlocien);
      // System.out.println();

      add( 
      new H1("Prosze podac parametry, Panie Stróżyk:")
      ,listaObrazow
      ,dodajObraz
      ,plotna
      );
    }

}
