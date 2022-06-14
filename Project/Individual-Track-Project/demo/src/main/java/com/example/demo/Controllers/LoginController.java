package com.example.demo.Controllers;

import com.example.demo.Business.LoginUseCase;
import com.example.demo.RepositoryClasses.UserRole;
import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;
private final UserRoleRepository userRoleRepository;
    @PostMapping
    public /*ResponseEntity<*/LoginResponseDTO/*>*/ login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = loginUseCase.login(loginRequestDTO);
        return /*ResponseEntity.ok(*/loginResponseDTO/*)*/;
    }
    @GetMapping("/roles")
    public List<UserRole> getUserRoles() {
        List<String> roles = new ArrayList<>();
        return userRoleRepository.findAll();
    }
    @GetMapping("/test")
    public String Test() {
        return "test";
    }
}
