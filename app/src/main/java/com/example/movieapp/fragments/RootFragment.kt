//package com.example.movieapp.fragments
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.movieapp.MainActivity
//import com.example.movieapp.R
//import com.example.movieapp.databinding.FragmentRootBinding
//import com.example.movieapp.presentation.adapters.ViewPagerAdapter
//import com.google.android.material.tabs.TabLayoutMediator
//
//class RootFragment : Fragment() {
//    private val binding: FragmentRootBinding by lazy(LazyThreadSafetyMode.NONE) {
//        FragmentRootBinding.inflate(layoutInflater)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val fragmentList = arrayListOf(
//            MainActivity(),ActorsFragment()
//        )
//        val adapter = ViewPagerAdapter(
//            fragmentList,
//            requireActivity().supportFragmentManager,
//            lifecycle = lifecycle
//        )
//        binding.viewPager.adapter = adapter
//        binding.viewPager.isSaveEnabled
//        TabLayoutMediator(binding.tableLayout, binding.viewPager){ tab, position->
//            when (position){
//                0-> tab.setIcon(R.drawable.ic_baseline_local_movies_24)
//                1-> tab.setIcon(R.drawable.ic_profile)
//            }
//        }.attach()
//        return binding.root
//    }
//}