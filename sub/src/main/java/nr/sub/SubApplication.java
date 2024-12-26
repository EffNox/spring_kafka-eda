package nr.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import nr.sub.model.Tarea;

@SpringBootApplication
public class SubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubApplication.class, args);
	}

	@KafkaListener(topics = "spring.task.test", groupId = "notiGroupId")
	public void getTask(Tarea tarea) {
		System.out.println("tarea: " + tarea);
	}

}
