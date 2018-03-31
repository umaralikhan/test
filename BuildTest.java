package com.build.qa.build.selenium.tests;

import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;


public class BuildTest extends BaseFramework { 
	
  Cart cart;
  
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 * Testing upload to Git
	 */
	@Test
	public void navigateToHomePage() { 
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product title
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() { 
		// TODO: Implement this test
	  driver.get(getConfiguration("SEARCHBAR"));
	  SearchBar search = new SearchBar(driver, wait);
	  
	  
	  softly.asserThat(search.searchFor("Quoizel MY1613").getTitle())
	        .as("Quoizel MY1613ML Malaga Monterey Mosaic 3 Light 16&quot; Wide Flush Mount Ceiling Fixture with Pen Shell Mosaic Shade")
	        .isEqual();
	  
	}
	
	/** 
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 */
	@Test
	public void addProductToCartFromCategoryDrop() { 
		// TODO: Implement this test
	  
	  driver.get("https://www.build.com/bathroom-sinks/c108504");
	  
	  SearchResults results = new SearchResults(driver, wait);
	  
	  Product prod = results.getProductByIndex(1);
	  
	  Cart cart = new Cart(driver, wait);
	  
	  cart.addProduct(prod);
	  
	  softly.asserThat(cart.getProduct(prodc))
    .as("Second Product name")
    .isTrue();
	  
	  
	}
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: chanelnalani@gmail.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 */
	@Test
	public void addProductToCartAndEmailIt() { 
		// TODO: Implement this test
	  
	  addProductToCartSteps();
	  
	  Email email = new Email();
	  
	  email.setTo("myemail@gmail.com");
	  email.setCC("chanelnalani@gmail.com");
	  email.setSubject("Cart details");
	  email.setMessage("This is Umar, sending you a cart from my automation!")
	  
	  cart.sendEmail(email);
	  
	  softly.asserThat(cart.getEmailMessageStatus)
    .as("Cart Sent")
    .isEqual();
	  
	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test
	}
	
	
	private void addProductToCartSteps(){
	  
	  driver.get("https://www.build.com/bathroom-sinks/c108504");
    
    SearchResults results = new SearchResults(driver, wait);
    
    Product prod = results.getProductByIndex(1);
    
    cart = new Cart(driver, wait);
    
    cart.addProduct(prod);
	}
	
}
