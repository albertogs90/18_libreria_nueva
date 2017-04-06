package ejercicio17.a17_libreria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javabeans.Libro;
import modelo.GestionLibros;

public class NuevoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
    }

    public void guardar(View v){
        //obtenemos referencias a los campos de texto
        EditText edt1=(EditText)this.findViewById(R.id.edtTitulo);
        EditText edt2=(EditText)this.findViewById(R.id.edtIsbn);
        EditText edt3=(EditText)this.findViewById(R.id.edtPrecio);
        //creamos el objeto libro
        Libro libro=new Libro(edt1.getText().toString(),
                edt2.getText().toString(),
                Double.parseDouble(edt3.getText().toString()));
        GestionLibros glibros=new GestionLibros(this);
        //si el isbn no existe, entonces se añade el libro
        if(!glibros.comprobacion(edt2.getText().toString())){
            //añaidmos el libro a la bd
            glibros.altaLibro(libro);
            glibros.cerrar();
            this.finish();
        }else{
            Toast.makeText(this,"Ese libro ya existe",Toast.LENGTH_LONG).show();
            glibros.cerrar();
        }


    }
}
