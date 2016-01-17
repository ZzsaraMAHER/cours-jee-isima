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

function createGetter(something) {
	return function() {
		return something;
	}
}
var a = 50;

var func50 = createGetter(a);
a = 'a text';

var funcAText = createGetter(a);
alert(func50());
alert(funcAText());
