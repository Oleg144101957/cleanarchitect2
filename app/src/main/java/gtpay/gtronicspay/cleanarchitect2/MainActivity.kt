package gtpay.gtronicspay.cleanarchitect2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import gtpay.gtronicspay.cleanarchitect2.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        mainViewModel.resultLiveData.observe(this) {
            binding.tvField.text = it
        }


        binding.btnGetData.setOnClickListener {
            mainViewModel.load()
        }

        binding.btnSaveData.setOnClickListener {
            val text = binding.etField.text.toString()
            mainViewModel.save(text)
        }


    }
}