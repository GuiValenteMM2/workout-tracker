package com.api.workouts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
@SpringBootApplication
@RestController
public class WorkoutServerApplication {

	@Autowired
	UserRepository UserRepository;

	public static void main(String[] args) {
		SpringApplication.run(WorkoutServerApplication.class, args);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String name) {
		try {
			List<User> nameList = new ArrayList<User>();
			if (name == null) {
			UserRepository.findAll().forEach(nameList::add);
			}
			else {
				UserRepository.findByName(name).forEach(nameList::add);
			}
			if (nameList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(nameList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		Optional<User> userData = UserRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<User> newUser(@RequestBody User user) {
		try {
			User _user = UserRepository.save(new User(user.getName(), user.getEmail(), user.getPassword()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
		try {
			UserRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
