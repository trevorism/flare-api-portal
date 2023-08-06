package com.trevorism.service

import com.trevorism.model.FlareApiRequest
import jakarta.inject.Inject

@jakarta.inject.Singleton
class LitecoinApiClient {

    static final String GET_BLOCKCHAIN_INFO = "getblockchaininfo"
    static final String GET_NETWORK_INFO = "getnetworkinfo"
    static final String GET_BEST_BLOCK_HASH = "getbestblockhash"
    static final String GET_BLOCK = "getblock"
    static final String GET_RAW_TRANSACTION = "getrawtransaction"

    @Inject
    ApiPortalClient apiPortalClient

    def invokeBitcoinApi(String methodName){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        apiPortalClient.post(FlareApiType.LITECOIN, flareApiRequest).value
    }

    def invokeBitcoinApi(String methodName, List params){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        flareApiRequest.params = params
        apiPortalClient.post(FlareApiType.LITECOIN, flareApiRequest).value
    }
}
