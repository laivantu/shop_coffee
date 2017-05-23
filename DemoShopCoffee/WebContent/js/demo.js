function totalAmount(){
		var t = 0;
		$('.amount').each(function(i,e){
			var amt = $(this).val()-0;
			t += amt;
		});
		$('.total').html(t);
	}
	$(function () {
		$('.getmoney').change(function(){
			var total = $('.total').html();
			var getmoney = $(this).val();
			var t = getmoney - total;
			$('.backmoney').val(t).toFixed(2);
		});
		$('.addProduct').click(function () {
			//remove empty row
			var tr = $('.neworderbody').find('.cart_content_area').remove();
			
			var product_id = $(this).attr('data-key');
			var product_name = $(this).attr('data-name');
			var product_price = $(this).attr('data-price');

			var n = ($('.neworderbody tr').length - 0);
			var tr = '<tr><td class="no">' + (n + 1) + '</td>' + '<td><input type="hidden" name="orderDetails['+ n +'].productId" value="'+ product_id +'"></input> <input type="text" class="product_id form-control" value="'+ product_name +'"></input></td>' +
				'<td><input type="text" class="qty form-control" name="orderDetails['+ n +'].quantity" value="1"></input></td>' +
				'<td><input type="text" class="price form-control" name="orderDetails['+ n +'].unitprice" value ="' + product_price + '"></input></td>' +
				'<td><input type="text" class="dis form-control" name="orderDetails['+ n +'].discount"value="0.0"></input></td>' +
				'<td><input type="text" class="amount form-control" name="orderDetails['+ n +'].amount" value ="' + product_price + '"></input></td>' +
				'<td><input type="button" class="btn btn-danger delete" value="x"></td></tr>';
			$('.neworderbody').append(tr);
		});
		//remove row
		$('.neworderbody').delegate('.delete', 'click', function () {
			$(this).parent().parent().remove();
			// add row when empty
			var n = ($('.neworderbody tr').length );

			if(n == 0) {
				var tr = '<tr class="cart_content_area"><td colspan="7"><div class="text-center text-warning"> <h3>There are no items in the cart<span class="flatGreenc"> [Sales]</span></h3></div></td></tr>';
				$('.neworderbody').append(tr);
			}
			
			totalAmount();
		});
		// cancel Order
		$('#cancel_sale_button').bind('click', function () {
			$('.neworderbody').empty();
			// add row when empty
			var n = ($('.neworderbody tr').length);
			if(n == 0) {
				var tr = '<tr class="cart_content_area"><td colspan="7"><div class="text-center text-warning"> <h3>There are no items in the cart<span class="flatGreenc"> [Sales]</span></h3></div></td></tr>';
				$('.neworderbody').append(tr);
			}
			totalAmount();
		});
		
		$('.neworderbody').delegate('.product_id', 'change', function () {
			var tr = $(this).parent().parent();
			var price = tr.find('.product_id option:selected').attr('data-price');
			tr.find('.price').val(price);
			
			var qty = tr.find('.qty').val() - 0;
			var dis = tr.find('.dis').val() - 0;
			var price = tr.find('.price').val() - 0;
		
			var total = (qty * price) - ((qty * price * dis)/100);
			tr.find('.amount').val(total);
			totalAmount();
		});
		$('.neworderbody').delegate('.qty , .dis', 'keyup', function () {
			var tr = $(this).parent().parent();
			var qty = tr.find('.qty').val() - 0;
			var dis = tr.find('.dis').val() - 0;
			var price = tr.find('.price').val() - 0;
		
			var total = (qty * price) - ((qty * price * dis)/100);
			tr.find('.amount').val(total);
			totalAmount();
		});
		
        $('#hideshow').on('click', function(event) {  
			 $('#content').removeClass('hidden');
			$('#content').addClass('show'); 
             $('#content').toggle('show');
        });
    

        
        $('#printPage')
		.click(
				function() {
					var data = '<input type="button" value="Print this page" onClick="window.print()">';
					data += '<div id="toPrint">';
					data += $('#toPrint')
							.html();
					data += '</div>';

					myWindow = window
							.open('', '',
									'width=1200,height=1000');
					myWindow.innerWidth = screen.width;
					myWindow.innerHeight = screen.height;
					myWindow.screenX = 0;
					myWindow.screenY = 0;
					myWindow.document
							.write(data);
					myWindow.focus();
				});
        
        //customer
        $("#search-form").click(function(event) {

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			searchViaAjax();

		});
        
	});
	
	// search customer
	function searchViaAjax() {

		var search = {}
		search["username"] = "name";//$("#username").val();
		search["email"] = "email";//$("#email").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "./customer/search.html",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}
	
	// set data customer.
	function display(data) {

		$('#feedback').html(data.name);
	}
	