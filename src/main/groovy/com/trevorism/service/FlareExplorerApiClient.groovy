package com.trevorism.service

import jakarta.inject.Inject

@jakarta.inject.Singleton
class FlareExplorerApiClient {

    static final String MODULE_BLOCK = "block"
    static final String MODULE_ACCOUNT = "account"
    static final String MODULE_STATS = "stats"

    static final String ACTION_BLOCK_NUMBER = "eth_block_number"
    static final String ACTION_BALANCE = "balance"
    static final String ACTION_TOKEN_LIST = "tokenlist"
    static final String ACTION_SUPPLY = "ethsupply"


    @Inject
    ApiPortalClient apiPortalClient

    def invokeFlareExplorerApi(String module, String action){
        String url = "/api?module=${module}&action=${action}"
        apiPortalClient.get(FlareApiType.FLARE_EXPLORER, url).value
    }

    def invokeFlareExplorerApi(String module, String action, String address){
        String url = "/api?module=${module}&action=${action}&address=${address}"
        apiPortalClient.get(FlareApiType.FLARE_EXPLORER, url).value
    }
}
