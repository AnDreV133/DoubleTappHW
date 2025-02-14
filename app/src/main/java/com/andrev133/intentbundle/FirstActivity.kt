package com.andrev133.intentbundle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FirstActivity : LoggedAppCompatActivity() {
    private var mNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<Button>(R.id.activity_first_button)
            .setOnClickListener {
                Intent(this, SecondActivity::class.java).run {
                    putExtra(KEY_NUMBER, mNumber)
                    startActivity(this)
                }
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_NUMBER, mNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mNumber = savedInstanceState.getInt(KEY_NUMBER)
        updateNum()

        findViewById<TextView>(R.id.activity_first_num)
            .text = "$mNumber"
    }

    private fun updateNum() {
        mNumber += 1
    }

    companion object {
        const val KEY_NUMBER = "num"
    }
}