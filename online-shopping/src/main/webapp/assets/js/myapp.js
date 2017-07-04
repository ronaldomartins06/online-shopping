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
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default :
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
});