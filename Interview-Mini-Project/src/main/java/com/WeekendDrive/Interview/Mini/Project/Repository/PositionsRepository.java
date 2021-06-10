package com.WeekendDrive.Interview.Mini.Project.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WeekendDrive.Interview.Mini.Project.Bean.Positions;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Integer>
{

	void save(Optional<Positions> positions);


}
