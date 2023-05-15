package gtpay.gtronicspay.cleanarchitect2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import gtpay.gtronicspay.cleanarchitect2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(this))[MainViewModel::class.java]

        mainViewModel.resultLiveData.observe(this, {
            binding.tvField.text = it
        })


        binding.btnGetData.setOnClickListener {
            mainViewModel.load()
        }

        binding.btnSaveData.setOnClickListener {
            val text = binding.etField.text.toString()
            mainViewModel.save(text)
        }


    }
}