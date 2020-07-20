package org.binaryitplanet.moroccancuisine.Utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = Config.FOOD_TABLE_NAME)
data class FoodUtils(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Config.COLUMN_ID)
    val id: Int?,

    @ColumnInfo(name = Config.COLUMN_FOOD_TITLE)
    var foodTitle: String,

    @ColumnInfo(name = Config.COLUMN_FOOD_IMAGE)
    var foodImage: String,

    @ColumnInfo(name = Config.COLUMN_FOOD_RECIPE)
    var foodRecipe: String
): Serializable {
}