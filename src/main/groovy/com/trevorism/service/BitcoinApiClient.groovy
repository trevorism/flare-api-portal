package com.trevorism.service

import com.trevorism.model.FlareApiRequest
import jakarta.inject.Inject

@jakarta.inject.Singleton
class BitcoinApiClient {

    static final String GET_BLOCKCHAIN_INFO = "getblockchaininfo"
    static final String GET_NETWORK_INFO = "getnetworkinfo"
    static final String GET_BEST_BLOCK_HASH = "getbestblockhash"

    @Inject
    ApiPortalClient apiPortalClient

    def invokeBitcoinApi(String methodName){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        apiPortalClient.post(FlareApiType.BITCOIN, flareApiRequest).value
    }

    def invokeBitcoinApi(String methodName, List params){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        flareApiRequest.params = params
        apiPortalClient.post(FlareApiType.BITCOIN, flareApiRequest).value
    }
}
