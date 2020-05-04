package com.br.otavianosilverio.termodeuso3d2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

        //identifica todos os objetos com clique
        this.mViewMain.button_salvar.setOnClickListener(this);

    }
    // Todos os objetos com clique serão executados no metodo
    @Override
    public void onClick(View view) {

        // Será tratado todos os eventos de clique na tela
        // botao gravar
        if (view.getId()== R.id.button_salvar){
            // Verificar se campo nome foi preenchido
            if (TextUtils.isEmpty(this.mViewMain.edit_nome.getText().toString())){
                this.mViewMain.edit_nome.setError("Informe o Nome compleott");
                this.mViewMain.edit_nome.requestFocus();
            }
            // Botao do sexo foi preenchido
            int itemRadioGroupSelecionado = this.mViewMain.rd_sexo.getCheckedRadioButtonId();
            if(itemRadioGroupSelecionado == -1){
                MensagemDeErro("Informe o Sexo");
            }else{
                RadioButton rbSexoSelecionado = findViewById(itemRadioGroupSelecionado);
                String sexoSelecionado = rbSexoSelecionado.getText().toString();
                MensagemDeErro(sexoSelecionado);

            }
            // Botao checkbox clicado pelo usuário
            if (!this.mViewMain.check_aceite.isChecked()){
                MensagemDeErro("Você precisa concordar com os termos de uso");
            }

        }

    }

    public void MensagemDeErro(String mensagem){

        AlertDialog.Builder Msg = new AlertDialog.Builder(MainActivity.this);
        Msg.setMessage(mensagem);
        Msg.setNeutralButton("Sair",null);
        Msg.create();
        Msg.show();
    }


    // Mapear e identificar todos os objetos que serão manipulados no codigo
    private static class ViewHolder{
        private EditText edit_nome;
        private RadioGroup rd_sexo;
        private CheckBox check_aceite;
        private Button button_salvar;


    }

}
