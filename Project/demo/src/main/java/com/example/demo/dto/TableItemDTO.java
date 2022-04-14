package com.example.demo.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableItemDTO {
    private int id;
    private int seats;
    private String location;
}
