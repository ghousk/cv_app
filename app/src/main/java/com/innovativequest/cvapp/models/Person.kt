package com.innovativequest.cvapp.models

import com.google.gson.annotations.SerializedName

data class Person(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("qualification")
	val qualification: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("technicalKnowledge")
	val technicalKnowledge: String? = null
)