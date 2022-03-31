package com.challenge.trademarkmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.challenge.trademarkmovieapp.R
import com.challenge.trademarkmovieapp.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment {
            return  FavouritesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFavouritesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_favourites,
            container,
            false
        )

        binding.title.setText("Favourites")

        return binding.root

    }
}