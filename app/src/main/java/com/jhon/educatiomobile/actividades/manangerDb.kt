
package com.jhon.educatiomobile.actividades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class manangerDb(val context: Context) {

    lateinit var db: SQLiteDatabase
    val dbHelper = BdHelper(context) // Llamado a la clase DBHelper para gestionar la conexión a la base de datos

    // Método para abrir la base de datos en modo escritura
    fun openDbWr() {
        db = dbHelper.writableDatabase
    }

    // Método para insertar datos en la tabla de clases
    fun insertarClase(valor: String, fecha: String, materia: String, ) {
        val values = ContentValues()
        values.put(BdHelper.COLUMN_VALOR, valor)
        values.put(BdHelper.COLUMN_FECHA, fecha)
        values.put(BdHelper.COLUMN_MATERIA, materia)
        db.insert(BdHelper.TABLE_CLASES, null, values)
    }
}
