package org.binaryitplanet.moroccancuisine.Features.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.binaryitplanet.moroccancuisine.R
import org.binaryitplanet.moroccancuisine.Utils.Config
import org.binaryitplanet.moroccancuisine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupToolbar()

        binding.add.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft)
        }

    }

    private fun setupRecyclerView() {
        //
    }

    private fun setupToolbar() {
        binding.toolbar.title = Config.HOME
    }
}