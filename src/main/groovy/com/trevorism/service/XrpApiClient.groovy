package com.trevorism.service

import com.trevorism.model.FlareApiRequest
import jakarta.inject.Inject

@jakarta.inject.Singleton
class XrpApiClient {

    static final String GET_SERVER_INFO = "server_info"
    static final String GET_ACCOUNT_INFO = "account_info"
    static final String GET_ACCOUNT_LINES = "account_lines"
    static final String GET_ACCOUNT_TX = "account_tx"

    @Inject
    ApiPortalClient apiPortalClient

    def invokeXrpApi(String methodName){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        apiPortalClient.post(FlareApiType.XRPL, flareApiRequest).value
    }

    def invokeXrpApi(String methodName, List params){
        def flareApiRequest = new FlareApiRequest()
        flareApiRequest.id = UUID.randomUUID().toString()
        flareApiRequest.method = methodName
        flareApiRequest.params = params
        apiPortalClient.post(FlareApiType.XRPL, flareApiRequest).value
    }

}
