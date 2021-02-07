package com.hackerman.androidcodingchallenge.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackerman.androidcodingchallenge.databinding.FragmentCardDetailsBinding
import com.hackerman.androidcodingchallenge.repository.model.CardDetail


class CardDetailsFragment : Fragment() {
    private var _binding: FragmentCardDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCardDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**Get passed argument*/
        var cardDetails = arguments?.getSerializable("CARD_DETAILS") as CardDetail

        binding.fragmentCardDetailsCardBrandInfoTv.text = cardDetails.scheme.toUpperCase()
        binding.fragmentCardDetailsBankInfoTv.text = cardDetails.bank.name.toUpperCase()
        binding.fragmentCardDetailsCardTypeInfoTv.text = cardDetails.type.toUpperCase()
        binding.fragmentCardDetailsCountryInfoTv.text = cardDetails.country.name.toUpperCase() + "   " + cardDetails.country.emoji


    }


}