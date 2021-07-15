package srandroiddeveloper.amrrabbie.smartangletaskk.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

	@field:SerializedName("imageUrl")
	val imageUrl: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("constractionYear")
	val constractionYear: String,

	@field:SerializedName("brand")
	val brand: String,

	@field:SerializedName("isUsed")
	val isUsed: Boolean


) : Parcelable