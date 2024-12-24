const AMERICA = 1 << 0;
const RUSSIA = 1 << 1;
const CHINA = 1 << 2;
const INDIA = 1 << 3;

let flags = AMERICA | CHINA;
// flagsにINDIAが含まれるか確認
console.log(flags & INDIA);
