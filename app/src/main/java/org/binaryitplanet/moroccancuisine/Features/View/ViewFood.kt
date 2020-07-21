package org.binaryitplanet.moroccancuisine.Features.View

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.*
import org.binaryitplanet.moroccancuisine.R
import org.binaryitplanet.moroccancuisine.Utils.Config
import org.binaryitplanet.moroccancuisine.databinding.ActivityAddFoodBinding
import org.binaryitplanet.moroccancuisine.databinding.ActivityViewFoodBinding

class ViewFood : AppCompatActivity() {

    private val TAG = "AddFood"
    private lateinit var binding: ActivityViewFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_food)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.enterTransition = null
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_food)

        setupAdMob()

        setUpToolbar()
    }

    override fun onResume() {
        super.onResume()
        val foodTitle = intent.getStringExtra(Config.FOOD_TITLE)
        val foodRecipe = intent.getStringExtra(Config.FOOD_RECIPE)
        val foodImage = intent.getIntExtra(Config.FOOD_IMAGE, 0)

        if (foodImage != 0) {
            binding.toolbar.title = foodTitle
            binding.foodTitle.text = foodTitle
            binding.foodRecipe.text = foodRecipe
            binding.foodImage.setImageResource(foodImage)
        }
    }

    private fun setupAdMob() {
        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        binding.adView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode : Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }


    // Toolbar menu setting
    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        Log.d(TAG, "Back pressed")
        onBackPressed()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft)
    }
}