package alfianyusufabdullah.mvvmstarter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btnIncrement.setOnClickListener {
            mainViewModel.increment()
        }

        btnDecrement.setOnClickListener {
            mainViewModel.decrement()
        }

        savedInstanceState?.let {
            mainViewModel.restore()
        }
    }

    private val resultObserve = Observer<MainState>{ it ->
        it?.let {
            when (it){
                is MainState.OnResult -> {
                    tvResult.text = it.result.toString()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.result.observe(this, resultObserve)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.result.removeObserver(resultObserve)
    }
}
