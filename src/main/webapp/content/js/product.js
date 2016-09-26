//----------------------------------------------------------------
// product class

function Product(sku, name, description, price, cal, carot, vitc, folate,
		potassium, fiber) {
	if (sku == null) {
		this.sku = sku;
	} else {
		this.sku = sku.toLowerCase();
	}// product code (SKU = stock keeping unit)
	this.name = name;
	this.description = description;
	this.price = price;
	this.cal = cal;
	this.nutrients = {
		"Carotenoid" : carot,
		"Vitamin C" : vitc,
		"Folates" : folate,
		"Potassium" : potassium,
		"Fiber" : fiber
	};
	this.dvaCaption = [ "Negligible", "Low", "Average", "Good", "Great" ];
	this.dvaRange = [ "below 5%", "between 5 and 10%", "between 10 and 20%",
			"between 20 and 40%", "above 40%" ];
}