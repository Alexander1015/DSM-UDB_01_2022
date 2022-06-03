package sv.edu.udb.desafio1_bf180436

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcelable

open class AdminSQLiteHelper: SQLiteOpenHelper {
    constructor(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
            super(context, name, factory, version)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE usuarios(user text primary key, password text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE usuarios")
        onCreate(db)
    }
}