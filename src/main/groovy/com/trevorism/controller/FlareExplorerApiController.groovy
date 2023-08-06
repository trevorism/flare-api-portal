package com.trevorism.controller

import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import com.trevorism.service.FlareExplorerApiClient
import com.trevorism.service.LitecoinApiClient
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/flare/explorer")
class FlareExplorerApiController {

    @Inject
    FlareExplorerApiClient flareExplorerApiClient

    @Tag(name = "Flare Explorer Operations")
    @Operation(summary = "Returns flare network block number **Secure")
    @Get(value = "/blockNumber", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlockNumber(){
        flareExplorerApiClient.invokeFlareExplorerApi(FlareExplorerApiClient.MODULE_BLOCK, FlareExplorerApiClient.ACTION_BLOCK_NUMBER)
    }

    @Tag(name = "Flare Explorer Operations")
    @Operation(summary = "Returns flare explorer balance for an address **Secure")
    @Get(value = "/balance/{addressHash}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBalance(String addressHash){
        flareExplorerApiClient.invokeFlareExplorerApi(FlareExplorerApiClient.MODULE_ACCOUNT, FlareExplorerApiClient.ACTION_BALANCE, addressHash)
    }

    @Tag(name = "Flare Explorer Operations")
    @Operation(summary = "Returns flare explorer token list for an address **Secure")
    @Get(value = "/tokenlist/{addressHash}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getTokenList(String addressHash){
        flareExplorerApiClient.invokeFlareExplorerApi(FlareExplorerApiClient.MODULE_ACCOUNT, FlareExplorerApiClient.ACTION_TOKEN_LIST, addressHash)
    }

    @Tag(name = "Flare Explorer Operations")
    @Operation(summary = "Returns flare explorer total supply **Secure")
    @Get(value = "/supply", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getTotalSupply(){
        flareExplorerApiClient.invokeFlareExplorerApi(FlareExplorerApiClient.MODULE_STATS, FlareExplorerApiClient.ACTION_SUPPLY)
    }
}
