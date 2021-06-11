package com.weekend.drive.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.bean.Round;
import com.weekend.drive.interview.request.RoundUpdateRequest;
import com.weekend.drive.interview.response.RoundResponse;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer> {

	void save(RoundResponse updatedRound);

	void save(RoundUpdateRequest roundUpdateRequest);

}
