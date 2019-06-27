package br.com.andersonmatte.projetofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.andersonmatte.projetofinal.R;
import br.com.andersonmatte.projetofinal.adaptor.PessoaAdapter;
import br.com.andersonmatte.projetofinal.base.AppCompatActivityBase;
import br.com.andersonmatte.projetofinal.entity.Pessoa;
import io.realm.RealmResults;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class ListarPessoasActivity extends AppCompatActivityBase {

    private List<Pessoa> pessoas;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pessoas);
        listView = findViewById(R.id.listView);
        this.buscaPessoas();
    }

    //Busca no BD as pessoas já salvas.
    private void buscaPessoas() {
        RealmResults<Pessoa> pessoasRecuperada = super.realm.where(Pessoa.class).findAllAsync();
        pessoasRecuperada.load();
        if (!pessoasRecuperada.isEmpty()) {
            this.pessoas = pessoasRecuperada;
            //Chama a montagem da ListView.
            this.populaListViewPessoas(this.pessoas);
        }
    }

    //Chama o Adapter.
    private void populaListViewPessoas(List<Pessoa> pessoas) {
        final PessoaAdapter adapter = new PessoaAdapter(this, pessoas);
        this.listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
        this.finish();
    }

}
