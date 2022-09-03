package com.example.recyclersearch.model

import android.text.Spannable
import android.text.SpannableString

data class Item (val abbr: Spannable, val name: Spannable){
    constructor(abbr: String, name: String) : this(SpannableString(abbr), SpannableString(name))
}
