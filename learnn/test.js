// coercizione di tipo 10.5 + 10 // 20.5

//to boolean
//"" -> false
//"ciao" -> true
//10->true
//!10 ->false
//!!10->true

"ciao Mondo!" +
    'ciao Mondo!' +
    `ciao Mondo!` //alt+96

    //Array
    ['ok', 'ciao']
    [10, 20]
    [true, false]

    ['ok', 'ciao', 10, 20, true, false]

    [
    [
        [
            [], [
                'ciao', 1
            ]
        ]
    ]
    ]

//oggetti
var obj = {
    '01': "fo",
    name: "mik",
    age: 27,
    dog: true,
    favorites: ['books', 'food'],
    altro: {
        caso1: ['ahah', 'prop']
    }
}
//null and undefined
//sono diversi

var age;//valore undefined
var age1 = 27;
var cycle = null;
var myObject = {
    name: null
}
//si mantiene la forma dell'oggetto e si imposta null se non disponibile il valore, non si cancella la proprietà

//javascript è un linguaggio funzionale

function sayHello() {
    return 'hello';
}

sayHello();

// var riassegna la variabile anche con lo stesso nome!!! si usa quindi let o const


//ES6 - ecmascript6 
//let, non permette di dichiarare una variabile già esistente 
//const non permette di riassegnare il valore

const obj = {
    name: 'lnux',
    age: 32,
    dog: {
        name: 'kappa'
    }
}
console.log(obj.name)






