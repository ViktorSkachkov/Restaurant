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
    /*@PostMapping("{id}/{username}")
    public ResponseEntity<AccessTokenDTO> getToken(@PathVariable(value = "id") final long id,
                                                   @PathVariable(value = "username") final String username) {
        AccessTokenDTO accessTokenDTO = loginUseCase.generateToken(id, username);
        return ResponseEntity.ok(accessTokenDTO);
    }*/
    @GetMapping("/roles")
    public List<UserRole> getUserRoles() {
        List<String> roles = new ArrayList<>();
       /* for(UserRole userRole : userRoleRepository.findAll())
        {
            if(userRole.getUserId() == 8) {
                if(userRole.getRole().equals("CLIENT")) {
                    roles.add(RoleEnum.CLIENT.name());
                }
                if(userRole.getRole().equals("WORKER")) {
                    roles.add(RoleEnum.WORKER.name());
                }
            }
        }*/
        return userRoleRepository.findAll();
    }
}
