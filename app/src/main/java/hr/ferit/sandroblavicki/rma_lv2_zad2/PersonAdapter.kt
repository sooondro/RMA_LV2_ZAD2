package hr.ferit.sandroblavicki.rma_lv2_zad2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    people: List<Person>,
    private val listener: PersonInteractionListener
    ) :
    RecyclerView.Adapter<PersonViewHolder>() {

    private val people: MutableList<Person> = mutableListOf()

    init {
        refreshData(people)
    }

    public fun refreshData(people: List<Person>){
        this.people.clear()
        this.people.addAll(people)
        /*this.notifyDataSetChanged()*/
        notifyItemInserted(itemCount-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(personView)
    }

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person, listener)
    }
}
