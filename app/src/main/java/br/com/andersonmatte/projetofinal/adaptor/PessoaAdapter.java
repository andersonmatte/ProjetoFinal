package br.com.andersonmatte.projetofinal.adaptor;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import br.com.andersonmatte.projetofinal.R;
import br.com.andersonmatte.projetofinal.entity.Pessoa;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Anderson Matte Tamborim
//******************************************************
public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private List<Pessoa> listaPessoa;
    private Context context;
    private AppCompatTextView tv_nome, tv_cpf, tv_idade, tv_telefone, tv_email;

    public PessoaAdapter(Context context, List<Pessoa> listaPessoaRecebido) {
        super(context, 0, listaPessoaRecebido);
        this.listaPessoa = listaPessoaRecebido;
        this.context = context;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.lista_pessoa, null);
        //Aqui ocorre a mágica no setTag onde é passado a posição da ListView!
        view.setTag(position);
        if (this.listaPessoa.get(position) != null) {
            this.tv_nome = view.findViewById(R.id.tv_nome);
            this.tv_nome.setText(context.getResources().getString(R.string.nome) + " " + this.listaPessoa.get(position).getNome());
            this.tv_cpf = view.findViewById(R.id.tv_cpf);
            this.tv_cpf.setText(context.getResources().getString(R.string.cpf) + " " + this.listaPessoa.get(position).getCpf().toString());
            this.tv_idade = view.findViewById(R.id.tv_idade);
            this.tv_idade.setText(context.getResources().getString(R.string.idade) + " " + this.listaPessoa.get(position).getIdade().toString());
            this.tv_telefone = view.findViewById(R.id.tv_telefone);
            this.tv_telefone.setText(context.getResources().getString(R.string.telefone) + " " + this.listaPessoa.get(position).getTelefone().toString());
            this.tv_email = view.findViewById(R.id.tv_email);
            this.tv_email.setText(context.getResources().getString(R.string.email) + " " + this.listaPessoa.get(position).getEmail());
        }
        return view;
    }

}
