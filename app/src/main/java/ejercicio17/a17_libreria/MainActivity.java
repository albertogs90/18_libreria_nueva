package ejercicio17.a17_libreria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void agregar(View v){
        this.startActivity(new Intent(this,NuevoActivity.class));
    }
    public void buscar(View v){
        this.startActivity(new Intent(this,BuscarActivity.class));
    }
    public void listado(View v){
        this.startActivity(new Intent(this,ListadoActivity.class));
    }
}
