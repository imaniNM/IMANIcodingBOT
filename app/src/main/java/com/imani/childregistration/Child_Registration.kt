package com.imani.childregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.imani.childregistration.Helpers.ApiHelper
import org.json.JSONObject

class Child_Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_child_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ChildName: EditText =findViewById(R.id.childname)
        val Age: EditText =findViewById(R.id.childage)
        val Gender: EditText =findViewById(R.id.childgender)
        val Allergies: EditText =findViewById(R.id.childallergies)
        val GuardianName: EditText =findViewById(R.id.editTextGuardian_name)
        val EmergencyContact: EditText =findViewById(R.id.Parent_Guardian_Phone)

        val savechild: Button =findViewById(R.id.buttonRegisterChild)
        //button view
        savechild.setOnClickListener{
            val  api="https://MuringoThe1.pythonanywhere.com/children"
            val  body= JSONObject()
            body.put("ChildName",ChildName.text.toString())
            body.put("Age",Age.text.toString())
            body.put("Gender",Gender.text.toString())
            body.put("Allergies",Allergies.text.toString())
            body.put("GuardianName",GuardianName.text.toString())
            body.put("EmergencyContact",EmergencyContact.text.toString())

            //access api helper
            val helper= ApiHelper(applicationContext)
            //post body to api
            helper.post(api, body, object : ApiHelper.ApiCallback {
                override fun onSuccess(response: String) {

                    Toast.makeText(applicationContext,response.toString(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,Registered_children::class.java))

                }

                override fun onFailure(error: String) {
                    Toast.makeText(applicationContext,error.toString(),Toast.LENGTH_SHORT).show()

                }
            })

        }

    }
}