package com.cloudmicro.microservices.pubservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataRepository extends JpaRepository<Data,Long> {
    @Override
    public Optional<Data> findById(Long aLong);
}
