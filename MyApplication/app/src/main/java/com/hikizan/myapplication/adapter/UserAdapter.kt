package com.hikizan.myapplication.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hikizan.myapplication.R
import com.hikizan.myapplication.databinding.ItemRowUserBinding
import com.hikizan.myapplication.network.model.DataItem

class UserAdapter(private val listUsers: List<DataItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_firstlastname)
        var tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = listUsers[position]
        val username = "${user.firstName} ${user.lastName}"
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvName.text = username
        holder.tvEmail.text = user.email
    }

    override fun getItemCount(): Int = listUsers.size
}