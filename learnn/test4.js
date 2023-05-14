
//pangram è una frase che contiene tutte le lettere dell'alfabeto

const sentence = "Qualche vago ione tipo zolfo, bromo, sodio ";

function isPangram(sentence) {
    // definizione alfabeto
    alfabeto = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'z'];

    // creazione mappa vuota
    const map1 = new Map();
    alfabeto.forEach(el => {
        map1.set(el, 0);
    });

    //riempimento mappa
    sentence.toLowerCase().split('').forEach(el => {
        if (alfabeto.indexOf(el) !== -1) {
            map1.set(el, map1.get(el) + 1);
        }
    })
    console.log(map1);

    //verifica pangramma
    for (field of map1) {
        if (field[1] === 0) {
            return false;
        }
    }
    return true;
}

console.log(isPangram(sentence));