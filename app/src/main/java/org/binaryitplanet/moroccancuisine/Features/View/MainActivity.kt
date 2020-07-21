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
        foodImages.add(R.drawable.baked_falafels_vegan)
        foodImages.add(R.drawable.baked_tomatoes)
        foodImages.add(R.drawable.bissara)
        foodImages.add(R.drawable.carrot_peas_and_potato_tagine)
        foodImages.add(R.drawable.chermoula_fish_tagine)
        foodImages.add(R.drawable.chicken_tagine)
        foodImages.add(R.drawable.chicken_tagine_with_almonds)
        foodImages.add(R.drawable.chicken_tagine_with_apricots_prunes_and_toasted_almonds)
        foodImages.add(R.drawable.from_vegetables_tajine)
        foodImages.add(R.drawable.from_vegetables_tajine0)
        foodImages.add(R.drawable.from_vegetables_tajine1)
        foodImages.add(R.drawable.lamb_tagine)
        foodImages.add(R.drawable.loubia_marocaine)
        foodImages.add(R.drawable.luciana_style_octopus)
        foodImages.add(R.drawable.meatball_and_potato_tagine)
        foodImages.add(R.drawable.moroccan_fish_tagine)
        foodImages.add(R.drawable.moroccan_lentils)
        foodImages.add(R.drawable.mutton_tagine)
        foodImages.add(R.drawable.potato_and_minced_meat_tagine)
        foodImages.add(R.drawable.sardine_tagine)
        foodImages.add(R.drawable.tagine_with_prunes_and_dried_apricots)
        foodImages.add(R.drawable.tajine_aux_petits_pois_et_aux_oeufs)
        foodImages.add(R.drawable.tajine_poulet_citron)
        foodImages.add(R.drawable.tajine_aux_boulettes_de_viande_et_pommes_de_terre)
        foodImages.add(R.drawable.tajine_aux_pruneaux_et_abricots_secs)
        foodImages.add(R.drawable.tajine_de_carottes_petits_pois_et_pommes_de_terre)
        foodImages.add(R.drawable.tajine_de_legumes)
        foodImages.add(R.drawable.tajine_de_poisson_a_la_marocaine)
        foodImages.add(R.drawable.tajine_de_poulet_aux_amandes)
        foodImages.add(R.drawable.tajine_sardine)
        foodImages.add(R.drawable.tajine_vegetarien_aux_pruneaux)
        foodImages.add(R.drawable.turkey_tagine_with_fennel)
        foodImages.add(R.drawable.vegetable_tagine_with_wild_peach_and_pistachio)
        foodImages.add(R.drawable.vegetarian_tagine_with_prunes)
        foodImages.add(R.drawable.winter_vegetable_and_dried_fruit_tagine)
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