package joe.creative.grandom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_main, container, false);

        // all event listeners for buttons
        view.findViewById<Button>(R.id.toastBtn).setOnClickListener {
            val newToast = Toast.makeText(this@Home.context, "Hey, Toast here", Toast.LENGTH_LONG);
            newToast.show();
        }
        view.findViewById<Button>(R.id.countBtn).setOnClickListener {
            val count: String = countValue.text.toString();
            var newCount: Int = Integer.parseInt(count);
            newCount++;
            countValue.text = newCount.toString();
        }
        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            // call a function in the parent activity of this fragment
            (activity as MainActivity).openSecondFragment(countValue.text.toString());
        }
        // event listeners for buttons ends here!!

        // Inflate the layout for this fragment
        return view;
    }
}
