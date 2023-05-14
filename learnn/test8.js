
function callDb() {
    time = 500;
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (time > 600) {
                reject("timeout!")
            }
            resolve([{ id: 1 }, { id: 2 }])
        }, time);
    });
}

//then catch finally
callDb().then((dat) => {
    console.log(dat)
}).catch((error) => { console.log(error) }).finally(() => console.log("finished!"));

//async await
async function main() {
    try {
        const data = await callDb();
        console.log(data);
    }
    catch (error) {
        console.log(error);
    } finally {
        console.log("fine");
    }
}
main();
