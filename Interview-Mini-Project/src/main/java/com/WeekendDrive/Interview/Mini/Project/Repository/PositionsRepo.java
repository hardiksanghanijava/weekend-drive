package com.example.demo.bean;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepo extends JpaRepository<Positions, Integer>
{

	void save(Optional<Positions> positions);


}
