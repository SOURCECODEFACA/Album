package copamerica.controladores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import copamerica.modelos.Lamina;
import copamerica.panini.Laminas;
import copamerica.panini.R;
import copamerica.util.Actualizar;

/**
 * Created by ing daniel on 17/03/2015.
 */
public class LaminasAdapter extends BaseAdapter {

    List<Lamina> laminas;
    Context context;
    Actualizar a;
    Class aClass;



    public LaminasAdapter(Context context,List<Lamina> laminas,Class aClass){
        this.context = context;
        this.laminas = laminas;
        this.aClass = aClass;
    }

    @Override
    public int getCount() {
        return laminas.size();
    }

    @Override
    public Object getItem(int position) {
        return laminas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return laminas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

           convertView = LayoutInflater.from(context).inflate(R.layout.item_lamina,null);

        }

        final Lamina l = laminas.get(position);

        TextView texto = (TextView)convertView.findViewById(R.id.tx_item_lamina);
        final ImageView imagen = (ImageView)convertView.findViewById(R.id.img_item_lamina);
        Button evento = (Button)convertView.findViewById(R.id.bt_evento);
        LinearLayout capa = (LinearLayout)convertView.findViewById(R.id.capa_principal);

        texto.setText(""+l.getId());
        imagen.setImageResource(l.getFicha());
        capa.setBackgroundResource(l.getFondo());


        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a.añadirLamina(l.getId());
                Intent t = new Intent(context,aClass);
                context.startActivity(t);
                Activity a = (Activity)context;
                a.finish();



            }
        });



        return convertView;
    }

    public void setCorreosListener(Actualizar a) {
        this.a=a;
    }
}
