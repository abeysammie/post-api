package com.javaMadeEasy.Entertainment.authentication.AUth;

import com.javaMadeEasy.Entertainment.authentication.cofig.JwtService;
import com.javaMadeEasy.Entertainment.authentication.repository.UserRepository;
import com.javaMadeEasy.Entertainment.authentication.user.Role;
import com.javaMadeEasy.Entertainment.authentication.user.User;
import com.javaMadeEasy.Entertainment.authentication.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	@Autowired
    private UserRepository repository;
	@Autowired
    private PasswordEncoder encoder;
	@Autowired
    private JwtService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;
	

        public AuthenticationResponce register(RegisterRequest request) {
            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(encoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponce.builder()
                    .token(jwtToken).build();
        }
public ResponseEntity<?> getSavedUSer(RegisterRequest request) {

    Optional<User> user = repository.findByEmail(request.getEmail());
    if (user.isPresent()) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.get().getFirstName());
        userDto.setLastName(user.get().getLastName());
        userDto.setEmail(user.get().getEmail());
        return ResponseEntity.ok(userDto);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    public AuthenticationResponce authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user= repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponce.builder()
                .token(jwtToken)
                .build();
    }

    public Optional<User> getUserDetails(String email) {

        return repository.findByEmail(email);
    }


}
