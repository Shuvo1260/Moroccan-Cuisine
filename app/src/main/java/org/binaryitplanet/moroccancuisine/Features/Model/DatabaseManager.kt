package org.binaryitplanet.moroccancuisine.Features.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.binaryitplanet.moroccancuisine.Utils.Config
import org.binaryitplanet.moroccancuisine.Utils.FoodUtils

@Database(
    entities = [FoodUtils::class],
    version = Config.DATABASE_VERSION
)

//@TypeConverters(DataConverters::class)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun getFoodDAO() : FoodDAO

    companion object{
        var INSTANCE: DatabaseManager? = null

        fun getInstance(context: Context): DatabaseManager? {

            if (INSTANCE == null) {
                synchronized(DatabaseManager::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseManager::class.java,
                        Config.DATABASE_NAME
                    ).allowMainThreadQueries().build()
                }
            }

            return INSTANCE
        }

        fun destroy(){
            INSTANCE = null
        }
    }
}