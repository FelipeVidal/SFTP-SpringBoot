package com.example.services;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.example.cron.SftpScanCron;
import com.example.model.cuv;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableScheduling
@Service
public class SftpServiceImpl implements SftpService{


    @Autowired
    private SftpScanCron sftpScanCron;

    cuv newCuv = null;

    @Override
    public cuv getCuv() {
        InputStream inputStream = sftpScanCron.getInpustream();
        if(inputStream!=null){
            try {
                cuv auxCuv = extractCUV(inputStream);
                if(auxCuv!=null){
                    newCuv = auxCuv;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return newCuv;
    }

    private cuv extractCUV(InputStream inputStream){

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(inputStream, cuv.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
    
}
