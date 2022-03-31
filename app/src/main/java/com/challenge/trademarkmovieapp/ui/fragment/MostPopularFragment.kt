package com.challenge.trademarkmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.challenge.trademarkmovieapp.R
import com.challenge.trademarkmovieapp.databinding.FragmentMostPopularBinding

class MostPopularFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment {
            return  MostPopularFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMostPopularBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_most_popular,
            container,
            false
        )

        binding.title.setText("Most Popular")

        return binding.root

    }
}