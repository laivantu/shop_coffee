<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../layout/header.jsp"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<div class="container" style="margin-top: 65px">

	
	<div class="row">
		<spring:url value="/order/saveOrUpdate.html" var="ActionUrl" />
		<form:form class="form-horizontal" id="yoyo" method="POST" modelAttribute="orderForm" action="${ActionUrl}">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">New Order</div>

					<div class="panel-body">

					<div id="table-wrapper">
  <div id="table-scroll">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Product Name</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Discount</th>
									<th>Amount</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody class="neworderbody"  id="table-scroll">
							
							
							<c:choose>
							    <c:when test="${not empty orderForm.orderDetails}">
							        
								<!-- orderDetail : de set value -->
								<!-- orderDetails : de set path -->
								<c:forEach var="orderDetail" items="${orderForm.orderDetails}" varStatus="status">
									<tr>
										<td class="no">${status.index + 1}</td>
										<td>
											<form:input type="hidden" path="orderDetails[${status.index}].productId"></form:input>
											<input type="text" class="qty form-control"
		 										value="product Name"></input>
	 									</td>
										<td><form:input type="text" class="qty form-control"
	 										path="orderDetails[${status.index}].quantity" value="${orderDetail.quantity}"></form:input></td>
	 									<td><form:input type="text" class="price form-control"
	 										path="orderDetails[${status.index}].unitprice"  value="${orderDetail.unitprice}"></form:input></td>
	 									<td><form:input type="text" class="dis form-control"
	 										path="orderDetails[${status.index}].discount"  value="${orderDetail.discount}"></form:input></td>
	 									<td><form:input type="text" class="amount form-control"
	 										path="orderDetails[${status.index}].amount"  value="${orderDetail.amount}"></form:input></td>
										<td><input type="button" class="btn btn-danger delete"
	 										value="x"></td>
	 								</tr>
								</c:forEach>
							    </c:when>    
							    <c:otherwise>
							        <tr class="cart_content_area">
										<td colspan="7">
											<div class="text-center text-warning"> <h3>There are no items in the cart<span class="flatGreenc"> [Sales]</span></h3></div>
										</td>
									</tr>
							        
							    </c:otherwise>
							</c:choose>
							

							</tbody>
						</table>
						</div>
						</div>
						<hr>

					</div>

				</div>

				<!-- start Product -->

				<div class="border">
					<div class="row" style="margin-right: 0px; margin-left: 0px;">

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#home"
								aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
							<li role="presentation"><a href="#profile"
								aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
							<li role="presentation"><a href="#messages"
								aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
							<li role="presentation"><a href="#settings"
								aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content"
							style="border-left: 1px solid #ddd; border-right: 1px solid #ddd; border-bottom: 1px solid #ddd;">
							<div role="tabpanel" class="tab-pane active" id="home">

								<!-- Wrapper for slides -->
								<div class="row">

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt=""  data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt=""  data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-sm-4 col-xs-6">
										<div class="thumbnail">
											<img class="addProduct" src="http://placehold.it/800x500" alt="" data-key = "1" data-name = "product1" data-price="1000">
											<div class="caption">
												<p class="hidenOver">This is a short description. Lorem
													ipsum dolor sit amet, consectetur adipiscing elit. This is
													a short description. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. This is a short description.
													Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div>
									</div>

								</div>
							</div>

							<div role="tabpanel" class="tab-pane" id="profile">...</div>
							<div role="tabpanel" class="tab-pane" id="messages">...</div>
							<div role="tabpanel" class="tab-pane" id="settings">...</div>
						</div>


					</div>
				</div>

				<!-- end Product -->

			</div>
			<!--  Right -->
			<div class="col-md-4">
				<div class="register-box register-right">

					<!-- If customer is added to the sale -->

					<div class="sale-buttons">

						<form
							action="https://demo.phppointofsale.com/index.php/sales/cancel_sale"
							id="cancel_sale_form" autocomplete="off" method="post"
							accept-charset="utf-8">

							<div class="btn-group">
								<button type="button" class="btn btn-suspended dropdown-toggle"
									data-toggle="dropdown" aria-expanded="false">
									<i class="ion-pause"></i> Suspend Sale
								</button>
							</div>
							<a href="#" class="btn btn-cancel" id="cancel_sale_button"> <i
								class="ion-close-circled"></i> Cancel Sale
							</a>
						</form>

					</div>
					<!-- Customer Badge when customer is added -->
					<div class="customer-badge">
						<div class="avatar">
							<img src="https://demo.phppointofsale.com/assets/img/user.png"
								alt="">
						</div>
						<div class="details">
							<a id="feedback"
								href="https://demo.phppointofsale.com/index.php/sales/customer_recent_sales/3"
								data-toggle="modal" data-target="#myModal" class="name">quang
								san</a>
								
								<%-- <form:input type="hidden" path="order.name" value="lai van tu" ></form:input> --%>


							<!-- Customer Email  -->

							<!-- Customer edit -->
						</div>

					</div>
					<div class="customer-action-buttons">
						<a id="search-form"
							href="#"
							class="btn"> <i class="ion-ios-compose-outline"></i> Update
							Customer
						</a> <input type="checkbox" name="email_receipt" value="1"
							id="email_receipt" class="email_receipt_checkbox hidden">


						<a
							href="https://demo.phppointofsale.com/index.php/sales/delete_customer"
							id="delete_customer" class="btn"  data-toggle="modal" data-target="#myModal"><i class="ion-close-circled"></i>
							Detach</a>
					</div>

				</div>

				<div class="register-box register-summary paper-cut">

					<!-- Tiers if its greater than 1 -->


					<!-- Tiers if its greater than 1 -->


					<ul class="list-group">

						<li class="list-group-item global-discount-group">
							<div class="key">Discount Entire Sale:</div>
							<div class="value pull-right">
								<span id="TEST"></span> <a href="#" id="discount_all_flat"
									class="xeditable editable editable-click editable-empty"
									data-validate-number="false" data-placement="left"
									data-type="text" data-pk="1" data-name="discount_all_flat"
									data-url="https://demo.phppointofsale.com/index.php/sales/discount_all"
									data-title="Discount Entire Sale" data-emptytext="Set Discount"
									data-placeholder="Set Discount (% or fixed)">Set Discount</a>

							</div>
						</li>


						<li class="list-group-item global-discount-group"
							id="discount-reason-group">
							<div class="key">Discount Reason:</div>
							<div class="value pull-right">
								<a href="#" id="discount_reason"
									class="xeditable editable editable-pre-wrapped editable-click editable-empty"
									data-validate-number="false" data-placement="left"
									data-type="textarea" data-pk="1" data-name="discount_reason"
									data-url="https://demo.phppointofsale.com/index.php/sales/discount_reason"
									data-title="Discount Reason" data-emptytext="Comments"
									data-placeholder="Discount Reason">Comments</a>
							</div>
						</li>



						<li class="sub-total list-group-item"><span class="key">Sub
								Total:</span> <span class="value">$23,760.00</span></li>

						<li class="list-group-item"><span class="key"> 5.000%
								Sales Tax: </span> <span class="value pull-right"> $260.87 </span></li>

					</ul>

					<div class="amount-block">
						<div class="total amount">
							<div class="side-heading">Total</div>
							<div class="amount total-amount" data-speed="1000"
								data-currency="$" data-decimals="2">$23,760.00</div>
						</div>
						<div class="total amount-due">
							<div class="side-heading">Amount Due</div>
							<div class="amount">$23,760.00</div>
						</div>
					</div>
					<!-- ./amount block -->


					<!-- Payment Applied -->


					<!-- Add Payment -->
					<div class="add-payment">
