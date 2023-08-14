package com.example.aula04_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InserirActivity extends AppCompatActivity {
    EditText editTextName, editTextIdade;
    Button buttonInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        buttonInsert = (Button) findViewById(R.id.buttonInsert);
    }

    public void cadastrar(){
        if(!TextUtils.isEmpty(editTextNome.getText().toString())){
            try{
                bancoDados = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);
                String sql = "INSERT INTO pessoa (nome, idade) VALUES (?,?)";
                SQLiteStatement stmt = bancoDados.compileStatement(sql);
                stmt.bindString(1,editTextNome.getText().toString());
                stmt.bindLong(2,Integer.parseInt(editTextNome.getText().toString()));
                stmt.executeInsert();
                bancoDados.close();
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}