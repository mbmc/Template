package com.mbmc.template.helper

import com.mbmc.template.domain.entity.Repo
import com.mbmc.template.ui.DataWrapper
import org.mockito.ArgumentMatcher

class RepoMatcher(private val dataWrapper: DataWrapper<List<Repo>>) : ArgumentMatcher<DataWrapper<List<Repo>>> {

    override fun matches(argument: DataWrapper<List<Repo>>): Boolean {
        if (dataWrapper.throwable != null && argument.throwable != null) {
            return dataWrapper.throwable.message == argument.throwable.message
        }
        for (i in dataWrapper.data.indices) {
            if (dataWrapper.data[i].name != argument.data[i].name) {
                return false
            }
        }
        return true
    }

}
