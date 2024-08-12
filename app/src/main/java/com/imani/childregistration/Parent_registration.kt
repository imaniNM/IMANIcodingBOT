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

class Parent_registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_parent_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Parent_Guardian_Names: EditText =findViewById(R.id.editTextGuardian_name)
        val Parent_Guardian_Email: EditText =findViewById(R.id.Guardian_Email)
        val Parent_Guardian_Phone: EditText =findViewById(R.id.Parent_Guardian_Phone)
        val Parent_Guardian_Password: EditText =findViewById(R.id.Guardian_Password)


        val saveparent: Button =findViewById(R.id.buttonparent_guardianRegistration)
        //button view
        saveparent.setOnClickListener{
            val  api="https://MuringoThe1.pythonanywhere.com/parents"
            val  body= JSONObject()
            body.put("Parent_Guardian_Names",Parent_Guardian_Names.text.toString())
            body.put("Parent_Guardian_Email",Parent_Guardian_Email.text.toString())
            body.put("Parent_Guardian_Phone",Parent_Guardian_Phone.text.toString())
            body.put("Parent_Guardian_Password",Parent_Guardian_Password.text.toString())


            //access api helper
            val helper= ApiHelper(applicationContext)
            //post body to api
            helper.post(api, body, object : ApiHelper.ApiCallback {
                override fun onSuccess(response: String) {

                    Toast.makeText(applicationContext,response.toString(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,Child_Registration::class.java))

                }

                override fun onFailure(error: String) {
                    Toast.makeText(applicationContext,error.toString(),Toast.LENGTH_SHORT).show()

                }
            })

        }

    }
}