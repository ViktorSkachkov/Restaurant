package com.example.demo.Business.impl;

import com.example.demo.Business.GetTablesUseCase;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.TableItemDTO;

import java.util.List;

public class GetTablesUseCaseImp implements GetTablesUseCase {
    private ReservationRepository rdh = new ReservationRepository();
    @Override
    public List<TableItemDTO> GetTables() {
        return this.rdh.GetTables();
    }
}
