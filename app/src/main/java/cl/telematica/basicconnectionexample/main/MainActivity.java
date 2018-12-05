package cl.telematica.basicconnectionexample.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import cl.telematica.basicconnectionexample.R;
import cl.telematica.basicconnectionexample.connection.RetrofitConnection;
import cl.telematica.basicconnectionexample.main.presenter.MainPresenterImpl;
import cl.telematica.basicconnectionexample.models.Libro;
import cl.telematica.basicconnectionexample.main.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MainView {

    public static Context context;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        mRecyclerView = findViewById(R.id.recyclerView);

        setRecyclerViewParams();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .build();

        RetrofitConnection service = restAdapter.create(RetrofitConnection.class);
        service.getLibro(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                List<Libro> list = response.body();
                populateRecyclerView(list);
            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {

            }
        });

        MainPresenterImpl presenter = new MainPresenterImpl(this);

        presenter.fetchData("http://www.mocky.io/v2/5bfc6aa9310000780039be36", 15000);
    }

    @Override
    public void setRecyclerViewParams() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void populateRecyclerView(List<Libro> libros) {
        mAdapter = new UIAdapter(context, libros);
        mRecyclerView.setAdapter(mAdapter);
    }

}
