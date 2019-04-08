package am.itspace.webflux.controller;

import am.itspace.webflux.model.User;
import am.itspace.webflux.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MainController {

    UserRepository userRepository;

    @GetMapping("/{id}")
    private Mono<User> getUserById(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping
    private Flux<User> getAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/save")
    private Mono<User> saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/byLastName/{surname}")
    public Flux<User> getBySurname(@PathVariable String surname) {
        return userRepository
                .findAll()
                .filter(user -> user.getSurname().equalsIgnoreCase(surname));
    }

}
