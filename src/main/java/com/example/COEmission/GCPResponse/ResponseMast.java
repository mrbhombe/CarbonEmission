package com.example.COEmission.GCPResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMast {
    String[] destination_addresses;
    String[] origin_addresses;
    String status;
    List<ResponseData> rows;
}
