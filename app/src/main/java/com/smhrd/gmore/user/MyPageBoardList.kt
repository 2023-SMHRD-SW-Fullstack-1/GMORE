package com.smhrd.gmore.user

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.smhrd.gmore.R
import com.smhrd.gmore.board.BoardDetailVO
import org.json.JSONArray
import org.json.JSONObject

class MyPageBoardList : AppCompatActivity() {

    lateinit var tvTitleMyBoard : TextView
    lateinit var rvMyBoard: RecyclerView
    var data = ArrayList<BoardDetailVO>()

    lateinit var requestQueue: RequestQueue
   lateinit var userId : String

//    lateinit var adapter: MyPageBoardAdapter
    lateinit var board : BoardDetailVO



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page_board_list)

        // 작성 게시글 없을시 텍스트 표시할 뷰
        tvTitleMyBoard = findViewById(R.id.tvTitleMyBoard)

        requestQueue = Volley.newRequestQueue(this@MyPageBoardList)
        rvMyBoard = findViewById(R.id.rvMyBoard)


        // spf 이용해 로그인 유저 데이터 받아오기
        val spf = getSharedPreferences("userSPF", Context.MODE_PRIVATE)


        // spf 에서 user 데이터 가져오기
        userId = spf.getString("loginId", "")!!
        Log.d("리스트인덱스", userId)
        val request = object : StringRequest(
            Request.Method.POST,
            "http://172.30.1.40:8888/user/boardlist",
            { response ->
                Log.d("response", response.toString())


                if (response.toString().equals("NODATA")) {
                    tvTitleMyBoard.text = "작성한 게시물이 없습니다"
                } else {

//                var result = JSONArray(response)
                    var result = JSONArray(response)
                for (i in 0 until result.length()) {
                    Log.d("데이터길이",result.length().toString())
                    // 여기 수정 -> board 전역 변수로 변경
//                    board = Gson().fromJson(result.get(i).toString(), BoardDetailVO::class.java)

                    // 데이터 파싱

                    val board_id = result.getJSONObject(i).getInt("board_id")

                    val user_id = result.getJSONObject(i).getString("user_id")
                    val title = result.getJSONObject(i).getString("title")
                    val content = result.getJSONObject(i).getString("content")
                    val image_url = result.getJSONObject(i).getString("image_url")
                    Log.d("파싱데이터", image_url.toString())
                    val category = result.getJSONObject(i).getString("category")
//                    val date = result.getString("date")
                    val date = result.getJSONObject(i).getString("date")

                    var newBoard : BoardDetailVO = BoardDetailVO(board_id,title,content,image_url,category,user_id.toInt(),date,null)
                    data.add(newBoard)

//                    data.add(board)

//                    adapter = MyPageBoardAdapter(applicationContext, R.layout.myboardtemplate, data)
                    }
                    // ✨✨✨✨✨adapter 생성시 넘겨 주는 매개 변수 순서 잘 맞춰 주기
                    var adapter =
                        MyPageBoardAdapter(applicationContext, R.layout.myboardtemplate, data)
                    rvMyBoard.layoutManager = LinearLayoutManager(this)
                    rvMyBoard.adapter = adapter
                }
            }, { error ->
                Log.d("error", error.toString())
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap<String, String>()
                params.put("userId", userId)

                return params
            }
        }
        requestQueue.add(request)

    }


}