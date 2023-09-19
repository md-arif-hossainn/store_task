package com.arif.storedetails.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.storedetails.R
import com.arif.storedetails.adapter.StoreDataAdapter
import com.arif.storedetails.databinding.FragmentSdataBinding
import com.arif.storedetails.models.StoreInfo
import com.arif.storedetails.viewModel.StoreViewModel

class StoreDataFragment : Fragment() {
    private val storeViewModel: StoreViewModel by activityViewModels()
    private lateinit var binding:FragmentSdataBinding
    private var currentPage=1
    private lateinit var adapter: StoreDataAdapter
    private val myList= mutableListOf<StoreInfo.Data>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = StoreDataAdapter(::onReceiveItemFromAdapter)
        binding = FragmentSdataBinding.inflate(inflater,container,false)
        binding.storeRV.layoutManager = LinearLayoutManager(requireActivity())
        binding.storeRV.adapter = adapter
        observers()
        callApi()
        return binding.root
    }

    private fun onReceiveItemFromAdapter(item: StoreInfo.Data) {
        val bundle = Bundle().apply {
            putString("info1",item.id.toString())
            putString("info2",item.name.toString())
            putString("info3",item.address)
        }
        findNavController().navigate(R.id.action_sdataFragment_to_detailsFragment,bundle)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextBtn.setOnClickListener {
            if (currentPage < 55) {
                currentPage++
                callApi()
            }
        }

        binding.previousBtn.setOnClickListener {
            if (currentPage > 1) { // Assuming 55 is the last page
                currentPage--
                callApi()
            }

        }
    }


    private fun callApi() {
        Log.d("current_page", "callApi: current-page: $currentPage")
        storeViewModel.fetchData(currentPage)
    }

    private fun observers() {
        storeViewModel.storeLiveData.observe(viewLifecycleOwner) {
            if (it.data.isNotEmpty()) {
                Log.d("current_page_data", "observers: id: ${it.data.first().id}")
//                myList.clear()
//                myList.addAll(it.data)
//                adapter.submitList(myList)
                adapter.submitList(it.data)
            }
        }
    }


}