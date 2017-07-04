$(function(){
	//Active menu
	switch(menu)
	{
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contatc Us':
		$('#contact').addClass('active');
		break;
	default :
		$('#home').addClass('active');
		break;
	}
});