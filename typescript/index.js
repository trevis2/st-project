function capitalize(word) {
    var word1 = word[0].toUpperCase() + word.slice(1, word.length);
    return word1;
}
var gret = capitalize("hello");
console.log(gret);
