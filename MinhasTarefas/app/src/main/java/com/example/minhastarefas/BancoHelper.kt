package com.example.minhastarefas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context) : SQLiteOpenHelper(context, "tarefas.bd", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists tarefas (id integer primary key autoincrement, " +
                "descricao text, " +
                "prioridade integer," + "status text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table tarefas")
        this.onCreate(db)
    }
}