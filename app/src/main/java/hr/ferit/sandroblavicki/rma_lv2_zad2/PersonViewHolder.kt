package hr.ferit.sandroblavicki.rma_lv2_zad2

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hr.ferit.sandroblavicki.rma_lv2_zad2.databinding.ItemPersonBinding

class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(person: Person, personListener: PersonInteractionListener) {
        val binding = ItemPersonBinding.bind(itemView)
        binding.tvPersonName.text = person.name
        binding.tvPersonDateOfBirth.text = person.dateOfBirth
        binding.tvPersonDescription.text = person.description
        Glide.with(binding.ivPersonImage).load(person.imageUrl).into(binding.ivPersonImage)
        itemView.setOnClickListener { personListener.onShowDetails(person.id) }
        itemView.setOnLongClickListener {
            personListener.onRemove(person.id)
            true
        }
    }
}