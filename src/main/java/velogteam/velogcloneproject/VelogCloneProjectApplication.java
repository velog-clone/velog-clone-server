package velogteam.velogcloneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import velogteam.velogcloneproject.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
@EnableTransactionManagement
public class VelogCloneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VelogCloneProjectApplication.class, args);
	}
}
