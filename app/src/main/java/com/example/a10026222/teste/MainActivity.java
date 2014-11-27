package com.example.a10026222.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.a10026222.teste.adapter.AdapterLembrete;
import com.example.a10026222.teste.entidades.Lembrete;
import com.example.a10026222.teste.entidades.Lembretes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity {

    private Button btAdicionar;
    private ListView listView;
    private AdapterLembrete adapter;
    private Lembretes lembretes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAdicionar = (Button) findViewById(R.id.btAdicionar);
        listView = (ListView) findViewById(R.id.listView);

        lembretes = Lembretes.getInstance();
        inicializaBotoes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adicionarListaNoAdapter();
    }

    private void inicializaBotoes(){
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdicionarLembreteActivity.class);
                startActivity(it);
            }
        });
    }

    private void adicionarListaNoAdapter() {
        adapter = new AdapterLembrete(getApplicationContext(), lembretes.getLembretes());
        listView.setAdapter(adapter);
    }

}
