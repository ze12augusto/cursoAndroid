package com.example.a10026222.teste.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a10026222.teste.R;
import com.example.a10026222.teste.entidades.Lembrete;

import java.util.Calendar;
import java.util.List;

/**
 * Created by a10026222 on 25/11/14.
 */
public class AdapterLembrete extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Lembrete> lembretes;

    public AdapterLembrete(Context context, List<Lembrete> lembretes) {
        this.inflater = LayoutInflater.from(context);
        this.lembretes = lembretes;
    }

    @Override
    public int getCount() {
        return lembretes.size();
    }

    @Override
    public Lembrete getItem(int position) {
        return lembretes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Lembrete lembrete = lembretes.get(position);
        View view = inflater.inflate(R.layout.listview_lembretes, null);

        ((TextView) view.findViewById(R.id.txtDescricao)).setText(lembrete.getDescricao());
        ((TextView) view.findViewById(R.id.txtData)).setText(lembrete.getData());

        view.setTag(lembrete);
        return view;
    }
}
