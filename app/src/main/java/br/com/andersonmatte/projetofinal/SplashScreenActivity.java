package br.com.andersonmatte.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.andersonmatte.projetofinal.activity.HomeActivity;
import br.com.andersonmatte.projetofinal.base.AppCompatActivityBase;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class SplashScreenActivity extends AppCompatActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        //Controla o tempo de exibição da Splash Screen.
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarHome();
            }
        }, 2000);
    }

    //Chama a HomeActivity.
    private void mostrarHome() {
        Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
