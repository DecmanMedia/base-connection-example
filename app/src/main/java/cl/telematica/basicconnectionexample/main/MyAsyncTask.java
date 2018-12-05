package cl.telematica.basicconnectionexample.main;

import android.os.AsyncTask;

import java.util.List;

import cl.telematica.basicconnectionexample.connection.HttpServerConnection;
import cl.telematica.basicconnectionexample.connection.RetrofitConnection;
import cl.telematica.basicconnectionexample.models.Libro;
import cl.telematica.basicconnectionexample.main.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    private String url;
    private int timeOut;
    private MainView mainView;

    public MyAsyncTask(String url, int timeOut, MainView mainView) {
        this.url = url;
        this.timeOut = timeOut;
        this.mainView = mainView;
    }

    @Override
    protected void onPreExecute()
    {
        //Antes de ejecutar la hebra
    }

    @Override
    protected String doInBackground(Void... voids) {


        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .build();

        RetrofitConnection service = restAdapter.create(RetrofitConnection.class);
        service.getLibro(new Callback<List<Libro>>() {

            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                List<Libro> list = response.body();
                mainView.populateRecyclerView(list);
            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {

            }
        });

        //String resultado = new HttpServerConnection().connectToServer(url, timeOut);
        return "Hola";
    }

    @Override
    protected void onPostExecute(String result) {
        if(result != null) {
            //populateRecyclerView(Libro.getLibros(result));
            //mainView.populateRecyclerView(Libro.getLibros(result));
        }
    }

}
