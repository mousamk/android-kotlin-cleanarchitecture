package pro.mousa.cleanmovies.features.movies

import android.os.Parcel
import pro.mousa.cleanmovies.core.platform.KParcelable
import pro.mousa.cleanmovies.core.platform.parcelableCreator

class MovieView(val id: Int, val poster: String) : KParcelable {

    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(poster)
    }

    companion object {
        @JvmField var CREATOR = parcelableCreator(::MovieView)
    }
}
