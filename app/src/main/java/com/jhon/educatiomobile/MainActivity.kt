package com.jhon.educatiomobile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jhon.educatiomobile.databinding.FragmentSaveclassBinding
import com.jhon.educatiomobile.actividades.manangerDb

class MainActivity : AppCompatActivity() {

    private lateinit var dbManager: manangerDb
    private lateinit var binding: FragmentSaveclassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSaveclassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el manangerDb
        dbManager = manangerDb(this)

        // Abrir la base de datos en modo escritura
        dbManager.openDbWr()

        // Configurar el listener para el botón usando data binding
        binding.Button.setOnClickListener {
            if (validarCampos()) {
                guardarClase()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        // Cerrar la base de datos cuando la actividad se destruye
        dbManager.db.close()
        super.onDestroy()
    }

    private fun validarCampos(): Boolean {
        val valor = binding.editTextValorClase.text.toString()
        val fecha = binding.datePickerFechaClase.text.toString()
        val materia = binding.editTextMateria.text.toString()
        return valor.isNotEmpty() && fecha.isNotEmpty() && materia.isNotEmpty()
    }

    private fun guardarClase() {
        val valor = binding.editTextValorClase.text.toString()
        val fecha = binding.datePickerFechaClase.text.toString()
        val materia = binding.editTextMateria.text.toString()
        dbManager.insertarClase(valor, fecha, materia)
        Toast.makeText(this, "Clase guardada correctamente", Toast.LENGTH_SHORT).show()
    }
}
