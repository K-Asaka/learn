function getTrapezoidArea(upper = 1, lower = upper, height = upper) {
    return (upper + lower) * height / 2;
}

console.log(getTrapezoidArea(10, 5, 3));
console.log(getTrapezoidArea(10, 5));
console.log(getTrapezoidArea(10));
