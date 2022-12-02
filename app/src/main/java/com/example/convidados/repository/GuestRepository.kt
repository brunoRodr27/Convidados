package com.example.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.model.GuestModel

class GuestRepository private constructor(context: Context){

    private val guestDataBase = GuestDataBase(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel) {
        val db = guestDataBase.writableDatabase
        val presence = if (guest.presence) 1 else 0
        val values = ContentValues()
        values.put("NAME", guest.name)
        values.put("PRESENCE", presence)

        db.insert("GUEST", null, values)
    }

    fun update() {

    }
}