package com.example.utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.apache.sshd.sftp.client.SftpClient.DirEntry;


@Configuration
@PropertySource("classpath:application.properties")
public class sftpConnect {

    @Value("${sftp.host}")
    private String host;
    @Value("${sftp.password}")
    private String password;
    @Value("${sftp.user}")
    private String user;
    @Value("${sftp.port}")
    private int port;

    @Bean()
    public SessionFactory<DirEntry> sftpSessionFactory(){
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost(host);
        factory.setPassword(password);
        factory.setPort(port);
        factory.setUser(user);
        factory.setAllowUnknownKeys(true);
        return new CachingSessionFactory<DirEntry>(factory);
    }
}
