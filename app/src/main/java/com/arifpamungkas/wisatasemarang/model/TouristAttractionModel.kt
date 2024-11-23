package com.arifpamungkas.wisatasemarang.model

// Data class TouristAttraction merepresentasikan objek pariwisata yang akan ditampilkan dalam aplikasi.
data class TouristAttractionModel(
    val image: Int, // Menyimpan ID gambar yang akan digunakan untuk menampilkan gambar pariwisata.
    val title: String, // Menyimpan judul atau nama dari objek pariwisata.
    val description: String // Menyimpan deskripsi atau informasi tambahan tentang objek pariwisata.
)