package com.smhrd.gmore.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.smhrd.gmore.R
import com.smhrd.gmore.vo.BoardCategoryVO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GameCategoryActivity : AppCompatActivity() {

    lateinit var reqQueue: RequestQueue
    lateinit var rv: RecyclerView
    lateinit var tvCategoryName: TextView
    val boardList = ArrayList<BoardCategoryVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_category)

        rv = this.findViewById(R.id.rvCategoryList1)
        tvCategoryName = this.findViewById(R.id.tvCategoryListName1)

        reqQueue = Volley.newRequestQueue(this@GameCategoryActivity)

        val request = object : StringRequest(
            Request.Method.GET,
            "http://localhost:8888/board/category",
//            "http://172.30.1.24:8888/board/category",
            { response ->
                Log.d("response", response.toString())

                var result = JSONArray(response)

                // JSON 응답을 List<BoardCategoryVO>로 변환하여 boardList 에 저장
                val typeToken = object : TypeToken<List<BoardCategoryVO>>() {}.type
                Log.d("TypeToken", typeToken.toString())
                boardList.clear()
                boardList.addAll(Gson().fromJson(response, typeToken))

                val adapter = BoardCategoryAdapter(this@GameCategoryActivity, boardList)
                rv.layoutManager = LinearLayoutManager(this@GameCategoryActivity)
                rv.adapter = adapter
            },
            { error ->
                Log.d("error!!", error.toString())
            }
        ) {}
        reqQueue.add(request)
    }

}