package com.example.roomdatabaseexample.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.model.User
import com.example.roomdatabaseexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class AddFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mUserViewModel: UserViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }


    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val firstName = addFirstName_et.text.toString()
        val lastName = addLastName_et.text.toString()
        val age = addAge_et.text

        if (inputCheck(firstName, lastName, age)){                                //if the below func is not empty then the values will be passed
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            //add user to d/b
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added!", Toast.LENGTH_LONG).show()
            //Navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all the details.", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}

