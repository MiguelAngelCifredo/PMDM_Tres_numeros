package dam.pmdm.tresnumeros;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivityV2 extends AppCompatActivity {

    EditText etNumero1; // Primer número introducido
    EditText etNumero2; // Segundo número introducido
    EditText etNumero3; // Tercer número introducido
    TextView tvNumPrimero; // Primer número resultado
    TextView tvNumSegundo; // Segundo número resultado
    TextView tvNumTercero; // Tercer número resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        etNumero3 = findViewById(R.id.etNumero3);
        tvNumPrimero = findViewById(R.id.tvNumPrimero);
        tvNumSegundo = findViewById(R.id.tvNumSegundo);
        tvNumTercero = findViewById(R.id.tvNumTercero);

        findViewById(R.id.btnMayor).setOnClickListener(v -> mostrarPosicion(2));
        findViewById(R.id.btnMenor).setOnClickListener(v -> mostrarPosicion(0));
        findViewById(R.id.btnOrdenarAsc).setOnClickListener(v -> mostrarOrdenados(true));
        findViewById(R.id.btnOrdenarDesc).setOnClickListener(v -> mostrarOrdenados(false));
        findViewById(R.id.btnBorrarTodo).setOnClickListener(v -> borrarTodo());
    }

    // Mostrar el número en la posición correcta
    private void mostrarPosicion(int pos) {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = ordenarNums(true);
            resultado1 = "";
            resultado2 = String.valueOf(num[pos]);
            resultado3 = "";
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        mostrarResultados(resultado1, resultado2, resultado3);
    }

    // Mostrar los números en el orden correcto
    private void mostrarOrdenados(boolean mode) {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = ordenarNums(mode);
            resultado1 = String.valueOf(num[0]);
            resultado2 = String.valueOf(num[1]);
            resultado3 = String.valueOf(num[2]);
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        mostrarResultados(resultado1, resultado2, resultado3);
    }

    // Borrar los números y los resultados
    private void borrarTodo() {
        etNumero1.setText("");
        etNumero2.setText("");
        etNumero3.setText("");
        mostrarResultados("", "", "");
    }

    // Ordenar los números introducidos
    private Integer[] ordenarNums(boolean asc) {
        Integer[] num = obtenerNumeros();
        if (asc) {
            Arrays.sort(num);
        } else {
            Arrays.sort(num, Collections.reverseOrder());
        }
        return num;
    }

    // Mostrar los resultados
    private void mostrarResultados(String resultado1, String resultado2, String resultado3) {
        tvNumPrimero.setText(resultado1);
        tvNumSegundo.setText(resultado2);
        tvNumTercero.setText(resultado3);
    }

    // Obtener los tres números introducidos
    @Nullable
    private Integer[] obtenerNumeros() {
        String txt1 = etNumero1.getText().toString().trim();
        String txt2 = etNumero2.getText().toString().trim();
        String txt3 = etNumero3.getText().toString().trim();

        if (txt1.isEmpty() || txt2.isEmpty() || txt3.isEmpty()) {
            return null;
        }

        try {
            int num1 = Integer.parseInt(txt1);
            int num2 = Integer.parseInt(txt2);
            int num3 = Integer.parseInt(txt3);
            return new Integer[] {num1, num2, num3};
        } catch (NumberFormatException e) {
            return null;
        }
    }

}