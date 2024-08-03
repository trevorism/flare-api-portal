package com.trevorism.controller

import com.trevorism.service.BitcoinApiClient
import com.trevorism.service.FlareApiPortalClient
import org.junit.jupiter.api.Test

class BitcoinControllerTest {

    @Test
    void testGetRawTransaction(){
        BitcoinController bitcoinController = new BitcoinController()
        bitcoinController.bitcoinApiClient = [invokeBitcoinApi: {x, y -> return "{\"test\":\"value\"}"}] as BitcoinApiClient
        assert bitcoinController.getTransactionInfo("xuz")
    }

    @Test
    void testGetChainTips(){
        BitcoinController bitcoinController = new BitcoinController()
        bitcoinController.bitcoinApiClient = [invokeBitcoinApi: {x -> return "{\"test\":\"value\"}"}] as BitcoinApiClient
        assert bitcoinController.getChainTips()
    }
}
