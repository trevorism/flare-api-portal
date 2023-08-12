package com.trevorism.gcloud

import com.trevorism.https.AppClientSecureHttpClient
import com.trevorism.https.SecureHttpClient
import io.cucumber.groovy.EN
import io.cucumber.groovy.Hooks

/**
 * @author tbrooks
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

SecureHttpClient secureHttpClient = new AppClientSecureHttpClient()
String serverInfo

When(/the server info is requested/) {  ->
    serverInfo = secureHttpClient.get("https://flare-api-portal.trade.trevorism.com/xrp/serverInfo")
}

Then(/the server info is returned/) {  ->
    assert serverInfo.contains("reserve_base_xrp")
    assert serverInfo.contains('"status":"success"')
}


