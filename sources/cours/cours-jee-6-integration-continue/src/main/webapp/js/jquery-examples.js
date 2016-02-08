$(function() {
	$('#insert-button').on('click', function() {
		// this pointe sur mon bouton
		$('#field-value').text($('#to-insert').val());
	});

	$('.color-change-button').on('click', function() {
		// Un code generique pour tous les boutons
		// l'attribut alt contient la valeur de la couleur cible
		$('#text-changeable').css('color', $(this).attr('alt'));
	});

	$('#desactiver-changement-couleur').on('click', function() {
		// l'attribut disabled ne peut pas se manipuler dans le dom avec des
		// booleen (voir correction tp3)
		// grace a jquery c'est le cas
		$('.color-change-button').prop('disabled', true);
	});
	$('#xxx').attr('type');

	$('#add-list-des-bouttons').on(
			'click',
			function() {
				// fait un for each sur chaque bouton de la page
				$(':button').each(
						function(index, elt) {
							$('#liste-des-boutons').append(
									'<li>Bouton id ' + $(elt).attr('id')
											+ ' classes css '
											+ $(elt).attr('class') + '</li>');
						});
			});
});
