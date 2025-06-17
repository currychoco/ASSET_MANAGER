package site.currychoco.assetmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.currychoco.assetmanager.asset.repository.AssetRepository;

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
