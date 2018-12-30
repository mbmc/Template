package com.mbmc.template.domain.repository;

import com.mbmc.template.domain.entity.Repo;
import io.reactivex.Observable;

import java.util.List;

public interface RepoRepository {

    Observable<List<Repo>> getRepos(String handle);

}