<!-- 						<div class="side-heading">Add Payment</div> -->

<!-- 						<a tabindex="-1" href="#" -->
<!-- 							class="btn btn-pay select-payment active" data-payment="Cash"> -->
<!-- 							Cash </a> <a tabindex="-1" href="#" -->
<!-- 							class="btn btn-pay select-payment " data-payment="Check"> -->
<!-- 							Check </a> <a tabindex="-1" href="#" -->
<!-- 							class="btn btn-pay select-payment " data-payment="Gift Card"> -->
<!-- 							Gift Card </a> <a tabindex="-1" href="#" -->
<!-- 							class="btn btn-pay select-payment " data-payment="Debit Card"> -->
<!-- 							Debit Card </a> <a tabindex="-1" href="#" -->
<!-- 							class="btn btn-pay select-payment " data-payment="Credit Card"> -->
<!-- 							Credit Card </a> -->



						<div class="input-group add-payment-form">
							<div class="customer-action-buttons">
								<div class="btn-group btn-group-justified">
                <div class="btn-group">
                    <button type="submit" id="like" class="btn btn-lg btn-success ">Like</button>
                </div>
                <div class="btn-group">
                    <button type="submit" id="nope" class="btn btn-lg btn-danger ">Nope</button>
                </div>
            </div>
							</div>
						</div>

					</div>

					<div class="comment-block">
						<div class="side-heading">
							<label id="comment_label" for="comment">Comments : </label>
						</div>
						<textarea name="comment" cols="40" rows="2" id="comment"
							class="form-control" data-title="Comments"></textarea>
						<input type="checkbox" name="show_comment_on_receipt" value="1"
							id="show_comment_on_receipt"> <label
							for="show_comment_on_receipt"><span></span>Show comments
							on receipt</label>
					</div>


					<!-- End of complete sale button -->
				</div>
			</div>

		</form:form>


		<!-- Row End -->

		<!-- start Modal Customer-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Customer</h4>
					</div>
					<form action="" class="form-horizontal">
						<div class="modal-body panel panel-piluku">
							<div class="panel-body ">


								<div class="row">
									<div class="col-md-12">

										<div class="form-group">
											<label for="first_name"
												class="required col-sm-3 col-md-3 col-lg-3 control-label ">First
												Name:</label>
											<div class="col-sm-9 col-md-9 col-lg-9">
												<input type="text" name="first_name" value=""
													class="form-control" id="first_name">
											</div>
										</div>

										<div class="form-group">
											<label for="last_name"
												class=" col-sm-3 col-md-3 col-lg-3 control-label ">Last
												Name:</label>
											<div class="col-sm-9 col-md-9 col-lg-9">
												<input type="text" name="last_name" value=""
													class="form-control" id="last_name">
											</div>
										</div>

										<div class="form-group">
											<label for="email"
												class="col-sm-3 col-md-3 col-lg-3 control-label not_required">E-Mail:</label>
											<div class="col-sm-9 col-md-9 col-lg-9">
												<input type="text" name="email" value=""
													class="form-control" id="email">
											</div>
										</div>
										<div class="form-group">
											<label for="phone_number"
												class="col-sm-3 col-md-3 col-lg-3 control-label ">Phone
												Number:</label>
											<div class="col-sm-9 col-md-9 col-lg-9">
												<input type="text" name="phone_number" value=""
													class="form-control" id="phone_number">
											</div>
										</div>
										<div class="form-group">
											<label for="image_id"
												class="col-sm-3 col-md-3 col-lg-3 control-label ">Select
												Image:</label>
											<div class="col-sm-9 col-md-9 col-lg-9">
												<ul class="list-unstyled avatar-list">
													<li><input type="file" name="image_id" id="image_id"
														class="filestyle" tabindex="-1"
														style="position: absolute; clip: rect(0px, 0px, 0px, 0px);">
													<div class="bootstrap-filestyle input-group">
															<input type="text" class="form-control " disabled="">
															<span class="group-span-filestyle input-group-btn"
																tabindex="0"><label for="image_id"
																class="btn btn-file-upload "><span
																	class="glyphicon glyphicon-folder-open"></span> <span
																	class="buttonText">Choose file</span></label></span>
														</div>&nbsp;</li>
													<li>
														<div id="avatar">
															<img
																src="https://demo.phppointofsale.com/assets/img/avatar.png"
																class="img-polaroid" id="image_empty" alt="">
														</div>
													</li>
												</ul>
											</div>
										</div>




										<div class="form-group">
											<label for="address_1"
												class="col-sm-3 col-md-3 col-lg-2 control-label ">Address:</label>
											<div class="col-sm-9 col-md-9 col-lg-10">
												<input type="text" name="address_1" value=""
													class="form-control" id="address_1">
											</div>
										</div>

										<div class="form-group">
											<label for="comments"
												class="col-sm-3 col-md-3 col-lg-2 control-label ">Comments:</label>
											<div class="col-sm-9 col-md-9 col-lg-10">
												<textarea name="comments" cols="17" rows="5" id="comments"
													class="form-control text-area"></textarea>
											</div>
										</div>

									</div>
									<!-- /col-md-12 -->
								</div>


							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>

		<!-- end Modal Customer-->

	</div>
</div>

<%@include file="../layout/footer.jsp"%>