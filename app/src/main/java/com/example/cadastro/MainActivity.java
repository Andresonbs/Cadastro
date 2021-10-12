package com.example.cadastro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nomeEditText;
    private EditText telefoneEditText;
    private EditText emailEditText;
    private CheckBox listaEmailsCheckbox;
    private RadioButton masculinoRadioButton;
    private RadioButton femininoRadioButton;
    private EditText cidadeEditText;
    private Spinner estadoSpinner;
    private Button limparButton;
    private Button salvarButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEt);
        telefoneEditText = findViewById(R.id.telefoneEt);
        emailEditText = findViewById(R.id.emailEt);
        listaEmailsCheckbox = findViewById(R.id.listaEmailCB);
        masculinoRadioButton = findViewById(R.id.masculinoRB);
        femininoRadioButton = findViewById(R.id.femininoRB);
        cidadeEditText = findViewById(R.id.cidadeEt);
        estadoSpinner = findViewById(R.id.estadosSp);
        limparButton = findViewById(R.id.limparBt);
        salvarButton = findViewById(R.id.salvarBt);
        limparButton.setOnClickListener(this);
        salvarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.salvarBt){
            Formulario formulario = new Formulario();
            formulario.setNome(nomeEditText.getText().toString());
            formulario.setTelefone(telefoneEditText.getText().toString());
            formulario.setEmail(emailEditText.getText().toString());
            if (listaEmailsCheckbox.isChecked()){
                formulario.setListaEmails(true);
            } else{
                formulario.setListaEmails(false);
            }
            if (masculinoRadioButton.isChecked()){
                formulario.setSexo("Masculino");
            }else{
                formulario.setSexo("Feminino");
            }
            formulario.setCidade(cidadeEditText.getText().toString());
            formulario.setUF(estadoSpinner.getSelectedItem().toString());
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.limparBt){
            nomeEditText.setText("");
            telefoneEditText.setText("");
            emailEditText.setText("");
            listaEmailsCheckbox.setChecked(false);
            masculinoRadioButton.setChecked(true);
            cidadeEditText.setText("");
            estadoSpinner.setSelection(0);
        }
    }
}