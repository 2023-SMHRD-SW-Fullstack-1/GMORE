package com.smhrd.gmore.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smhrd.gmore.R
import com.smhrd.gmore.board.GameCategoryActivity

class Fragment1 : Fragment() {

    lateinit var ivLOL: ImageView
    lateinit var ivOverwatch: ImageView
    lateinit var ivMaplestory: ImageView
    lateinit var ivFifa4: ImageView
    lateinit var ivLostark: ImageView
    lateinit var ivBattleground: ImageView
    lateinit var spf: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_1, container, false)

        val imageView = view.findViewById<ImageView>(R.id.your_image_view)
        Glide.with(this).load(R.drawable.cirby).into(imageView)

        ivLOL = view.findViewById(R.id.ivLOL)
        ivOverwatch = view.findViewById(R.id.ivOverwatch)
        ivMaplestory = view.findViewById(R.id.ivMaplestory)
        ivFifa4 = view.findViewById(R.id.ivFIFA4)
        ivLostark = view.findViewById(R.id.ivLostArk)
        ivBattleground = view.findViewById(R.id.ivBattleGround)

        val imageViews =
            listOf(ivLOL, ivOverwatch, ivMaplestory, ivFifa4, ivLostark, ivBattleground)

        // 각 이미지를 클릭하면 클릭한 이미지의 태그 text를 넘기고 카테고리 페이지로 이동
        val commonClickListener = View.OnClickListener { view ->
            val imageTag = (view as ImageView).tag.toString()
            val intent = Intent(requireContext(), GameCategoryActivity::class.java)
//            intent.putExtra("categoryTag", imageTag) // 받을 때 이 키값 사용!
            spf = requireActivity().getSharedPreferences("userSPF", Context.MODE_PRIVATE)
            editor= spf.edit()
            editor.putString("category", imageTag.toString())
            editor.commit()
            startActivity(intent)
        }

        imageViews.forEach { it.setOnClickListener(commonClickListener) }

        return view


    }
}