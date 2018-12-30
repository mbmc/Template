package com.mbmc.template.domain.usecase;

import com.mbmc.template.domain.entity.Repo;
import com.mbmc.template.domain.repository.RepoRepository;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class RepoUseCase {

    private final RepoRepository repoRepository;

    @Inject
    public RepoUseCase(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public Observable<List<Repo>> getRepos(String handle) {
        return repoRepository.getRepos(handle);
    }

}
