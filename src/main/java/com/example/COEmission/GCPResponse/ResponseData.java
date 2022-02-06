package com.example.COEmission.GCPResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    //List<ElementObject> elements;
    List<DistanceDuration> elements;
}
