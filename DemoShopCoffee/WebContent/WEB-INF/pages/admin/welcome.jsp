<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="./layout/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Welcome</div>
				
                <div class="panel-body">
                    <div>
					  <label>Name:</label>
					  <input type="text" placeholder="Enter a name here">
					  <hr>
					  <h1>Hello yourName !</h1>
						<div class="panel-body">
							<input type="text" placeholder="What..">
								Hello  data.test 
							<hr>
							<button class=" btn btn-lg"> I'm BTN</button>
						</div>
					</div>
                    	<a class="btn btn-primary" href="#">Place Order</a>
                    	<a class="btn btn-primary" href="#">Register</a>
                    	<a class="btn btn-primary" href="#">Show All Users</a>
                    	<a class="btn btn-primary" href="#">Shop</a>
                    	<a class="btn btn-primary" href="#">Show All Products</a>
                    	<a class="btn btn-primary" href="#">Add Product</a>
                    	<a class="btn btn-primary" href="#">Add Category</a>
                    	<a class="btn btn-raised btn-primary" href="#">Show All Categories</a>
                    	<hr>
                    	<a class="btn btn-raised btn-default" href="#"> Settings</a>

                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./layout/footer.jsp" %>
