package com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig.model


/**
 * Created by muso on 31/12/2018.
 */

class Plan(){
    var planId: Int = 0
    var gigId: Int = 0
    var price: Int = 0
    var description: String? = null
    var features: List<String> = arrayListOf()

    constructor(price: Int, description: String?, features: List<String>): this(){
        this.price = price
        this.description = description
        this.features = features
    }
}