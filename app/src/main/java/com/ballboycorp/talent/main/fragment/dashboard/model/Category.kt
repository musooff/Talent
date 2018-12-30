package com.ballboycorp.talent.main.fragment.dashboard.model

/**
 * Created by musooff on 30/12/2018.
 */

class Category() {
    var id: Int = 0
    var title: String? = null
    var subTitles: List<String> = arrayListOf()
    var thumbUrl: String? = null

    constructor(title: String, subTitles: List<String>): this(){
        this.title = title
        this.subTitles = subTitles
    }
}