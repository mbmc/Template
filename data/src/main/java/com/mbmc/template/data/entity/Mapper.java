package com.mbmc.template.data.entity;

import com.mbmc.template.domain.entity.Repo;

public final class Mapper {

    public static Repo mapFromData(RepoData from) {
        return new Repo(from.name);
    }

    private Mapper() {

    }

}
