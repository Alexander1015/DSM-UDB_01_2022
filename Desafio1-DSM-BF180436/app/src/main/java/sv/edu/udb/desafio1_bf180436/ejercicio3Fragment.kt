package sv.edu.udb.desafio1_bf180436

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ejercicio3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ejercicio3Fragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var button: Button
    private lateinit var lbl: TextView
    private lateinit var nombreEmpleado1: EditText
    private lateinit var nombreEmpleado2: EditText
    private lateinit var nombreEmpleado3: EditText
    private lateinit var apellidoEmpleado1: EditText
    private lateinit var apellidoEmpleado2: EditText
    private lateinit var apellidoEmpleado3: EditText
    private lateinit var puestoEmpleado1: EditText
    private lateinit var puestoEmpleado2: EditText
    private lateinit var puestoEmpleado3: EditText
    private lateinit var horasEmpleado1: EditText
    private lateinit var horasEmpleado2: EditText
    private lateinit var horasEmpleado3: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater!!.inflate(R.layout.fragment_ejercicio3, container, false)
        button = view.findViewById(R.id.btn_ejer3)
        lbl = view.findViewById(R.id.lblresult_ejer3)
        nombreEmpleado1 = view.findViewById(R.id.txtname1)
        apellidoEmpleado1 = view.findViewById(R.id.txtlast1)
        puestoEmpleado1 = view.findViewById(R.id.txtplace1)
        horasEmpleado1 = view.findViewById(R.id.txtsal1)
        nombreEmpleado2 = view.findViewById(R.id.txtname2)
        apellidoEmpleado2 = view.findViewById(R.id.txtlast2)
        puestoEmpleado2 = view.findViewById(R.id.txtplace2)
        horasEmpleado2 = view.findViewById(R.id.txtsal2)
        nombreEmpleado3 = view.findViewById(R.id.txtname3)
        apellidoEmpleado3 = view.findViewById(R.id.txtlast3)
        puestoEmpleado3 = view.findViewById(R.id.txtplace3)
        horasEmpleado3 = view.findViewById(R.id.txtsal3)
        button.setOnClickListener(this)
        return view
    }

    companion object {
        fun newInstance(): ejercicio1Fragment {
            return newInstance()
        }
    }

    override fun onClick(view: View?) {
       when (view?.id) {
           R.id.btn_ejer3 -> {
               try {
                   //Empleado 1
                   var name1 = nombreEmpleado1.text.toString()
                   var last1 = apellidoEmpleado1.text.toString()
                   var place1 = puestoEmpleado1.text.toString()
                   var hour1 = horasEmpleado1.text.toString().toDouble()
                   //Empleado 2
                   var name2 = nombreEmpleado2.text.toString()
                   var last2 = apellidoEmpleado2.text.toString()
                   var place2 = puestoEmpleado2.text.toString()
                   var hour2 = horasEmpleado2.text.toString().toDouble()
                   //Empleado 3
                   var name3 = nombreEmpleado3.text.toString()
                   var last3 = apellidoEmpleado3.text.toString()
                   var place3 = puestoEmpleado3.text.toString()
                   var hour3 = horasEmpleado3.text.toString().toDouble()
                   if (hour1 > 0) {
                       if (hour2 > 0) {
                           if (hour3 > 0) {
                               var sueldoBase1: Double = 0.0
                               var sueldoBase2: Double = 0.0
                               var sueldoBase3: Double = 0.0
                               //Calculando sueldo base
                               if (hour1 <= 160) sueldoBase1 = hour1 * 9.75
                               else sueldoBase1 = (160 * 9.75) + ((hour1 - 160) * 11.50)
                               if (hour2 <= 160) sueldoBase2 = hour2 * 9.75
                               else sueldoBase2 = (160 * 9.75) + ((hour2 - 160) * 11.50)
                               if (hour3 <= 160) sueldoBase3 = hour3 * 9.75
                               else sueldoBase3 = (160 * 9.75) + ((hour3 - 160) * 11.50)
                               //Descuentos
                               var isss1: Double = sueldoBase1 * 0.0525
                               var afp1: Double = sueldoBase1 * 0.0688
                               var rent1: Double = sueldoBase1 * 0.1
                               var isss2: Double = sueldoBase2 * 0.0525
                               var afp2: Double = sueldoBase2 * 0.0688
                               var rent2: Double = sueldoBase2 * 0.1
                               var isss3: Double = sueldoBase3 * 0.0525
                               var afp3: Double = sueldoBase3 * 0.0688
                               var rent3: Double = sueldoBase3 * 0.1
                               //Sueldo Liquido
                               var liquid1: Double = sueldoBase1 - isss1 - afp1 - rent1
                               var liquid2: Double = sueldoBase2 - isss2 - afp2 - rent2
                               var liquid3: Double = sueldoBase3 - isss3 - afp3 - rent3
                               //Bonos
                               //Existe/no existe bono
                               var exist = true
                               var bono1: Double = 0.0
                               var bono2: Double = 0.0
                               var bono3: Double = 0.0
                               var cant1: Int = 0
                               var cant2: Int = 0
                               var cant3: Int = 0
                               if (place1.uppercase() == "GERENTE" && place2.uppercase() == "ASISTENTE" && place3.uppercase() == "SECRETARIA") exist = false
                               else {
                                   if (place1.uppercase() == "GERENTE") {
                                       bono1 = liquid1 * 0.1
                                       cant1 = 10
                                   }
                                   else if (place1.uppercase() == "ASISTENTE") {
                                       bono1 = liquid1 * 0.05
                                       cant1 = 5
                                   }
                                   else if (place1.uppercase() == "SECRETARIA") {
                                       bono1 = liquid1 * 0.03
                                       cant1 = 3
                                   }
                                   else {
                                       bono1 = liquid1 * 0.02
                                       cant1 = 2
                                   }
                                   //
                                   if (place2.uppercase() == "GERENTE") {
                                       bono2 = liquid2 * 0.1
                                       cant2 = 10
                                   }
                                   else if (place2.uppercase() == "ASISTENTE") {
                                       bono2 = liquid2 * 0.05
                                       cant2 = 5
                                   }
                                   else if (place2.uppercase() == "SECRETARIA") {
                                       bono2 = liquid2 * 0.03
                                       cant2 = 3
                                   }
                                   else {
                                       bono2 = liquid2 * 0.02
                                       cant2 = 2
                                   }
                                   //
                                   if (place3.uppercase() == "GERENTE") {
                                       bono3 = liquid3 * 0.1
                                       cant3 = 10
                                   }
                                   else if (place3.uppercase() == "ASISTENTE") {
                                       bono3 = liquid3 * 0.05
                                       cant3 = 5
                                   }
                                   else if (place3.uppercase() == "SECRETARIA") {
                                       bono3 = liquid3 * 0.03
                                       cant3 = 3
                                   }
                                   else {
                                       bono3 = liquid3 * 0.02
                                       cant3 = 2
                                   }
                               }
                               //Calculando mayor salario y menor salario
                               var max: String = ""
                               var min: String = ""
                               if (liquid1 > liquid2 && liquid1 > liquid3) max = name1 + " " + last1
                               else if (liquid2 > liquid1 && liquid2 > liquid3) max = name2 + " " + last2
                               else if (liquid3 > liquid1 && liquid3 > liquid2) max = name3 + " " + last3
                               else max = "Ninguno es el mayor de los 3"
                               if (liquid1 < liquid2 && liquid1 < liquid3) min = name1 + " " + last1
                               else if (liquid2 < liquid1 && liquid2 < liquid3) min = name2 + " " + last2
                               else if (liquid3 < liquid1 && liquid3 < liquid2) min = name3 + " " + last3
                               else min = "Ninguno es el menor de los 3"
                               var more300: Int = 0
                               if (liquid1 > 300) more300++
                               if (liquid2 > 300) more300++
                               if (liquid3 > 300) more300++
                               //Mensaje
                               var mensaje: String = String.format("Salarios:\n\n" +
                                       "Empleado 1\n" +
                                       "Nombre: %s %s\n" +
                                       "Sueldo base: $%.2f\n" +
                                       "ISSS: $%.2f, AFP: $%.2f, Renta: $%.2f\n" +
                                       "Sueldo liquido: $%.2f\n", name1, last1, sueldoBase1, isss1, afp1, rent1, liquid1)
                               if (exist == true) mensaje += String.format("Bono (%d%%): $%.2f\n", cant1, bono1)
                               mensaje += String.format("\nEmpleado 2\n" +
                                       "Nombre: %s %s\n" +
                                       "Sueldo base: $%.2f\n" +
                                       "ISSS: $%.2f, AFP: $%.2f, Renta: $%.2f\n" +
                                       "Sueldo liquido: %.2f\n", name2, last2, sueldoBase2, isss2, afp2, rent2, liquid2)
                               if (exist == true) mensaje += String.format("Bono (%d%%): $%.2f\n", cant2, bono2)
                               mensaje += String.format("\nEmpleado 3\n" +
                                       "Nombre: %s %s\n" +
                                       "Sueldo base: $%.2f\n" +
                                       "ISSS: $%.2f, AFP: $%.2f, Renta: $%.2f\n" +
                                       "Sueldo liquido: %.2f\n", name3, last3, sueldoBase3, isss3, afp3, rent3, liquid3)
                               if (exist == true) mensaje += String.format("Bono (%d%%): $%.2f\n", cant3, bono3)
                               else mensaje += String.format("\nNO HAY BONOS\n")
                               mensaje += String.format("\nEl empleado que gana el MAYOR salario es:\n%s", max)
                               mensaje += String.format("\nEl empleado que gana el MENOR salario es:\n%s\n", min)
                               mensaje += String.format("\nActualmente %d empleado/s gana/n más de $300", more300)
                               println(mensaje)
                               lbl.text = mensaje
                           }
                           else {
                               Toast.makeText(context, "Las horas ingresadas del empleado 3 deben ser mayores que 0.", Toast.LENGTH_SHORT).show()
                           }
                       }
                       else {
                           Toast.makeText(context, "Las horas ingresadas del empleado 2 deben ser mayores que 0.", Toast.LENGTH_SHORT).show()
                       }
                   }
                   else {
                       Toast.makeText(context, "Las horas ingresadas del empleado 1 deben ser mayores que 0.", Toast.LENGTH_SHORT).show()
                   }
               }
               catch (e: Exception) {
                   Log.d("Error", e.toString())
               }
           }
       }
    }
}