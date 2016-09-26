
function user(userName, Password, Products){
	this.userName = userName;
	this.Password = Password;
	this.Products = Products;
	
}

user.prototype.getProducts = function () {
    return this.Products()
}