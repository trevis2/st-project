function capitalize(word: string): string {
    let word1 = word[0].toUpperCase() + word.slice(1, word.length)
    return word1;
}

const gret: string = capitalize("hello");
console.log(gret);

type Age = string | number;
const age: Age = "10";