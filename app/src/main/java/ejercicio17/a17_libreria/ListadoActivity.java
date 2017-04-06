package ejercicio17.a17_libreria;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javabeans.Libro;
import modelo.GestionLibros;

public class ListadoActivity extends AppCompatActivity {
    ListView lstDatos;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lstDatos=(ListView)this.findViewById(R.id.lstLibros);
        //cargamos la lista al iniciar actividad
        cargarLista();

        lstDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //asignamos a la variable pos la posición del item pulsado
                //para que pueda ser utilizada desde el manejador del evento
                //del botón si.
                pos=position;
                AlertDialog.Builder cuadro=new AlertDialog.Builder(ListadoActivity.this);
                cuadro.setTitle("Aviso");
                cuadro.setMessage("¿Desea eliminar la fila?");
                cuadro.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        GestionLibros glib=new GestionLibros(ListadoActivity.this);
                        ArrayList<Libro> todos=glib.recuperarTodosLibros();
                        String isbn=todos.get(pos).getIsbn();
                        glib.eliminar(isbn);
                        glib.cerrar();
                        //después de eliminar un libro en la base de datos
                        //se debe regenerar el contenido de la lista para que quede reflejado
                        //en esta
                        cargarLista();
                    }
                });
                cuadro.setNegativeButton(android.R.string.no,null);
                cuadro.show();


            }
        });

    }


    //carga el ListView a partir de la información
    //existen en BD
    private void cargarLista(){

        GestionLibros glibros=new GestionLibros(this);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.fila,
                glibros.obtenerLibros(),
                new String[]{"titulo","isbn","precio"},
                new int[]{R.id.tvFilaTitulo,R.id.tvFilaIsbn,R.id.tvFilaPrecio},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        //Asignamos adaptador al listview
        lstDatos.setAdapter(adapter);

        glibros.cerrar();
    }

    public void salir(View v){
        this.finish();
    }
}
