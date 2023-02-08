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

        with(binding) {

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