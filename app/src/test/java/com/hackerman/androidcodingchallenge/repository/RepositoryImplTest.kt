package com.hackerman.androidcodingchallenge.repository

import com.hackerman.androidcodingchallenge.api_service.API
import com.hackerman.androidcodingchallenge.repository.model.CardDetail
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class RepositoryImplTest{
    @Mock
    lateinit var api: API

    @Mock
    lateinit var card: CardDetail



    @Test
    fun testRepository(){
        MockitoAnnotations.initMocks(this)
        GlobalScope.launch {
            Mockito.`when`(api.getGetCardDetails("12344")).thenReturn(null)
            var repository = RepositoryImpl(api)
            assertEquals(repository.getCardDetails("12345"),null)
        }
    }


    @Test
    fun test_repository_returns_api_call(){
        MockitoAnnotations.initMocks(this)
        val response = Response.success(card)
        GlobalScope.launch {
            Mockito.`when`(api.getGetCardDetails("12344")).thenReturn(response)
            var repository = RepositoryImpl(api)
            assertEquals(repository.getCardDetails("12345"),response)
        }
    }

}