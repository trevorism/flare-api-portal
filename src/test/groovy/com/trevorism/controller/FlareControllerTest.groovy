package com.trevorism.controller

import com.trevorism.service.FlareApiClient
import com.trevorism.service.FlareApiPortalClient
import com.trevorism.service.XrpApiClient
import org.junit.jupiter.api.Test

class FlareControllerTest {

    @Test
    void testGetBlockNumber() {
        FlareApiController flareController = new FlareApiController()

        String json = "{\"test\":\"value\"}"
        flareController.flareApiClient = ["invokeFlareApi":{ x,y -> json}] as FlareApiClient
        assert json == flareController.getBlockNumber()

        //flareController.flareApiClient = new FlareApiClient()
        //flareController.flareApiClient.apiPortalClient = new FlareApiPortalClient()
        //println flareController.getBlockNumber()
    }

    @Test
    void testGetChainId() {
        FlareApiController flareController = new FlareApiController()
        String json = "{\"test\":\"value\"}"
        flareController.flareApiClient = ["invokeFlareApi":{ x,y -> json}] as FlareApiClient
        assert json == flareController.getChainId()
    }
}
