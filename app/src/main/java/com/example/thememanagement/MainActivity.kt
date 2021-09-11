package com.example.thememanagement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        setContentView(R.layout.activity_main)
    }

    fun btnPikachu(view: View) {
        writeTheme("theme1")
        refresh()
    }
    fun btnBulbasaur(view: View) {
        writeTheme("theme2")
        refresh()
    }
    fun btnJigglypuff(view: View) {
        writeTheme("theme3")
        refresh()
    }
    fun btnCharmander(view: View) {
        writeTheme("theme4")
        refresh()
    }
    fun writeTheme(theme: String){
        val preference=getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        val editor=preference.edit()
        editor.putString("current_theme", theme)
        editor.commit()
    }

    fun setTheme(){
        val preference=getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        val name= preference.getString("current_theme", "").toString()

        if(name.equals("theme1")){
            setTheme(R.style.pikachu)
            writeTheme("theme1")
        }
        else if(name.equals("theme2")){
            setTheme(R.style.bulbasaur)
            writeTheme("theme2")
        }
        else if(name.equals("theme3")){
            setTheme(R.style.jigglypuff)
            writeTheme("theme3")
        }
        else if(name.equals("theme4")){
            setTheme(R.style.charmander)
            writeTheme("theme4")
        }
        else{
            setTheme(R.style.pikachu)
            writeTheme("theme2")
        }
    }

    fun refresh(){
        val intent = intent
        finish()
        startActivity(intent)
    }


}
