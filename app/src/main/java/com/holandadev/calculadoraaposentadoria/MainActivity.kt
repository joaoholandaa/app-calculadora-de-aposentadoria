package com.holandadev.calculadoraaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter
import android.os.PersistableBundle

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spinnerSexo = findViewById<Spinner>(R.id.spinner_sexo)

        val editTextIdade = findViewById<EditText>(R.id.edit_text_idade)

        val buttonCalcular = findViewById<Button>(R.id.button_calcular)

        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("masculino", "feminino")
        )

        spinnerSexo.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        spinnerSexo.adapter = adapter

        buttonCalcular.setOnClickListener {

            val sexoSelecionado = spinnerSexo.selectedItem as String

            val idade = editTextIdade.text.toString().toInt()

            var resultado = 0

            if (sexoSelecionado == "masculino") {
                resultado = 65 - idade
            } else {
                resultado = 62 - idade
            }

            textViewResultado.text = "Faltam $resultado anos para você se aposentar."
        }

    }
}