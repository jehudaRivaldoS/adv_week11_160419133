package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4.R
import com.example.advweek4.databinding.FragmentStudentDetailBinding
import com.example.advweek4.util.loadImage
import com.example.advweek4.viewModel.DetailListModel
import kotlinx.android.synthetic.main.fragment_student_detail.*

class StudentDetailFragment : Fragment(), ButtonUpdateClickListener {
    private lateinit var viewModel: DetailListModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel = ViewModelProvider(this).get(DetailListModel::class.java)
        viewModel.fetch(id)
        observeViewModel()


    }
    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer{
            dataBinding.student = it
            dataBinding.listener = this
        })
        /*viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtIdD.setText(it.id)
            txtNameCard.setText(it.name)
            txtBirthD.setText(it.bod)
            txtPhoneD.setText(it.phone)
            imageView2.loadImage(viewModel.studentLD.value?.photoUrl.toString(), progressBar3)
        })*/
    }
    override fun onButtonUpdateClick(v: View) {
        TODO("Not yet implemented")
    }
}