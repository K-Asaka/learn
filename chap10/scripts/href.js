document.querySelector('#isbn').addEventListener('change', function(e) {
    location.href = `https://wings.msn.to/index.php/-/A-03/${e.target.value}`;
}, false);
