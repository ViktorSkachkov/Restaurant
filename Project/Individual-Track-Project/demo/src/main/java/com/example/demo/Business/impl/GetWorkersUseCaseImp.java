package com.example.demo.Business.impl;

import com.example.demo.Business.GetWorkersUseCase;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.WorkerDTO;

import java.util.ArrayList;
import java.util.List;

public class GetWorkersUseCaseImp implements GetWorkersUseCase {
    private UserRepository udh = new UserRepository();
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
