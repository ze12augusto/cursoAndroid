package com.example.a10026222.teste.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a10026222 on 25/11/14.
 */
public class Lembretes {

    private List<Lembrete> lembretes;
    private static Lembretes instance;

    public static Lembretes getInstance(){
        if( instance == null ){
            instance = new Lembretes();
        }

        return  instance;
    }

    private Lembretes(){
        this.lembretes = new ArrayList<Lembrete>();
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public void addLembrete(Lembrete lembrete){
        this.lembretes.add(lembrete);
    }
}
