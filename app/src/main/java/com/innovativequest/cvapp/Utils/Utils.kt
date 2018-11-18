package com.innovativequest.cvapp.Utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.innovativequest.cvapp.models.Experiences
import com.innovativequest.cvapp.models.Person
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.SimpleDateFormat

object Utils {

    val INPUT_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val OUTPUT_DATE_FORMAT = SimpleDateFormat("dd MMMM yyyy")

    fun getJsonFromAssetPath(path: String, context: Context): String? {
        try {
            val jsonStream = context.assets.open(path)
            val r = BufferedReader(InputStreamReader(jsonStream))
            val total = StringBuilder()
            var line: String?

            do{
                line = r.readLine()
                if(line!=null) total.append(line)
            }
            while(line != null)
            return total.toString()
        } catch (ex: IOException) {

            Log.e("HomeAdapter", ex.message)
            return null
        }

    }

    fun experiencesFromJson(json:String):Experiences {
        return Gson().fromJson<Experiences>(json, Experiences::class.java)
    }


    fun personFromJson(json:String): Person {
        return Gson().fromJson<Person>(json, Person::class.java)
    }

    fun getDateInDisplayableFormat(inputDateStr: String): String{
        return OUTPUT_DATE_FORMAT.format(INPUT_DATE_FORMAT.parse(inputDateStr))
    }
}
