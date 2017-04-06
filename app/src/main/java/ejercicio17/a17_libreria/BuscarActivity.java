package ejercicio17.a17_libreria;

import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import javabeans.Libro;
import modelo.GestionLibros;

public class BuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }
    public void busqueda(View v){
        EditText edtBusqueda=(EditText)this.findViewById(R.id.edtBusqueda);
       /* ListView lstBusqueda=(ListView)this.findViewById(R.id.lstBusqueda);
        GestionLibros glibros=new GestionLibros(this);
        Cursor c=glibros.obtenerLibroPorIsbn(edtBusqueda.getText().toString());
        //creamos adaptador y se lo asignamos al listview
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.fila,
                c,
                new String[]{"titulo","isbn","precio"},
                new int[]{R.id.tvFilaTitulo,R.id.tvFilaIsbn,R.id.tvFilaPrecio},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        //Asignamos adaptador al listview
        lstBusqueda.setAdapter(adapter);
        glibros.cerrar();*/
        GestionLibros glibros=new GestionLibros(this);
        Libro lib=glibros.buscarLibro(edtBusqueda.getText().toString());
        String mensaje;
        if(lib!=null){
            mensaje="Título: "+lib.getTitulo();
        }else{
            mensaje="Libro no encontrado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();

    }
}
