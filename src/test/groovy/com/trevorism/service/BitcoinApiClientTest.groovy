package com.trevorism.service

import com.trevorism.http.HeadersHttpResponse
import org.junit.jupiter.api.Test

class BitcoinApiClientTest {

    @Test
    void testInvokeWithoutParams() {
        BitcoinApiClient bitcoinApiClient = new BitcoinApiClient()
        bitcoinApiClient.apiPortalClient = [post: {x, y ->
            return new HeadersHttpResponse('{"value": {"chain": "test"}}', [:])
        }] as ApiPortalClient
        assert bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BEST_BLOCK_HASH)
    }

    @Test
    void testInvokeWithParams() {
        BitcoinApiClient bitcoinApiClient = new BitcoinApiClient()
        bitcoinApiClient.apiPortalClient = [post: {x, y ->
            return new HeadersHttpResponse('{"value": {"chain": "test"}}', [:])
        }] as ApiPortalClient
        assert bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_NETWORK_INFO, ["test"])
    }

    @Test
    void testInvokeBlockchainInfo() {
        BitcoinApiClient bitcoinApiClient = new BitcoinApiClient()
        bitcoinApiClient.apiPortalClient = [post: {x, y ->
            return new HeadersHttpResponse('{"value": {"chain": "test"}}', [:])
        }] as ApiPortalClient
        assert bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BLOCKCHAIN_INFO)
    }

}
