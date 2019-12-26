package joe.creative.grandom

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_second.*
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [second.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [second.newInstance] factory method to
 * create an instance of this fragment.
 */
class second : Fragment() {
    // TODO: Rename and change types of parameters
    private var generatedNumber: String = "";
//    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            generatedNumber = it.getString("GENERATED_NUMBER", "1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false);

        // event listener for button click
        view.findViewById<Button>(R.id.previousBtn).setOnClickListener {
            (activity as MainActivity).openFirstFragment()
        };

        this.generateRandomNumber(view);
        return view;
    }

    fun generateRandomNumber(view: View) {
        view.findViewById<TextView>(R.id.message).text = "Generating random number from 0 - ${generatedNumber}";
        view.findViewById<TextView>(R.id.randomNumber).text = Random.nextInt(0, generatedNumber.toInt()).toString();
    }

    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: randomNumberUri) {
//        listener?.onFragmentInteraction(uri)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */

}
