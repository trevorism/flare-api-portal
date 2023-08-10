package com.trevorism.controller

import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import com.trevorism.service.FlareApiClient
import com.trevorism.service.FlareExplorerApiClient
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/flare")
class FlareApiController {

    @Inject
    FlareApiClient flareApiClient

    @Tag(name = "Flare Operations")
    @Operation(summary = "Returns flare block number **Secure")
    @Get(value = "/blockNumber", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlockNumber(){
        flareApiClient.invokeFlareApi(FlareApiClient.GET_ETH_BLOCK_NUMBER,[1])
    }

    @Tag(name = "Flare Operations")
    @Operation(summary = "Returns flare chain id **Secure")
    @Get(value = "/chainId", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getChainId(){
        flareApiClient.invokeFlareApi(FlareApiClient.GET_ETH_CHAIN_ID, [1])
    }

}
