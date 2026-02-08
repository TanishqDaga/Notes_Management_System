package com.notesmanagementsystem.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.notesmanagementsystem.entity.Notes;
import com.notesmanagementsystem.entity.ResponseStructure;
import com.notesmanagementsystem.exception.NotesNotFoundException;
import com.notesmanagementsystem.repository.NotesRepository;


@Service

public class NotesService { 
	
	@Autowired
	private NotesRepository notesRepository;
	
	public ResponseEntity<ResponseStructure<Notes>> createNotes(Notes notes){
		ResponseStructure<Notes> structure =new ResponseStructure<>();
		structure.setData(notesRepository.save(notes));
		structure.setMessage("Created Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Notes>>(structure,HttpStatus.CREATED);  
	}
	
	public ResponseEntity<ResponseStructure<Notes>> updateNotes(Notes notes,Integer id){
		ResponseStructure<Notes> structure =new ResponseStructure<>();
		
		Optional<Notes> recNotes= notesRepository.findById(id);
		
		if(recNotes.isPresent()) {
			Notes existNotes=recNotes.get();
			existNotes.setTitle(notes.getTitle());
			existNotes.setContent(notes.getContent());
			
			Notes updateNotes=notesRepository.save(existNotes);
			
			structure.setData(updateNotes);
			structure.setMessage("Notes Updates Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			
			
			return new ResponseEntity<ResponseStructure<Notes>>(structure,HttpStatus.OK); 
			
		}
		else {
			throw new NotesNotFoundException("Notes Not Found");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteNotes(Integer id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		
		Optional<Notes> recNotes= notesRepository.findById(id);
		
		if(recNotes.isPresent()) {
			
			
			notesRepository.deleteById(id);
			
			structure.setData("Deletion Successfull");
			structure.setMessage("Notes Deleted Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		else {
			throw new NotesNotFoundException("Notes Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Notes>>> viewAllNotes(){
		ResponseStructure<List<Notes>> structure=new ResponseStructure<>();
		
		List<Notes> recNotes= notesRepository.findAll();
		
		if(recNotes.size()>0) {
			structure.setMessage("List of Notes");
			structure.setData(recNotes);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Notes>>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new NotesNotFoundException("Notes Not Found");
		}
		
		
	}
	
	public ResponseEntity<ResponseStructure<List<Notes>>> searchNotes(String title){
		ResponseStructure<List<Notes>> structure=new ResponseStructure<>();
		
		List<Notes> recNotes= notesRepository.findByTitleContainingIgnoreCase(title);
		
		if(recNotes.size()>0) {
			structure.setMessage("List of Notes");
			structure.setData(recNotes);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Notes>>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new NotesNotFoundException("Notes Not Found");
		}
		
		
	}
	
	
}
