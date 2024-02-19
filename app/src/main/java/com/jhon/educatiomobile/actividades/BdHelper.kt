package com.jhon.educatiomobile.actividades

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "educatio.db"
        private const val DATABASE_VERSION = 1

        // Definir el nombre de la tabla y los nombres de las columnas
        const val TABLE_CLASES = "clases"
        const val COLUMN_ID = "_id"
        const val COLUMN_VALOR = "valor"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_MATERIA = "materia"
    }

    // Crear la tabla en la base de datos
    override fun onCreate(db: SQLiteDatabase) {
        val guardarClase = ("CREATE TABLE $TABLE_CLASES ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_VALOR TEXT, $COLUMN_FECHA TEXT, $COLUMN_MATERIA TEXT)")
        db.execSQL(guardarClase)
    }

    // Actualizar la base de datos si es necesario
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CLASES")
        onCreate(db)
    }
}


