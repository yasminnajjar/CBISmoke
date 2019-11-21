package com.generic.selector;

import com.generic.setup.cselector;

public class PDPSelectors {
	
	//CBI SMK
	
	public static final cselector avaibleOptions = new cselector("css,.c-product-options>div");
	public static final cselector allColors = new cselector("css,.gwt-image-picker-option >img","css,.pw-swatch__chip>.pw-swatch__chip-inner>.c-product-option-items__item-content.gwt-image-picker-option");
	public static final cselector allSizes = new cselector("css,.gwt-product-option-panel-listbox-container>div> .gwt-ListBox","css,.c-product-options__content u-border-brand-color u-border-radius");
	public static final cselector allFabrics = new cselector("css,.gwt-image-picker-option-holder>.gwt-selection-chip-picker-option", "css,.pw-swatch__chip>.pw-swatch__chip-inner");
	public static final cselector allShipLeadTime = new cselector("css,.gwt-image-picker-option-holder>.gwt-selection-chip-picker-option","css,.pw-swatch__chip>.pw-swatch__chip-inner");
	public static final cselector addToCartBtn = new cselector("gwt-add-to-cart-btn");
	public static final cselector addToCartCloseBtn = new cselector("gwt-Button ok-cancel-close-btn");
	
	// done-OCM
	public static String price = "price-and-special-messaging";
	public static String title = "product-name";
	public static String id = "code";
	public static String desc = "description";
	public static String socialMediaButtons = "css,div.st-btns";
	public static String shareBtn = "st-label";
	public static String numberOfProductsInBundle = "included-items-shipping";
	public static String productsInBundle = "css,div.each-included-item .information";
	public static String reviewsCount = "css,a.bv-rating-label.bv-text-link.bv-focusable>span";
	public static String reviewCountPerEachRate = "bv-inline-histogram-ratings-score";
	public static String starsRating = "bv-rating-stars-on bv-rating-stars";
	public static String secondaryRating = "bv-rating-ratio bv-td";

	public static String closSocialShareBtn = "st-close";
	public static String PDPnavs = "css,div.nav-tabs-container>ul>li";
	public static String PDPnavs_mobile = "css,div.tab-content>div>div>button";
	public static String favButton = "addToWishlist";
	public static String randomVariant = "css,.each-option-holder>div>.btn";
	public static String optionHolder = "each-option-holder";
	public static String optionHolderTitle="css,p>span.variant-text";

	public static String colorLable = "css,body>div>div>div>div>div>div>div>div>div>ul>li.attribute.color>div.label";
	public static String color = "Select color: ";
	public static String sizeAndFamilyLable = "css,div.product-variations > ul > div > ul > li > div.label";
	public static String lengthLable = "css,div>div>div.product-sister-styles>ul>li>div.label";
	public static String cart_popup = "popup-btn-checkout";
	public static String qty = "input-qty no-spin";
	public static String SA = "stock-in-stock";
	public static String cartPopupProductQty = "quantity";
	public static String miniCartProductUnitPrice = "unit-price";
	public static String minicart = "cart-component";
	public static String OverView;
	public static String size;

}
