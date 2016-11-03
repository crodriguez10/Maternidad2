package com.example.dell.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dell.modelo.ModelCitas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 23/10/2016.
 */
public class ConexionBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "nombreBaseDatos_v4.db";


    private static final String SQL_CREAR_CITAS = "create table " +
             "citas( id integer primary key autoincrement, " +
            " fecha date not null, "+
            " hora text not null, " +
            " clinica text not null, " +
            " cumplimiento boolean not null, " +
            " id_usuario integer not null, " +
            "id_motivo integer not null )";

    private static final String SQL_CREAR_ECOGRAFIAS = "create table " +
            "ecografias( id integer primary key autoincrement, " +
            " imagen text not null, "+
            " mes integer not null, " +
            " id_cita integer not null)";

    private static final String SQL_CREAR_MOTIVOS = "create table " +
            "motivos( id integer primary key autoincrement, " +
            " descripcion text not null)";

    private static final String SQL_CREAR_RESULTADOS = "create table " +
            "resultados( id integer primary key autoincrement, " +
            " adjunto text not null, "+
            " fecha date not null)";

    public ConexionBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREAR_CITAS);
        db.execSQL(SQL_CREAR_ECOGRAFIAS);
        db.execSQL(SQL_CREAR_MOTIVOS);
        db.execSQL(SQL_CREAR_RESULTADOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
