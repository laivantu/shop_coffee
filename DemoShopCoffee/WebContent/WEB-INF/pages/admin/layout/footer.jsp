
    <!-- jQuery -->
    <script src="${pageContext.servletContext.contextPath }/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.servletContext.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.servletContext.contextPath }/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="${pageContext.servletContext.contextPath }/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.servletContext.contextPath }/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath }/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/demo.js"></script>
	<script type="text/javascript">
		var ops = {
			'html' : true,
			content : function() {
				return $('#content').html();
			}
		};

		$(function() {
			$('#example').popover(ops)
		});
	</script>
</body>
	
</html>
