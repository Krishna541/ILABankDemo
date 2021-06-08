package com.ilabank.ui.dashboard

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.viewpager.widget.ViewPager
import com.ilabank.activity.MainActivity
import com.ilabank.R
import com.ilabank.base.BaseFragment
import com.ilabank.databinding.FragmentDashboardBinding
import com.ilabank.utils.TextAfterChange
import com.ilabank.utils.gone
import com.ilabank.utils.hideKeyboard
import com.ilabank.utils.visible


class DashboardFragment : BaseFragment() {

    private lateinit var mViewBinding: FragmentDashboardBinding
    private lateinit var dashboardRecyclerAdapter: DashboardRecyclerAdapter
    private lateinit var dashboardViewPagerAdapter: DashboardViewPagerAdapter
    private val mViewModel: DashboardViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.show()
    }

    override fun onError(error: String) {

    }

    override fun onBack() {
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_dashboard
    }

    override fun onIntializedView(binding: ViewDataBinding, view: View) {
        mViewBinding = binding as FragmentDashboardBinding
        setUpListeners()
        setUpObservers()
        setUpViewPager()
        setUpRecyclerView()
    }


    private fun setUpViewPager() {
        dashboardViewPagerAdapter = DashboardViewPagerAdapter()
        mViewBinding.vpSlider.adapter = dashboardViewPagerAdapter
        mViewBinding.tlBottomDots.setupWithViewPager(mViewBinding.vpSlider, true)
    }


    private fun setUpRecyclerView() {
        mViewModel.postDataToCarousel(mViewModel.getDataWithRespectToPosition(0))
        dashboardRecyclerAdapter = DashboardRecyclerAdapter {
            if (it) {
                mViewBinding.emptyView.visible()
            } else {
                mViewBinding.emptyView.gone()
            }
        }
        mViewBinding.rvCarousel.run {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = dashboardRecyclerAdapter
        }
    }


    private fun setUpListeners() {
        mViewBinding.vpSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                mViewModel.postDataToCarousel(
                    mViewModel.getDataWithRespectToPosition(
                        position
                    )
                )
            }
        })

        mViewBinding.etSearch.addTextChangedListener(TextAfterChange {
            dashboardRecyclerAdapter.filter.filter(it)
        })

        mViewBinding.etSearch.setOnClickListener {
            mViewBinding.rootMotionLayout.transitionToEnd()
            mViewBinding.rootMotionLayout.requestFocus()
        }

        mViewBinding.etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                mViewBinding.etSearch.hideKeyboard()
                return@OnEditorActionListener true
            }
            false
        })

        mViewBinding.etSearch.setOnFocusChangeListener { v, hasFocus ->
            run {
                if (hasFocus) {
                    mViewBinding.rootMotionLayout.transitionToEnd()
                }
            }
        }


    }


    private fun setUpObservers() {
        mViewModel.carouselData.observe(viewLifecycleOwner, {
            dashboardViewPagerAdapter.addItems(it)
        })

        mViewModel.selectedCarouselListItemData.observe(viewLifecycleOwner, {
            dashboardRecyclerAdapter.setOriginalList(it)
        })
    }

}