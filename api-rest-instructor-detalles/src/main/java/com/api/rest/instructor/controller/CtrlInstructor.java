package com.api.rest.instructor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.api.rest.instructor.entity.Instructor;
import com.api.rest.instructor.exceptions.ResourceNotFoundException;
import com.api.rest.instructor.repository.RepoInstructor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CtrlInstructor
{
	@Autowired
	private RepoInstructor repoInstructor;

	@GetMapping("/instructores")
	public List<Instructor> listarInstructores()
	{
		return repoInstructor.findAll();
	}

	@GetMapping("/instructores/{id}")
	public ResponseEntity<Instructor> verDatellesInstructor(@PathVariable Long id)
	{
		Instructor instructor = repoInstructor.findById(id).orElseThrow
		(
			() -> new ResourceNotFoundException("Instructor con el ID : "+id+" no encontrado")
		);

		return ResponseEntity.ok().body(instructor);
	}

	@PostMapping("/instructores")
	public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor)
	{
		return repoInstructor.save(instructor);
	}

	@PutMapping("/instructores/{id}")
	public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Long id,@Valid @RequestBody Instructor instructorActualizar)
	{
		Instructor instructor = repoInstructor.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Instructor con el ID : "+id+" no encontrado"));
		instructor.setEmail(instructorActualizar.getEmail());
		instructor.setNombre(instructorActualizar.getNombre());
		instructor.setApellido(instructorActualizar.getApellido());
		
		Instructor instructorActualizado = repoInstructor.save(instructor);
		return ResponseEntity.ok().body(instructorActualizado);
	}
	
	@DeleteMapping("/instructores/{id}")
	public Map<String, Boolean> eliminarInstructor(@PathVariable Long id)
	{
		Instructor instructor = repoInstructor.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Instructor con el ID : "+id+" no encontrado"));
		repoInstructor.delete(instructor);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Instructor eliminado", Boolean.TRUE);
		return respuesta;
	}
}
