package com.trevorism.service

import com.trevorism.http.HeadersHttpResponse
import org.junit.jupiter.api.Test

class XrpApiClientTest {

    @Test
    void testXrpNonParam(){
        XrpApiClient xrpApiClient = new XrpApiClient()
        String json = '{"result": {"status": "success"}}'
        xrpApiClient.apiPortalClient = ["post": {x, y ->
            return new HeadersHttpResponse(json, [:])
        }] as ApiPortalClient
        assert json == xrpApiClient.invokeXrpApi(XrpApiClient.GET_SERVER_INFO)
    }

    @Test
    void testXrpWithParam(){
        XrpApiClient xrpApiClient = new XrpApiClient()
        String json = '{"result": {"status": "success"}}'
        xrpApiClient.apiPortalClient = ["post": {x, y ->
            return new HeadersHttpResponse(json, [:])
        }] as ApiPortalClient
        assert json == xrpApiClient.invokeXrpApi(XrpApiClient.GET_ACCOUNT_INFO, [["account": "rpxxxxxxxxxxxxxxxxxxxxxxxxxxx"]])
    }
}
