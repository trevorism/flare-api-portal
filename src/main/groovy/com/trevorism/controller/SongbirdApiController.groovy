package com.trevorism.controller

import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import com.trevorism.service.FlareApiClient
import com.trevorism.service.FlareApiType
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/songbird")
class SongbirdApiController {

    @Inject
    FlareApiClient flareApiClient

    @Tag(name = "Songbird Operations")
    @Operation(summary = "Returns songbird block number **Secure")
    @Get(value = "/blockNumber", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlockNumber(){
        flareApiClient.invokeFlareApi(FlareApiType.SONGBIRD, FlareApiClient.GET_ETH_BLOCK_NUMBER)
    }

    @Tag(name = "Songbird Operations")
    @Operation(summary = "Returns songbird chain id **Secure")
    @Get(value = "/chainId", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getChainId(){
        flareApiClient.invokeFlareApi(FlareApiType.SONGBIRD, FlareApiClient.GET_ETH_CHAIN_ID)
    }

}
