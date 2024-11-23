package com.arifpamungkas.wisatasemarang.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifpamungkas.wisatasemarang.databinding.ActivityDetailBinding


// Aktivitas DetailActivity menampilkan detail dari objek pariwisata yang dipilih.
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    // Metode onCreate dipanggil ketika aktivitas dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari intent yang dikirimkan dari aktivitas sebelumnya.
        val strTitle = intent.getStringExtra(KEY_TITLE)
        val strDescription = intent.getStringExtra(KEY_DESCRIPTION)
        val intImage = intent.getIntExtra(KEY_IMAGE, 0)

        // Menetapkan data ke tampilan detail.
        binding.tvTitle.text = strTitle
        binding.tvDescription.text = strDescription
        binding.imageTouristAttraction.setImageResource(intImage)
    }

    companion object {
        // Key untuk mendapatkan data dari intent.
        const val KEY_TITLE = "title"
        const val KEY_DESCRIPTION = "description"
        const val KEY_IMAGE = "image"
    }
}
