package com.example.Management

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class Recycle_view_Adapter: RecyclerView.Adapter<Recycle_view_Adapter.prsn_ViewHolder> {




    var lastpositin: Int = -1

    var arrayprsn : ArrayList<prsn>?
    var context: Context? = null

    constructor(arrayprsn: ArrayList<prsn>?, context: Context?) : super() {

        this.context = context
        this.arrayprsn = arrayprsn

    }


    class prsn_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val c_NARM = itemView.findViewById<TextView>(R.id.c_NARM)
        val c_PARM = itemView.findViewById<TextView>(R.id.c_PARM)
        val c_NZWJ = itemView.findViewById<TextView>(R.id.c_NZWJ)
        val c_PZWJ = itemView.findViewById<TextView>(R.id.c_PZWJ)
        val c_CHMF = itemView.findViewById<TextView>(R.id.c_CHMF)
    }

    override fun onViewDetachedFromWindow(holder: prsn_ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): prsn_ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.carte_view, parent, false)
        return prsn_ViewHolder(view)
    }


    fun setAnimation(viewToAnimation: View,position: Int)
    {

        val animation: Animation = AnimationUtils.loadAnimation(
            context,
            if (position > lastpositin) R.anim.up_from_bottom else R.anim.down_from_top
        )
        viewToAnimation.startAnimation(animation)
        lastpositin = position

    }

    override fun onBindViewHolder(holder: prsn_ViewHolder, position: Int) {

        val mydb = Mydatabase(context!!)
        val prsn = arrayprsn!![position]

//         if (holder.adapterPosition > lastpositin) {
            holder.c_NARM.text = prsn.NARM
            holder.c_PARM.text = prsn.PARM
            holder.c_NZWJ.text = prsn.NZWJ
            holder.c_PZWJ.text = prsn.PZWJ
            holder.c_CHMF.text = (prsn.CHF!!.toInt() + prsn.CHM!!.toInt()).toString()

            setAnimation(holder.itemView,position)
//        }


        holder.itemView.setOnClickListener {
                    val id = arrayprsn!![position].ID

                    val arraydata = mydb.getAll_Data_by_ID(id!!)

                    val intent = Intent(context, Details_prsn::class.java)
                    intent.putExtra("ID", arraydata[0].ID)
                    intent.putExtra("PARM", arraydata[0].PARM)
                    intent.putExtra("NARM", arraydata[0].NARM)
                    intent.putExtra("DNARM", arraydata[0].DNARM)
                    intent.putExtra("PDNARM", arraydata[0].PDNARM)
                    intent.putExtra("PZWJ", arraydata[0].PZWJ)
                    intent.putExtra("NZWJ", arraydata[0].NZWJ)
                    intent.putExtra("DNZWJ", arraydata[0].DNZWJ)
                    intent.putExtra("TWZWJ", arraydata[0].TWZWJ)
                    intent.putExtra("PDNZWJ", arraydata[0].PDNZWJ)
                    intent.putExtra("ADDRES", arraydata[0].ADDRES)
                    intent.putExtra("CHF", arraydata[0].CHF)
                    intent.putExtra("CHM", arraydata[0].CHM)
                    intent.putExtra("NUM", arraydata[0].NUM)
                    context!!.startActivities(arrayOf(intent))

            }

        holder.itemView.setOnLongClickListener (object:View.OnLongClickListener {

            fun remove(position: Int) {
                val id = arrayprsn!![position].ID!!.toInt()
                arrayprsn!!.removeAt(position)

                notifyItemRemoved(position)
           
                notifyItemRangeChanged(0,arrayprsn!!.size)

                mydb.Delete(id)

            }

            override fun onLongClick(v: View?): Boolean {
                val inflater = LayoutInflater.from(context)
                val view: View = inflater.inflate(R.layout.alert_delete, null)
                val Al_NARM = view.findViewById<TextView>(R.id.Al_NARM)
                val Al_PARM = view.findViewById<TextView>(R.id.Al_PARM)
                mydb.getAll_Data()
                Log.d("posi", "$position")
                Al_NARM.text = arrayprsn!![position].NARM.toString()
                Al_PARM.text = arrayprsn!![position].PARM.toString()

                val builder = AlertDialog.Builder(context!!)
                val a = builder.create()
                a.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                a.setView(view, 0, 0, 0, 100)
                a.show()
                val bu_Yes = view.findViewById<Button>(R.id.bu_yes)
                val bu_No = view.findViewById<Button>(R.id.bu_no)
                bu_Yes.setOnClickListener {
                    remove(position)
                    a.hide()
                }
                bu_No.setOnClickListener {
                    a.hide()
                }
                return true
            }

        })


    }

        override fun getItemCount(): Int {
            return arrayprsn!!.size
        }



     fun filterlist(filterlite:ArrayList<prsn>)
     {
         arrayprsn = filterlite
         notifyDataSetChanged()
     }



}

