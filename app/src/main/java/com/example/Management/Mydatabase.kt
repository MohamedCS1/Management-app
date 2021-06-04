package com.example.Management

import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import kotlin.system.exitProcess


var DB_NAME:String = "PRSN_DB"

var DB_Version:Int = 61

val TABLE_NAME:String = "MyDATA"
val column_ID:String = "id"
val PARM:String = "PARM"
val NARM:String = "NARM"
val DNARM:String = "DNARM"
val PDNARM:String = "PDNARM"
val PZWJ:String = "PZWJ"
val NZWJ:String = "NZWJ"
val DNZWJ:String = "DNZWJ"
val TWZWJ:String = "TWZWJ"
val PDNZWJ:String = "PDNZWJ"
val CHM:String = "CHM"
val CHF:String = "CHF"
val ADDRES:String = "ADDRES"
val NUM:String = "NUM"

open class Mydatabase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_Version) {


    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("CREATE TABLE $TABLE_NAME ($column_ID INTEGER PRIMARY KEY AUTOINCREMENT ,$PARM TEXT NOT NULL,$NARM TEXT NOT NULL ,$DNARM TEXT NOT NULL ,$PDNARM TEXT NOT NULL ,$PZWJ TEXT NOT NULL ,$NZWJ TEXT NOT NULL ,$DNZWJ TEXT NOT NULL ,$TWZWJ TEXT ,$PDNZWJ TEXT NOT NULL ,$CHM INTEGER NOT NULL ,$CHF INTEGER NOT NULL ,$ADDRES TEXT NOT NULL ,$NUM TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun Insert_prsn(prsn: prsn):Boolean
    {
        val db:SQLiteDatabase = writableDatabase
        val values = contentValuesOf()
        values.put(PARM, prsn.PARM)
        values.put(NARM,prsn.NARM)
        values.put(DNARM,prsn.DNARM)
        values.put(PDNARM,prsn.PDNARM)
        values.put(PZWJ,prsn.PZWJ)
        values.put(NZWJ,prsn.NZWJ)
        values.put(DNZWJ,prsn.DNZWJ)
        values.put(TWZWJ,prsn.TWZWJ)
        values.put(PDNZWJ,prsn.PDNZWJ)
        values.put(CHM,prsn.CHM)
        values.put(CHF,prsn.CHF)
        values.put(ADDRES,prsn.ADDRES)
        values.put(NUM,prsn.NUM)

        db.insert(TABLE_NAME,null,values)
        return  true
    }


    fun exist(NARM:String, PARM:String):Boolean {

        val string = arrayOf<String>(NARM,PARM)
        val db:SQLiteDatabase = readableDatabase
        val result = DatabaseUtils.queryNumEntries(db, TABLE_NAME , "NARM=? AND PARM=?" ,string)
        return result > 0

    }

    fun getAll_Data():ArrayList<prsn>
    {
         val array_Data = arrayListOf<prsn>()
         val db:SQLiteDatabase = readableDatabase
         val cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME/*ORDER BY column_ID DESC*/",null)
        if (cursor.moveToNext())
        {
            do {

                val id:Int = cursor.getInt(cursor.getColumnIndex(column_ID))
                val PARM = cursor.getString(cursor.getColumnIndex(PARM))
                val NARM = cursor.getString(cursor.getColumnIndex(NARM))
                val DNARM = cursor.getString(cursor.getColumnIndex(DNARM))
                val PDNARM = cursor.getString(cursor.getColumnIndex(PDNARM))
                val PZWJ = cursor.getString(cursor.getColumnIndex(PZWJ))
                val NZWJ = cursor.getString(cursor.getColumnIndex(NZWJ))
                val DNZWJ = cursor.getString(cursor.getColumnIndex(DNZWJ))
                val TWZWJ = cursor.getString(cursor.getColumnIndex(TWZWJ))
                val PDNZWJ = cursor.getString(cursor.getColumnIndex(PDNZWJ))
                val ADDRES = cursor.getString(cursor.getColumnIndex(ADDRES))
                val CHF = cursor.getString(cursor.getColumnIndex(CHF))
                val CHM =  cursor.getString(cursor.getColumnIndex(CHM))
                val NUM =  cursor.getString(cursor.getColumnIndex(NUM))

                val prsn_Data = prsn(id,PARM,NARM,DNARM,PDNARM,PZWJ,NZWJ,DNZWJ,TWZWJ,PDNZWJ,CHM,CHF,ADDRES,NUM)

                array_Data.add(prsn_Data)

            }while (cursor.moveToNext())
            cursor.close()
        }
      return array_Data
  }

  fun get_Last_item(): ArrayList<prsn> {
      val array_Data = arrayListOf<prsn>()
      val db:SQLiteDatabase = readableDatabase
      val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME /*ORDER BY column_ID DESC*/",null)

      if (cursor.moveToLast())
      {
          val id:Int = cursor.getInt(cursor.getColumnIndex(column_ID))
          Log.d("last","$id")
          val PARM = cursor.getString(cursor.getColumnIndex(PARM))
          Log.d("last", PARM)
          val NARM = cursor.getString(cursor.getColumnIndex(NARM))
          Log.d("last","$NARM")
          val DNARM = cursor.getString(cursor.getColumnIndex(DNARM))
          Log.d("last","$DNARM")
          val PDNARM = cursor.getString(cursor.getColumnIndex(PDNARM))
          Log.d("last","$PDNARM")
          val PZWJ = cursor.getString(cursor.getColumnIndex(PZWJ))
          Log.d("last","$PZWJ")
          val NZWJ = cursor.getString(cursor.getColumnIndex(NZWJ))
          Log.d("last","$NZWJ")
          val DNZWJ = cursor.getString(cursor.getColumnIndex(DNZWJ))
          Log.d("last","$DNZWJ")
          val TWZWJ = cursor.getString(cursor.getColumnIndex(TWZWJ))
          Log.d("last","$TWZWJ")
          val PDNZWJ = cursor.getString(cursor.getColumnIndex(PDNZWJ))
          Log.d("last","$PDNZWJ")
          val ADDRES = cursor.getString(cursor.getColumnIndex(ADDRES))
          Log.d("last","$ADDRES")
          val CHF = cursor.getString(cursor.getColumnIndex(CHF))
          Log.d("last","$CHF")
          val CHM =  cursor.getString(cursor.getColumnIndex(CHM))
          Log.d("last","$CHM")
          val NUM =  cursor.getString(cursor.getColumnIndex(NUM))
          Log.d("last","$NUM")
          val prsn_Data = prsn(id,PARM,NARM,DNARM,PDNARM,PZWJ,NZWJ,DNZWJ,TWZWJ,PDNZWJ,CHM,CHF,ADDRES,NUM)

          array_Data.add(prsn_Data)
      }
          cursor.close()

      return array_Data
  }

  fun getAll_Data_by_ID(id:Int):ArrayList<prsn>
  {
      val array_Data = arrayListOf<prsn>()
      val db:SQLiteDatabase = readableDatabase
      val cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE ID = $id",null)

      if (cursor.moveToNext())
      {
          do {

              val id:Int = cursor.getInt(cursor.getColumnIndex(column_ID))
              val PARM = cursor.getString(cursor.getColumnIndex(PARM))
              val NARM = cursor.getString(cursor.getColumnIndex(NARM))
              val DNARM = cursor.getString(cursor.getColumnIndex(DNARM))
              val PDNARM = cursor.getString(cursor.getColumnIndex(PDNARM))
              val PZWJ = cursor.getString(cursor.getColumnIndex(PZWJ))
              val NZWJ = cursor.getString(cursor.getColumnIndex(NZWJ))
              val DNZWJ = cursor.getString(cursor.getColumnIndex(DNZWJ))
              val TWZWJ = cursor.getString(cursor.getColumnIndex(TWZWJ))
              val PDNZWJ = cursor.getString(cursor.getColumnIndex(PDNZWJ))
              val ADDRES = cursor.getString(cursor.getColumnIndex(ADDRES))
              val CHF = cursor.getString(cursor.getColumnIndex(CHF))
              val CHM =  cursor.getString(cursor.getColumnIndex(CHM))
              val NUM =  cursor.getString(cursor.getColumnIndex(NUM))

              val prsn_Data = prsn(id,PARM,NARM,DNARM,PDNARM,PZWJ,NZWJ,DNZWJ,TWZWJ,PDNZWJ,CHM,CHF,ADDRES,NUM)

              array_Data.add(prsn_Data)

          }while (cursor.moveToNext())
          cursor.close()
      }
      return array_Data

  }

  fun Delete(id:Int)
  {
      val db:SQLiteDatabase = readableDatabase
      db.execSQL("DELETE FROM $TABLE_NAME WHERE ID = $id")
  }

  fun Update_by_id(id:Int,prsn: prsn)
  {
      val db:SQLiteDatabase = writableDatabase
      val values = contentValuesOf()
      values.put(PARM, prsn.PARM)
      values.put(NARM,prsn.NARM)
      values.put(DNARM,prsn.DNARM)
      values.put(PDNARM,prsn.PDNARM)
      values.put(PZWJ,prsn.PZWJ)
      values.put(NZWJ,prsn.NZWJ)
      values.put(DNZWJ,prsn.DNZWJ)
      values.put(TWZWJ,prsn.TWZWJ)
      values.put(PDNZWJ,prsn.PDNZWJ)
      values.put(CHM,prsn.CHM)
      values.put(CHF,prsn.CHF)
      values.put(ADDRES,prsn.ADDRES)
      values.put(NUM,prsn.NUM)
      db.update(TABLE_NAME,values,"ID = $id",null)
  }

}