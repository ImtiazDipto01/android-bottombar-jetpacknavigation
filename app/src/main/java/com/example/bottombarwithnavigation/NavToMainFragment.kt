package com.example.bottombarwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_nav_to_main.*

class NavToMainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nav_to_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initListener()
    }

    private fun initListener() {
        viewBalanceBtn.setOnClickListener(this)
        sendMoneyBtn.setOnClickListener(this)
        viewTransactionsBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.viewBalanceBtn ->      navController.navigate(R.id.action_navToMainFragment_to_navToChooseRecepientFragment)
                R.id.sendMoneyBtn ->        navController.navigate(R.id.action_navToMainFragment_to_navToViewBalanceFragment)
                R.id.viewTransactionsBtn -> navController.navigate(R.id.action_navToMainFragment_to_navToViewTransactionFragment)
            }
        }
    }

}
