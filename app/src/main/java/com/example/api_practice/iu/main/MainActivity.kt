package com.example.api_practice.iu.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_practice.R
import com.example.api_practice.data.model.User
import com.example.api_practice.data.source.repositories.UserRepository
import com.example.api_practice.iu.main.adapter.MainAdapter
import com.example.api_practice.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<User> {

    private val mAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        handleEvent()
    }

    override fun onGetUserSuccess(users: MutableList<User>) {
        mAdapter.updateData(users)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: User?) {
        Toast.makeText(this, item?.name, Toast.LENGTH_SHORT).show()
    }

    private fun handleEvent() {
        mAdapter.registerItemRecyclerViewClickListener(this@MainActivity)
    }

    private fun initData() {
        MainPresenter(UserRepository.instant).apply {
            setView(this@MainActivity)
            onStart()
        }
    }

    private fun initView() {
        with(recyclerViewUser) {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}
