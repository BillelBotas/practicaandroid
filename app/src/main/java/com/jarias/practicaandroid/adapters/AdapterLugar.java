package com.jarias.practicaandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jarias.practicaandroid.R;
import com.jarias.practicaandroid.base.Lugar;

import java.util.List;

public class AdapterLugar extends BaseAdapter {

    private LayoutInflater inflater;
    private int idLayout;
    private List<Lugar> lugares;

    public AdapterLugar(Context contexto, int idLayout, List<Lugar> lugares){
        inflater = LayoutInflater.from(contexto);
        this.idLayout = idLayout;
        this.lugares = lugares;
    }

    static class ViewHolder {
        TextView itvNombre;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(idLayout, null);

            holder = new ViewHolder();
            holder.itvNombre = convertView.findViewById(R.id.itvNombre);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Lugar lugar = lugares.get(position);
        holder.itvNombre.setText(lugar.getNombre());

        return convertView;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
