package com.example.Management

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.*

open class Details_prsn : AppCompatActivity() {
    var b:Boolean = false

    @SuppressLint("ResourceType")
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_prsn)


       window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

       val Tv_NARM = findViewById<EditText>(R.id.Tv_NARM)
       val Tv_PARM = findViewById<EditText>(R.id.Tv_PARM)
       val Tv_DNARM = findViewById<EditText>(R.id.Tv_DNARM)
       val Tv_PDNARM = findViewById<EditText>(R.id.Tv_PDNARM)
       val Tv_NZWJ = findViewById<EditText>(R.id.Tv_NZWJ)
       val Tv_PZWJ = findViewById<EditText>(R.id.Tv_PZWJ)
       val Tv_DNZWJ = findViewById<EditText>(R.id.Tv_DNZWJ)
       val Tv_PDZWJ = findViewById<EditText>(R.id.Tv_PDNZWJ)
       val Tv_TWZWJ = findViewById<EditText>(R.id.Tv_TWZWJ)
       val Tv_CHM = findViewById<EditText>(R.id.Tv_CHM)
       val Tv_CHF = findViewById<EditText>(R.id.Tv_CHF)
       val Tv_ADDRES = findViewById<EditText>(R.id.Tv_ADDRES)
       val Tv_NUM = findViewById<EditText>(R.id.Tv_NUM)

       b = false
       Tv_NARM.isEnabled = b
       Tv_PARM.isEnabled = b
       Tv_DNARM.isEnabled = b
       Tv_PDNARM.isEnabled = b
       Tv_NZWJ.isEnabled = b
       Tv_PZWJ.isEnabled = b
       Tv_DNZWJ.isEnabled = b
       Tv_PDZWJ.isEnabled = b
       Tv_TWZWJ.isEnabled = b
       Tv_CHM.isEnabled = b
       Tv_CHF.isEnabled = b
       Tv_ADDRES.isEnabled = b
       Tv_NUM.isEnabled = b

       fun enable() {
          Tv_NARM.isEnabled = b
          Tv_PARM.isEnabled = b
          Tv_DNARM.isEnabled = b
          Tv_PDNARM.isEnabled = b
          Tv_NZWJ.isEnabled = b
          Tv_PZWJ.isEnabled = b
          Tv_DNZWJ.isEnabled = b
          Tv_PDZWJ.isEnabled = b
          Tv_TWZWJ.isEnabled = b
          Tv_CHM.isEnabled = b
          Tv_CHF.isEnabled = b
          Tv_ADDRES.isEnabled = b
          Tv_NUM.isEnabled = b
       }


        val bundle = intent.extras
       Tv_NARM.setText(bundle!!.getString(NARM))
       Tv_PARM.setText(bundle.getString(PARM))
       Tv_DNARM.setText(bundle.getString(DNARM))
       Tv_PDNARM.setText(bundle.getString(PDNARM))
       Tv_NZWJ.setText(bundle.getString(NZWJ))
       Tv_PZWJ.setText(bundle.getString(PZWJ))
       Tv_DNZWJ.setText(bundle.getString(DNZWJ))
       Tv_PDZWJ.setText(bundle.getString(PDNZWJ))
       Tv_TWZWJ.setText(bundle.getString(TWZWJ))
       Tv_CHM.setText(bundle.getString(CHM))
       Tv_CHF.setText(bundle.getString(CHF))
       Tv_ADDRES.setText(bundle.getString(ADDRES))
       Tv_NUM.setText(bundle.getString(NUM))

       val buedit = findViewById<ImageButton>(R.id.buedit)
       buedit.setOnClickListener{
          b = true
          enable()
       }

   }

    override fun onBackPressed() {
        super.getOnBackPressedDispatcher()

        val mydb = Mydatabase(this)

        if (b == true)
        {
            val bundle:Bundle = intent.extras!!
            val inflater = LayoutInflater.from(this)
             val view: View = inflater.inflate(R.layout.alert_edit, null)
             val Al_NARM = view.findViewById<TextView>(R.id.Al_NARM)
             val Al_PARM = view.findViewById<TextView>(R.id.Al_PARM)
             Al_NARM.text = bundle.getString(NARM)
             Al_PARM.text = bundle.getString(PARM)
             val builder = AlertDialog.Builder(this)
             val a = builder.create()
             a.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
             a.setView(view,0,0,0,100)
             a.show()
            val buNo = view.findViewById<Button>(R.id.bu_no)
            val buYes = view.findViewById<Button>(R.id.bu_yes)
            val id = bundle.getInt("ID")


           val Tv_NARM = findViewById<EditText>(R.id.Tv_NARM)
           val Tv_PARM = findViewById<EditText>(R.id.Tv_PARM)
           val Tv_DNARM =  findViewById<EditText>(R.id.Tv_DNARM)
           val Tv_PDNARM = findViewById<EditText>(R.id.Tv_PDNARM)
           val Tv_NZWJ = findViewById<EditText>(R.id.Tv_NZWJ)
           val Tv_PZWJ = findViewById<EditText>(R.id.Tv_PZWJ)
           val Tv_DNZWJ = findViewById<EditText>(R.id.Tv_DNZWJ)
           val Tv_PDZWJ = findViewById<EditText>(R.id.Tv_PDNZWJ)
           val Tv_TWZWJ = findViewById<EditText>(R.id.Tv_TWZWJ)
           val Tv_CHM = findViewById<EditText>(R.id.Tv_CHM)
           val Tv_CHF = findViewById<EditText>(R.id.Tv_CHF)
           val Tv_ADDRES = findViewById<EditText>(R.id.Tv_ADDRES)
           val Tv_NUM = findViewById<EditText>(R.id.Tv_NUM)

           val NARM = Tv_NARM.text.toString()
           val PARM = Tv_PARM.text.toString()
           val DNARM = Tv_DNARM.text.toString()
           val PDNARM = Tv_PDNARM.text.toString()
           val NZWJ = Tv_NZWJ.text.toString()
           val PZWJ = Tv_PZWJ.text.toString()
           val DNZWJ = Tv_DNZWJ.text.toString()
           val PDZWJ = Tv_PDZWJ.text.toString()
           val TWZWJ = Tv_TWZWJ.text.toString()
           val CHM = Tv_CHM.text.toString()
           val CHF = Tv_CHF.text.toString()
           val ADDRES = Tv_ADDRES.text.toString()
           val NUM = Tv_NUM.text.toString()


            buNo.setOnClickListener {
                finish()
            }
            buYes.setOnClickListener {
                mydb.Update_by_id(id,prsn(PARM,NARM,DNARM,PDNARM,PZWJ,NZWJ,DNZWJ,TWZWJ,PDZWJ,CHM,CHF,ADDRES,NUM))
                Toast.makeText(this,"تم التعديل بنجاح",Toast.LENGTH_SHORT).show()
                finish()
                val intent = Intent(this,List_view_prsn::class.java)
                overridePendingTransition(0, 0);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }

        }
        else
        {
            finish()
        }
    }
}