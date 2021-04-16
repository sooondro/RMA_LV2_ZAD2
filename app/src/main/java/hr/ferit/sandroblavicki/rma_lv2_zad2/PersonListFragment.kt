package hr.ferit.sandroblavicki.rma_lv2_zad2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.rma_lv2_zad2.databinding.FragmentPersonListBinding

class PersonListFragment: Fragment() {

    private lateinit var personListBinding : FragmentPersonListBinding
    private val peopleRepository = PeopleRepository

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is PersonInteractionListener){
            personInteractionListener = context
        }
    }*/

    override fun onResume() {
        super.onResume()
        (personListBinding.rvPersonList.adapter as PersonAdapter).refreshData(PeopleRepository.getPeople())
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personListBinding = FragmentPersonListBinding.inflate(layoutInflater)
        setUpUi()
        return personListBinding.root
    }

    private fun setUpUi() {
        personListBinding.rvPersonList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        personListBinding.rvPersonList.itemAnimator = DefaultItemAnimator()
        personListBinding.rvPersonList.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        displayData()
    }

    private fun displayData() {
        val personInteractionListener = object: PersonInteractionListener{
            override fun onRemove(id: Int) {
                PeopleRepository.remove(id)
                (personListBinding.rvPersonList.adapter as PersonAdapter).refreshData(PeopleRepository.getPeople())
            }

            override fun onShowDetails(id: Int) {
                val person = PeopleRepository.get(id)
                Toast.makeText(context, person?.description.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        personListBinding.rvPersonList.adapter = PersonAdapter(peopleRepository.getPeople(), personInteractionListener)
    }

    companion object {
        const val TAG = "People list"
        fun newInstance() : PersonListFragment {
            return PersonListFragment()
        }
    }
}