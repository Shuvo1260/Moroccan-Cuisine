package org.binaryitplanet.moroccancuisine.Utils

import android.graphics.Bitmap
import java.nio.ByteBuffer


class Config {
    companion object {
        val FOOD_TITLE = "FoodTitle"
        val FOOD_RECIPE = "FoodRecipe"
        val FOOD_IMAGE = "FoodImage"


        // Toolbar
        val HOME = "Foods"
        val ADD_FOOD = "Add new food"


        // Database
        const val DATABASE_NAME = "FoodDatabase"
        const val DATABASE_VERSION = 1

        // Table
        const val FOOD_TABLE_NAME = "Food_Table"

        const val COLUMN_FOOD_TITLE = "Food_Title"
        const val COLUMN_FOOD_IMAGE = "Food_Image"
        const val COLUMN_FOOD_RECIPE = "Food_Recipe"
        const val COLUMN_ID = "ID"


        fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray? {
            val byteBuffer: ByteBuffer = ByteBuffer.allocate(bitmap.byteCount)
            bitmap.copyPixelsToBuffer(byteBuffer)
            byteBuffer.rewind()
            return byteBuffer.array()
        }
    }
}