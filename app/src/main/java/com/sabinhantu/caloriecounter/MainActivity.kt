package com.sabinhantu.caloriecounter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.firebase.auth.FirebaseAuth
import com.sabinhantu.caloriecounter.auth.AuthActivity
import com.sabinhantu.caloriecounter.databinding.ActivityMainBinding
import com.sabinhantu.caloriecounter.overview.OverviewFragment
import kotlinx.android.synthetic.main.app_bar.*


class MainActivity : AppCompatActivity(), OverviewFragment.OnOverviewCurrent {

    override fun onOverviewCurrent(isCurrent: Boolean) {
        isOverviewCurrent = isCurrent
        //update menu
        invalidateOptionsMenu()
        if (isCurrent) {
            // set current day string
            supportActionBar?.subtitle = "cf sefule"
        } else {
            supportActionBar?.subtitle = ""
        }
    }

    private var mAuth: FirebaseAuth? = null
    private lateinit var navController: NavController
    private var isOverviewCurrent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        setSupportActionBar(app_toolbar)

        navController = this.findNavController(R.id.nav_main_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)





    }

    override fun onStart() {
        super.onStart()

        var user = mAuth!!.currentUser
        if (user == null) {
            intentToAuthActivity()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_main_fragment)
        return navController.navigateUp()
    }

    fun intentToAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    /** MENU */
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (isOverviewCurrent) {
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_calendar) {
            Toast.makeText(this, "sabi boss", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
