package com.notesmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notesmanagementsystem.entity.Notes;
import java.util.*;

@Repository
public interface NotesRepository extends JpaRepository<Notes,Integer> {
	List<Notes> findByTitleContainingIgnoreCase(String title);
}
