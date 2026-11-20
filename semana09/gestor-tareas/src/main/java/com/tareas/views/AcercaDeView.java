package com.tareas.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "acerca", layout = MainLayout.class)
public class AcercaDeView extends VerticalLayout {

    public AcercaDeView() {

        add(
            new H1("Acerca de"),
            new Paragraph(
                "Gestor de Tareas con navegación multi-vista, " +
                "desarrollado con Java y Vaadin."
            )
        );
    }
}
