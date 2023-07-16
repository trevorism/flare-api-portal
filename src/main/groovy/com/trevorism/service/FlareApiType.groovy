package com.trevorism.service

class FlareApiType {

    static FlareApiType BITCOIN = new FlareApiType("bitcoin", "https://api.flare.network/bitcoin")
    static FlareApiType LITECOIN = new FlareApiType("litecoin", "https://api.flare.network/litecoin")
    static FlareApiType XRPL = new FlareApiType("xrpl", "https://api.flare.network/xrpl")
    static FlareApiType FLARE = new FlareApiType("flare", "https://api.flare.network/flare")
    static FlareApiType SONGBIRD = new FlareApiType("songbird", "https://api.flare.network/songbird")

    final String name
    final String baseUrl

    FlareApiType(String name, String baseUrl){
        this.name = name
        this.baseUrl = baseUrl
    }

}