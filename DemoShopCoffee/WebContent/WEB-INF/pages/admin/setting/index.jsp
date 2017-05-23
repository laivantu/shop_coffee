<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../layout/header.jsp"%>

<div class="container margintop">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">DataTables Advanced Tables</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>No</th>
								<th>ID</th>
								<th>Company Name</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="setting" items="${settingList}"
								varStatus="status">
								<spring:url value="/setting/${setting.settingId}/update.html"
									var="updateUrl" />
								<tr>
									<td>${status.index + 1}</td>
									<td>${setting.settingId}</td>
									<td>${setting.companyName}</td>
									<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
										href="javascript:void();"
										onclick="window.location='${updateUrl}'" data-toggle="modal"
										data-target="#myModal">Edit</a></td>
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

<%@include file="../layout/footer.jsp"%>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>