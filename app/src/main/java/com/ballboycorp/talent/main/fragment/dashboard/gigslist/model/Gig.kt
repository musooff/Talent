package com.ballboycorp.talent.main.fragment.dashboard.gigslist.model

/**
 * Created by musooff on 30/12/2018.
 */

class Gig() {
    var id: Int = 0
    var title: String? = null
    var startPrice: Double = 0.0
    var thumbUrl: String? = null


    constructor(title: String, startPrice: Double): this(){
        this.title = title
        this.startPrice = startPrice
    }
}