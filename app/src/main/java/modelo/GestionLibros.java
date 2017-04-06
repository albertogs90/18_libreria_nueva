package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import javabeans.Libro;

/**
 * Created by USUARIO on 03/04/2017.
 */

public class GestionLibros {
    private Ayudante helper;
    private SQLiteDatabase bd;
    public GestionLibros(Context ctx){
        helper=new Ayudante(ctx,"libreria");
        bd=helper.getWritableDatabase();
    }

    public void altaLibro(Libro lb){
        /*metodo 1: usando sql
        String sql="insert into libros (titulo,isbn,precio) ";
        sql+="values('"+lb.getTitulo()+"','"+lb.getIsbn()+"',"+lb.getPrecio()+")";
        bd.execSQL(sql);*/
        //metodo 2: sin usar SQL
        ContentValues valores=new ContentValues();
        valores.put("titulo",lb.getTitulo());
        valores.put("isbn",lb.getIsbn());
        valores.put("precio",lb.getPrecio());
        bd.insert("libros",null,valores);
    }

    public Cursor obtenerLibros(){
        /*metodo 1: con sql
        String sql="select * from libros";
        return bd.rawQuery(sql,null);*/
        //metodo 2: sin sql
        return bd.query("libros",null,null,null,null,null,null);

    }
    public Cursor obtenerLibroPorIsbn(String isbn){
        /*metodo 1: con sql
        String sql="select * from libros where isbn='"+isbn+"'";
        return bd.rawQuery(sql,null);
        */
        //metodo 2: sin sql
        return bd.query("libros",null,"isbn=?",new String[]{isbn},null,null,null);
    }

    public Libro buscarLibro(String isbn){
        String sql="select * from libros where isbn='"+isbn+"'";
        Cursor c=bd.rawQuery(sql,null);
        Libro lib=null;
        //si se ha encontrado el libro, habrá una fila y creamos
        //un objeto Libro con los datos de esa fila
        if(c.moveToNext()){
            lib=new Libro(c.getString(1),c.getString(2),c.getDouble(3));
        }
        return lib;
    }
    public ArrayList<Libro> recuperarTodosLibros(){
        String sql="select * from libros";
        ArrayList<Libro> todos=new ArrayList<>();
        Cursor c=bd.rawQuery(sql,null);
        while(c.moveToNext()){
            Libro lib=new Libro(c.getString(1),c.getString(2),c.getDouble(3));
            todos.add(lib);
        }
        return todos;
    }
    public void cerrar(){
        helper.close();
    }


    public boolean comprobacion(String isbn){
        String sql="select * from libros where isbn='"+isbn+"'";
        Cursor c=bd.rawQuery(sql,null);
        boolean res=false;
        //si se ha encontrado el libro, habrá una fila y creamos
        //un objeto Libro con los datos de esa fila
        if(c.moveToNext()){
            res=true;
        }
        return res;
    }

    public void eliminar(String isbn){
        /*metodo 1: con sql
        String sql="delete from libros where isbn='"+isbn+"'";
        bd.execSQL(sql);*/
        //metodo 2: sin sql
        bd.delete("libros","isbn=?",new String[]{isbn});
    }


}
