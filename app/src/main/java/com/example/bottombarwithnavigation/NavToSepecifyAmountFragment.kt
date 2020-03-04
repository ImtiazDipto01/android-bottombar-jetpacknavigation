package com.example.bottombarwithnavigation

import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_nav_to_sepecify_amount.*

class NavToSepecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    var recipient: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient") ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_to_sepecify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance(view)
        initListener()
        tvRecipient.text = "Sending Money To $recipient"
    }

    private fun initInstance(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun initListener(){
        sendBtn.setOnClickListener(this)
        cancelBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.cancelBtn -> activity?.onBackPressed()
                R.id.sendBtn -> {
                    val valueObj = Value(recipient!!, inputAmount.text.toString())
                    val bundle = bundleOf(
                        "allValue" to valueObj)
                    navController.navigate(R.id.action_navToSepecifyAmountFragment_to_navToConfirmationFragment, bundle)
                }
            }
        }
    }

}
