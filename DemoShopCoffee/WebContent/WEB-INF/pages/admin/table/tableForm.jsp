<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../layout/header.jsp" %>

<div class="container margintop">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Update Company Name</div>
                <div class="panel-body">
                	<spring:url value="/table/saveOrUpdate.html" var="ActionUrl" />
                    <form:form class="form-horizontal" method="POST" modelAttribute="tableForm" action="${ActionUrl}">
						 <form:hidden path="tableId" />

                        <div class="form-group">
                            <label class="col-md-4 control-label">Table Name</label>

                            <div class="col-md-6">
                                <form:input path="tableName"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-btn fa-user"></i>Update Company
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
