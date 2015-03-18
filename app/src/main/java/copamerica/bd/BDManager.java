package copamerica.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ing daniel on 17/03/2015.
 */
public class BDManager extends SQLiteOpenHelper {

    public static String COLUM_ID = "numero";
    public static String COLUM_FICHA = "ficha";
    public static String COLUM_ESTADO = "estado";
    public static String COLUM_TIPO = "tipo";
    public static String COLUM_FONDO = "fondo";
    public static String COLUM_COLOR = "color";
    public static String COLUM_BANNER = "banner";
    public static String NOM_TABLE_PAGINAS = "paginas";
    public static int COLUM_INDEX_ID = 0;
    public static int COLUM_INDEX_FICHA = 1;
    public static int COLUM_INDEX_ESTADO = 2;
    public static int COLUM_INDEX_TIPO = 3;
    public static int COLUM_INDEX_FONDO = 4;
    public static int COLUM_INDEX_COLOR = 5;
    public static int COLUM_INDEX_BANNER = 6;


    public String crearTablaPagina = "CREATE TABLE "+NOM_TABLE_PAGINAS+" ("+
                                     COLUM_ID+" INTEGER PRYMARY KEY,"+
                                     COLUM_FICHA+" TEXT,"+
                                     COLUM_ESTADO+" TEXT," +
                                     COLUM_TIPO+" TEXT," +
                                     COLUM_FONDO+" TEXT," +
                                     COLUM_COLOR+" TEXT," +
                                     COLUM_BANNER+" TEXT)";


    public BDManager(Context context) {
        super(context,"america",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         db.execSQL(crearTablaPagina);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXITS "+NOM_TABLE_PAGINAS);
        db.execSQL(crearTablaPagina);

    }
}
