package com.ujjwal.mobileShop.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.adapter.ArticleAdapter
import com.ujjwal.mobileShop.db.ArticleDB
import com.ujjwal.mobileShop.repository.ArticleRepository


class ArticlesFragment : Fragment() {


    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleAdapter


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val articleDao = ArticleDB.getInstance(requireContext()).getArticleDAO()
        val repository = ArticleRepository(articleDao)
        val viewModelFactory = ArticleViewModelFactory(repository)
        articleViewModel = ViewModelProvider(this,viewModelFactory).get(ArticleViewModel::class.java)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_articles, container, false)
        recyclerView = view.findViewById(R.id.articleRecycler)

        articleViewModel.getAllArticles()

        articleViewModel.text.observe(viewLifecycleOwner, Observer { lstArticles ->
            adapter.setList(lstArticles)
        })


        adapter = ArticleAdapter(requireContext())
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
//        loadArticles()
        return view
    }

//    private fun loadArticles() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val articleRepository = ArticleRepository()
//                val response = articleRepository.getAllArticles()
//                if (response.success == true) {
//                    // Put all the student details in lstStudents
//                    val lstArticles = response.data
//                    withContext(Dispatchers.Main) {
//                        recyclerView.adapter =
//                                ArticleAdapter(lstArticles!!, requireContext())
//                        recyclerView.layoutManager = //GridLayoutManager
//                     LinearLayoutManager(context)
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                            context,"Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
//    }
}