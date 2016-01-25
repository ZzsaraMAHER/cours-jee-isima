/**
 * 
 */
$(function() {
	$('.direction-button').each(function(index, elt) {
		$(this).on("click", function() {
			var targetQuote = $(this).attr('targetIndex');
			loadQuote(targetQuote);
		});
	});
	refreshButtonState();
});

function loadQuote(targetQuote) {
	$.ajax({
		url : 'loadQuote',
		dataType : 'json',
		data : {
			quoteNumber : targetQuote
		}
	}).done(onLoadSuccess).fail(onLoadFailure);
}

function onLoadSuccess(data, textStatus, jqXHR) {
	$('#number').text(data.number);
	$('#content').text(data.content);
	$('#author').text(data.author);
	$.each(data.directions, function(index, element) {
		var button = $('#' + element.id);
		button.attr('enabled', element.enabled);
		button.attr('targetIndex', element.targetIndex);
	});
	refreshButtonState();
}

function refreshButtonState() {
	$('.direction-button').each(function(index, elt) {
		$(this).prop('disabled', $(this).attr('enabled') == "false");
	});
}

function onLoadFailure(jqXHR, textStatus, errorThrow) {
	$('#content').text(errorThrown);
	$('#author').text(textStatus);
	// activer seulement le premier
}