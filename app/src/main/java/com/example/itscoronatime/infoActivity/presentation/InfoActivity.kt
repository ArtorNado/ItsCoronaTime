package com.example.itscoronatime.infoActivity.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.itscoronatime.R
import com.example.itscoronatime.app.injector.Injector
import com.example.itscoronatime.databinding.ActivityInfoBinding
import javax.inject.Inject

class InfoActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: InfoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_info)
        val arguments: Bundle? = intent.extras
        val id = arguments?.getInt("id")?: 0
        Injector.plusInfoComponent(id).injectInfoActivityComponent(this)
        initViewModel()
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        Injector.clearInfoActivityComponent()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(InfoViewModel::class.java)
        }
        this.viewModel = viewModel
    }

    companion object {

        fun start(context: Context, id: Int) {
            Log.e("ID", id.toString())
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }
    }
}
