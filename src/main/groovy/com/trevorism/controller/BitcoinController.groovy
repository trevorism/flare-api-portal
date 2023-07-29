package com.trevorism.controller

import com.trevorism.service.BitcoinApiClient
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/bitcoin")
class BitcoinController {

    @Inject
    BitcoinApiClient bitcoinApiClient

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns bitcoin network info")
    @Get(value = "/networkInfo", produces = MediaType.APPLICATION_JSON)
    def getNetworkInfo(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_NETWORK_INFO)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns bitcoin blockchain info")
    @Get(value = "/blockchainInfo", produces = MediaType.APPLICATION_JSON)
    def getBlockchainInfo(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BLOCKCHAIN_INFO)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns latest block hash")
    @Get(value = "/bestHash", produces = MediaType.APPLICATION_JSON)
    def getBestBlockchainHash(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BEST_BLOCK_HASH)
    }
}
