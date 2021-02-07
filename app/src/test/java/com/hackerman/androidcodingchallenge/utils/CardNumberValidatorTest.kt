package com.hackerman.androidcodingchallenge.utils

import org.junit.Test

import org.junit.Assert.*

class CardNumberValidatorTest{

    @Test
    fun number_over_four_digits(){

        var cardNumber="123456"
        assertTrue(CardNumberValidator().isValidCardNumber(cardNumber))
    }

    @Test
    fun number_with_special_character(){
        var cardNumber="123456%"
        assertFalse(CardNumberValidator().isValidCardNumber(cardNumber))
    }

    @Test
    fun number_less_than_four_Digits(){
        var cardNumber="126"
        assertFalse(CardNumberValidator().isValidCardNumber(cardNumber))
    }


    @Test
    fun number_with_four_digit(){
        var cardNumber="1234"
        assertTrue(CardNumberValidator().isValidCardNumber(cardNumber))
    }

}