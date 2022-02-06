package com.example.COEmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CoEmissionController {

    @Autowired
    CoEmissionServiceImpl coEmissionService;


    @PostMapping("/bypincode")
    public GeneralResponse<CostEmission> byPincodeEmissionCount(@RequestBody ByPinCode record)
    {
        GeneralResponse<CostEmission> result=null;
        try {
            if (record.getOriginPinCode() == null || record.getDestinationPinCode()==null)
                throw new Exception("NUll record passed");

            CostEmission costEmission = coEmissionService.calculateByPinCode(record);
            result = new GeneralResponse<>(costEmission,"Data found",true,System.currentTimeMillis(),HttpStatus.OK);

        }
        catch (Exception e)
        {
            result = new GeneralResponse<>(null,e.getMessage(),false,System.currentTimeMillis(), HttpStatus.BAD_REQUEST);
        }
        return result;
    }
}
