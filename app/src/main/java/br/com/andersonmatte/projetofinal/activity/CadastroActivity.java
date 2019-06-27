package br.com.andersonmatte.projetofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.andersonmatte.projetofinal.R;
import br.com.andersonmatte.projetofinal.base.AppCompatActivityBase;
import br.com.andersonmatte.projetofinal.entity.Pessoa;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class CadastroActivity extends AppCompatActivityBase {

    private AppCompatEditText tvNome, tvCpf ,tvidade , tvTelefone, tvEmail;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaTextView();
        //Clique do botão para Salvar a pessoa no Banco de Dados.
        AppCompatButton botaoCadastrarPessoa = findViewById(R.id.button_cadastrar);
        botaoCadastrarPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaForm()) {
                    montaObjetoParaSalvar();
                    salvar();
                }
            }
        });
        //Clique do botão Listar os pessoas cadastradas no Banco de Dados.
        AppCompatButton botaoListarPessoas = findViewById(R.id.button_listar);
        botaoListarPessoas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vai para a Lista de pessoas cadastradas.
                Intent intent = new Intent(CadastroActivity.this, ListarPessoasActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Clique do botão que controla a volta para a Activity anteriror a HomeActivity.
        AppCompatButton botaoVoltar = findViewById(R.id.button_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void inicializaTextView(){
        tvNome = findViewById(R.id.nome);
        tvCpf = findViewById(R.id.cpf);
        tvidade = findViewById(R.id.idade);
        tvTelefone = findViewById(R.id.telefone);
        tvEmail = findViewById(R.id.email);
    }

    //Valida se os dados foram preenchidos.
    private Boolean validaForm() {
        if (tvNome.getText().toString().isEmpty() || tvCpf.getText().toString().isEmpty()
                || tvidade.getText().toString().isEmpty()
                || tvTelefone.getText().toString().isEmpty()
                || tvEmail.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.erro_campos_obrigatórios), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    //Popula o objeto Pessoa para ser salvo no banco.
    private void montaObjetoParaSalvar() {
        this.pessoa = new Pessoa();
        TextView tvNome = findViewById(R.id.nome);
        this.pessoa.setNome(tvNome.getText().toString());
        TextView tvCpf = findViewById(R.id.cpf);
        this.pessoa.setCpf(Long.parseLong(tvCpf.getText().toString()));
        TextView tvidade = findViewById(R.id.idade);
        this.pessoa.setIdade(Long.parseLong(tvidade.getText().toString()));
        TextView tvTelefone = findViewById(R.id.telefone);
        this.pessoa.setTelefone(Long.parseLong(tvTelefone.getText().toString()));
        TextView tvEmail = findViewById(R.id.email);
        this.pessoa.setEmail(tvEmail.getText().toString());
    }

    //Salva o objeto no Banco.
    private void salvar() {
        super.realm.beginTransaction();
        super.realm.insertOrUpdate(this.pessoa);
        super.realm.commitTransaction();
        //Chama a Lista de pessoas.
        Intent intent = new Intent(CadastroActivity.this, ListarPessoasActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
