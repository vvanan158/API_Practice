package com.example.api_practice.iu.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_practice.data.model.User
import com.example.api_practice.utils.OnItemRecyclerViewClickListener

class MainAdapter : RecyclerView.Adapter<UserViewHolder>(),
    OnItemRecyclerViewClickListener.OnClickItemListener<User> {

    private val users: MutableList<User> = arrayListOf()
    private var onItemClickListener: OnItemRecyclerViewClickListener<User>? = null

    fun updateData(users: MutableList<User>?) {
        users?.let {
            this.users.clear()
            this.users.addAll(users)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<User>?) {
        this.onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent, this)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindViewData(users[position])
    }

    override fun onClickItem(item: User?, position: Int) {
        onItemClickListener?.onItemClickListener(item)
    }
}
