package com.patmanning.android.madlib

data class MadLib(
    val title: String,
    val story: String,
    val partsOfSpeech: List<PartsOfSpeech>,
    val answers: MutableList<String>
)