package org.binaryitplanet.moroccancuisine.Features.Adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_list_food_item.view.*
import org.binaryitplanet.moroccancuisine.Features.View.ViewFood
import org.binaryitplanet.moroccancuisine.R
import org.binaryitplanet.moroccancuisine.Utils.Config
import android.util.Pair as UtilPair

class FoodListAdapter(
    val context: Context,
    val foodNames: Array<String>,
    val foodRecipes: Array<String>,
    val foodImages: ArrayList<Int>
): RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    private val TAG = "FoodListAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(context)
                .inflate(
                    R.layout.view_list_food_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int = foodNames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView

        view.foodTitle.text = foodNames[position]
        view.foodImage.setImageResource(foodImages[position])

        Log.d(TAG, "Resources: $foodNames, $foodRecipes, $foodImages")

        view.setOnClickListener {
            Log.d(TAG, "FoodClicked: $position")

            var intent = Intent(context, ViewFood::class.java)

            // Passing selected item data
            intent.putExtra(Config.FOOD_TITLE, foodNames[position])
            intent.putExtra(Config.FOOD_RECIPE, foodRecipes[position])
            intent.putExtra(Config.FOOD_IMAGE, foodImages[position])

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Creating animation options
                val options =
                    ActivityOptions.makeSceneTransitionAnimation(
                        context as Activity,
//                        UtilPair.create(
//                            view.foodTitle,
//                            context.resources.getString(R.string.foodTitleTransition)
//                        ),
                        UtilPair.create(
                            view.foodImage,
                            context.resources.getString(R.string.foodImageTransition)
                        )
//                        ,
//                        UtilPair.create(
//                            view.foodTitle,
//                            context.resources.getString(R.string.foodTitleTransition)
//                        )
                    )

                context.window.exitTransition = null
                context.startActivity(intent, options.toBundle())
            } else {
                context.startActivity(intent)
            }
        }
    }


    // Holding the view
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {}
}