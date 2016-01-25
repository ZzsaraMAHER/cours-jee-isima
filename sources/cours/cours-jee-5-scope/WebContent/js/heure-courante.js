$(function() {
	rafraichirDansUneSeconde();
});

function rafraichirDansUneSeconde() {
	setTimeout(rafraichirHeureCourante, 1000);
}

function rafraichirHeureCourante() {
	$.ajax({
		url : 'GenererHeureFormatStandard',
		dataType : 'json',
		success : function(data, textStatus, jqXHR) {
			$('#heureCourante').text(data.date);
		}
	});
	rafraichirDansUneSeconde();
}