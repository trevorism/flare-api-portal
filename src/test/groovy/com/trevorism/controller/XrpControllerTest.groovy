package com.trevorism.controller

import com.trevorism.service.XrpApiClient
import org.junit.jupiter.api.Test

class XrpControllerTest {

    @Test
    void testGetServerInfo() {
        XrpController xrpController = new XrpController()
        String json = "{\"test\":\"value\"}"
        xrpController.xrpApiClient = ["invokeXrpApi":{ x -> json}] as XrpApiClient
        assert json == xrpController.getServerInfo()
    }

    @Test
    void testGetAccountInfo() {
        XrpController xrpController = new XrpController()
        String json = "{\"test\":\"value\"}"
        xrpController.xrpApiClient = ["invokeXrpApi":{ x,y -> json}] as XrpApiClient
        assert json == xrpController.getAccountInfo("r4xxxxxxxxxxxxxxxxxxxxxxxxxx")
    }
}
