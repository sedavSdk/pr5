package com.example.pr5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), BFragment.TouchListener, AFragment.TouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        var fragment1: Fragment? = AFragment()
        var test: Boolean = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b: Button = findViewById(R.id.b)
        val dop: Button = findViewById(R.id.button2)
        b.setOnClickListener {
            if (test) {
                test = false
                val fragment: BFragment = BFragment()
                fragment1 = fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment).commit()
            } else {
                test = true
                val fragment: AFragment = AFragment()
                fragment1 = fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment).commit()
            }
        }
        dop.setOnClickListener {
            System.out.println(fragment1)
            if (test) {
                (fragment1 as AFragment).text(applicationContext)
            } else {
                (fragment1 as BFragment).text(applicationContext)
            }
        }
    }

    override fun asd(a: String) {
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, a, duration)
        toast.show()
    }
}