package com.example.Management

import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.text.BoringLayout
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import java.io.*
import java.nio.charset.Charset
import java.util.*

class List_view_prsn : AppCompatActivity() {

    var adapter:Recycle_view_Adapter? = null
    val b:Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_prsn)

        val mydb = Mydatabase(this)
        val prsn_Data = arrayListOf<prsn>()

        fun load_Data():ArrayList<prsn>
        {

            if (prsn_Data.size > 0)
            {
                val d = mydb.get_Last_item()
                prsn_Data.addAll(d)
            }
            else
            {
                val d = mydb.getAll_Data()
                prsn_Data.addAll(d)
            }

            return prsn_Data
        }

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        adapter = Recycle_view_Adapter(load_Data(),this)

        recycler_view.adapter = adapter

        val lm = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            true
        )

        recycler_view.layoutManager = lm

        recycler_view.smoothScrollToPosition(prsn_Data.size+1)

        val buadd_prsn_list_view = findViewById<FloatingActionButton>(R.id.buadd_list_view)

        val builder = AlertDialog.Builder(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)

        val inflater:LayoutInflater = LayoutInflater.from(this)

        val view = inflater.inflate(R.layout.alert_add ,null)

        builder.setView(view)
        val d = builder.create()

        if (prsn_Data.size == 0)
        {
            val `is`: InputStream =  resources.openRawResource(R.raw.welldata)
            val reader = BufferedReader(
                InputStreamReader(`is`, Charset.forName("UTF-8"))
            )
            var line = ""

            reader.readLine().also { line = it } != null
            for (i in 0..62) {

                reader.readLine().also { line = it } != null
                // Split the line into different tokens (using the comma as a separator).
                val tokens = line.split(",").toTypedArray()

                // Read the data and store it in the WellData POJO.
                val wellData = arrayListOf<String>()

                val prsn = prsn(tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10],tokens[11],tokens[12],tokens[13])

                mydb.Insert_prsn(prsn)
                load_Data()
                filter("",prsn_Data)
                Log.d("posi","array size : ${prsn_Data.size}")
                adapter!!.notifyItemInserted(prsn_Data.size)
                recycler_view.smoothScrollToPosition(prsn_Data.size)
                wellData.clear()
            }
        }





        buadd_prsn_list_view.setOnClickListener {

            d.show()
            val edit_PARM = view.findViewById<EditText>(R.id.Edit_add_PARM).text
            val edit_NARM = view.findViewById<EditText>(R.id.Edit_add_NARM).text
            val edit_DNARM = view.findViewById<EditText>(R.id.Edit_add_DNARM).text
            val edit_PDARM = view.findViewById<EditText>(R.id.Edit_add_PDNARM).text
            val edit_PZWJ = view.findViewById<EditText>(R.id.Edit_add_PZWJ).text
            val edit_NZWJ = view.findViewById<EditText>(R.id.Edit_add_NZWJ).text
            val edit_DNZWJ = view.findViewById<EditText>(R.id.Edit_add_DNZWJ).text
            val edit_TWZWJ = view.findViewById<EditText>(R.id.Edit_add_TWZWJ).text
            val edit_PDZWJ = view.findViewById<EditText>(R.id.Edit_add_PDNZWJ).text
            val edit_CHF   = view.findViewById<EditText>(R.id.Edit_add_CHF).text
            val edit_CHM   = view.findViewById<EditText>(R.id.Edit_add_CHM).text
            val edit_ADDRES = view.findViewById<EditText>(R.id.Edit_add_ADDRES).text
            val edit_NUM = view.findViewById<EditText>(R.id.Edit_add_NUM).text


            val editText = findViewById<EditText>(R.id.edit_search)


            view.findViewById<Button>(R.id.buadd_prsn_alert).setOnClickListener {
                editText.isEnabled = true
               if ( edit_PARM.isEmpty() || edit_NARM.isEmpty() || edit_DNARM.isEmpty() || edit_PDARM.isEmpty() || edit_PZWJ.isEmpty() || edit_NZWJ.isEmpty() || edit_DNZWJ.isEmpty() || edit_TWZWJ.isEmpty() || edit_PDZWJ.isEmpty() || edit_CHM.isEmpty() || edit_CHF.isEmpty() || edit_ADDRES.isEmpty() || edit_NUM.isEmpty() )
               {
                   Toast.makeText(this,"يجب إدخال جميع المعلومات",Toast.LENGTH_LONG).show()
               }
               else if (mydb.exist(edit_NARM.toString(),edit_PARM.toString()) && (edit_NARM.toString() != "لايوجد" && edit_PARM.toString() != "لايوجد"))
               {
                   Toast.makeText(this,"هذه الأرملة موجودة من قبل",Toast.LENGTH_LONG).show()

               }
               else
               {
                   editText.isEnabled = false
                   editText.setText("")

                   mydb.Insert_prsn(prsn("$edit_PARM" , "$edit_NARM" ,"$edit_DNARM","$edit_PDARM" ,"$edit_PZWJ" ,"$edit_NZWJ" ,"$edit_DNZWJ" ,"$edit_TWZWJ","$edit_PDZWJ" ,"$edit_CHM" ,"$edit_CHF" ,"$edit_ADDRES" ,"$edit_NUM"))
                   load_Data()
                   filter("",prsn_Data)
                   Log.d("posi","array size : ${prsn_Data.size}")
                   adapter!!.notifyItemInserted(prsn_Data.size)
                   recycler_view.smoothScrollToPosition(prsn_Data.size)


                   Toast.makeText(this,"تم الإدخال بنجاح",Toast.LENGTH_LONG).show()

                   d.hide()
                   view.findViewById<EditText>(R.id.Edit_add_PARM).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_NARM).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_DNARM).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_PDNARM).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_PZWJ).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_NZWJ).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_DNZWJ).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_TWZWJ).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_PDNZWJ).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_CHF).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_CHM).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_ADDRES).setText("")
                   view.findViewById<EditText>(R.id.Edit_add_NUM).setText("")
                   editText.isEnabled = true
               }

            }

        }


        val editText = findViewById<EditText>(R.id.edit_search)

        editText.addTextChangedListener(object :TextWatcher
        {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                return
            }

            override fun afterTextChanged(s: Editable?) {
                if (s == null) return
                val g = mydb.getAll_Data()
                filter(s.toString(),g)
            }

        })

        val clear = findViewById<ImageButton>(R.id.clear)
        clear.setOnClickListener(object :View.OnClickListener
        {
            override fun onClick(v: View?) {

                editText.setText("")
            }

        })



    }


    fun filter(text: String, Array: ArrayList<prsn>)
    {
        val listfilter = arrayListOf<prsn>()

            for (p in Array)
            {
                if (p.NARM!!.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault())) || p.PARM!!.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault())))
                {
                    listfilter.add(p)
                }
            }
            adapter!!.filterlist(listfilter)

    }



}
