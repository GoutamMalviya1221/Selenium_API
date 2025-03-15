package RestAsurred;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;



public class JsonDummyApi {
	
		@Test
		public void Get1() {
			given()
			.get("https://dummyjson.com/recipes")
			.then()
			.statusCode(200)
			.log()
			.all();
		}
		@Test
		public void Get2() {
			given()
			.get("https://dummyjson.com/recipes/1")
			.then()
			.statusCode(200)
			.log()
			.all();
		}
		@Test
		public void get3() {
			
			given()
			.get("https://dummyjson.com/recipes/search?q=chicken")
			.then()
			.statusCode(200)
			.log()
			.all();
		}
		@Test
		public void post1() {

			given()
			.when()
			.post("https://dummyjson.com/recipes/add")
			.then()
			.statusCode(200)
			.log()
			.all();
		}
		@Test
		public void put1() {
			
			given()
			.when().put("https://dummyjson.com/recipes/%7Bid%7D")
			.then()
			.statusCode(404)
			.log()
			.all();
			
			
		}
		@Test
		public void delete1() {
			given()
			.delete("https://dummyjson.com/recipes/%7Bid%7D")
			.then()
			.statusCode(404)
			.log()
			.all();
			
		}

	

}
