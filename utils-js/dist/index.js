import express from "express";
const app = express();
const PORT = process.env.PORT || 3000;
app.get('/', (req, res) => {
    console.log(`chiamata in ` + req.method + ` verso url ` + req.url + " e parametri ", req.params);
    res.send("Ambiente: " + process.env.NODE_ENV);
});

app.listen(PORT, () => {
    console.log(`Server in esecuzione sulla porta ${PORT}`);
});
