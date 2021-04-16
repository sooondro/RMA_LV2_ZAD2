package hr.ferit.sandroblavicki.rma_lv2_zad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import hr.ferit.sandroblavicki.rma_lv2_zad2.databinding.FragmentNewPersonBinding

class NewPersonFragment : Fragment() {

    private lateinit var newPersonBinding: FragmentNewPersonBinding

    companion object {
        fun newInstance(): NewPersonFragment {
            return NewPersonFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newPersonBinding = FragmentNewPersonBinding.inflate(layoutInflater)
        newPersonBinding.btnNewPersonSave.setOnClickListener { savePerson() }
        return newPersonBinding.root
    }

    private fun savePerson() {
        val name = newPersonBinding.etNewPersonNameInput.text.toString()
        val description = newPersonBinding.etNewPersonDescriptionInput.text.toString()
        val dateOfBirth = newPersonBinding.etNewPersonDateOfBirthInput.text.toString()
        val quotes = newPersonBinding.etNewPersonQuotesInput.text?.split('.')
        val imageUrl = newPersonBinding.etNewPersonImageUrlInput.text.toString()

        val id = PeopleRepository.generateId()
        val newPerson = quotes?.let { Person(id, name, dateOfBirth, it, description, imageUrl) }
        newPerson?.let { PeopleRepository.add(it) }
        Log.d("SANDRO", newPerson.toString())
        Toast.makeText(context, "New Person Added", Toast.LENGTH_SHORT).show()

    }
}