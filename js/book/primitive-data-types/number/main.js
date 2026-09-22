

let intNr = 1;
let decNr = 1.5;
let expNr = 1.4e15;
let octNr = 0o10;
let hexNr = 0x3E8;
let biNr = 0b101;
let intNr2 = 2344;
let intNr3 = -1234;
let decNr2 = 234.2345;
let binNr2 = 0b100;

let bigNr = 234567n;

let re = bigNr + intNr; // TypeError: Cannpt mix BigInt and other types,
// use explicit conversions.
