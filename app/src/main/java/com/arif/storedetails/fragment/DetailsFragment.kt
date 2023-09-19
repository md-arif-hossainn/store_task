package com.arif.storedetails.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arif.storedetails.databinding.FragmentDetailsBinding
import com.arif.storedetails.databinding.FragmentSdataBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        val bundle = arguments
        val item1 = bundle?.getString("info1")
        val item2 = bundle?.getString("info2")
        val item3 = bundle?.getString("info3")


/*        binding.nameTV.text = item2
        binding.addTV.text = item3*/

        val name = "<b>Name:</b> "
        val address = "<b>Address:</b> "

        binding.nameTV.text = Html.fromHtml(name + item2, Html.FROM_HTML_MODE_COMPACT)
        binding.addTV.text = Html.fromHtml(address + item3, Html.FROM_HTML_MODE_COMPACT)

        return binding.root
    }

}