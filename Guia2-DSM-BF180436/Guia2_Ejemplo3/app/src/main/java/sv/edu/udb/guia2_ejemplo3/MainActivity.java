package sv.edu.udb.guia2_ejemplo3;

import static android.Manifest.permission.READ_CONTACTS;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView lblPermiso;
    private TextView lblContacto;
    private final int MY_PERMISSONS = 100; //Codigo que utilizamos para solicitar los permisos, puede ser cualquier numero

    private final int OPEN_CONTACT = 200; //Codigo que utilizamos para abrir la lista de contactos, puede ser cualquier numero

    private final String str_permitido = "PERMITIDO";
    private final String str_denegado = "DENEGADO";
    private String estado;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estado = "Estado del permiso";

        lblPermiso = (TextView) findViewById(R.id.lblPermiso);
        lblContacto = (TextView) findViewById(R.id.lblContacto);

        if (verificarPermiso())
            lblPermiso.setText(estado + " " + str_permitido);
        else
            lblPermiso.setText(estado + " " + str_denegado);
    }

    public boolean verificarPermiso() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true;

        if(checkSelfPermission(READ_CONTACTS)== PackageManager.PERMISSION_GRANTED)
            return true;

        return false;
    }

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.M)
    public void on_Click (View view) {
        if (verificarPermiso())
        {
            lblPermiso.setText(estado+" "+str_permitido);
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, OPEN_CONTACT);
        }else {
            requestPermissions(new String[]{READ_CONTACTS}, MY_PERMISSONS);
        }
    }

    @SuppressLint({"Range", "SetTextI18n", "Recycle"})
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){
            switch (requestCode)
            {
                case OPEN_CONTACT:
                    Uri contactUri = data.getData();
                    Cursor cursor = getContentResolver().query(contactUri, null, null, null,null );

                    String nombre = "\n" + "Contacto Seleccionado: "+"\n";

                    if (cursor.moveToFirst())
                    {
                        nombre = nombre+cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    }
                    lblContacto.setText(nombre);
                    break;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_PERMISSONS)
        {
            if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                lblPermiso.setText(estado+" "+str_permitido);
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, OPEN_CONTACT);
            }else{
                lblPermiso.setText(estado+" "+str_denegado);
            }
        }
    }
}