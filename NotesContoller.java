package com.notesmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesmanagementsystem.entity.Notes;
import com.notesmanagementsystem.entity.ResponseStructure;
import com.notesmanagementsystem.service.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesContoller {
	
	@Autowired
	private NotesService notesService;
	@PostMapping("/create")
	public ResponseEntity<ResponseStructure<Notes>> createNotes(@RequestBody Notes notes){
		return notesService.createNotes(notes);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Notes>> updateNotes(@RequestBody Notes notes,@PathVariable Integer id){
		return notesService.updateNotes(notes,id);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteNotes(@PathVariable Integer id){
		return notesService.deleteNotes(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Notes>>> viewAllNotes(){
		return notesService.viewAllNotes();
	}
	@GetMapping("/search/{title}")
	public ResponseEntity<ResponseStructure<List<Notes>>> searchNotes(@PathVariable String title){
		return notesService.searchNotes(title);
	}
	
	
}
