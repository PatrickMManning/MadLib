package com.patmanning.android.madlib

import androidx.lifecycle.ViewModel

class MadLibViewModel : ViewModel() {
    val madLibs = mutableListOf<MadLib>(MadLib(
        "Android coding",
        "Learning Android is %s.  Coding %s and %s is especially %s.  I'll be an expert when I can %s %s.",
        listOf(
            PartsOfSpeech.ADJECTIVE,
            PartsOfSpeech.PLURAL_NOUN,
            PartsOfSpeech.PLURAL_NOUN,
            PartsOfSpeech.ADJECTIVE,
            PartsOfSpeech.ADVERB,
            PartsOfSpeech.VERB
        ),
        MutableList<String>(6) { "" }
    ), MadLib(
        "Vacation",
        "I am going on a vacation to %s.  When I get there I will %s and %s.  I hear their %s %s is the best in the world!  I can't wait to go.",
        listOf(
            PartsOfSpeech.PLACE,
            PartsOfSpeech.VERB,
            PartsOfSpeech.VERB,
            PartsOfSpeech.ADJECTIVE,
            PartsOfSpeech.NOUN
        ),
        MutableList<String>(5) { "" }
    ), MadLib(
        "Cooking",
        "If you wish to cook a %s %s, you will need three ingredients: one cup of %s, one tablespoon of %s, and one gallon of %s.  %s the ingredients together and %s.  Make sure to keep your %s away from the oven!",
        listOf(
            PartsOfSpeech.ADJECTIVE,
            PartsOfSpeech.NOUN,
            PartsOfSpeech.NOUN,
            PartsOfSpeech.NOUN,
            PartsOfSpeech.NOUN,
            PartsOfSpeech.VERB,
            PartsOfSpeech.VERB,
            PartsOfSpeech.PART_OF_BODY
        ),
        MutableList<String>(8) { "" }
    ))
}