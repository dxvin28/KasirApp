package com.smktelkommlg.kasirapp

import android.content.Context

@Database(entities = [Food::class, Beverage::class, User::class, Meja::class],
    version = 2,
    exportSchema = false
)
abstract class KasirDb : RoomDatabase() {
    abstract fun getDaoKsr(): DaoKsr

    companion object{
        @Volatile
        private var INSTANCE: KasirDb? = null

        fun getDatabase(context: Context): KasirDb {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    KasirDb::class.java,
                    "kasir"
                ).fallbackToDestructiveMigration()
                    .build().also {
                        INSTANCE = it
                    }
            }
        }
    }
}