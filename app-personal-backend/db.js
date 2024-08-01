const Pool = require('pg').Pool;

// const pool = new Pool({
//     user: "postgres",
//     password: "postgres",
//     host: "localhost",
//     port: 5432,
//     database: "apptodo"
// })

const pool = new Pool({
    connectionString: process.env.POSTGRES_URL,
})


module.exports = pool;