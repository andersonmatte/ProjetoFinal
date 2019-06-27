package br.com.andersonmatte.projetofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import br.com.andersonmatte.projetofinal.R;
import br.com.andersonmatte.projetofinal.base.AppCompatActivityBase;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class HomeActivity extends AppCompatActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatButton botaoInserirPessoa = (AppCompatButton) findViewById(R.id.button_inserir);
        botaoInserirPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chama a próxima Activity, que fará o cadastro da pessoa e salvará no BD.
                Intent intentPerfil = new Intent(HomeActivity.this, CadastroActivity.class);
                startActivity(intentPerfil);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
