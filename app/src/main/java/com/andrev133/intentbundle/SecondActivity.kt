package com.andrev133.intentbundle

import android.os.Bundle
import android.widget.TextView

class SecondActivity : LoggedAppCompatActivity() {
    private var mNumber: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mNumber = savedInstanceState
            ?.getLong(FirstActivity.KEY_NUMBER)
            ?: intent
                .getIntExtra(FirstActivity.KEY_NUMBER, 0)
                .toLong()

        findViewById<TextView>(R.id.activity_second_button)
            .text = "${getPow2()}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong(FirstActivity.KEY_NUMBER, mNumber)
        super.onSaveInstanceState(outState)
    }

    private fun getPow2(): Long {
        return mNumber * mNumber
    }
}