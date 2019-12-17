package tj.belajar.orang.model.minum

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Minuman : Serializable {

    @SerializedName("id")
    var id = 0

    @SerializedName("nama")
    var namaMinum : String= ""

    @SerializedName("harga")
    var hargaMinum : String = ""

    @SerializedName("image")
    var gambarMinum : String = ""
}