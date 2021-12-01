package com.example.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.*
import org.w3c.dom.Text

class GithubAdapter(val userlst:List<Item>):RecyclerView.Adapter<GithubAdapter.CustomViewHolder>(){
    class CustomViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return CustomViewHolder(itemview)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val text=holder.itemView.findViewById<TextView>(R.id.id)
        val txt2=holder.itemView.findViewById<TextView>(R.id.url)
        text.text=userlst[position].id.toString()
        txt2.text=userlst[position].url
        val img=holder.itemView.findViewById<ImageView>(R.id.avatar)
        Picasso.get().load(userlst[position].avatar_url).into(img)

    }

    override fun getItemCount(): Int {
        return userlst.size
//        TODO("Not yet implemented")
    }

}