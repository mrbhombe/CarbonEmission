package com.example.COEmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ByPinCode {

    String originPinCode;
    String destinationPinCode;
}
