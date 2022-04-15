package com.example.pr5

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class BFragment : Fragment() {

    interface TouchListener {
        public fun asd(a : String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            com.example.pr5.R.layout.b_fragment,
            container, false
        )
        val callBack : TouchListener = context as TouchListener
        view.setOnClickListener {
            callBack.asd("Bfragment")
            System.out.println("click")
        }
        return view
    }

    fun text(context : Context){
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(context, "b", duration)
        toast.show()
    }

}