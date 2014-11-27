package com.example.a10026222.teste;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a10026222.teste.entidades.Lembrete;
import com.example.a10026222.teste.entidades.Lembretes;

import java.util.Calendar;

/**
 * Created by a10026222 on 25/11/14.
 */
public class AdicionarLembreteActivity extends Activity{

    private Lembretes lembretes;
    private Button btSalvar;
    private Button btVoltar;
    private EditText etDescricao;
    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivyt_novo_lembrete);

        btSalvar = (Button) findViewById(R.id.btSalvar);
        btVoltar = (Button) findViewById(R.id.btVoltar);
        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etData = (EditText) findViewById(R.id.etData);

        lembretes = Lembretes.getInstance();

        inicialicaBotoes();

        desativarBtSalvar();
        validaBtSalvar();
    }

    private void inicialicaBotoes(){
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Lembrete lembrete = new Lembrete();
                lembrete.setDescricao( etDescricao.getText().toString() );
                lembrete.setData(etData.getText().toString());
                lembretes.addLembrete(lembrete);
                finish();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void validaBtSalvar() {

        etDescricao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                verificaBtSalvar();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                verificaBtSalvar();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void desativarBtSalvar(){
        btSalvar.setClickable(false);
    }

    private void ativarBtSalvar(){
        btSalvar.setClickable(true);
    }

    private void verificaBtSalvar(){
        if( etData.getText().length() > 1 && etDescricao.getText().length() > 1 ){
            ativarBtSalvar();
        }else{
            desativarBtSalvar();
        }
    }
}
