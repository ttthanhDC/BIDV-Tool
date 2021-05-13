package com.ngs.repository;

import com.ngs.entity.Application;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class ApplicationRepository implements CrudRepository<Application, Integer> {
    @Override
    public <S extends Application> S save(S s) {
        return null;
    }

    @Override
    public <S extends Application> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Application> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Application> findAll() {
        return null;
    }

    @Override
    public Iterable<Application> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Application application) {

    }

    @Override
    public void deleteAll(Iterable<? extends Application> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
