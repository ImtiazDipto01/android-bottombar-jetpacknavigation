package com.example.bottombarwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_nav_to_choose_recepient.*

class NavToChooseRecepientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_to_choose_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance(view)
        initListener()
    }

    private fun initListener() {
        nextBtn.setOnClickListener(this)
        cancelBtn.setOnClickListener(this)
    }

    private fun initInstance(view: View) {
        navController = Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        if(v != null){
            when (v.id){
                R.id.nextBtn ->{
                    val bundle = bundleOf("recipient" to input_recipient.text.toString())
                    navController.navigate(R.id.action_navToChooseRecepientFragment_to_navToSepecifyAmountFragment, bundle)
                }
                R.id.cancelBtn -> activity?.onBackPressed()
            }
        }
    }

}
