
//programmazione imperativa

function isPalindrome(sentence) {

    console.log("parola da verificare: " + sentence);
    if (sentence.length % 2 === 0) {
        primaMeta = sentence.substring(0, (sentence.length / 2));
        secondaMeta = sentence.substring((sentence.length / 2));
    } else {
        primaMeta = sentence.substring(0, ((sentence.length - 1) / 2));
        secondaMeta = sentence.substring(((sentence.length + 1) / 2));
    }
    console.log("primaMeta: " + primaMeta);
    console.log("secondaMeta: " + secondaMeta);

    for (index = 0; index < primaMeta.length; index++) {
        if (primaMeta.charAt(index) !== secondaMeta.charAt((primaMeta.length - 1) - index)) {
            console.log("index: " + index);
            console.log("primaMeta.charAt(index): " + primaMeta.charAt(index));
            console.log("secondaMeta.charAt((primaMeta.length-1) - index): " + secondaMeta.charAt((primaMeta.length - 1) - index));
            return false;
        }
    }
    return true;
}

console.log(isPalindrome("asdsa"));
console.log(isPalindrome("asddsa"));
console.log(isPalindrome("ciao"));