package site.currychoco.assetmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.repository.AssetRepository;
import site.currychoco.assetmanager.employee.domain.EmployeeDto;

import java.util.List;

@Transactional
@SpringBootTest
class AssetManagerApplicationTests {

	@Autowired
	private AssetRepository assetRepository;

	@Test
	void contextLoads() {

		/*
		final long id = 1L;
		Asset asset = assetRepository.findById(id).get();
		System.out.println(asset.getAssetState());

		 */

		// {asset.category.categoryName}
		
	}

}
