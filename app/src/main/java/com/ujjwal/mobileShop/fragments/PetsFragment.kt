package com.ujjwal.mobileShop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ujjwal.mobileShop.R


class PetsFragment : Fragment() {




    private lateinit var btnFav: Button
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)









//        loadPets()
        return view



    }
//    private  val TAG = "PetsFragment"



//    private fun loadPets() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val petRepository = PetRepository()
//                val response = petRepository.getAllPets()
//                if (response.success == true) {
//                    // Put all the student details in lstStudents
//                    val lstPets = response.data
//                    withContext(Dispatchers.Main) {
//                        val adapter =
//                                PetAdapter(lstPets!!, requireContext())
//                        recyclerView.layoutManager = LinearLayoutManager(context)
//                        recyclerView.adapter = adapter
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                            context,
//                            "Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
//    }


}