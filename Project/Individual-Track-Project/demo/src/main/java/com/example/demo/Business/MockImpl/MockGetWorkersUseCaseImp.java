package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetWorkersUseCase;
import com.example.demo.MockRepositories.MockUserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.WorkerDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetWorkersUseCaseImp implements GetWorkersUseCase {
    private MockUserRepository udh = new MockUserRepository();
    @Override
    public List<WorkerDTO> GetWorkers() {
        List<WorkerDTO> workers = new ArrayList<>();
        for(UserDTO user : udh.GetUsers()) {
            if(user instanceof WorkerDTO) {
                workers.add((WorkerDTO) user);
            }
        }
        return workers;
    }
}
