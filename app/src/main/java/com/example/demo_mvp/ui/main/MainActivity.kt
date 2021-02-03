package com.example.demo_mvp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_mvp.R
import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.data.source.repositories.UserRepository
import com.example.demo_mvp.ui.main.adapter.MainAdapter
import com.example.demo_mvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<User> {

    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        handleEvent()
    }

    private fun initView() {
        with(recyclerViewUser) {
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
        }
    }

    private fun initData() {
        MainPresenter(UserRepository.instance).apply {
            setView(this@MainActivity)
            onStart()
        }
    }

    private fun handleEvent() {
        adapter.registerItemRecyclerViewClickListener(this@MainActivity)
    }

    override fun onGetUserSuccess(users: MutableList<User>) {
        adapter.updateData(users)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: User?) {
        Toast.makeText(this, item?.name, Toast.LENGTH_SHORT).show()
    }
}
