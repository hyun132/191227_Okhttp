package com.example.a191227_okhttp.utils

import android.content.Context
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ConnectServer {

    interface JsonRequestHandler{
        fun onResponse(json: JSONObject)
    }

    companion object{
        val baseUrl = ""

//        클라이언트 객체화
        var client = OkHttpClient()

//        서버로 들고갈 파라미터 작성 - 요청함수
        fun postRequest(context: Context, name:String ,img:String, phone:String ,handler:JsonRequestHandler?){

            var url = "${baseUrl}/..."
//    서버로 들고갈 폼데이터 작성
            val formData = FormBody.Builder().add("name",name).add("img",img).add("phone",phone).build()
//    실제로 날아갈 요청 작성
            val request = Request.Builder().url("").post(formData).build()
//    작성한 요청 보내기
            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    var body = response.body().toString()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }

    }
}