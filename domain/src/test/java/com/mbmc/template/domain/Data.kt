package com.mbmc.template.domain

import com.mbmc.template.domain.entity.Repo

class Data {

    companion object {
        val REPOS = listOf<Repo>(Repo("Android-ViewPagerIndicator"),
            Repo("androidthings-imageclassifier"),
            Repo("FiInfo"),
            Repo("mapbox-directions-android"),
            Repo("MaterialEditText"),
            Repo("MaterialViewPager"),
            Repo("Parcel"),
            Repo("RoboTest"),
            Repo("Template"))
    }

}