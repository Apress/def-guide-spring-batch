package com.example.Chapter06;

//@EnableBatchProcessing
//@SpringBootApplication
public class RestApplication {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public Job job() {
//		return this.jobBuilderFactory.get("job")
//				.incrementer(new RunIdIncrementer())
//				.start(step1())
//				.build();
//	}
//
//	@Bean
//	public Step step1() {
//		return this.stepBuilderFactory.get("step1")
//				.tasklet((stepContribution, chunkContext) -> {
//					System.out.println("step 1 ran today!");
//					return RepeatStatus.FINISHED;
//				}).build();
//	}
//
//	@RestController
//	public static class JobLaunchingController {
//
//		@Autowired
//		private JobLauncher jobLauncher;
//
//		@Autowired
//		private ApplicationContext context;
//
//		@Autowired
//		private JobExplorer jobExplorer;
//
//		@PostMapping(path = "/run")
//		public ExitStatus runJob(@RequestBody JobLaunchRequest request) throws Exception {
//			Job job = this.context.getBean(request.getName(), Job.class);
//
//			JobParameters jobParameters =
//					new JobParametersBuilder(request.getJobParameters(),
//								this.jobExplorer)
//							.getNextJobParameters(job)
//							.toJobParameters();
//
//			return this.jobLauncher.run(job, jobParameters).getExitStatus();
////			Job job = this.context.getBean(request.getName(), Job.class);
////
////			return this.jobLauncher.run(job, request.getJobParameters()).getExitStatus();
//		}
//	}
//
//	public static class JobLaunchRequest {
//		private String name;
//
//		private Properties jobParameters;
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public Properties getJobParamsProperties() {
//			return jobParameters;
//		}
//
//		public void setJobParamsProperties(Properties jobParameters) {
//			this.jobParameters = jobParameters;
//		}
//
//		public JobParameters getJobParameters() {
//			Properties properties = new Properties();
//			properties.putAll(this.jobParameters);
//
//			return new JobParametersBuilder(properties)
//					.toJobParameters();
//		}
//	}
//
//	public static void main(String[] args) {
//		new SpringApplication(RestApplication.class).run(args);
//	}
}
