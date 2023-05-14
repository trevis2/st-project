// programmazione funzionale

const array1 = [true, false, "ciao", "ciao ciao", 10]
const array2 = [true, false, "ciao", "ciao ciao"]

function containsNumber(array) {
    return array.some((elem) => typeof elem === "number");
}

// console.log(containsNumber(array1));
// console.log(containsNumber(array2));


const sentence = "Qualche vago ione tipo zolfo, bromo, sodio ";

function isPangram(sentence) {
    const alfabeto = 'abcdefghilmnopqrstuvz';
    const letters = sentence.toLowerCase().split('');

    return alfabeto.split('').every((alphabetLetter) => letters.includes(alphabetLetter));
}

console.log(isPangram(sentence));
console.log(isPangram("ciao"));



function isPalindrome(sentence) {
    return sentence === sentence.split('').reverse().join('');
}

console.log(isPalindrome("asdsa"));
console.log(isPalindrome("asddsa"));
console.log(isPalindrome("ciao"));

//funzioni built in in javascript per la programmazione funzionale

//