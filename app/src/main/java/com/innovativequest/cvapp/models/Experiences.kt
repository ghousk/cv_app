package com.innovativequest.cvapp.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Experiences(

	@field:SerializedName("experiences")
	val experienceItems: List<ExperiencesItem>? = null
)