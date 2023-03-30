package com.plotno.plotno.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import lombok.Data;

@Data
@Component
public class ListaPlocien extends Grid<Material> {
    Material material;
    List<Material> plotna = new ArrayList<>();

    public ListaPlocien() {
        addColumn(Material::getId).setHeader("Lp: ");
        addColumn(Material::getWysokoscCm).setHeader("Wysokość: ");
        addColumn(Material::getCenaZl).setHeader("Cena: ");
        addColumn(
                new ComponentRenderer<>(Button::new, (button, plotno) -> {
                    // button.setText("usun");
                    button.setIcon(new Icon(VaadinIcon.TRASH));
                    button.addClickListener(e -> {
                        this.usunPlotno(plotno);
                        Notification.show("material clicked");
                    });
                })
                ).setHeader("Usuń:");
        // addColumn(e -> new Span("usun")).setHeader("Usuń: ");
        
        // .addAttachListener(e -> addItemClickListener(ee -> {
        //     plotna.remove(ee.getItem());
        //     this.getDataProvider().refreshAll();
        // }));
        
        // this.addItemClickListener(e -> {
        //     e.getItem();
        // });
        setItems(plotna);
    }

    public void dodajPlotno(Material material) {
        plotna.add(material);
        this.getDataProvider().refreshAll();
    }

    public Button usunPlotno(Material material) {
        Button usun = new Button("usun");
        usun.addClickListener(e -> {
            plotna.remove(material);
            this.getDataProvider().refreshAll();
        }); 
        return usun;
    }

    private void usunPlotno2(Material material) {
        if (material == null) return;
        plotna.remove(material);
        this.getDataProvider().refreshAll();
    }
    
}
