

//il doppio uguale fa coercizione di tipo, il triplo uguale no
sayHi(19);
sayHi(16);
sayHi('kay');

printArray([1, 4, 5]);

function sayHi(age) {
    switch (true) {
        case age < 18:
            def = 'Kid'
            break
        case age >= 18:
            def = 'Adult'
            break
        default: def = 'undefined'
    }
    console.log(`Hi ${def}: You have ${age} yo`)
}

function printArray(array) {
    for (const item of array) {
        console.log(item);
    }
}
//gli oggetti non sono iterabili con il for of ma con il for in


const obj = {
    name: "ok",
    age: "12",
    isTall: false
}
printObject(obj);

function printObject(obj) {

    for (const field in obj) {
        console.log(`${field}:${obj[field]}`);
    }
}
