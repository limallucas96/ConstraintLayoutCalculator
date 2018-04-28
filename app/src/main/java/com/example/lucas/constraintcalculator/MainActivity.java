package com.example.lucas.constraintcalculator;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private String strOperacao = "";
    private String textoBotao = "";
    private String lastResult;
    private Boolean isSaved = false;
    private EditText input;

    private FloatingActionButton ultimoResultado;

    private Button delete;
    private Button resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editText);
        ultimoResultado = findViewById(R.id.floatingActionButton);
        delete = findViewById(R.id.button_delete);
        resultado = findViewById(R.id.button_igual);
    }

    public void onResultado(View view) {
        Expression e = new ExpressionBuilder(strOperacao).build();
        String resultado = String.valueOf(e.evaluate());

        input.setText(resultado);
        strOperacao = resultado;
        lastResult = resultado;
    }

    public void getButtonValue(View view) {
        Button button = (Button) view;
        textoBotao = button.getText().toString();
        if (isSaved) {
            strOperacao += lastResult;
            isSaved = false;
        }
        strOperacao += textoBotao;
        input.setText(strOperacao);
    }

    public void clearEditText(View view) {
        input.setText("0");
        strOperacao = "";
    }

    public void setUltimoResultado(View view) {
        if (input.getText().toString().equals("0")) {
            input.setText(lastResult);
            isSaved = true;
        } else {
            input.setText(input.getText().toString() + lastResult);
            strOperacao += lastResult;
        }
    }

}
