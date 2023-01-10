package site.currychoco.assetmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import site.currychoco.assetmanager.employee.domain.EmployeeDto;

import java.util.List;

@SpringBootTest
class AssetManagerApplicationTests {

	@Value("${hr-manager.url}")
	private String hrManagerUrl;

	@Value("${hr-manager.key}")
	private String hrManagerKey;

	@Test
	void contextLoads() {
		final String url = hrManagerUrl + "/external-api/employee";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", hrManagerKey);

		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<List<EmployeeDto>> response = new RestTemplate().exchange(
				url,
				HttpMethod.GET,
				request,
				new ParameterizedTypeReference<>() {}
		);

		System.out.println(response.getBody());
	}

}
