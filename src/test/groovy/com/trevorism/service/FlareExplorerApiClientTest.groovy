package com.trevorism.service

import com.trevorism.http.HeadersHttpResponse
import org.junit.jupiter.api.Test

class FlareExplorerApiClientTest {

    @Test
    void testInvokeFlareExplorerApi() {

        FlareExplorerApiClient flareExplorerApiClient = new FlareExplorerApiClient()
        String json = '{"result": {"status": "success"}}'
        flareExplorerApiClient.apiPortalClient = ["get": { x, y ->
            return new HeadersHttpResponse(json, [:])
        }] as ApiPortalClient

        assert json == flareExplorerApiClient.invokeFlareExplorerApi(FlareExplorerApiClient.MODULE_BLOCK, FlareExplorerApiClient.ACTION_BLOCK_NUMBER)
    }
}
