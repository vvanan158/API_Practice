package com.example.api_practice.iu.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_practice.R
import com.example.api_practice.data.model.User
import com.example.api_practice.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_user.view.*

class UserViewHolder(
    viewGroup: ViewGroup,
    private var onClickListener: OnItemRecyclerViewClickListener.OnClickItemListener<User>
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

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_layout_user, viewGroup, false)
        }
    }
}
