package copamerica.panini;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import copamerica.bd.Paginas;
import copamerica.controladores.LaminasAdapter;
import copamerica.modelos.Lamina;
import copamerica.util.Actualizar;


public class Selecciones extends ActionBarActivity implements Actualizar {

    GridView gr_equipo;
    ImageView img_banner;
    Paginas paginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciones);

        gr_equipo = (GridView)findViewById(R.id.gr_selecciones);
        img_banner = (ImageView)findViewById(R.id.img_selecciones);

        paginas = new Paginas(this);
        paginas.openBD();
        Cursor validar = paginas.getRegistrosSeleccion("Seleccion Colombia");
        if(!validar.moveToFirst()){
            for(int i = 31 ; i <= 48 ; i++){
                paginas.insertarContenido(i,0,"no","Seleccion Colombia",R.drawable.fondo_col,"#FFEB3B",R.drawable.colombia);
            }
        }
        Cursor cursor = paginas.getRegistrosSeleccion("Seleccion Colombia");

        List<Lamina> laminas = paginas.getContentData(cursor);
        LaminasAdapter adapter = new LaminasAdapter(this,laminas,Selecciones.class);

        gr_equipo.setAdapter(adapter);
        adapter.setCorreosListener(this);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(laminas.get(0).getColor())));
        getSupportActionBar().setTitle(laminas.get(0).getTipo());
        img_banner.setImageResource(laminas.get(0).getBanner());





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        paginas.closeBD();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selecciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void añadirLamina(int id) {

        paginas.actualizar(id,R.drawable.escudo_colombia,"si");

    }
}
