package com.example.COEmission.GCPResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceDuration {
    Distance distance;
    Duration duration;
    String status;
}
