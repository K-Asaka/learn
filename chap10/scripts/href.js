document.querySelector('#isbn').addEventListener('change', function(e) {
    location.replace(`https://wings.msn.to/index.php/-/A-03/${e.target.value}`);
}, false);
