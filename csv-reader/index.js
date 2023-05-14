const fs = require('fs');
const csv = require('csv-parser')
require('dotenv').config()
const mysql = require('mysql2')

const connection = mysql.createConnection(process.env.DATABASE_URL)
console.log('Connected to DB')


fs.createReadStream('./data.csv')
    .pipe(csv())
    .on('data', async (data) => {
        //console.log(data);
        await connection.execute(
            `insert into users 
            (id, first_name, last_name, email, gender, ip_address, job_title, company) 
            values (?,?,?,?,?,?,?,?)`,
            [parseInt(data.id), data.first_name, data.last_name, data.email, data.gender, data.ip_address, data.job_title, data.company]
        );
        console.log('userInserted: ' + data.id);
    })
    .on('close', () => {
        console.log("finished!")
        connection.end()
    })

