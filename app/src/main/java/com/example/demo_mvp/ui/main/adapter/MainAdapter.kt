package com.example.demo_mvp.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.utils.OnItemRecyclerViewClickListener

class MainAdapter : RecyclerView.Adapter<UserViewHolder>(), UserViewHolder.OnClickListener {

    private val users: MutableList<User> = mutableListOf()
    private var onItemClickListener: OnItemRecyclerViewClickListener<User>? = null

    fun updateData(users: MutableList<User>?) {
        users?.let {
            this.users.clear()
            this.users.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<User>?) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun getItemCount() = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent, this)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindViewData(users[position])
    }

    override fun onClickItem(user: User, position: Int) {
        onItemClickListener?.onItemClickListener(user)
    }
}
