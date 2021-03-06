package com.example.roomdatabaseexample.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class ListFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mUserViewModel: UserViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        //Recycler view
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //user view model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)   //readAllData is sql query which is getting all data from our d/b
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->       //live data observing coz when ever data changed we need adapter to update data to new value
            adapter.setData(user)
        })


        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}