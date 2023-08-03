package com.smhrd.gmore.user

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.smhrd.gmore.board.BoardDetailVO

class MyPageBoardAdapter (var context: Context, var template: Int, var data:ArrayList<BoardDetailVO>):
    RecyclerView.Adapter<MyPageBoardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageBoardViewHolder {
        var template_View: View = LayoutInflater.from(context).inflate(template, parent, false)

        var VH: MyPageBoardViewHolder = MyPageBoardViewHolder(template_View)


        return VH
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyPageBoardViewHolder, position: Int) {


        val imageBytes = Base64.decode(data.get(position).image_url, 0)
        val image = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)



        holder.imgMyBoard.setImageBitmap(image)
        holder.tvMyTitle.text = data.get(position).title
        holder.tvMyDate.text = data.get(position).date_created!!.substring(0 until 10)


    }

}