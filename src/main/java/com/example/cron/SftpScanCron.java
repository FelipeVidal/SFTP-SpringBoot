package com.example.cron;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.utils.sftpConnect;

@EnableScheduling
@Configuration
public class SftpScanCron {

    @Autowired
    private sftpConnect newSftpConnect;
    
    private SftpRemoteFileTemplate sftpRemoteFileTemplate;

    public InputStream inputStream = null;
    
    @Scheduled(fixedDelay = 30000, initialDelay = 10000)
    private void scanSFTP(){

        sftpRemoteFileTemplate = new SftpRemoteFileTemplate(newSftpConnect.sftpSessionFactory());
        
            sftpRemoteFileTemplate.execute(session -> {

            String remoteFilePath = "data/IPS_Sanitas/01/cuv.json";

            try{ 
                this.inputStream = session.readRaw(remoteFilePath);
                System.out.println("File cuv exists");
                session.mkdir("data/IPS_Sanitas/temporal/01");
                session.rename("data/IPS_Sanitas/01/cuv.json","data/IPS_Sanitas/temporal/01/cuv.json");
                session.remove(remoteFilePath);

            }catch(Exception e){
                System.out.println(e);
            }
            return null; 
        });
    }
    public InputStream getInpustream(){
        return inputStream;
    }
}
