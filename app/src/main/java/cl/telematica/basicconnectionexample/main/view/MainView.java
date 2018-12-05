package cl.telematica.basicconnectionexample.main.view;

import java.util.List;

import cl.telematica.basicconnectionexample.models.Libro;

public interface MainView {
    void setRecyclerViewParams();
    void populateRecyclerView(List<Libro> libros);
}
