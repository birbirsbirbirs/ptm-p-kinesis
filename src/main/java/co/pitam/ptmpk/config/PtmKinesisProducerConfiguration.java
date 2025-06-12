package co.pitam.ptmpk.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PtmKinesisProducerConfiguration {


    @Bean
    public KinesisProducerConfiguration kinesisProducerConfiguration() {
        KinesisProducerConfiguration kinesisProducerConfiguration = new KinesisProducerConfiguration();
        kinesisProducerConfiguration.setCredentialsProvider(new AWSStaticCredentialsProvider(new BasicAWSCredentials("test","test")));
        kinesisProducerConfiguration.setRegion("us-east-1");
        kinesisProducerConfiguration.setVerifyCertificate(false);
        return kinesisProducerConfiguration;
    }
}
