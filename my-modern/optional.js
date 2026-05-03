const str = null;
if (str !== null && str !== undefined) {
    console.log(str.substring(1));
}

console.log(str?.substring(1));

let value = null;
//console.log(value ?? '既定値');
value ??= '既定値';
console.log(value);
