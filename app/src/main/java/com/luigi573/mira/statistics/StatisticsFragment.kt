package com.luigi573.mira.statistics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.luigi573.mira.databinding.StatisticsFragBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class StatisticsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private val viewModel by viewModels<StatisticsViewModel> { viewModelFactory }

    private lateinit var viewDataBinding : StatisticsFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = StatisticsFragBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRefreshLayout()
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewModel.start()
    }

    private fun setupRefreshLayout() {
        viewDataBinding.refreshLayout.setOnRefreshListener {
            viewModel.start()
        }
    }
}