package com.trevorism.service

import com.google.gson.Gson
import com.trevorism.ClasspathBasedPropertiesProvider
import com.trevorism.PropertiesProvider
import com.trevorism.http.HeadersHttpResponse
import com.trevorism.http.HttpClient
import com.trevorism.http.JsonHttpClient
import com.trevorism.model.FlareApiRequest

@jakarta.inject.Singleton
class FlareApiPortalClient implements ApiPortalClient {

    private HttpClient httpClient = new JsonHttpClient()
    private Gson gson = new Gson()
    private PropertiesProvider provider = new ClasspathBasedPropertiesProvider()
    private final String apiKey

    FlareApiPortalClient() {
        this.apiKey = provider.getProperty("apiKey")
    }

    @Override
    HeadersHttpResponse post(FlareApiType apiType, FlareApiRequest flareApiRequest) {
        httpClient.post(apiType.baseUrl, gson.toJson(flareApiRequest), ["x-apikey":apiKey])
    }

    @Override
    HeadersHttpResponse get(FlareApiType apiType, String url) {
        httpClient.get(apiType.baseUrl + url, ["x-apikey":apiKey])
    }
}
