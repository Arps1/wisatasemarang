package com.arifpamungkas.wisatasemarang.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifpamungkas.wisatasemarang.databinding.ItemTouristAttractionsBinding
import com.arifpamungkas.wisatasemarang.model.TouristAttractionModel


class TouristAttractionAdapter(
    private val items: Array<TouristAttractionModel>, // List objek pariwisata yang akan ditampilkan.
    private val onSelect: (TouristAttractionModel) -> Unit // Listener yang dipanggil ketika salah satu item dipilih.
) : RecyclerView.Adapter<TouristAttractionAdapter.ViewHolder>() {

    private var currentIndex: Int = 0 // Menyimpan indeks saat ini.

    inner class ViewHolder(private val binding: ItemTouristAttractionsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TouristAttractionModel) {
            binding.apply {
                imageTouristAttraction.setImageResource(item.image)
                root.setOnClickListener { onSelect(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTouristAttractionsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Fungsi untuk menampilkan item berikutnya.
    fun nextItem() {
        if (currentIndex < items.size - 1) {
            currentIndex++
            notifyItemChanged(currentIndex - 1) // Update tampilan sebelumnya.
            notifyItemChanged(currentIndex)    // Update tampilan saat ini.
        }
    }

    // Fungsi untuk menampilkan item sebelumnya.
    fun previousItem() {
        if (currentIndex > 0) {
            currentIndex--
            notifyItemChanged(currentIndex + 1) // Update tampilan sebelumnya.
            notifyItemChanged(currentIndex)     // Update tampilan saat ini.
        }
    }

    // Fungsi untuk mendapatkan item saat ini (opsional, jika diperlukan untuk keperluan lain).
    fun getCurrentItem(): TouristAttractionModel {
        return items[currentIndex]
    }
}
