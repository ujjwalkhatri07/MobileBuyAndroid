package com.ujjwal.mobileShop.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ujjwal.mobileShop.MainActivity
import com.ujjwal.mobileShop.ProfileActivity
import com.ujjwal.mobileShop.R


class MoreFragment : Fragment() {
    private lateinit var tvSignout: TextView
    private lateinit var tvProfile: TextView
    private lateinit var editor : SharedPreferences.Editor;
    private lateinit var sharedPreferences: SharedPreferences;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        tvSignout = view.findViewById(R.id.tvsignout)
        tvProfile = view.findViewById(R.id.tvProfile)

        sharedPreferences = activity?.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)!!
        editor = sharedPreferences.edit();

        tvSignout.setOnClickListener{
            editor.remove("token")
            editor.remove("username")
            editor.remove("password")
            editor.apply()
            editor.commit()
            startActivity(Intent(context, MainActivity::class.java))
            Toast.makeText(context, "You have been logged out", Toast.LENGTH_SHORT).show()}

        tvProfile.setOnClickListener{
            startActivity(Intent(context, ProfileActivity::class.java))
        }

        return view
    }


}