const express = require('express')
const cors = require('cors')
const pool = require("./db")

const app = express()
const port = 3003

var whitelist = ['http://example1.com', 'http://example2.com', 'http://localhost']
var corsOptions = {
    origin: (origin, callback) => {
        console.log('origin', origin)
        console.log('whitelist', whitelist)
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

app.post('/user', async (req, res) => {
    const { description } = req.body;
    const newTodo = await pool.query("INSERT INTO TODO (description) VALUES($1)", [description])
    res.json(newTodo);
})


app.listen(port,
    () => {
        console.log(`app listening at port ${port}`)
    }
)