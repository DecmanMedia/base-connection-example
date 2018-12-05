<<<<<<< HEAD
package cl.telematica.basicconnectionexample.connection;


import java.util.List;

import cl.telematica.basicconnectionexample.models.Libro;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface RetrofitConnection {

    @GET("v2/5bfc6aa9310000780039be36")
    void getLibro(Callback<List<Libro>> callback);
}
=======
package cl.telematica.basicconnectionexample.connection;


import java.util.List;

import cl.telematica.basicconnectionexample.models.Libro;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface RetrofitConnection {

    @GET("v2/5bfc6aa9310000780039be36")
    void getLibro(Callback<List<Libro>> callback);
}
>>>>>>> 4b11cc714d9f53473ffc079b6740793df28cd45b
