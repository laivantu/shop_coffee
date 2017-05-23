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
                	<spring:url value="/user/saveOrUpdate.html" var="ActionUrl" />
                    <form:form class="form-horizontal" method="POST" modelAttribute="userForm"  action="${ActionUrl}">
						 <form:input type="hidden" path="userId"></form:input>


                        <div class="form-group">
                            <label class="col-md-4 control-label">User Name</label>

                            <div class="col-md-6">
                                <form:input type="text" class="form-control" path="userName"></form:input>

                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">Password</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="password"></form:input>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">Shop</label>

                            <div class="col-md-6">
                                <form:input type="text" class="form-control" path="shopId"></form:input>

                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label">Phone</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="phone"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label">E-Mail Address</label>

                            <div class="col-md-6">
                                <form:input class="form-control" path="email"></form:input>
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
