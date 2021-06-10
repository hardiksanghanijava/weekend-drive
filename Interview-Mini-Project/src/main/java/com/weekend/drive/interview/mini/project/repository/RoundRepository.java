package com.weekend.drive.interview.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.mini.project.bean.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer> {

}
