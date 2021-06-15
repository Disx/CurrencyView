package com.dis.currencyview.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dis.currencyview.R
import com.dis.currencyview.databinding.HomeFragmentBinding
import com.dis.currencyview.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.isAuthorized()){
            viewModel.isLoggedIn.observe(viewLifecycleOwner, Observer { stateLoggedIn ->
                binding.message.text = "isLoggedIn = ${stateLoggedIn}"
            })
        } else {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}