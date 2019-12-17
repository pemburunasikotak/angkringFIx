package tj.belajar.orang.model.minum

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AllMinuman :Serializable {
    
    @SerializedName("data")
    var data = ArrayList<Minuman>()

    @SerializedName("error")
    var error = ""
}