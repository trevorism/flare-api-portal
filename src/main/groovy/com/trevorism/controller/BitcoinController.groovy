package com.trevorism.controller

import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
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
    @Operation(summary = "Returns bitcoin network info **Secure")
    @Get(value = "/networkInfo", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getNetworkInfo(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_NETWORK_INFO)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns bitcoin blockchain info **Secure")
    @Get(value = "/blockchainInfo", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlockchainInfo(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BLOCKCHAIN_INFO)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns latest block hash **Secure")
    @Get(value = "/bestHash", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBestBlockchainHash(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BEST_BLOCK_HASH)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns chain tips **Secure")
    @Get(value = "/chainTips", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getChainTips(){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_CHAIN_TIPS)
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns latest block hash **Secure")
    @Get(value = "/block/{hash}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getBlock(String hash){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_BLOCK, [hash])
    }

    @Tag(name = "Bitcoin Operations")
    @Operation(summary = "Returns latest block hash **Secure")
    @Get(value = "/tx/{txid}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    def getTransactionInfo(String txid){
        bitcoinApiClient.invokeBitcoinApi(BitcoinApiClient.GET_RAW_TRANSACTION, [txid, true])
    }
}
