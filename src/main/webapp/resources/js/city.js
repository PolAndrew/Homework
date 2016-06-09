

//var select = document.getElementById("List");



//select.onchange = function(){
//	var cn= this.options[this.selectedIndex].text;
//	$.ajax({
//		url : "city/name/" + cn,
//		type : 'GET',
//		success : function(data) {
//			var content = "";
//			for (var i in data) {
//				content += "<option>"+data[i].name ;
//			}
//			$('#content').html(content);
//		}
//	});
//};

$('#cityList').change(function(){
	var cn= this.options[this.selectedIndex].text;
	$.ajax({
		url : "city/name/" + cn,
		type : 'GET',
		success : function(data) {
			var content = "";
			for (var i in data) {
				content += "<option>"+data[i].name ;
			}
			$('#departmentList').html("<option>"+content);
		}
	});
});

$('#departmentList').change(function(){
	var cn= this.options[this.selectedIndex].text;
	$.ajax({
		url : "city/department/" + cn,
		type : 'GET',
		success : function(data) {
			var content = "";
			for (var i in data) {
				content += "<tr><td>"+data[i].name+"</td><td>"+data[i].email+"</td></tr>" ;
			}
			$('#content').html(content);
		}
	});
});
