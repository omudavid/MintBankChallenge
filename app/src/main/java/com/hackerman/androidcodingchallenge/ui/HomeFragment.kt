package com.hackerman.androidcodingchallenge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hackerman.androidcodingchallenge.R
import com.hackerman.androidcodingchallenge.databinding.FragmentHomeBinding
import com.hackerman.androidcodingchallenge.utils.CardNumberValidator
import com.hackerman.androidcodingchallenge.view_model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var validator: CardNumberValidator
    lateinit var navController: NavController
    private val viewModel:HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.fragmentHomeSubmitBtn.setOnClickListener {
            it.isEnabled = false
          var number =  binding.fragmentHomeTextField.text.toString().trim()
            if(validator.isValidCardNumber(number)){
                lifecycleScope.launch {
                    try{
                  var cardDetails =  viewModel.getCardDetails(number)
                        if(cardDetails!=null){
                            val bundle = bundleOf("CARD_DETAILS" to cardDetails as Serializable)
                            navController.navigate(R.id.action_homeFragment_to_cardDetailsFragment,bundle)
                            binding.fragmentHomeTextField.text?.clear()
                        }else{
                            it.isEnabled = true
                            Toast.makeText(requireContext(), "Card Details not found", Toast.LENGTH_LONG).show()
                        }
                    }catch (e:Exception){
                        it.isEnabled = true
                        Toast.makeText(requireContext(), "Please check network connection", Toast.LENGTH_LONG).show()
                    }

                }

           }else{  it.isEnabled = true
                binding.fragmentHomeTextField.setError("Invalid Card Number")}

        }


    }

}