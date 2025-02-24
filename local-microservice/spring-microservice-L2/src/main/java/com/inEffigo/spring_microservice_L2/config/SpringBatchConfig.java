package com.inEffigo.spring_microservice_L2.config;

import com.inEffigo.dto.UserDto;
import com.inEffigo.spring_microservice_L2.entity.User;
import com.inEffigo.spring_microservice_L2.repository.UserRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class SpringBatchConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public JsonItemReader<UserDto> jsonItemReader(){
        return new JsonItemReaderBuilder<UserDto>()
                .name("userItemReader")
                .resource(new ClassPathResource("users.json"))
                .jsonObjectReader(new JacksonJsonObjectReader<>(UserDto.class))
                .build();
    }

    @Bean
    public UserProcessor processor(){
        return new UserProcessor();
    }

    @Bean
    RepositoryItemWriter<User> writer(){
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
        writer.setRepository(userRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("importUsers", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("json-import-step", jobRepository)
                .<UserDto, User>chunk(10, platformTransactionManager)
                .reader(jsonItemReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
