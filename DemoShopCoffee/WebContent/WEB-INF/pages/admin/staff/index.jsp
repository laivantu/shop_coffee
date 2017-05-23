<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../layout/header.jsp" %>
	<div class="container margintop">
	<div class="row">
		<div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
										<th>ID</th>
										<th>Name</th>
										<th>Phone</th>
										<th>Email</th>
										<th>Address</th>
										<th>Image</th>
										<th>Update</th>
										<th>Delete</th>
									  </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="staff" items="${staffList}" varStatus="status">
								  	  	<spring:url value="/staff/${staff.staffId}/update.html" var="updateUrl" />
								  	  	<spring:url value="/staff/${staff.staffId}/delete.html" var="deleteUrl" />
										  <tr>
										    <td>${staff.staffId}</td>
										    <td>${staff.staffName}</td>
											<td>${staff.phone}</td>
											<td>${staff.email}</td>
										    <td>${staff.address}</td>
											<td>${staff.image}</td>
											<td>
												<i class="fa fa-pencil fa-fw"></i> <a href="javascript:void();" onclick="window.location='${updateUrl}'" >Edit</a>
											</td>
											<td>
												<i class="fa fa-trash-o  fa-fw"></i> <a href="javascript:void();"  onclick="window.location='${deleteUrl}'"> Delete </a>
											</td>
										  </tr>
									  </c:forEach>
                                </tbody>
                            </table>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
	</div>
	
	
<%@include file="../layout/footer.jsp" %>
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>