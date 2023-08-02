package com.smhrd.gmore.board

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.smhrd.gmore.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class BoardDetailActivity : AppCompatActivity() {

    // 뷰 변수 선언
    private lateinit var tvBoardTitle: TextView
    private lateinit var tvBoardWriter: TextView
    private lateinit var tvBoardDate: TextView
    private lateinit var tvBoardContent: TextView
    private lateinit var ivBoardImage: ImageView
    private lateinit var ivInputAdd: ImageView
    private lateinit var rvComments: RecyclerView
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var boardbookmark: ImageView
    private lateinit var boardLike: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_detail)
        tvBoardTitle = findViewById(R.id.tvBoardTitle)
        tvBoardWriter = findViewById(R.id.tvBoardWriter)
        tvBoardDate = findViewById(R.id.tvBoardDate)
        tvBoardContent = findViewById(R.id.tvBoardContent)
        ivBoardImage = findViewById(R.id.ivBoardImage)
        ivInputAdd = findViewById(R.id.ivInputAdd)
        rvComments = findViewById(R.id.rvComments)
        boardbookmark = findViewById(R.id.boardBookmark)
        boardLike = findViewById(R.id.boardLike)

        fetchBoardDetail()
        fetchComments()
        var isBookmarked = false // 북마크 상태를 저장하는 변수 (기본값: false)

        boardbookmark.setOnClickListener {
            isBookmarked = !isBookmarked // isBookmarked 값을 전환 (예: ture -> false, false -> true)

            if (isBookmarked) {
                boardbookmark.setImageResource(android.R.drawable.btn_star_big_on) // 활성화 된 별 이미지로 변경
            } else {
                boardbookmark.setImageResource(android.R.drawable.btn_star_big_off) // 비활성화 된 별 이미지로 변경
            }
            updateBookmark(isBookmarked)
        }

        var isLiked = false // 좋아요 상태를 저장하는 변수 (기본값: false)

        boardLike.setOnClickListener {
            isLiked = !isLiked // 좋아요 상태를 전환 (예: ture -> false, false -> true)

            if (isLiked) {
                boardLike.setImageResource(R.drawable.harton) // 활성화 된 하트 이미지로 변경
            } else {
                boardLike.setImageResource(R.drawable.hartoff) // 비활성화 된 하트 이미지로 변경
            }
            updateLike(isLiked)
        }
    }

    private fun fetchBoardDetail() {
        thread {
            try {
                val urlString = "http://172.30.1.11:8888/board/detail/1"
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection

                conn.requestMethod = "GET"

                val `in` = BufferedReader(InputStreamReader(conn.inputStream))
                val response = StringBuilder()

                var inputLine: String?
                while (`in`.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                `in`.close()

                Log.d("Response", response.toString())

                // 응답을 Kotlin 데이터 클래스로 변환
                val gson = Gson()
                val boardDetail = gson.fromJson(response.toString(), BoardDetailVO::class.java)

                // UI 갱신
                runOnUiThread {
                    tvBoardTitle.text = boardDetail.title
                    tvBoardWriter.text = boardDetail.nickname
                    tvBoardDate.text = boardDetail.date_created
                    tvBoardContent.text = boardDetail.content
                    // 이미지 로드
                    // 예를 들어 Glide 라이브러리를 사용한다면:
                    // Glide.with(this).load(boardDetail.image_url).into(ivBoardImage)
                }

            } catch (e: Exception) {
                Log.e("Fetch c", "Error fetching board detail: ${e.message}", e)
            }
        }
    }

    private fun fetchComments() {
        thread {
            try {
                val urlString = "http://172.30.1.11:8888/board/detail/1/comments"
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection

                conn.requestMethod = "GET"

                val `in` = BufferedReader(InputStreamReader(conn.inputStream))
                val response = StringBuilder()

                var inputLine: String?
                while (`in`.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                `in`.close()

                Log.d("Response", response.toString())

                // 응답을 Kotlin 데이터 클래스로 변환
                val gson = Gson()
                val comments =
                    gson.fromJson(response.toString(), Array<CommentVO>::class.java).toList()

                // UI 갱신
                runOnUiThread {
                    // 리사이클러뷰 어댑터 설정
                    commentAdapter = CommentAdapter(comments)
                    rvComments.adapter = commentAdapter
                    rvComments.layoutManager = LinearLayoutManager(this@BoardDetailActivity)
                }

            } catch (e: Exception) {
                Log.e("Fetch Comments", "Error fetching comment list: ${e.message}", e)
            }
        }
    }

    private fun updateBookmark(isBookmarked: Boolean) {
        thread {
            try {
                val urlString = "http://172.30.1.11:8888/board/detail/1/1/$isBookmarked/book"
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection

                conn.requestMethod = "GET"

                val responseCode = conn.responseCode
                Log.d("Response", "Response Code: $responseCode")

            } catch (e: Exception) {
                Log.e("Update Bookmark", "Error updating bookmark: ${e.message}", e)
            }
        }
    }

    private fun updateLike(isLiked: Boolean) {
        thread {
            try {
                val urlString = "http://172.30.1.11:8888/board/detail/1/1/$isLiked/like"
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection

                conn.requestMethod = "GET"

                val responseCode = conn.responseCode
                Log.d("Response", "Response Code: $responseCode")

            } catch (e: Exception) {
                Log.e("Update Like", "Error updating like: ${e.message}", e)
            }
        }
    }



}
