const str = null;
if (str !== null && str !== undefined) {
    console.log(str.substring(1));
}

console.log(str?.substring(1));
