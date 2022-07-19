package com.cookandroid.project

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.provider.MediaStore

import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager


class MyGallery : AppCompatActivity() {

    private val REQUEST_READ_EXTERNAL_STORAGE = 1000
    lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mygallery)

        viewPager = findViewById(R.id.viewPager)

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                // 이전에 거부한 적이 있으면 설명(경고)
                var dlg = AlertDialog.Builder(this)
                dlg.setTitle("권한이 필요한 이유")
                dlg.setMessage("사진 정보를 얻기 위해서는 외부 저장소 권한이 필수로 필요합니다")
                dlg.setPositiveButton("확인"){
                    dialog, which -> ActivityCompat.requestPermissions(this@MyGallery,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_READ_EXTERNAL_STORAGE)

                }
                dlg.setNegativeButton("취소", null)
                dlg.show()
            }else{
                // 처음 권한 요청
                ActivityCompat.requestPermissions(this@MyGallery,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_READ_EXTERNAL_STORAGE)
            }
        else{
            getAllPhotos()
        }


    }

    private fun getAllPhotos(){
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Images.ImageColumns.DATE_TAKEN+" DESC") // 촬영 날짜순

        val fragments = ArrayList<Fragment>()

        if(cursor != null){
            while(cursor.moveToNext()){
                val uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                Log.d("MainActivity", uri)
                fragments.add(PhotoFragment.newInstance(uri))
            }
            cursor.close()
        }

        val adapter = MyPagerAdapter(supportFragmentManager)
        adapter.updateFragment(fragments)
        viewPager.adapter = adapter
    }
}