package com.trevorism.controller

import com.trevorism.service.BitcoinApiClient
import com.trevorism.service.XrpApiClient
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/xrp")
class XrpController {

    @Inject
    XrpApiClient xrpApiClient

    @Tag(name = "Xrp Operations")
    @Operation(summary = "Returns xrp server info")
    @Get(value = "/serverInfo", produces = MediaType.APPLICATION_JSON)
    def getServerInfo(){
        xrpApiClient.invokeXrpApi(XrpApiClient.GET_SERVER_INFO)
    }

    @Tag(name = "Xrp Operations")
    @Operation(summary = "Returns xrp address info")
    @Get(value = "/accountInfo/{address}", produces = MediaType.APPLICATION_JSON)
    def getAccountInfo(String address){
        xrpApiClient.invokeXrpApi(XrpApiClient.GET_ACCOUNT_INFO, [["account":address]])
    }
}
