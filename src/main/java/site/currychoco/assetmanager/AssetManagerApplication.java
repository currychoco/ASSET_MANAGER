package site.currychoco.assetmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class AssetManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssetManagerApplication.class, args);
	}

}
