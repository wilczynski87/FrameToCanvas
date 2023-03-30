package com.plotno.plotno.data;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Component
public class ListaObrazow extends FlexLayout  {

    public ListaObrazow() {
        setFlexDirection(FlexDirection.ROW);
        setFlexWrap(FlexWrap.WRAP);
    }
    
}
