package com.example.demo.Business;

import com.example.demo.dto.WorkerDTO;

import java.util.List;

public interface GetWorkersUseCase {
    public List<WorkerDTO> GetWorkers();
}
