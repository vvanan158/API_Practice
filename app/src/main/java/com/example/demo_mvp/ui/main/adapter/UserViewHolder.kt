package com.example.demo_mvp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo_mvp.R
import com.example.demo_mvp.data.model.User
import kotlinx.android.synthetic.main.item_layout_user.view.*

class UserViewHolder(
    viewGroup: ViewGroup,
    private var onClickListener: OnClickListener
) : RecyclerView.ViewHolder(newInstance(viewGroup)) {

    fun bindViewData(user: User) {
        with(itemView) {
            textViewName.text = user.name
            setOnClickListener {
                onClickListener.onClickItem(user, adapterPosition)
            }
        }
        getImageCircle(user)
    }

    private fun getImageCircle(user: User) {
        Glide.with(itemView.context)
            .load(user.avatar)
            .into(itemView.imageUser)
    }

    interface OnClickListener {
        fun onClickItem(user: User, position: Int)
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_layout_user, viewGroup, false)
        }
    }
}
