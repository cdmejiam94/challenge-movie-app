package com.challenge.trademarkmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.challenge.trademarkmovieapp.R
import com.challenge.trademarkmovieapp.databinding.FragmentPlayingNowBinding

class PlayingNowFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment {
            return  PlayingNowFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPlayingNowBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_playing_now,
            container,
            false
        )

        binding.title.setText("Playing Now")

        return binding.root

    }
}