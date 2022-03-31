package com.challenge.trademarkmovieapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.challenge.trademarkmovieapp.R
import com.challenge.trademarkmovieapp.databinding.ActivityMainBinding
import com.challenge.trademarkmovieapp.ui.fragment.*
import com.challenge.trademarkmovieapp.viewmodel.MainActivityViewModel
import com.challenge.trademarkmovieapp.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        mainActivityViewModel = ViewModelProviders.of(
            this,
            MainActivityViewModelFactory()
        )[MainActivityViewModel::class.java]

        initActivity()

        mainActivityViewModel.showBottomNavigationMenu.observe(this, Observer{
            if (it!=null){
                if (it){
                    binding.bottomNavigationMenu.visibility = View.VISIBLE
                } else {
                    binding.bottomNavigationMenu.visibility = View.GONE
                }
            }
        })

        binding.bottomNavigationMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.playing_now -> replaceFragment(PlayingNowFragment.newInstance(), "PlayingNow")
                R.id.most_popular -> replaceFragment(MostPopularFragment.newInstance(), "MostPopular")
                R.id.favourites -> replaceFragment(FavouritesFragment.newInstance(), "Favourites")
                R.id.profile -> replaceFragment(ProfileFragment.newInstance(), "Profile")
                else -> Toast.makeText(application, "Error!", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    private fun initActivity() {
        mainActivityViewModel.loggedStatus.postValue(false)

        replaceFragment(LoginFragment.newInstance(), "Login")
    }

    fun replaceFragment(newInstance: Fragment, tag: String) {
        val manager : FragmentManager = supportFragmentManager
        val fragment_transaction : FragmentTransaction = manager.beginTransaction()
        fragment_transaction.replace(R.id.frame_layout, newInstance, tag)
        fragment_transaction.commit()
    }

    override fun onBackPressed() {

    }
}