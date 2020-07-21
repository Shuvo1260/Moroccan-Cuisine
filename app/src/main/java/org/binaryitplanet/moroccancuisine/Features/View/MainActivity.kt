package org.binaryitplanet.moroccancuisine.Features.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.binaryitplanet.moroccancuisine.Features.Adapter.FoodListAdapter
import org.binaryitplanet.moroccancuisine.R
import org.binaryitplanet.moroccancuisine.Utils.Config
import org.binaryitplanet.moroccancuisine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    private var foodImages = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupToolbar()

//        binding.add.setOnClickListener {
//            val intent = Intent(this, AddFood::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft)
//        }

        getValues()
        getImages()



    }

    private fun getImages() {
        foodImages.add(R.drawable.lamb_tagine)
        foodImages.add(R.drawable.loubia_marocaine)
        foodImages.add(R.drawable.tajine_poulet_citron)
        foodImages.add(R.drawable.tajine_aux_boulettes_de_viande_et_pommes_de_terre)
        foodImages.add(R.drawable.tajine_aux_pruneaux_et_abricots_secs)
        foodImages.add(R.drawable.tajine_de_carottes_petits_pois_et_pommes_de_terre)
        foodImages.add(R.drawable.tajine_de_legumes)
        foodImages.add(R.drawable.tajine_de_poisson_a_la_marocaine)
        foodImages.add(R.drawable.tajine_de_poulet_aux_amandes)
        foodImages.add(R.drawable.tajine_sardine)
        foodImages.add(R.drawable.tajine_vegetarien_aux_pruneaux)
        foodImages.add(R.drawable.zaalouk)
    }

    private fun getValues() {
        try {
            val foodRecipes = resources.getStringArray(R.array.recipes)
            val foodNames = resources.getStringArray(R.array.foodNames)
            setupRecyclerView(foodNames, foodRecipes)
        } catch (e: Exception) {
            Log.d(TAG, "ResourceException: ${e.message}")
        }
    }

    private fun setupRecyclerView(
        foodNames: Array<String>,
        foodRecipes: Array<String>
    ) {
        var adapter = FoodListAdapter(
            this,
            foodNames,
            foodRecipes,
            foodImages
        )
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.setItemViewCacheSize(1000)
    }

    private fun setupToolbar() {
        binding.toolbar.title = Config.HOME
    }
}