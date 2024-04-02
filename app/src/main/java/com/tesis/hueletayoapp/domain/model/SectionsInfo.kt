package com.tesis.hueletayoapp.domain.model

import com.tesis.hueletayoapp.R

sealed class SectionsInfo( val img:Int, val name: Int) {
    data object LvlUno:SectionsInfo(R.drawable.huele, R.string.lvl_1)
    data object LvlDos:SectionsInfo(R.drawable.huele, R.string.lvl_2)
    data object LvlTres:SectionsInfo(R.drawable.huele, R.string.lvl_3)
    data object LvlCuatro:SectionsInfo(R.drawable.huele, R.string.lvl_4)
    data object LvlCinco:SectionsInfo(R.drawable.huele, R.string.lvl_5)
    data object LvlSeis:SectionsInfo(R.drawable.huele, R.string.lvl_6)
    data object LvlSiete:SectionsInfo(R.drawable.huele, R.string.lvl_7)
    data object LvlOcho:SectionsInfo(R.drawable.huele, R.string.lvl_8)

}