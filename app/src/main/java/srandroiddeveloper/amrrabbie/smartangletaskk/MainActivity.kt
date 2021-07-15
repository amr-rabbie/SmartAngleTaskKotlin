package srandroiddeveloper.amrrabbie.smartangletaskk

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import srandroiddeveloper.amrrabbie.smartangletaskk.adapters.Adapter
import srandroiddeveloper.amrrabbie.smartangletaskk.databinding.ActivityMainBinding
import srandroiddeveloper.amrrabbie.smartangletaskk.model.DataItem
import srandroiddeveloper.amrrabbie.smartangletaskk.viewmodel.TaskViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel: TaskViewModel by viewModels()
    lateinit var madapter: Adapter


    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bindData()

        setupRecyclerView()
        loadData()
    }

  /*  private fun bindData() {


            viewModel.getData(1)

            viewModel.dataresponse.observe(this, { response ->

                Log.d("TAG", "bindData: ${response.toString()}")


                madapter = Adapter(this, response)

                binding.carsrecycler.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = madapter
                    visibility = View.VISIBLE
                }

                binding.pbar.visibility = View.GONE


            })

    }*/

    private fun setupRecyclerView() {

        madapter = Adapter(this)

        binding.carsrecycler.apply {
            adapter = madapter;
            layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

    }

    @InternalCoroutinesApi
    private fun loadData() {

        lifecycleScope.launch {

            viewModel.listdata.collect {
                Log.d("aaa", "load: $it")
                madapter.submitData(it)
            }


        }
    }


}