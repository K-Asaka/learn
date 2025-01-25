let pic = document.querySelector('#cover');
pic.onmouseenter = function() {
	pic.src = 'images/haribo.jpg';
}

pic.onmouseleave = function() {
	pic.src = 'images/sauce.jpg';
}
