package mazer.arthur.gokapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import mazer.arthur.gokapp.R
import mazer.arthur.gokapp.data.ApiHelper
import mazer.arthur.gokapp.data.RetrofitHelper
import mazer.arthur.gokapp.domains.model.Status
import mazer.arthur.gokapp.utils.ViewModelFactory
import mazer.arthur.gokapp.view.adapter.ProductsAdapter
import mazer.arthur.gokapp.view.adapter.SpotlightAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var spotlightAdapter = SpotlightAdapter()
    private var productsAdapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        registerObservers()
        setupView()
    }

    private fun setupView() {
        setupSpotlightRecyclerView()
        setupProductsRecyclerView()
    }

    private fun registerObservers(){
        viewModel.getProducts().observe(this, Observer {
            it.let{ response ->
                when (response.status){
                    Status.SUCCESS -> {
                        response.data.let { productsList ->
                            spotlightAdapter.spotlightList = productsList?.spotlight ?: return@Observer
                            productsAdapter.productsList = productsList.product
                            Picasso.get().load(productsList.cash.bannerURL).into(ivCash)
                        }
                    }
                    Status.LOADING -> {
                    }
                    Status.ERROR -> {
                    }
                }

            }
        })
    }

    private fun setupSpotlightRecyclerView() {
        rvSpotlight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSpotlight.itemAnimator = DefaultItemAnimator()
        rvSpotlight.adapter = spotlightAdapter
    }

    private fun setupProductsRecyclerView() {
        rvProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProducts.itemAnimator = DefaultItemAnimator()
        rvProducts.adapter = productsAdapter
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this,
            ViewModelFactory(
                ApiHelper(
                    RetrofitHelper.api
                ), applicationContext
            )
        ).get(MainViewModel::class.java)
    }
}