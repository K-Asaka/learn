let pic = document.querySelector('#cover');
pic.addEventListener('mouseenter', function() {
	this.src = 'images/haribo.jpg';
}, false);

pic.addEventListener('mouseleave', function() {
	this.src = 'images/sauce.jpg';
}, false);
