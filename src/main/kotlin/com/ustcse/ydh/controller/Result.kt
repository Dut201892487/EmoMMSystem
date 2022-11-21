package com.ustcse.ydh.controller

/**
 *@Author 殷德好
 *@Date 2022/11/17 22:20
 *@Version 1.0
 */

class Result() {
    var code:Int?=null;
    var data:Any?=null;
    var msg:String?=null;


    constructor(code: Int,msg:String) : this() {
        this.code = code
        this.msg = msg
    }
    constructor(code: Int,data:Any, msg:String) : this() {
        this.code = code
        this.data = data
        this.msg = msg
    }
}
