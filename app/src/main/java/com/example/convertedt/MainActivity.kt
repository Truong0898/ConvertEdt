package com.example.convertedt

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.convertedt.ui.theme.ConvertEdtTheme
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        edtNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                edtNumber.removeTextChangedListener(this)
                val number = convertNumber(edtNumber)
                edtNumber.setText(number)
                edtNumber.setSelection(edtNumber.text.length)

                edtNumber.addTextChangedListener(this)
            }

        })

    }
    fun convertNumber(edt: EditText): String? {
        val string = edt.text.toString()
        val numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH)
        val format = DecimalFormat("#,###")
        if (!TextUtils.isEmpty(string)) {
            val textNb = string.replace(",".toRegex(), "")
            val number = textNb.toDouble()
            return format.format(number)
        }
        return ""
    }
}


