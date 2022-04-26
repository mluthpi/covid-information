package com.example.covidinformation.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.covidinformation.api.RetrofitClient
import com.example.covidinformation.databinding.ActivityMainBinding
import com.example.covidinformation.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        showIndonesia()


        binding.btnProvince.setOnClickListener{
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }


    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<IndonesiaResponse> {
            override fun onResponse(
                call: Call<IndonesiaResponse>,
                response: Response<IndonesiaResponse>
            ) {
                val indonesia = response.body()
                val positive = NumberFormat.getNumberInstance(Locale.US).format(indonesia?.positif).replace(",",".")
                val hospitalized = NumberFormat.getNumberInstance(Locale.US).format(indonesia?.dirawat).replace(",",".")
                val recover = NumberFormat.getNumberInstance(Locale.US).format(indonesia?.sembuh).replace(",",".")
                val death = NumberFormat.getNumberInstance(Locale.US).format(indonesia?.meninggal).replace(",",".")

                binding.tvPositive.text = positive
                binding.tvHospitalized.text = hospitalized
                binding.tvRecover.text = recover
                binding.tvDeath.text = death

            }

            override fun onFailure(call: Call<IndonesiaResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }



}