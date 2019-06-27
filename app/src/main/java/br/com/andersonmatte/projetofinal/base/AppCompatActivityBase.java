package br.com.andersonmatte.projetofinal.base;

import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class AppCompatActivityBase extends AppCompatActivity {

    protected Realm realm;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        this.criaBancoRealm();
    }

    public void criaBancoRealm() {
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

}
