package com.example.api_practice.utils

interface OnItemRecyclerViewClickListener<T> {
    fun onItemClickListener(item: T?)

    interface OnClickItemListener<T> {
        fun onClickItem(item: T?, position: Int)
    }
}
