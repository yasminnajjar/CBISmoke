package com.generic.tests.RY.Cart;

import java.util.List;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.setup.SelTestCase;
import com.generic.page.PDP.*;

public class CartValidation extends SelTestCase {

	public static void addProductToCart() throws Exception {
		PDP.NavigateToPDP("dress");


		PDP_cart.addProductsToCart();
		Thread.sleep(5000);
			PDP_cart.clickAddToCartCloseBtn();
		
	}

	public static void cartValidation() throws Exception {
		//Search for products and add them to cart
		addProductToCart();
		if(!isMobile())
		Thread.sleep(5000);
		addProductToCart();
		
		//Navigate to cart by URL
		CheckOut.navigatetoCart();	
		
		Thread.sleep(3500);

		Cart.closeGWPIfExsist();
		
		Thread.sleep(1500);

		//Check addition of products and thier images and prices
		sassert().assertTrue(Cart.isItemAdded(), "Added item to cart validation has some problems");
		sassert().assertTrue(Cart.addedItemImageValidation(), "Added item image validation has some problems");
		sassert().assertTrue(Cart.checkAddedItemPriceDisplay(),
				"Added item price displayed validation has some problems");
		sassert().assertTrue(Cart.checkAddedItemTotalPriceDisplay(),
				"Added item total price displayed validation has some problems");
		if(Cart.isItemEditable()) {

		List <String> optionsBefore = Cart.getFirstSavedItemsOptions();
		
		Thread.sleep(3000);

		//Perform edit on first product in cart
		Cart.editOptions();
		
		Thread.sleep(3000);
		
		List <String> optionsAfter = Cart.getlastAddedItemsOptions();
		
		logs.debug("optionsBefore"+optionsBefore+"optionsAfter"+optionsAfter);
		//Check if the edit is saved correctly
		sassert().assertTrue(!optionsBefore.equals(optionsAfter), "Edit item validation has some problems");
		}
		//Save total before moving item
		String totalPriceBeforeMove = Cart.getTotalPrice();
		
		//Moving item
		Cart.clickMoveToWishListBtnForSavedItem();
	    Thread.sleep(3000);
	    String WLName = PDP_WL.getWishListName();
	    if(isMobile()) {
	    	Thread.sleep(2000);
			Cart.createNewWL(WLName);
			Thread.sleep(8000);
			Cart.clickOnSelectWLConfirmationBtn();
			Thread.sleep(8000);
	    }else {
			sassert().assertTrue(PDP_WL.validateNameYourNewWLModalIsDisplayed(), "Name your new wish list modal is not dispayed");
			Cart.createNewWL(WLName);
			Cart.validateSelectWishListModalIsDisplayed();
			sassert().assertTrue(PDP_WL.validateCreatedWLisSelectedByDefault(WLName), "created wish list is not selected by default");
			PDP_WL.clickOnCreateNewWLConfirmationBtn();
	    }
			

		
	    Thread.sleep(3000);
		//Save total again 
		String totalPriceAfterMove = Cart.getTotalPrice();
		
		Thread.sleep(3000);
		if(isMobile()){
			Thread.sleep(5000);
			sassert().assertTrue(!totalPriceBeforeMove.equals(totalPriceAfterMove), "Move item to wish list validation has some problems");
			Cart.navigatetoWishList();
			Cart.selectWLByName(WLName);
		}else {
			Thread.sleep(5000);
			Cart.validateAddedToWLModalIsDisplayed();
			sassert().assertTrue(!totalPriceBeforeMove.equals(totalPriceAfterMove), "Move item to wish list validation has some problems");
			Cart.clickOnViewListBtn();
		}
		Thread.sleep(2000);
		sassert().assertTrue(Cart.verifySavedItemToWL(), "Saved list validation has some problems");
		
		Thread.sleep(2000);
		Cart.moveItemsToCartFromWishlist();
		Cart.clickOnCheckout();
		Thread.sleep(2000);
		
		//Deletion and total before and after
		String totalPriceBeforeDelete = Cart.getTotalPrice();
		
		Cart.clickRemoveBtnForSavedItem();
		
		Thread.sleep(2000);
		
		String totalPriceAfterDelete = Cart.getTotalPrice();
		sassert().assertTrue(!totalPriceBeforeDelete.equals(totalPriceAfterDelete), "Remove item validation has some problems");

	}

}
