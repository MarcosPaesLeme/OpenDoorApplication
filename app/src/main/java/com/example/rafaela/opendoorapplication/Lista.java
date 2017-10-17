package com.example.rafaela.opendoorapplication;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {


    private List<String> lista = new ArrayList<>();
    private List<Conjunto> nLista = new ArrayList<>();
    private ListView listaConjuntos;
    //Activity atividade;

    public void inicializaListaConjuntos(){
        Conjunto conjunto = new Conjunto(101, false, 500.00, 120.0, 0, "" );
        nLista.add(conjunto);
        conjunto = new Conjunto(102, true, 800.00, 150.0, 12, "Escritório imoboliado, lindo!" );
        nLista.add(conjunto);
        conjunto = new Conjunto(201, true, 500.00, 110.0, 10, "Possui ar-condicionado, ótima vista" );
        nLista.add(conjunto);
        conjunto = new Conjunto(202, false, 700.00, 140.0, 0, "" );
        nLista.add(conjunto);
        conjunto = new Conjunto(301, true, 600.00, 100.0, 2, "Já possui mesas e cadeiras" );
        nLista.add(conjunto);
        conjunto = new Conjunto(302, true, 1000.00, 240.00, 11, "Escritório com ótima vista" );
        nLista.add(conjunto);
        conjunto = new Conjunto(401, false, 900.00, 180.00, 0, "Possui ar-condicionado" );
        nLista.add(conjunto);
        conjunto = new Conjunto(402, false, 600.00, 110.0, 0, "" );
        nLista.add(conjunto);
        conjunto = new Conjunto(501, true, 700.00, 110.0, 5, "Em perfeitas condições" );
        nLista.add(conjunto);
        conjunto = new Conjunto(502, false, 760.00, 200.00, 0, "Ambiente muito confortável" );
        nLista.add(conjunto);
        conjunto = new Conjunto(601, true, 1900.00, 300.00, 13, "Lindo!!" );
        nLista.add(conjunto);
        conjunto = new Conjunto(602, false, 450.000, 110.0, 0, "Já imobiliado" );
        nLista.add(conjunto);
    }
    public void geraListaConjuntos( ){
        lista.add("101");
        lista.add("102");
        lista.add("103");
        lista.add("104");
        lista.add("201");
        lista.add("202");
        lista.add("203");
        lista.add("204");
        lista.add("301");
        lista.add("302");
        lista.add("303");
        lista.add("304");
        lista.add("401");
        lista.add("402");
        lista.add("403");
        lista.add("404");
        lista.add("501");
        lista.add("502");
        lista.add("503");
        lista.add("504");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listaConjuntos = (ListView) findViewById(R.id.conjuntosListView);
        inicializaListaConjuntos();
        Intent intent = getIntent();
        String busca = intent.getStringExtra("busca");
        final List<Conjunto> resultado1 = encontraConjuntos(busca);
        List<String> result = new ArrayList<>();
        for(Conjunto elem : resultado1){
          result.add(String.valueOf(elem.getId_conjunto()));
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,result);
        listaConjuntos.setAdapter(adapter);
        listaConjuntos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListaActivity.this, nomesListView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (Lista.this, DetalhesConjunto.class);
                intent.putExtra("conjunto1", (Conjunto)resultado1.get(i));
                //intent.putExtra("conjunto", listaConjuntos.getItemAtPosition(i).toString());
               // intent.putExtra("valor", listaConjuntos.getItemAtPosition(i).toString());
                //intent.putExtra("tamanho", listaConjuntos.getItemAtPosition(i).toString());
                //intent.putExtra("status", listaConjuntos.getItemAtPosition(i).toString());
               // intent.putExtra("obs", listaConjuntos.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }




    public List<String> buscaConjuntos(String busca){
        //ArrayList<String> lista = geraListaConjuntos();
        if (busca == null || busca.length() == 0){
            return lista;
        } else {
            List<String> devolucao = new ArrayList<>();
            for(String elemento : lista){
                if(elemento.contains(busca)){
                    devolucao.add(elemento);
                }
            }
            return devolucao;
        }
    }

    public List<Conjunto> encontraConjuntos(String busca){
        //ArrayList<String> lista = geraListaConjuntos();
        if (busca == null || busca.length() == 0){
            return nLista;
        } else {
            List<Conjunto> devolucao = new ArrayList<>();

            for(Conjunto elemento : nLista){
                String a = busca;
                if(String.valueOf(elemento.getId_conjunto()).contains(a)){
                    devolucao.add(elemento);
                }
            }
            return devolucao;
        }
    }


}
