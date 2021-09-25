package com.yujin.librarypractice_210824

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


        override fun setupEvents() {

            callBtn.setOnClickListener {

                val pl = object : PermissionListener {

                    override fun onPermissionGranted() {

                        val myUri = Uri.parse("tel:02-5555-8888")
                        val myIntent = Intent( Intent.ACTION_CALL, myUri )
                        startActivity(myIntent)

                    }

                    override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                        Toast.makeText(mContext, "권한이 거부되어 전화연결이 불가합니다.", Toast.LENGTH_SHORT).show()

                    }


                }


            }

            profileImg.setOnClickListener {


                val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
                startActivity(myIntent)


            }

        }

        override fun setValues() {


            Glide.with(mContext).load("https://cdn.topstarnews.net/news/photo/201912/714847_426867_3336.jpeg").into(recentImg)




        }
}