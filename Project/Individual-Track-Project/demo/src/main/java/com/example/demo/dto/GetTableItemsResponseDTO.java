package com.example.demo.dto;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTableItemsResponseDTO {
    private List<TableItemDTO> tableItems;
}
