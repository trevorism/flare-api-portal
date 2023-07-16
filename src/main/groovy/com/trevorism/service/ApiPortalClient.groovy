package com.trevorism.service

import com.trevorism.http.HeadersHttpResponse
import com.trevorism.model.FlareApiRequest

interface ApiPortalClient {

    HeadersHttpResponse post(FlareApiType apiType, FlareApiRequest flareApiRequest)

}