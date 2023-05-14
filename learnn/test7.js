class Person {
    name;
    surname;

    constructor(name, surname) {
        this.name = name
        this.surname = surname
    }

    sayHi() {
        console.log(`Hi! ${this.name} ${this.surname}`)
    }
}

class Student extends Person {
    #voto;

    constructor(name, surname, voto) {
        super(name, surname);
        this.#voto = voto;
    }
    sayHi() {
        super.sayHi();
        console.log(`il mio voto è: ${this.#voto}`)
    }

}
const mic = new Person('simo', 'tre');
mic.sayHi();

const stu = new Student('simo', 'tre', 8.05);
stu.sayHi();
