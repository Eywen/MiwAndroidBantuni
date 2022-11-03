package es.upm.miw.bantumi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import es.upm.miw.bantumi.model.PuntuacionEntity;
import es.upm.miw.bantumi.model.PuntuacionViewModel;
import es.upm.miw.bantumi.views.PuntuacionListAdapter;

public class TopTenActivity extends AppCompatActivity {
    PuntuacionViewModel puntuacionViewModel;
    LiveData<List<PuntuacionEntity>> topTen;
    private Button btBoton;
    protected final String LOG_TAG = "MiW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topten);
        // Add the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final PuntuacionListAdapter adapter = new PuntuacionListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        puntuacionViewModel = new ViewModelProvider(this).get(PuntuacionViewModel.class);
        topTen = puntuacionViewModel.getTopTen();
        topTen.observe(this, adapter::setTopTen);
        btBoton = findViewById(R.id.btDeleteTopTen);

        btBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteTopTenDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
            }
        });
    }

    public void eliminarTopTen(){

        for (PuntuacionEntity puntuacion : topTen.getValue()){
            this.puntuacionViewModel.delete(puntuacion);
        }

        Snackbar.make(
                findViewById(android.R.id.content),
                getString(R.string.txtDialogoTopTenEliminado),
                Snackbar.LENGTH_LONG
        ).show();
    }

}
