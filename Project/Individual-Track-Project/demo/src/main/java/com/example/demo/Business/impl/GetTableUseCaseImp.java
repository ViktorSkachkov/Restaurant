package com.example.demo.Business.impl;

import com.example.demo.Business.GetTableUseCase;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.TableItemDTO;

public class GetTableUseCaseImp implements GetTableUseCase {
    private ReservationRepository rdh = new ReservationRepository();
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
