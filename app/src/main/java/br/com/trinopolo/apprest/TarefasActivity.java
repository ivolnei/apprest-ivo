package br.com.trinopolo.apprest;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TarefasActivity extends AppCompatActivity {
    Button mBtnSalvar;
    Switch mSwitch_concluida;
    EditText mEditText_corpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);
        setup();
        setTitle("TAREFAS TRINOPOLO");

        mBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Tarefa tarefa = new Tarefa();
                tarefa.usuarioId = "ik";
                tarefa.corpo = mEditText_corpo.getText();
                tarefa.concluida = mSwitch_concluida.getSplitTrack();

                TarefaService.put(tarefa).enqueue(new Callback<Tarefa>() {
                    @Override
                    public void onResponse(Call<Tarefa> call, Response<Tarefa> response) {
                        verificaPost();
                    }

                    @Override
                    public void onFailure(Call<Tarefa> call, Throwable t) {

                    }
                });
            }
        });

            }

    private void verificaPost() {

    }

    private void setup() {
        mBtnSalvar = (Button) findViewById(R.id.btn_salvar);
        mBtnSalvar = (Button) findViewById(R.id.btn_salvar);
        mSwitch_concluida = (Switch) findViewById(R.id.switch_concluida);
        mEditText_corpo = (EditText) findViewById(R.id.editText_corpo);
    }
}
