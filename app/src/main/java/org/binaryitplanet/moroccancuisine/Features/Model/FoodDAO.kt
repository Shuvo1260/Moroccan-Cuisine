package org.binaryitplanet.moroccancuisine.Features.Model

import androidx.room.*
import org.binaryitplanet.moroccancuisine.Utils.FoodUtils

@Dao
interface FoodDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(foodUtils: FoodUtils)

    @Delete
    fun delete(foodUtils: FoodUtils)

    @Update
    fun update(foodUtils: FoodUtils)
}