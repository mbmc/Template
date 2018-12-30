package com.mbmc.template.data.repository;

import com.mbmc.template.data.api.ApiService;
import com.mbmc.template.data.entity.Mapper;
import com.mbmc.template.domain.entity.Repo;
import com.mbmc.template.domain.repository.RepoRepository;
import io.reactivex.Observable;

import java.util.List;
import java.util.stream.Collectors;

public class RepoDataRepository implements RepoRepository {

    private final ApiService apiService;

    public RepoDataRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Repo>> getRepos(String handle) {
        return apiService.getRepos(handle).map(repoData ->
                repoData.stream().map(Mapper::mapFromData).collect(Collectors.toList()));
    }

}
