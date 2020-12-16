package io.spring.batch.helloworld

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@EnableBatchProcessing
@SpringBootApplication
class BatchApplication(private val jobBuilderFactory: JobBuilderFactory,
private val stepBuilderFactory: StepBuilderFactory) {

    @Bean
    fun step(): Step =
        this.stepBuilderFactory.get("step1").tasklet { _, _ ->
                println("Hello, World!")
                RepeatStatus.FINISHED
        }.build()

    @Bean
    fun job(): Job =
        this.jobBuilderFactory.get("job").start(step()).build()
}

fun main(args: Array<String>) {
    runApplication<BatchApplication>(*args)
}
