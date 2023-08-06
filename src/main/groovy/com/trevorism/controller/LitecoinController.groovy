package com.trevorism.controller

import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import com.trevorism.service.BitcoinApiClient
import com.trevorism.service.LitecoinApiClient
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/litecoin")
class LitecoinController {

    @Inject
    LitecoinApiClient litecoinApiClient

    @Tag(name = "Litecoin Operations")
    @Operation(summary = "Returns litecoin network info **Secure")
    @Get(value = "/networkInfo", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getNetworkInfo(){
        litecoinApiClient.invokeBitcoinApi(LitecoinApiClient.GET_NETWORK_INFO)
    }

    @Tag(name = "Litecoin Operations")
    @Operation(summary = "Returns litecoin blockchain info **Secure")
    @Get(value = "/blockchainInfo", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlockchainInfo(){
        litecoinApiClient.invokeBitcoinApi(LitecoinApiClient.GET_BLOCKCHAIN_INFO)
    }

    @Tag(name = "Litecoin Operations")
    @Operation(summary = "Gets litecoin block with the given hash **Secure")
    @Get(value = "/block/{hash}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlock(String hash){
        litecoinApiClient.invokeBitcoinApi(LitecoinApiClient.GET_BLOCK, [hash])
    }

    @Tag(name = "Litecoin Operations")
    @Operation(summary = "Gets litecoin transaction info with the given id **Secure")
    @Get(value = "/tx/{txid}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getTransactionInfo(String txid){
        litecoinApiClient.invokeBitcoinApi(LitecoinApiClient.GET_RAW_TRANSACTION, [txid, true])
    }

    @Tag(name = "Litecoin Operations")
    @Operation(summary = "Returns chain tips **Secure")
    @Get(value = "/chainTips", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getChainTips(){
        litecoinApiClient.invokeBitcoinApi(LitecoinApiClient.GET_CHAIN_TIPS)
    }
}
