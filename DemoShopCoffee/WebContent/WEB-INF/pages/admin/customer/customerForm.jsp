<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../layout/header.jsp" %>
<div class="container margintop">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Update</div>
                <div class="panel-body">
                	<spring:url value="/customer/saveOrUpdate.html" var="ActionUrl" />
                    <form:form class="form-horizontal" method="POST" modelAttribute="customerForm"  action="${ActionUrl}"  enctype="multipart/form-data">
						 <form:input type="hidden" path="customerId"></form:input>


                        <div class="form-group">
                            <label class="col-md-4 control-label">Customer Name</label>

                            <div class="col-md-6">
                                <form:input type="text" class="form-control" path="customerName"></form:input>

                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">Phone</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="phone"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label">E-Mail</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="email"></form:input>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">Address</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="address"></form:input>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">note</label>

                            <div class="col-md-6">
                                <form:input type="text" class="form-control" path="note"></form:input>

                            </div>
                        </div>
                        
                        <div class="form-group">
							<label for="image_id"
								class="col-sm-3 col-md-3 col-lg-2 control-label ">Select
								Image:</label>
							<div class="col-sm-9 col-md-9 col-lg-10">
								<ul class="list-unstyled avatar-list">
									<li><input type="file" name="file" id="image_id"
										class="filestyle" tabindex="-1"
										style="position: absolute; clip: rect(0px, 0px, 0px, 0px);" onchange="readURL(this);">
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
												src="${pageContext.servletContext.contextPath}/images/avatar.png"
												class="img-polaroid" id="image_empty" alt="">
										</div>
									</li>
								</ul>
							</div>
						</div>

                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-btn fa-user"></i>Update
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script type="text/javascript">
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	
	        reader.onload = function (e) {
	            $('#image_empty')
	                .attr('src', e.target.result)
	                .width(200)
	                .height(200);
	        };
	
	        reader.readAsDataURL(input.files[0]);
	    }
	}
</script>
