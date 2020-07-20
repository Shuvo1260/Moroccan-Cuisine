package org.binaryitplanet.moroccancuisine.Features.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.databinding.DataBindingUtil
import org.binaryitplanet.moroccancuisine.R
import org.binaryitplanet.moroccancuisine.Utils.Config
import org.binaryitplanet.moroccancuisine.databinding.ActivityAddFoodBinding
import org.binaryitplanet.moroccancuisine.databinding.ActivityMainBinding

class AddFood : AppCompatActivity() {

    private val TAG = "AddFood"
    private lateinit var binding: ActivityAddFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_food)

        setUpToolbar()


        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.done) {
//                if (isEditEnabled)
//                    update()
//                else
//                    saveData()
            }
            return@setOnMenuItemClickListener super.onOptionsItemSelected(it)
        }
    }


    // Toolbar menu setting
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.done_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun setUpToolbar() {

        binding.toolbar.title = Config.ADD_FOOD
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