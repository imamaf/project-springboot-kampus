package com.teknoglobal.kampus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.teknoglobal.kampus.exception.ResourceNotFoundException;
import com.teknoglobal.kampus.model.Dosen;
import com.teknoglobal.kampus.repository.DosenRepository;

@RestController
@RequestMapping("/api/v1")
public class DosenController {
	@Autowired
	private DosenRepository dosenRepository;

	@GetMapping("/dosen")
	public List<Dosen> getAllDosen() {
		return dosenRepository.findAll();
	}

	@GetMapping("/dosen/{id}")
	public ResponseEntity<Dosen> getDosenById(@PathVariable(value = "id") Long dosenId)
			throws ResourceNotFoundException {
		Dosen dosen = dosenRepository.findById(dosenId)
				.orElseThrow(() -> new ResourceNotFoundException("Dosen not found for this id :: " + dosenId));
		return ResponseEntity.ok().body(dosen);
	}

	@PostMapping("/dosen")
	public Dosen createDosen(@Valid @RequestBody Dosen dosen) {
		return dosenRepository.save(dosen);
	}

	@PutMapping("/dosen/{id}")
	public ResponseEntity<Dosen> updateDosen(@PathVariable(value = "id") Long dosenId,
			@Valid @RequestBody Dosen dosenDetails) throws ResourceNotFoundException {
		Dosen dosen = dosenRepository.findById(dosenId)
				.orElseThrow(() -> new ResourceNotFoundException("Dosen not found for this id :: " + dosenId));

		dosen.setNid(dosenDetails.getNid());
		dosen.setNamaDosen(dosenDetails.getNamaDosen());
        dosen.setJenisKelamin(dosenDetails.getJenisKelamin());
        dosen.setMataKuliah(dosenDetails.getMataKuliah());
		final Dosen updatedDosen = dosenRepository.save(dosen);
		return ResponseEntity.ok(updatedDosen);
    }

	@DeleteMapping("/dosen/{id}")
	public Map<String, Boolean> deleteDosen(@PathVariable(value = "id") Long dosenId)
			throws ResourceNotFoundException {
		Dosen dosen = dosenRepository.findById(dosenId)
				.orElseThrow(() -> new ResourceNotFoundException("Dosen not found for this id :: " + dosenId));

		dosenRepository.delete(dosen);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
