package com.emretnkl.breakingnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.emretnkl.breakingnewsapp.R
import com.emretnkl.breakingnewsapp.adapters.NewsAdapter
import com.emretnkl.breakingnewsapp.databinding.FragmentSavedNewsBinding
import com.emretnkl.breakingnewsapp.ui.NewsActivity
import com.emretnkl.breakingnewsapp.ui.NewsViewModel

class SavedNewsFragment : Fragment() {

    lateinit var binding : FragmentSavedNewsBinding
    lateinit var viewModel : NewsViewModel
    lateinit var newsAdapter : NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSavedNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }


        }
        private fun setupRecyclerView() {
            newsAdapter = NewsAdapter()
            binding.rvSavedNews.apply {
                adapter = newsAdapter
                layoutManager = LinearLayoutManager(activity)
            }
    }

}