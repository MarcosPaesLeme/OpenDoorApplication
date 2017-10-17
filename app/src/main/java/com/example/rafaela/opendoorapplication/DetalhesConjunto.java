package com.example.rafaela.opendoorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetalhesConjunto extends AppCompatActivity {

    private TextView exibeConjuntoTextView;
    private TextView exibeValor;
    private TextView exibeTamanho;
    private TextView exibeStatus;
    private TextView exibeObs;
    //private ArrayList<Conjunto> listaConjunto;
    private Conjunto conjunto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_conjunto);
        exibeConjuntoTextView = (TextView) findViewById(R.id.exibeConjuntoTextView);
        exibeValor = (TextView) findViewById(R.id.exibeValor);
        exibeTamanho = (TextView) findViewById(R.id.exibeTamanho);
        exibeStatus = (TextView) findViewById(R.id.exibeStatus);
        exibeObs = (TextView) findViewById(R.id.exibeObs);
        Intent intent = getIntent();
        //listaConjunto = (ArrayList<Conjunto>) getIntent().getSerializableExtra("conjunto1");
        conjunto1 = (Conjunto) getIntent().getSerializableExtra("conjunto1");
        int conjunto = conjunto1.getId_conjunto();
        double valor = conjunto1.getValor();
        double tamanho = conjunto1.getMedida();
        boolean status = conjunto1.getStatus();
        String obs = conjunto1.getObservacao();

        exibeConjuntoTextView.setText("Número do conjunto: "+String.valueOf(conjunto));
        exibeValor.setText("Valor: "+String.valueOf(valor));
        exibeTamanho.setText("Tamanho(m²): "+String.valueOf(tamanho));
        if (status == true)
            exibeStatus.setText("Status: "+"Ocupado");
        else
            exibeStatus.setText("Status: "+"Disponível");

        exibeObs.setText("Observação: "+obs);
        exibeConjuntoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetalhesConjunto.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


