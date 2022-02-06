package com.example.COEmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostEmission {
    String distance;
    Double carbonEmission;
    String fuel;
    String consideration;

    public CostEmission(Double co2, String km) {
        this. fuel="Petrol";
        this. consideration = "Taking the consideration that 5 litre petrol is required to travel 100km distance";
        this.distance =km;
        this.carbonEmission = co2;

    }
}
