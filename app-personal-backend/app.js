const express = require('express')
const cors = require('cors')
const pool = require("./db")

const app = express()
const port = 3003

var whitelist = ['http://example1.com', 'http://example2.com', 'http://localhost']
var corsOptions = {
    origin: (origin, callback) => {
        // console.log('origin', origin)
        // console.log('whitelist', whitelist)
        if (whitelist.indexOf(origin) !== -1 || !origin) {
            callback(null, true)
        }
        else {
            callback(new Error('Not allowed by CORS'))
        }
    },
    optionsSuccessStatus: 200 // some legacy browsers (IE11, various SmartTVs) choke on 204
}

app.use(express.json())
app.use(cors(corsOptions)) //uso i cors su tutte le richieste
app.options('*', cors(corsOptions))

app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.post('/item', async (req, res) => {
    const { description } = req.body;
    const item = await pool.query("INSERT INTO TODO (description) VALUES($1) RETURNING *", [description])
    res.json(item);
})

app.delete('/item/:id', async (req, res) => {
    const { id } = req.params;
    const item = await pool.query("DELETE FROM TODO WHERE ID=$1 RETURNING *", [id])
    res.json(item.rows);
})

app.get('/item/:id', async (req, res) => {
    const { id } = req.params;
    const item = await pool.query("SELECT * FROM TODO WHERE ID=$1", [id])
    res.json(item.rows);
})

app.put('/item', async (req, res) => {
    const { id, description } = req.body;
    const item = await pool.query("UPDATE TODO SET DESCRIPTION=$1 WHERE ID=$2 RETURNING *", [description, id])
    res.json(item.rows);
})

app.get('/items', async (req, res) => {
    const items = await pool.query("SELECT * FROM TODO ORDER BY ID");
    res.json(items.rows);
})


app.listen(port,
    () => {
        console.log(`app listening at port ${port}`)
    }
)

module.exports = app;