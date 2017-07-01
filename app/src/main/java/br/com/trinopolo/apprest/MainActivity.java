package br.com.trinopolo.apprest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button mbtnTarefa1;
    Button mbtnTarefa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TAREFAS TRINOPOLO");
        setup();

        mbtnTarefa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrir = new Intent(MainActivity.this, TarefasActivity.class);
                MainActivity.this.startActivity(intentAbrir);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mysterious-meadow-17207.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final TarefaService tarefaService = retrofit.create(TarefaService.class);




    }

    private void setup() {
        mbtnTarefa1 = (Button) findViewById(R.id.btnTarefa1);
        mbtnTarefa2 = (Button) findViewById(R.id.btnTarefa2);
    }
}
