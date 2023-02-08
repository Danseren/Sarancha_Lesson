package ru.aston.sarancha_lesson1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aston.sarancha_lesson1.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = UserFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userList = arrayListOf(
            User("John", "Doe", 30, "john.doe@gmail.com"),
            User("Bob", "Anderson", 27, "bob1984@gmail.com"),
            User("Jain", "Doe", 35, "jain@gmail.com"),
            User("Bill", "Smith", 22, "bill.smith@gmail.com"),
            User("Artur", "Doe", 47, "artur.the.king@gmail.com"),
            User("Jack", "Doe", 33, "simple.jack@gmail.com")
        )

        with(binding) {
            btnShowUser.setOnClickListener {
                val randomNumber = (0..5).random()
                tvUserName.text = "${userList[randomNumber].name} ${userList[randomNumber].surname}"
                tvUserAge.text = "Age: ${userList[randomNumber].age}"
                tvUserEmail.text = "Email: ${userList[randomNumber].email}"
            }

            btnMakeDesign.setOnClickListener {
                tvUserName.apply {
                    val randomStyle = (4..8).random()
                    textSize = (randomStyle * 4).toFloat()
                    setPadding(5, 25 * randomStyle, 5, 25 * randomStyle)
                    when (randomStyle) {
                        4 -> {setTextColor(Color.BLACK)}
                        5 -> {setTextColor(Color.RED)}
                        6 -> {setTextColor(Color.GREEN)}
                        7 -> {setTextColor(Color.BLUE)}
                        8 -> {setTextColor(Color.YELLOW)}
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}