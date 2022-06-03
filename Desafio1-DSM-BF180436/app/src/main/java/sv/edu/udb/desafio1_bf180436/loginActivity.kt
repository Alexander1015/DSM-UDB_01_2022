package sv.edu.udb.desafio1_bf180436

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonlog: Button = findViewById(R.id.btn_login)
        val txtUser: EditText = findViewById(R.id.txtuser)
        val txtPassword: EditText = findViewById(R.id.txtpassword)
        buttonlog.setOnClickListener {
            try {
                val admin: AdminSQLiteHelper = AdminSQLiteHelper(this, "administracion", null, 2)
                val bd: SQLiteDatabase = admin.writableDatabase
                var user = txtUser.text.toString()
                var password = txtPassword.text.toString()
                var fila: Cursor = bd.rawQuery("SELECT password FROM usuarios WHERE user = '" + user + "'", null)
                if (fila.moveToFirst()) {
                    if (password == fila.getString(0)) {
                        txtUser.setText("")
                        txtPassword.setText("")
                        val intent: Intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "Usuario/Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this, "El usuario ingresado no existe", Toast.LENGTH_SHORT).show()
                }
            }
            catch (e: Exception) {
                Log.d("Error", e.toString())
            }
        }
        val buttonew: Button = findViewById(R.id.btn_login_new)
        buttonew.setOnClickListener {
            try {
                var exits: Boolean = false
                val admin: AdminSQLiteHelper = AdminSQLiteHelper(this, "administracion", null, 2)
                val bd: SQLiteDatabase = admin.writableDatabase
                var user = txtUser.text.toString()
                var password = txtPassword.text.toString()
                var registro: ContentValues = ContentValues()
                registro.put("user", user)
                registro.put("password", password)
                bd.insertOrThrow("usuarios", null, registro)
                bd.close()
                exits = true
                if (exits) {
                    txtUser.setText("")
                    txtPassword.setText("")
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "No se ha podido crear el usuario.", Toast.LENGTH_SHORT).show()
                }
            }
            catch (e: Exception) {
                Log.d("Error", e.toString())
            }
        }
    }
}