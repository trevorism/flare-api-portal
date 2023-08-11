package com.trevorism.service

import com.trevorism.model.FlareApiRequest
import jakarta.inject.Inject

@jakarta.inject.Singleton
class FlareApiClient {

    static final String GET_ETH_BLOCK_NUMBER = "eth_blockNumber"
    static final String GET_ETH_CHAIN_ID = "eth_chainId"

    @Inject
    ApiPortalClient apiPortalClient

    def invokeFlareApi(FlareApiType type, String methodName){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.jsonrpc = "2.0"
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        apiPortalClient.post(type, flareApiRequest).value
    }

    def invokeFlareApi(FlareApiType type, String methodName, List params){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.jsonrpc = "2.0"
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        flareApiRequest.params = params
        apiPortalClient.post(type, flareApiRequest).value
    }
}
