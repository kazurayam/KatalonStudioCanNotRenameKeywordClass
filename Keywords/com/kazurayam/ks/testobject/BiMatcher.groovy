package com.kazurayam.ks.testobject

import java.util.regex.Matcher
import java.util.regex.Pattern

class BiMatcher {

	private String pattern
	private Pattern ptrn = null
	private Boolean isRegex

	BiMatcher(String pattern = "", Boolean isRegex = false) throws IOException {
		Objects.requireNonNull(pattern)
		this.pattern = pattern
		this.isRegex = isRegex
		if (isRegex) {
			ptrn = Pattern.compile(pattern)
		}
	}

	Boolean matches(String text) {
		Objects.requireNonNull(text)
		if (pattern.length() > 0) {
			if (isRegex) {
				Matcher m = ptrn.matcher(text)
				return m.find()    // will try partial match, not entire match
			} else {
				return text.contains(pattern)
			}
		} else {
			return true
		}
	}
}