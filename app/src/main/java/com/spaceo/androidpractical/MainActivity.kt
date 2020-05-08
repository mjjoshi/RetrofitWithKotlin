package com.spaceo.androidpractical

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.spaceo.androidpractical.model.ResponseData
import com.spaceo.androidpractical.model.Result
import com.spaceo.androidpractical.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.String

class MainActivity : AppCompatActivity() {

    private var responseList = listOf<Result>()
    private lateinit var mProgressDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showProgress()
        RetrofitClient.instance.getDatas().enqueue(object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                Log.d("checkingg", t.message)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                mProgressDialog.dismiss()
                responseList = response.body()!!.Result
                Log.d("checkingg", String.valueOf(response.body()))
                Log.d("checkingg", responseList.toString())



            }

        })

    }

    fun showProgress() {
        mProgressDialog = Dialog(this)
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mProgressDialog.setContentView(R.layout.progress_dialog)
        mProgressDialog.window!!.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        mProgressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        mProgressDialog.setCancelable(false)
        mProgressDialog.show()
    }

}
