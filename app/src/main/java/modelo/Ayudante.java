package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USUARIO on 03/04/2017.
 */

public class Ayudante extends SQLiteOpenHelper {

    public Ayudante(Context ctx, String nombre){
        super(ctx,nombre,null,1);
    }
    //este mÃ©todo se ejecuta cuando Android crea la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        //montamos la instrucciÃ³n SQL de creaciÃ³n de la tabla
        String sqlCreaTabla="create table libros (";
        sqlCreaTabla+="_id integer primary key autoincrement,";
        sqlCreaTabla+="titulo text,";
        sqlCreaTabla+="isbn text,";
        sqlCreaTabla+="precio double)";
        //ejecutamos la instrucciÃ³n
        db.execSQL(sqlCreaTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
