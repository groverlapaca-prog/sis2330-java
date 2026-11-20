package com.tareas.views;

import com.tareas.Tarea;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class TareasView extends VerticalLayout {

    private final List<Tarea> tareas = new ArrayList<>();

    private long siguienteId = 1;

    private final Grid<Tarea> grid =
        new Grid<>(Tarea.class, false);

    private final TextField descripcion =
        new TextField("Descripción");

    private final Checkbox completada =
        new Checkbox("Completada");

    private final Binder<TareaEditable> binder =
        new Binder<>(TareaEditable.class);

    private Tarea seleccionActual;

    public TareasView() {

        // Columnas de la tabla
        grid.addColumn(Tarea::id).setHeader("ID");

        grid.addColumn(Tarea::descripcion)
            .setHeader("Descripción");

        grid.addColumn(t -> t.completada() ? "Sí" : "No")
            .setHeader("Completada");

        // Seleccionar una tarea
        grid.asSingleSelect()
            .addValueChangeListener(event ->
                cargarEnFormulario(event.getValue())
            );

        // Configurar Binder
        binder.forField(descripcion)
            .asRequired("La descripción es obligatoria")
            .bind(
                TareaEditable::getDescripcion,
                TareaEditable::setDescripcion
            );

        binder.forField(completada)
            .bind(
                TareaEditable::isCompletada,
                TareaEditable::setCompletada
            );

        // Botones
        Button guardar = new Button("Guardar",
            evento -> guardar());

        Button eliminar = new Button("Eliminar",
            evento -> eliminar());

        Button limpiar = new Button("Nuevo",
            evento -> cargarEnFormulario(null));

        // Formulario lateral
        VerticalLayout formulario = new VerticalLayout(
            descripcion,
            completada,
            new HorizontalLayout(guardar, eliminar, limpiar)
        );

        // Mostrar tabla y formulario
        add(new HorizontalLayout(grid, formulario));

        refrescarGrid();
        cargarEnFormulario(null);
    }

    // Cargar tarea seleccionada
    private void cargarEnFormulario(Tarea tarea) {

        seleccionActual = tarea;

        TareaEditable editable = new TareaEditable();

        if (tarea != null) {
            editable.setId(tarea.id());
            editable.setDescripcion(tarea.descripcion());
            editable.setCompletada(tarea.completada());
        }

        binder.readBean(editable);
    }

    // Guardar o actualizar
    private void guardar() {

        TareaEditable editable = new TareaEditable();

        if (!binder.writeBeanIfValid(editable)) {
            Notification.show(
                "Revisa los datos del formulario"
            );
            return;
        }

        if (seleccionActual == null) {

            // Agregar tarea nueva
            tareas.add(new Tarea(
                siguienteId++,
                editable.getDescripcion(),
                editable.isCompletada()
            ));

            Notification.show("Tarea agregada correctamente");

        } else {

            // Actualizar tarea seleccionada
            long id = seleccionActual.id();

            tareas.removeIf(t -> t.id() == id);

            tareas.add(new Tarea(
                id,
                editable.getDescripcion(),
                editable.isCompletada()
            ));

            Notification.show("Tarea actualizada correctamente");
        }

        refrescarGrid();
        cargarEnFormulario(null);
    }

    // Eliminar tarea
    private void eliminar() {

        if (seleccionActual == null) {

            Notification.show(
                "Selecciona una tarea para eliminar"
            );

            return;
        }

        tareas.removeIf(
            t -> t.id() == seleccionActual.id()
        );

        Notification.show("Tarea eliminada correctamente");

        refrescarGrid();
        cargarEnFormulario(null);
    }

    // Actualizar tabla
    private void refrescarGrid() {
        grid.setItems(tareas);
    }
}
