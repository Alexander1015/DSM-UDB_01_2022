package sv.edu.udb.desafio1_bf180436

import android.app.AlertDialog
import android.content.DialogInterface
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
import java.util.logging.Logger
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sqrt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ejercicio1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ejercicio1Fragment : Fragment(), View.OnClickListener {
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
    private lateinit var A: EditText
    private lateinit var B: EditText
    private lateinit var C: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_ejercicio1, container, false)
        button = view.findViewById(R.id.btn_ejer1)
        lbl = view.findViewById(R.id.lblresult_ejer1)
        A = view.findViewById(R.id.txtnuma)
        B = view.findViewById(R.id.txtnumb)
        C = view.findViewById(R.id.txtnumc)
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
            R.id.btn_ejer1 -> {
                try {
                    var txtA = A.text.toString()
                    var txtB = B.text.toString()
                    var txtC = C.text.toString()
                    var b2 = txtB.toDouble().pow(2)
                    var intern = b2 - 4 * txtA.toDouble() * txtC.toDouble()
                    if (intern >= 0) {
                        var square = sqrt(intern)
                        var num1 = - txtB.toDouble() + square
                        var num2 = - txtB.toDouble() - square
                        var den = 2 * txtA.toDouble()
                        var x1 = num1 / den
                        var x2 = num2 / den
                        lbl.text = String.format("Solución:\nx1 = %.2f, x2 = %.2f", x1, x2)
                    }
                    else {
                        lbl.text = "El ejercicio no tiene solución"
                    }
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