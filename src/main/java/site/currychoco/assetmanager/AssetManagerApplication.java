package site.currychoco.assetmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class AssetManagerApplication {

	@Value("${hr-manager.url}")
	private String hrManagerUrl;

	@Value("${hr-manager.key}")
	private String hrManagerKey;

	public static void main(String[] args) {
		SpringApplication.run(AssetManagerApplication.class, args);
	}

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void test() {
		System.out.println("hrManagerUrl = " + hrManagerUrl);
		System.out.println("hrManagerKey = " + hrManagerKey);
	}

}
