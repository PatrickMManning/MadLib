package com.patmanning.android.madlib

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var questions: LinearLayout
    private lateinit var submit: Button
    private lateinit var new_mad_lib: Button

    private var currentMadLibIndex = 0
    private var questionViews = mutableListOf<EditText>()

    private val madLibViewModel: MadLibViewModel by lazy {
        ViewModelProviders.of(this).get(MadLibViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.title)
        questions = findViewById(R.id.questions)
        submit = findViewById(R.id.submit)
        new_mad_lib = findViewById(R.id.new_mad_lib)

        getNewMadLib()

        submit.setOnClickListener {
            val intent = StoryActivity.newIntent(
                this@MainActivity,
                madLibViewModel.madLibs[currentMadLibIndex].story,
                madLibViewModel.madLibs[currentMadLibIndex].answers
            )
            startActivity(intent)
        }

        new_mad_lib.setOnClickListener {
            getNewMadLib()
        }
    }

    override fun onStart() {
        super.onStart()
        newEditListeners()
    }

    private fun newEditListeners() {
        madLibViewModel.madLibs[currentMadLibIndex].partsOfSpeech.forEachIndexed  { index, _ ->
            val editWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    madLibViewModel.madLibs[currentMadLibIndex].answers[index] = s.toString()
                }
            }
            var edit = questionViews[index] as EditText
            edit.addTextChangedListener(editWatcher)
        }
    }

    private fun getNewMadLib() {
        currentMadLibIndex = (currentMadLibIndex + 1) % madLibViewModel.madLibs.size
        questionViews.clear()
        questions.removeAllViews()
        title.setText(madLibViewModel.madLibs[currentMadLibIndex].title)
        madLibViewModel.madLibs[currentMadLibIndex].partsOfSpeech.forEachIndexed { index, _ ->
            var edit = EditText(this)
            edit.hint = madLibViewModel.madLibs[currentMadLibIndex].partsOfSpeech[index].name
            questionViews.add(edit)
            questions.addView(edit)
        }
        newEditListeners()
    }
}