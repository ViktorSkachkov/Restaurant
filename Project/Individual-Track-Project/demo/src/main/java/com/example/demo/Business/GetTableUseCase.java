package com.example.demo.Business;

import com.example.demo.dto.TableItemDTO;

public interface GetTableUseCase {
    public TableItemDTO GetTable(int tableID);
}
