package com.imani.childregistration

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.imani.childregistration.Helpers.ApiHelper
import org.json.JSONArray



class Registered_children: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registered_children)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //find view
        val  progress: ProgressBar =findViewById(R.id.prgchildren)
        //specify api
        val  api="https://MuringoThe1.pythonanywhere.com/children"
        val helper=ApiHelper(applicationContext)
        helper.get(api,object :ApiHelper.ApiCallback{
            override fun onSuccess(response: String) {
                val itemJSONArray= JSONArray(response.toString())
                //a loop for looping through the Json array
                (0 until  itemJSONArray.length()).forEach(){
                    val children=itemJSONArray.getJSONObject(it)
                    val childrenData: TextView =findViewById(R.id.get_registered_children_Tv)
                    childrenData.append("ChildName: "+children.get("ChildName")+"\n")
                    childrenData.append("Age: "+children.get("Age")+"\n")
                    childrenData.append("Gender: "+children.get("Gender")+"\n")
                    childrenData.append("Allergies: "+children.get("Allergies")+"\n")
                    childrenData.append("GuardianName: "+children.get("GuardianName")+"\n")
                    childrenData.append("EmergencyContact: "+children.get("EmergencyContact")+"\n")
                    childrenData.append("\n\n")
                }
                progress.visibility= View.GONE
            }



            override fun onFailure(error: String) {

            }
        })
    }
}