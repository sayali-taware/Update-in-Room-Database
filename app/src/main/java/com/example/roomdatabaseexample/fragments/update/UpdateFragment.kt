package com.example.roomdatabaseexample.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdatabaseexample.R
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_update.view.*

private val args by navArgs<UpdateFragmentArgs>()
class UpdateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

//        view.updateFirstName_et.setText(args.currentUser.firstName)
//        view.updateLastName_et.setText(args.currentUser.lastName)
//        view.updateAge_et.setText(args.currentUser.age.toString())

        return view
    }
}