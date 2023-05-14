const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const arrayforeach = array.forEach((item) => {
    return item * 2
})
//console.log(arrayforeach);

const map = array.map((item) => {
    return item * 2
})
//console.log(map);

const filter = array.filter((item) => {
    return item % 2
})
//console.log(filter);

//const num = 0;
// 0->false
// !0 ->true
//if (0) {
//  console.log("SI!");
//} else {
//console.log("NO!");
//}

const arrayObj = [{
    name: 'lnux',
    age: 32,
    dog: 'kappa'
},
{
    name: 'asda',
    age: 2,
    dog: 'kapasdapa'
}, {
    name: 'aaaa',
    age: 3,
    dog: 'ssss'
}]

const find = arrayObj.find((elem) => {
    return elem.dog === "ssss";
})
//console.log(find);

myArray = [1, "mask", true, () => { return true; }, undefined];
const some = myArray.some((elem) => {
    return typeof elem === "symbol"
})
console.log(some);