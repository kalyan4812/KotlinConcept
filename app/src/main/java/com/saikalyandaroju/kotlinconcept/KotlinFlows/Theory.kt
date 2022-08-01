package com.saikalyandaroju.kotlinconcept.KotlinFlows

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


/*

 * kotlin feature for react programming(rxjava type).

 * React programming - its all about being notified about changes in code and sending them through
  a pipeline that potentially modifies them.

 * Flow= couroutine that can emit multiple values at a time.











 */
fun TextView.append(string: String?, @ColorRes color: Int) {
    if (string == null || string.isEmpty()) {
        return
    }

    val spannable: Spannable = SpannableString(string)
    spannable.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, color)),
        0,
        spannable.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    append(spannable)
}