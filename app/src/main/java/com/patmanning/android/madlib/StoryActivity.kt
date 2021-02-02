package com.patmanning.android.madlib

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val EXTRA_ANSWERS = "com.bignerdranch.android.geoquiz.answers"
private const val EXTRA_STORY = "com.bignerdranch.android.geoquiz.story"

class StoryActivity : AppCompatActivity() {

    private lateinit var story: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        story = findViewById(R.id.story)

        val answerString = intent.getStringExtra(EXTRA_ANSWERS)
        val answers = answerString?.split(",") ?: listOf()

        val storyString = intent.getStringExtra(EXTRA_STORY)
        val display = storyString?.format(*answers.toTypedArray()) ?: ""

        story.setText(display)
    }

    companion object {
        fun newIntent(
            packageContext: Context,
            story: String,
            answers: MutableList<String>
        ): Intent {
            return Intent(packageContext, StoryActivity::class.java).apply {
                putExtra(EXTRA_STORY, story)
                putExtra(EXTRA_ANSWERS, answers.joinToString(","))
            }
        }
    }
}