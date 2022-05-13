package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetTablesUseCase;
import com.example.demo.MockRepositories.MockReservationRepository;
import com.example.demo.dto.TableItemDTO;

import java.util.List;

public class MockGetTablesUseCaseImp implements GetTablesUseCase {
    private MockReservationRepository rdh = new MockReservationRepository();
    @Override
    public List<TableItemDTO> GetTables() {
        return this.rdh.GetTables();
    }
}
