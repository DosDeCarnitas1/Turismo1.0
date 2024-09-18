package com.example.turismo10

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.ChipGroup

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario)

        //Obtener los datos del intent
        val destination = intent.getStringExtra("destination")

        //Referencias a los elementos del formulario
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtApellido = findViewById<EditText>(R.id.edtApellido)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtTelefono = findViewById<EditText>(R.id.edtTelefono)
        val swtNotificacion = findViewById<Switch>(R.id.swtNotificacion)
        val gpoHoteles = findViewById<ChipGroup>(R.id.gpoHoteles)
        val ibtnMostar = findViewById<ImageButton>(R.id.ibtnMostrar)
        val ibtnGuardar = findViewById<ImageButton>(R.id.ibtnGuardar)
        val txtDetalles = findViewById<TextView>(R.id.txtDetalles)

        var nombre: String = ""
        var apellido: String = ""
        var email: String = ""
        var telefono: String = ""
        var notificacion: Boolean = false
        var hotel: String = ""

        //Función para guardar los datos
        ibtnGuardar.setOnClickListener{
            nombre = edtNombre.text.toString()
            apellido = edtApellido.text.toString()
            email = edtEmail.text.toString()
            telefono = edtTelefono.text.toString()
            notificacion = swtNotificacion.isChecked

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()

            val selectedChipId = gpoHoteles.checkedChipId
            hotel = when (selectedChipId) {
                R.id.chHotel1 -> "Hotel Rui Caribe"
                R.id.chHotel2 -> "Hotel Fiesta Inn"
                else -> "No seleccionado"
            }
        }


        //Función para mostrar los datos guardados
        ibtnMostar.setOnClickListener {
            val detalles = """
                Destino: $destination
                Nombre: $nombre
                Apellidos: $apellido
                Email: $email
                Teléfono: $telefono
                Notificación: ${if (notificacion)"Activada" else "Desactivada"}
                Hotel: $hotel
            """.trimIndent()

            txtDetalles.text = detalles
        }
    }
}
