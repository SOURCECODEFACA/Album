package copamerica.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import copamerica.modelos.Lamina;

/**
 * Created by ing daniel on 17/03/2015.
 */
public class Paginas {

    BDManager bdManager;
    SQLiteDatabase database;

    public Paginas(Context context){
        bdManager = new BDManager(context);
    }

    public void openBD(){
        database = bdManager.getWritableDatabase();
    }

    public void  closeBD(){
        database.close();
    }

    public void insertarContenido(int codigo , int ficha , String estado , String tipo , int fondo , String color , int banner){


        ContentValues values = new ContentValues();
        values.put(BDManager.COLUM_ID,codigo);
        values.put(BDManager.COLUM_FICHA,ficha);
        values.put(BDManager.COLUM_ESTADO,estado);
        values.put(BDManager.COLUM_TIPO,tipo);
        values.put(BDManager.COLUM_FONDO,fondo);
        values.put(BDManager.COLUM_COLOR,color);
        values.put(BDManager.COLUM_BANNER,banner);

        database.insert(BDManager.NOM_TABLE_PAGINAS,null,values);

    }

    public Cursor getRegistros(){

        return database.query(BDManager.NOM_TABLE_PAGINAS,new String[]{
                              BDManager.COLUM_ID,
                              BDManager.COLUM_FICHA,
                              BDManager.COLUM_ESTADO,
                              BDManager.COLUM_TIPO,
                              BDManager.COLUM_FONDO,
                              BDManager.COLUM_COLOR,
                              BDManager.COLUM_BANNER
        },null,null,null,null,null);

    }
    public Cursor getRegistrosSeleccion(String tipo){

        return database.query(BDManager.NOM_TABLE_PAGINAS,new String[]{
                BDManager.COLUM_ID,
                BDManager.COLUM_FICHA,
                BDManager.COLUM_ESTADO,
                BDManager.COLUM_TIPO,
                BDManager.COLUM_FONDO,
                BDManager.COLUM_COLOR,
                BDManager.COLUM_BANNER
        },BDManager.COLUM_TIPO+" = '"+tipo+"'",null,null,null,null);

    }

    public List<Lamina> getContentData(Cursor c){

        List<Lamina> laminas = new ArrayList<>();
        if(c.moveToFirst()){

            do{

                Lamina lamina = new Lamina();
                lamina.setId(c.getInt(BDManager.COLUM_INDEX_ID));
                lamina.setFicha(c.getInt(BDManager.COLUM_INDEX_FICHA));
                lamina.setEstado(c.getString(BDManager.COLUM_INDEX_ESTADO));
                lamina.setTipo(c.getString(BDManager.COLUM_INDEX_TIPO));
                lamina.setFondo(c.getInt(BDManager.COLUM_INDEX_FONDO));
                lamina.setColor(c.getString(BDManager.COLUM_INDEX_COLOR));
                lamina.setBanner(c.getInt(BDManager.COLUM_INDEX_BANNER));

                laminas.add(lamina);

            }while (c.moveToNext());
        }

        return laminas;
    }

    public void actualizar(int id,int ficha , String estado){
        ContentValues values = new ContentValues();
        values.put(BDManager.COLUM_FICHA,ficha);
        values.put(BDManager.COLUM_ESTADO,estado);

        database.update(BDManager.NOM_TABLE_PAGINAS,values,BDManager.COLUM_ID+"="+id,null);
    }

}
