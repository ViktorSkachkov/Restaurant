package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetTableUseCase;
import com.example.demo.MockRepositories.MockReservationRepository;
import com.example.demo.dto.TableItemDTO;

public class MockGetTableUseCaseImp implements GetTableUseCase {
    private MockReservationRepository rdh = new MockReservationRepository();
    @Override
    public TableItemDTO GetTable(int tableID) {
        TableItemDTO table = null;
        for(TableItemDTO t: rdh.GetTables()) {
            if(t.getId() == tableID) {
                table = t;
                return table;
            }
        }
        return null;
    }
}
