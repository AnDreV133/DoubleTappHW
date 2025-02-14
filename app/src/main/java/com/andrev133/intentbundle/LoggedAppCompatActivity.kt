package com.andrev133.intentbundle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

open class LoggedAppCompatActivity : AppCompatActivity() {
    private val childClassName = this.javaClass.simpleName
    private val logFileName = "app_logs.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $childClassName")
        writeLog("onCreate $childClassName")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart $childClassName")
        writeLog("onStart $childClassName")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume $childClassName")
        writeLog("onResume $childClassName")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause $childClassName")
        writeLog("onPause $childClassName")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop $childClassName")
        writeLog("onStop $childClassName")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy $childClassName")
        writeLog("onDestroy $childClassName")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart $childClassName")
        writeLog("onRestart $childClassName")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState $childClassName $outState")
        writeLog("onSaveInstanceState $childClassName $outState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState $savedInstanceState")
        writeLog("onRestoreInstanceState $savedInstanceState")
    }

    private fun writeLog(msg: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            val timestamp = SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss",
                Locale.getDefault()
            ).format(Date())
            val logMessage = "$timestamp: $msg\n"

            val file = File(filesDir, logFileName)
            try {
                FileOutputStream(file, true).use { fos ->
                    fos.write(logMessage.toByteArray())
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error when write log-message to file", e)
            }
        }
    }

    companion object {
        private val TAG = LoggedAppCompatActivity::class.java.simpleName
    }
}