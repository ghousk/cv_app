package com.innovativequest.cvapp.models

import com.google.gson.annotations.SerializedName

data class ExperiencesItem(

	@field:SerializedName("achievements")
	val achievements: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("jobTitle")
	val jobTitle: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)