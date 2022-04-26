package com.example.covidinformation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidinformation.R
import com.example.covidinformation.adapter.ProvinceAdapter
import com.example.covidinformation.api.RetrofitClient
import com.example.covidinformation.databinding.ActivityProvinceBinding
import com.example.covidinformation.model.Province
import com.example.covidinformation.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProvinceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showProvince()

    }

    private fun showProvince() {
        binding.rvProvince.setHasFixedSize(true)
        binding.rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvinsi().enqueue(object : Callback<List<Province>>{
            override fun onResponse(
                call: Call<List<Province>>,
                response: Response<List<Province>>
            ) {

                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                binding.rvProvince.adapter = adapter

            }

            override fun onFailure(call: Call<List<Province>>, t: Throwable) {

                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }

}