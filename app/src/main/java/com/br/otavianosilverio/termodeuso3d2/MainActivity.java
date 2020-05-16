package com.br.otavianosilverio.termodeuso3d2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // instanciando a classe ViewHolder
    private ViewHolder mViewMain = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewMain.edit_nome = this.findViewById(R.id.edit_nome);
        this.mViewMain.rd_sexo = this.findViewById(R.id.Rd_sexo);
        this.mViewMain.check_aceite = this.findViewById(R.id.check_aceite);
        this.mViewMain.button_salvar = this.findViewById(R.id.button_salvar);
        this.mViewMain.edit_email = this.findViewById(R.id.edit_email);
        this.mViewMain.lbl_politica = this.findViewById(R.id.lbl_politica);

        //identifica todos os objetos com clique
        this.mViewMain.button_salvar.setOnClickListener(this);
        this.mViewMain.lbl_politica.setOnClickListener(this);

    }
    // Todos os objetos com clique serão executados no metodo
    @Override
    public void onClick(View view) {

        // Será tratado todos os eventos de clique na tela
        // botao gravar
        if (view.getId()== R.id.button_salvar){
            // Verificar se campo nome foi preenchido
           if (validaCampos() == false){
            MensagemDeErro("Dados incorretos");
           }else{
               // gravar os dados..
               MensagemDeErro("Dados Corretos");
           }

        }
        if (view.getId() == R.id.lbl_politica){
            Intent acessoTelaPolitica = new Intent(MainActivity.this,PoliticaPrivacidade.class);
            startActivity(acessoTelaPolitica);
        }

    }
    private boolean validaCampos() {
        boolean resultado = false;

        if (resultado = isCampoVazio(this.mViewMain.edit_nome.getText().toString())) {
            this.mViewMain.edit_nome.requestFocus();
        }

        if (resultado = !isEmailValido(this.mViewMain.edit_email.getText().toString())) {
            this.mViewMain.edit_email.setError("Email invalido");
            this.mViewMain.edit_email.requestFocus();
        }

        // Botao do sexo foi preenchido
        int itemRadioGroupSelecionado = this.mViewMain.rd_sexo.getCheckedRadioButtonId();
        if (itemRadioGroupSelecionado == -1) {
           resultado = false;
        }else{
            resultado = true;
        }
        // Botao checkbox clicado pelo usuário
        if (!this.mViewMain.check_aceite.isChecked()) {
          resultado = false;
        }else{
            resultado = true;
        }
        return resultado;

    }

    public void MensagemDeErro(String mensagem){

        AlertDialog.Builder Msg = new AlertDialog.Builder(MainActivity.this);
        Msg.setMessage(mensagem);
        Msg.setNeutralButton("Sair",null);
        Msg.create();
        Msg.show();
    }

    private boolean isCampoVazio(String valor){

        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());

    }

    private boolean isEmailValido(String email){
            return (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    // Mapear e identificar todos os objetos que serão manipulados no codigo
    private static class ViewHolder{
        private EditText edit_nome;
        private RadioGroup rd_sexo;
        private CheckBox check_aceite;
        private Button button_salvar;
        private EditText edit_email;
        private TextView lbl_politica;



    }

}
