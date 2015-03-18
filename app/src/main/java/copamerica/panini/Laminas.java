package copamerica.panini;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.Collections;
import java.util.List;

import copamerica.bd.Paginas;
import copamerica.controladores.LaminasAdapter;
import copamerica.modelos.Lamina;
import copamerica.util.Actualizar;


public class Laminas extends ActionBarActivity implements Actualizar {

    GridView listado_laminas;
    Paginas paginas;
    LaminasAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laminas);

        listado_laminas = (GridView)findViewById(R.id.gr_laminas);
        paginas = new Paginas(this);
        paginas.openBD();
        Cursor validar = paginas.getRegistrosSeleccion("Copa America");
        if(!validar.moveToFirst()){
            for(int i = 1 ; i <=30 ; i++){

                paginas.insertarContenido(i,0,"no","Copa America",R.drawable.fondo_lamina,"#3F51B5",R.drawable.fondo_lamina);

            }
        }
        Cursor cursor = paginas.getRegistrosSeleccion("Copa America");
        List<Lamina> laminas = paginas.getContentData(cursor);
        adapter = new LaminasAdapter(this,laminas,Laminas.class);
        adapter.setCorreosListener(this);
        listado_laminas.setAdapter(adapter);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(laminas.get(0).getColor())));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_laminas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_selecciones) {


            Intent t = new Intent(this,Selecciones.class);
            startActivity(t);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void añadirLamina(int id) {

        paginas.actualizar(id,R.drawable.estadio,"si");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        paginas.closeBD();
    }
}
