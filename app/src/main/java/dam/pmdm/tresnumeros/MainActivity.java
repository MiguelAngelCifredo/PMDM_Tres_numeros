package dam.pmdm.tresnumeros;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

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

        findViewById(R.id.btnMayor).setOnClickListener(v -> mayor());
        findViewById(R.id.btnMenor).setOnClickListener(v -> menor());
        findViewById(R.id.btnOrdenarAsc).setOnClickListener(v -> ordenarAsc());
        findViewById(R.id.btnOrdenarDesc).setOnClickListener(v -> ordenarDesc());
        findViewById(R.id.btnBorrarTodo).setOnClickListener(v -> borrarTodo());
    }

    // Mayor de los tres números
    private void mayor() {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = obtenerNumeros();
            int mayor = num[0];
            for (int i = 1; i < num.length; i++) {
                if (num[i] > mayor) {
                    mayor = num[i];
                }
            }
            resultado1 = "";
            resultado2 = String.valueOf(mayor);
            resultado3 = "";
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        tvNumPrimero.setText(resultado1);
        tvNumSegundo.setText(resultado2);
        tvNumTercero.setText(resultado3);
    }

    // Menor de los tres números
    private void menor() {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = obtenerNumeros();
            int menor = num[0];
            for (int i = 1; i < num.length; i++) {
                if (num[i] < menor) {
                    menor = num[i];
                }
            }
            resultado1 = "";
            resultado2 = String.valueOf(menor);
            resultado3 = "";
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        tvNumPrimero.setText(resultado1);
        tvNumSegundo.setText(resultado2);
        tvNumTercero.setText(resultado3);
    }

    // Ordenar ascendentemente los tres números
    private void ordenarAsc() {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = obtenerNumeros();
            Arrays.sort(num);
            resultado1 = String.valueOf(num[0]);
            resultado2 = String.valueOf(num[1]);
            resultado3 = String.valueOf(num[2]);
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        tvNumPrimero.setText(resultado1);
        tvNumSegundo.setText(resultado2);
        tvNumTercero.setText(resultado3);
    }

    // Ordenar descendentemente los tres números
    private void ordenarDesc() {
        String resultado1, resultado2, resultado3;
        try{
            Integer[] num = obtenerNumeros();
            Arrays.sort(num, Collections.reverseOrder());
            resultado1 = String.valueOf(num[0]);
            resultado2 = String.valueOf(num[1]);
            resultado3 = String.valueOf(num[2]);
        }catch(Exception e){
            resultado1 = "";
            resultado2 = "Error";
            resultado3 = "";
        }
        tvNumPrimero.setText(resultado1);
        tvNumSegundo.setText(resultado2);
        tvNumTercero.setText(resultado3);
    }

    // Borrar los números y el resultado
    private void borrarTodo() {
        etNumero1.setText("");
        etNumero2.setText("");
        etNumero3.setText("");
        tvNumPrimero.setText("");
        tvNumSegundo.setText("");
        tvNumTercero.setText("");
    }

    // Obtener los tres números
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