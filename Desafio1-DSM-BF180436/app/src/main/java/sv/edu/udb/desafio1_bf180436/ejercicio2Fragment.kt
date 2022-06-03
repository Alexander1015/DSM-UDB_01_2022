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
import java.lang.Exception
import kotlin.math.pow
import kotlin.math.sqrt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ejercicio2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ejercicio2Fragment : Fragment(), View.OnClickListener  {
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
    private lateinit var listv: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_ejercicio2, container, false)
        button = view.findViewById(R.id.btn_ejer2)
        lbl = view.findViewById(R.id.lblresult_ejer2)
        listv = view.findViewById(R.id.txtlista)
        button.setOnClickListener(this)
        return view
    }

    companion object {
        fun newInstance(): ejercicio2Fragment {
            return newInstance()
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_ejer2 -> {
                try {
                    var txtList = listv.text.toString()
                    var newList = txtList.split(",").sorted()
                    var total: Int = newList.size
                    var dato:String = newList[0]
                    var mensaje: String = "Votos Totales:\n\n"
                    var cont: Int = 0
                    var i: Int = 0
                    while (i < total) {
                        println(newList[i])
                        if (i == total - 1) {
                            cont++
                            var porcent: Double = (cont * 100.00) / total
                            mensaje += String.format("Candidato %s:\nvotos: %d, porcentaje: %.2f %%\n\n", dato, cont, porcent)
                        }
                        else if (dato == newList[i]) {
                            cont++
                        }
                        else {
                            var porcent: Double = (cont * 100.00) / total
                            mensaje += String.format("Candidato %s:\nvotos: %d, porcentaje: %.2f %%\n\n", dato, cont, porcent)
                            cont = 1
                            dato = newList[i]
                        }
                        i++
                    }
                    lbl.text = mensaje
                }
                catch (e: Exception) {
                    Log.d("Error", e.toString())
                }
            }
            else -> {

            }
        }
    }
}