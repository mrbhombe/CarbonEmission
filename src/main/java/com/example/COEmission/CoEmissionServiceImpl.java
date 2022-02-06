package com.example.COEmission;

import com.example.COEmission.GCPResponse.DistanceDuration;
import com.example.COEmission.GCPResponse.ResponseData;
import com.example.COEmission.GCPResponse.ResponseMast;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Iterator;
import java.util.Map;

@Service("coEmissionCalculateService")
public class CoEmissionServiceImpl {


    @Autowired
    private RestTemplate restTemplate;

    //GCP KEY
    public static String API_KEY="AIzaSyAuEkvHjXhHKbAxmtlgYWnKCfCHRxlA7ak";

    //considerations
    private static Double liter = 5.0;
    private static Long kmPerGivenLiter = 100l;

    public CostEmission calculateByPinCode(ByPinCode record) throws Exception {
        CostEmission costEmission=null;
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseMast responseMast = restTemplate.getForObject("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+record.getOriginPinCode()+"&destinations="+record.getDestinationPinCode()+"&key="+API_KEY, ResponseMast.class);
        if(responseMast.getStatus().equalsIgnoreCase("OK"))
        {
            for(DistanceDuration distanceDuration:responseMast.getRows().get(0).getElements())
            {
                if(distanceDuration.getStatus().equalsIgnoreCase("OK"))
                {
                    Double km = Double.parseDouble(distanceDuration.getDistance().getText().split(" ")[0]);
                    Double co2 = (km * liter)/kmPerGivenLiter;
                    costEmission = new CostEmission(co2,distanceDuration.getDistance().getText());
                }
                else
                {
                    throw new Exception(distanceDuration.getStatus());
                }
            }
        }
        else
        {
            throw new Exception(responseMast.getStatus());
        }
        return costEmission;
    }
}
