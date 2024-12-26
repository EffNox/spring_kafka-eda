package nr.pub;

import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import lombok.RequiredArgsConstructor;
import nr.pub.model.Tarea;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class PubApplication {

	private final KafkaTemplate<String, Tarea> kafka;

	public static void main(String[] args) {
		SpringApplication.run(PubApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(KafkaTemplate<String, Tarea> kafka) {
	// 	return args -> {
	// 		kafka.sendDefault(new Tarea(UUID.randomUUID().toString(), 18.5));
	// 	};
	// }

	@Scheduled(fixedDelay = 1000)
	public void event() {
		var task = new Tarea(UUID.randomUUID().toString(), 18.5);
		System.out.println("task: " + task);
		kafka.sendDefault(task);
	}

}
