package com.example.itscoronatime.infoActivity.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.itscoronatime.R
import com.example.itscoronatime.databinding.ActivityInfoBinding
import com.example.itscoronatime.infoActivity.presentation.viewModel.InfoViewModel

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_info)
        val arguments: Bundle? = intent.extras
        val viewModel by lazy {
            ViewModelProvider(
                this,
                com.example.itscoronatime.infoActivity.presentation.viewModel.ViewModelFactory(
                    arguments?.getInt("id") ?: 0
                )
            ).get(InfoViewModel::class.java)
        }
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
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
