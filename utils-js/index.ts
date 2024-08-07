import express, { Request, Response } from "express";

const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req: Request, res: Response) => {
    console.log(`chiamata in ` + req.method + ` verso url ` + req.url + " e parametri ", req.params);
    res.send("ciao");
})

app.listen(PORT, () => {
    console.log(`Server in esecuzione sulla porta ${PORT}`);
});