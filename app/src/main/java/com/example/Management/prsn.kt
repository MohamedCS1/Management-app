package com.example.Management

import android.widget.EditText

class prsn {

    var ID:Int? = null
    var PARM:String? = null
    var NARM:String   ? = null
    var DNARM:String  ? = null
    var PDNARM:String ? = null
    var PZWJ:String   ? = null
    var NZWJ:String   ? = null
    var DNZWJ:String  ? = null
    var TWZWJ:String  ? = null
    var PDNZWJ:String ? = null
    var CHM:String    ? = null
    var CHF:String    ? = null
    var ADDRES:String ? = null
    var NUM:String    ? = null

    constructor(
        PARM:String,
        NARM:String,
        DNARM:String,
        PDNARM:String,
        PZWJ:String,
        NZWJ:String,
        DNZWJ:String,
        TWZWJ:String,
        PDNZWJ:String,
        CHM:String,
        CHF:String,
        ADDRES:String,
        NUM: String
    )
    {
        this.PARM = PARM
        this.NARM = NARM
        this.DNARM = DNARM
        this.PDNARM = PDNARM
        this.PZWJ = PZWJ
        this.NZWJ = NZWJ
        this.DNZWJ = DNZWJ
        this.TWZWJ = TWZWJ
        this.PDNZWJ = PDNZWJ
        this.CHF = CHF
        this.CHM = CHM
        this.ADDRES = ADDRES
        this.NUM = NUM
    }
    constructor(ID:Int,PARM:String,NARM:String,DNARM:String,PDNARM:String,PZWJ:String,NZWJ:String,DNZWJ:String,TWZWJ:String,PDNZWJ:String,CHM:String,CHF:String,ADDRES:String,NUM:String)
    {
        this.ID = ID
        this.PARM = PARM
        this.NARM = NARM
        this.DNARM = DNARM
        this.PDNARM = PDNARM
        this.PZWJ = PZWJ
        this.NZWJ = NZWJ
        this.DNZWJ = DNZWJ
        this.TWZWJ = TWZWJ
        this.PDNZWJ = PDNZWJ
        this.CHF = CHF
        this.CHM = CHM
        this.ADDRES = ADDRES
        this.NUM = NUM
    }



}